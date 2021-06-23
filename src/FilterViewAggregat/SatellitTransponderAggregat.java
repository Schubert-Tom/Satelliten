package FilterViewAggregat;
import Controller.*;
import Model.CountCode;
import Model.Filter.Channel.FilterForChannelRes;
import Model.Filter.Channel.FilterForChannelType;
import Model.Filter.Satellit.FilterForSatellitName;
import Model.Filter.Transponder.FilterForTransponderFreq;
import Model.ViewCode;
import java.util.List;
import java.util.function.Supplier;
/**
 * Klasse zum Erstellen eines Beispielaggregates
 * @author 4328112, 1319658, 1060449
 * @version 3.1
 */
public class SatellitTransponderAggregat implements Supplier<Aggregat> {
    /**
     * Funktion zum Erstellen eines Beispielaggregates wobei nach folgendem gefiltert wird:
     * Satellitname "Eutelsat 3B"
     * Transponderfrequenz 4034
     * View Satellit -> Transponder -> Channel, Count Channels of transponder
     * @return name, der aktuell gespeicherte Name
     */
    @Override
    public Aggregat get() {
        // Erzeugen des SatellitenFilters --> Satellitname "Eutelsat 3B"
        FilterSatellit satFilter = new FilterSatellit(new FilterForSatellitName("Eutelsat 3B"),(List<FilterSatellit>) null);
        // Erzeugen TransponderFilter Ebene --> Transponderfrequenz 4034
        FilterTransponder transFilter = new FilterTransponder(new FilterForTransponderFreq("4034"),(List<FilterTransponder>) null);
        // Erzeugen ChannelFilter Ebene --> kein Filter
        FilterChannel chanFilter = null;
        CompleteFilter filter = new CompleteFilter(satFilter,transFilter,chanFilter);
        //  view and count settings
        ViewCode view = ViewCode.STC;
        CountCode count = CountCode.countSecondOrder;
        Aggregat aggregat = new Aggregat(filter,view,count);
        return aggregat;
    }
}

