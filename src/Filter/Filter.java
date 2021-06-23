package Filter;

import java.util.function.Function;
import java.util.function.Predicate;

import Controller.FilterForChannel;
import Model.*;
import java.util.*;
import java.util.stream.Collectors;

public class Filter {
    Predicate<? extends FilterForChannel> filter;
    String type = ""; //Satellit, Transponder or Channel
    List<Filter> subFilter;

    public Filter(Predicate<? extends FilterForChannel> filter, List<Filter> subfilter)
    {
        this.filter = filter;
        this.subFilter = subfilter;
    }

    public Filter(Predicate<? extends FilterForChannel> filter)
    {
        this.filter = filter;
        this.subFilter = null;
    }

    public List<Satellit> filter(List<Satellit> data, Predicate<Satellit> satFilter, Predicate<Transponder> trapoFilter, Predicate<Channel> chanFilter)
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
