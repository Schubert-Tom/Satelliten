package Controller;

import Model.Data;
import Model.Satellit;

import java.util.List;
import java.util.stream.Collectors;

public class FilterSatellit{
    private FilterForSatellit filter;
    private java.util.List<FilterSatellit> deepFilter;

    public FilterSatellit(FilterForSatellit filter, List<FilterSatellit> deepFilter) {
        this.filter = filter;
        this.deepFilter = deepFilter;
    }
    // filter und deepfilter werden miteinander verundet
    // FilterSatelliten in deepfilter werden miteinander verodert


    public void setDeepFilter(List<FilterSatellit> deepFilter) {
        this.deepFilter = deepFilter;
    }

    public Boolean filter_data(Satellit satellit){
        // use filter on data (AND operation)
        if (this.filter == null){
            return this.getDeepFilterBoolean(satellit);
        }
        return this.filter.filter(satellit) && this.getDeepFilterBoolean(satellit);
    };
    public Boolean getDeepFilterBoolean(Satellit satellit){
        if (this.deepFilter == null){
            return true;
        }
        return this.deepFilter.stream().anyMatch(filter->filter.filter_data(satellit));
    }
}
