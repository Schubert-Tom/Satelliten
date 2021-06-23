package Filter;

import java.util.function.Function;
import java.util.function.Predicate;

import Controller.FilterForChannel;
import Model.*;
import com.sun.jdi.Type;

import java.util.*;
import java.util.stream.Collectors;

public class Filter {
    Predicate<? extends Channel> filter;
    Class<? extends Channel> type; //Satellit, Transponder or Channel
    List<Filter> subFilter;

    public <T extends Channel>Filter(Predicate<T> filter, Class<T> type, List<Filter> subfilter)
    {
        //Check that type is the type of Predicate
        this.filter = filter;
        this.type = type;
        this.subFilter = subfilter;
    }

    public  <T extends Channel>Filter(Predicate<T> filter, String type)
    {
        //Check that type is the type of Predicate
        this.filter = filter;
        this.subFilter = null;
    }

    public List<Satellit> filter(List<Satellit> data)
    {
        buildFilter("Satellit");
        return filterElements(data, elementFilters(0), elementFilters(1), elementFilters(2));
    }

    //private <T> T buildFilter(Predicate<T> type)
    public <T extends Channel> Predicate<T> buildFilter(Class<T> type)
    {
        Predicate<T> orFilters = subFilter.stream().map(fil -> fil.buildFilter()).reduce(Predicate::and);

        this.filter.and(orFilters);

        return flatFilter;
    }

    private List<Satellit> filterElements(List<Satellit> data, Predicate<Satellit> satFilter, Predicate<Transponder> trapoFilter, Predicate<Channel> chanFilter)
    {
        Predicate<Transponder> subFilterChan = trapo -> trapo.getChannels().stream().filter(chanFilter).anyMatch(chan -> true);
        Predicate<Satellit> subFilterTrapo = sat -> sat.getTransponders().stream().filter(trapoFilter.and(subFilterChan)).anyMatch(trans -> true);

        data = data.stream().filter(satFilter.and(subFilterTrapo)).collect(Collectors.toList());
        for (Satellit sat : data){
            List<Transponder> transponders = sat.getTransponders().stream().filter(trapoFilter.and(subFilterChan)).collect(Collectors.toList());
            for(Transponder trapo : transponders)
            {
                trapo.setChannels(trapo.getChannels().stream().filter(chanFilter).collect(Collectors.toList()));
            }
            sat.setTransponders(transponders);
        }
        return data;
    }
}
