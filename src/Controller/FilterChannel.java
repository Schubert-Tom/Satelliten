package Controller;

import Model.Channel;
import Model.Data;
import Model.Satellit;

public class FilterChannel{
    // filter und deepfilter werden miteinander verundet
    // FilterSatelliten in deepfilter werden miteinander verodert
    private FilterForChannel filter;
    private java.util.List<FilterChannel> deepFilter;
    public Boolean filter_data(Channel channel){
        // use filter on data (AND operation)
        return this.filter.filter(channel) && this.getDeepFilterBoolean(channel);
    };
    public Boolean getDeepFilterBoolean(Channel channel){
        return this.deepFilter.stream().anyMatch(filter->filter.filter_data(channel));
    }

    }
