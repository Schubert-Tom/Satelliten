package Controller;

import Model.Data;
import Model.Satellit;

import java.util.List;
import java.util.stream.Collectors;

public class FilterSatellit{
    // filter und deepfilter werden miteinander verundet
    // FilterSatelliten in deepfilter werden miteinander verodert
    private FilterForSatellit filter;
    private java.util.List<FilterSatellit> deepFilter;
    public Boolean filter_data(Satellit satellit){
        // use filter on data (AND operation)
        return this.filter.filter(satellit) && this.getDeepFilterBoolean(satellit);
    };
    public Boolean getDeepFilterBoolean(Satellit satellit){
        return this.deepFilter.stream().anyMatch(filter->filter.filter_data(satellit));
    }
}
