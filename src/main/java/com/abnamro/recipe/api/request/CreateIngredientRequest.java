package com.abnamro.recipe.api.request;

import com.abnamro.recipe.config.ValidationConfig;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import javax.persistence.SecondaryTable;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreateIngredientRequest {
    @NotBlank(message = "{ingredient.notBlank}")
    @Size(max = ValidationConfig.MAX_LENGTH_NAME, message = "{ingredient.size}")
    @Pattern(regexp = ValidationConfig.PATTERN_NAME, message = "{ingredient.pattern}")
    @ApiModelProperty(notes = "The name of the ingredient", example = "Potato")
    private String name;
}
