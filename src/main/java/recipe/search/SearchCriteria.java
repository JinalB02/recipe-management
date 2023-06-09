package recipe.search;

import recipe.api.request.SearchCriteriaRequest;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class SearchCriteria {
    private String filterKey;
    private Object value;
    private String operation;
    private String dataOption;

    public SearchCriteria(SearchCriteriaRequest request) {
        this.dataOption = request.getDataOption();
        this.filterKey = request.getFilterKey();
        this.operation = request.getOperation();
        this.value = request.getValue();
    }
}
