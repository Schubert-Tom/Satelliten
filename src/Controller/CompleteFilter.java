package Controller;
import Model.Data;
import Model.Satellit;
import Model.Transponder;
import java.util.List;
import java.util.stream.Collectors;


/**
 * Klasse beschreibt eine allgemeine Filter Struktur
 * Unterteilung in drei Ebenen zum Filtern: Satelliten-Ebene, Transponder-Ebene, Channel-Ebene
 * @author 4328112, 1319658, 1060449
 * @version 4.8
 */

public class CompleteFilter {
    private FilterSatellit filterSatellit;
    private FilterTransponder filterTransponder;
    private FilterChannel filterChannel;
    /**
     * Konstruktor für Klasse FilterForChannelAPid
     * @param filterSatellit, filterSatellit der die Filterstruktur auf Satelliten-Ebene beschreibt
     * @param filterTransponder, filterTransponder der die Filterstruktur auf Satelliten-Ebene beschreibt
     * @param filterChannel, filterChannel der die Filterstruktur auf Satelliten-Ebene beschreibt
     * @post Instanz von CompleteFilter erstellt
     */
    public CompleteFilter(FilterSatellit filterSatellit, FilterTransponder filterTransponder, FilterChannel filterChannel) {
        this.filterSatellit = filterSatellit;
        this.filterTransponder = filterTransponder;
        this.filterChannel = filterChannel;
    }
    /**
     * Funktion zum Ausführen der einzelnen Filter für die einzelnen Ebenen
     * Es wird von unten nach oben gefiltert also von Channel --> Satellit
     * Es wird immer eine einzelne Channel/Transponder/Satellit-Instanz übergeben die dann den Filter durchläuft
     * @param data, zu filternde Datenstruktur
     * @return data, gefilterte Datenstruktur
     */
    public Data filter(Data data) {
        // Filter for Channel
        List<Satellit> satelliteList = data.getData();
        if (this.filterChannel!=null) {
            for (Satellit sat : satelliteList) {
                List<Transponder> transponders = sat.getTransponders();
                for (Transponder transponder : transponders) {
                    transponder.setChannels(transponder.getChannels().stream().filter(channel -> this.filterChannel.filter_data(channel)).collect(Collectors.toList()));
                }
                sat.setTransponders(transponders);
            }
            data.setData(satelliteList);
        }
        if (this.filterTransponder!=null) {
            // Filter for Transponders
            satelliteList = data.getData();
            satelliteList.forEach(satellite -> satellite.setTransponders(satellite.getTransponders().stream().filter(transponder -> this.filterTransponder.filter_data(transponder)).collect(Collectors.toList())));
            data.setData(satelliteList);
        }

        if (this.filterSatellit!=null) {
            // Filter for satellits
            satelliteList = data.getData();
            satelliteList=satelliteList.stream().filter(satellit -> this.filterSatellit.filter_data(satellit)).collect(Collectors.toList());
            data.setData(satelliteList);
        }
        return data;
    }
}
