package recipe.api.request;

import recipe.config.ValidationConfig;
import recipe.models.RecipeType;
import recipe.validator.EnumValidator;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.List;

@Valid
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UpdateRecipeRequest {

    @NotNull(message = "{id.notNull}")
    @Positive(message = "{id.positive}")
    @ApiModelProperty(notes = "Id of the attribute", example = "1")
    private Integer id;

    @NotBlank(message = "{recipeName.notBlank}")
    @Size(max = ValidationConfig.MAX_LENGTH_NAME, message = "{recipeName.size}")
    @Pattern(regexp = ValidationConfig.PATTERN_NAME, message = "{recipeName.pattern}")
    @ApiModelProperty(notes = "The name of the ingredient", example = "Potato")
    private String name;

    @EnumValidator(enumClass = RecipeType.class, message = "{recipeType.invalid}")
    @ApiModelProperty(notes = "The type of the recipe", example = "VEGETARIAN")
    private String type;

    @NotNull(message = "{numberOfServings.notNull}")
    @Positive(message = "{numberOfServings.positive}")
    @ApiModelProperty(notes = "The number of servings", example = "7")
    private int numberOfServings;

    @ApiModelProperty(notes = "The new ids of the ingredients needed for the update", example = "[3,4]")
    private List<Integer> ingredientIds;

    @NotBlank(message = "{instructions.notBlank}")
    @Size(max = ValidationConfig.MAX_LENGTH_DEFAULT, message = "{instructions.size}")
    @Pattern(regexp = ValidationConfig.PATTERN_FREE_TEXT, message = "{instructions.pattern}")
    @ApiModelProperty(notes = "The instructions to update the recipe", example = "Cut,fry,eat")

    private String instructions;

}
