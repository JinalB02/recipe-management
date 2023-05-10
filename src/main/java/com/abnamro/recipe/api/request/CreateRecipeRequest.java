package com.abnamro.recipe.api.request;

import com.abnamro.recipe.config.ValidationConfig;
import com.abnamro.recipe.models.RecipeType;
import com.abnamro.recipe.validator.EnumValidator;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreateRecipeRequest {
    @NotBlank(message = "{recipeName.notBlank}")
    @Size(max = ValidationConfig.MAX_LENGTH_NAME, message = "{recipeName.size}")
    @Pattern(regexp = ValidationConfig.PATTERN_NAME, message = "{recipeName.pattern}")
    @ApiModelProperty(notes = "The name of the recipe", example = "Pasta")
    private String name;

    @ApiModelProperty(notes = "The type of the recipe", example = "VEGETARIAN")
    @EnumValidator(enumClass = RecipeType.class, message = "{recipeType.invalid}")
    private String type;

    @NotNull(message = "{numberOfServings.notNull}")
    @Positive(message = "{numberOfServings.positive}")
    @ApiModelProperty(notes = "The number of servings per recipe", example = "4")
    private int numberOfServings;

    @ApiModelProperty(notes = "The ids of the ingredients needed to make the recipe", example = "[1,2]")
    private List<Integer> ingredientIds;

    @NotBlank(message = "{instructions.notBlank}")
    @Size(max = ValidationConfig.MAX_LENGTH_DEFAULT, message = "{instructions.size}")
    @Pattern(regexp = ValidationConfig.PATTERN_FREE_TEXT, message = "{instructions.pattern}")
    @ApiModelProperty(notes = "The instructions to create the recipe", example = "Chop the onions, stir and fry, boil potatoes, mix and serve")
    private String instructions;
}
