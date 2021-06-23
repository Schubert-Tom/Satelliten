package Controller;

import Model.Data;
import Model.Satellit;
import Model.Transponder;

import java.util.List;
import java.util.stream.*;

public class FilterTransponder{
    // filter und deepfilter werden miteinander verundet
    // FilterSatelliten in deepfilter werden miteinander verodert
    private FilterForTransponder filter;

    public List<FilterTransponder> getDeepFilter() {
        return deepFilter;
    }

    public void setDeepFilter(List<FilterTransponder> deepFilter) {
        this.deepFilter = deepFilter;
    }

    private java.util.List<FilterTransponder> deepFilter;

    public FilterTransponder(FilterForTransponder filter) {
        this.filter = filter;
    }

    public Boolean filter_data(Transponder transponder){
        // use filter on data (AND operation)
        return this.filter.filter(transponder) && this.getDeepFilterBoolean(transponder);
    };
    public Boolean getDeepFilterBoolean(Transponder transponder){
        return this.deepFilter.stream().anyMatch(filter->filter.filter_data(transponder));
    }
}
