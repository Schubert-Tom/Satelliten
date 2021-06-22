package Controller;

import Model.Data;
import Model.Satellit;

import java.util.List;
import java.util.stream.Collectors;

public class FilterTransponder{
    private FilterForTransponder filter;
    private List<FilterTransponder> deepfilter;
    public Data filter_data(Data data){
        // use filter on data (AND operation) for all Transponders
        data.getData().stream().forEach(satellit -> satellit.setTransponders(this.filter.filter(satellit.getTransponders())));

        // start all filters in deepfilter (OR operation)
        //List<Data> filtered_data_by_or = this.deepFilter.stream().map( filter -> filter.filter_data(data)).collect( Collectors.toList());
        // combine all filtered results and delete distinct results for OR-operation
        //data.setData((List<Satellit>)filtered_data_by_or.stream().flatMap(flat_data -> flat_data.getData().stream()).distinct().collect(Collectors.toList()));
        return data;
    };
}
