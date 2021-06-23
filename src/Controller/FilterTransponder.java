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
    private java.util.List<FilterTransponder> deepFilter;

    public List<FilterTransponder> getDeepFilter() {
        return deepFilter;
    }

    public void setDeepFilter(List<FilterTransponder> deepFilter) {
        this.deepFilter = deepFilter;
    }



    public FilterTransponder(FilterForTransponder filter, List<FilterTransponder> deepFilter) {
        this.filter = filter;
        this.deepFilter = deepFilter;
    }

    public Boolean filter_data(Transponder transponder){
        // use filter on data (AND operation)
        if (this.filter == null){
            return this.getDeepFilterBoolean(transponder);
        }
        return this.filter.filter(transponder) && this.getDeepFilterBoolean(transponder);
    }
    public Boolean getDeepFilterBoolean(Transponder transponder){
        if (this.deepFilter == null){
            return true;
        }
        return this.deepFilter.stream().anyMatch(filter->filter.filter_data(transponder));
    }
}
