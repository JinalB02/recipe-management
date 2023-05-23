package recipe.api.request;

import recipe.api.request.input.DataOptionReqInput;
import recipe.validator.EnumValidator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.Valid;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RecipeSearchRequest {
    @JsonProperty("criteria")
    @ApiModelProperty(notes = "Search criteria you want to search the recipe with")
    @Valid
    private List<SearchCriteriaRequest> searchCriteriaRequests;

    @ApiModelProperty(notes = "If you want all or just one criteria is enough for filter to work", example = "all")
    @EnumValidator(enumClass = DataOptionReqInput.class, message = "{dataOption.invalid}")
    private String dataOption;
}
