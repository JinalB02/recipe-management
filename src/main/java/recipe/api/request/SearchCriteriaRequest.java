package recipe.api.request;

import recipe.api.request.input.FilterKeyReqInput;
import recipe.api.request.input.SearchOperationReqInput;
import recipe.validator.EnumValidator;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.Valid;

@Valid
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SearchCriteriaRequest {

    @ApiModelProperty(notes = "The name of the column you want to search on. Available fields are " +
            "name, " +
            "numberOfServings, " +
            "type, " +
            "instructions, " +
            "ingredientName)", example = "name")
    @EnumValidator(enumClass = FilterKeyReqInput.class, message = "{filterKey.invalid}")
    private String filterKey;


    @ApiModelProperty(notes = "The actual phrase you want to do search on", example = "Pasta")
    private Object value;

    @ApiModelProperty(notes = "The operation type you wanted to search (cn - contains, " +
            "nc - doesn't contain, " +
            "eq - equals, " +
            "ne - not equals", example = "cn")
    @EnumValidator(enumClass = SearchOperationReqInput.class, message = "{searchOperation.invalid}")
    private String operation;

    @ApiModelProperty(hidden = true)
    private String dataOption;

    public SearchCriteriaRequest(String filterKey, Object value, String operation) {
        this.filterKey = filterKey;
        this.value = value;
        this.operation = operation;
    }
}
