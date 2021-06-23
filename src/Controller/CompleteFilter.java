package Controller;

import Model.Data;
import Model.Satellit;
import Model.Transponder;

import java.util.List;
import java.util.stream.Collectors;

public class CompleteFilter{
    private FilterSatellit filterSatellit;
    private FilterTransponder filterTransponder;
    private FilterChannel filterChannel;

    public void filter(Data data){
        // Filter for Channel
        List< Satellit>satelliteList = data.getData();
        for (Satellit sat : satelliteList){
            List<Transponder> transponders = sat.getTransponders();
            for(Transponder transponder : transponders)
            {
                transponder.setChannels(transponder.getChannels().stream().filter(channel -> this.filterChannel.filter_data(channel)).collect(Collectors.toList()));
            }
            sat.setTransponders(transponders);
        }
        data.setData(satelliteList);
        // Filter for Transponders
        satelliteList = data.getData();
        satelliteList.stream().forEach(satellite -> satellite.setTransponders(satellite.getTransponders().stream().filter(transponder -> this.filterTransponder.filter_data(transponder)).collect(Collectors.toList())));
        data.setData(satelliteList);

        // Filter for satellits
        satelliteList = data.getData();
        satelliteList.stream().filter(satellit -> this.filterSatellit.filter_data(satellit)).collect(Collectors.toList());
        data.setData(satelliteList);

    }
}
