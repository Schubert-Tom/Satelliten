package Controller;

import Model.Data;
import Model.Satellit;
import Model.Transponder;

import java.util.List;
import java.util.stream.Collectors;

public class CompleteFilter {
    private FilterSatellit filterSatellit;
    private FilterTransponder filterTransponder;
    private FilterChannel filterChannel;

    public CompleteFilter(FilterSatellit filterSatellit, FilterTransponder filterTransponder, FilterChannel filterChannel) {
        this.filterSatellit = filterSatellit;
        this.filterTransponder = filterTransponder;
        this.filterChannel = filterChannel;
    }
    public Data filter(Data data) {
        // Filter for Channel
        List<Satellit> satelliteList = data.getData();
        if (!this.filterChannel.equals(null)) {
            for (Satellit sat : satelliteList) {
                List<Transponder> transponders = sat.getTransponders();
                for (Transponder transponder : transponders) {
                    transponder.setChannels(transponder.getChannels().stream().filter(channel -> this.filterChannel.filter_data(channel)).collect(Collectors.toList()));
                }
                sat.setTransponders(transponders);
            }
            data.setData(satelliteList);
        }
        if (!this.filterTransponder.equals(null)) {
            // Filter for Transponders
            satelliteList = data.getData();
            satelliteList.stream().forEach(satellite -> satellite.setTransponders(satellite.getTransponders().stream().filter(transponder -> this.filterTransponder.filter_data(transponder)).collect(Collectors.toList())));
            data.setData(satelliteList);
        }

        if (!this.filterSatellit.equals(null)) {
            // Filter for satellits
            satelliteList = data.getData();
            satelliteList.stream().filter(satellit -> this.filterSatellit.filter_data(satellit)).collect(Collectors.toList());
            data.setData(satelliteList);
        }
        return data;
    }
}
