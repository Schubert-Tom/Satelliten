package FilterViewAggregat;

import Controller.*;
import Model.CountCode;
import Model.Filter.Channel.FilterForChannelRes;
import Model.Filter.Channel.FilterForChannelType;
import Model.ViewCode;
import java.util.List;
import java.util.function.Supplier;
/**
 * Klasse zum Erstellen eines Beispielaggregates
 * @author 4328112, 1319658, 1060449
 * @version 3.1
 */
public class ChannelTVAndHDAggregat implements Supplier<Aggregat> {
    /**
     * Funktion zum Erstellen eines Beispielaggregates wobei nach folgendem gefiltert wird:
     * Channeltype TV AND Channelresolution HD
     * View Sateellit -> Channel, Counting no
     * @return name, der aktuell gespeicherte Name
     */
    @Override
    public Aggregat get() {
        // Erzeugen des Filters
        // Erzeugen SatellitenFilter Ebene --> kein Filter
        FilterSatellit satFilter = null;
        // Erzeugen TransponderFilter Ebene --> kein Filter
        FilterTransponder transFilter = null;
        // Erzeugen ChannelFilter Ebene --> HD Channel und Tv Channel
        // HD Channel
        FilterChannel chanRes = new FilterChannel(new FilterForChannelRes("HD"),(List<FilterChannel>) null);
        // Tv Channel
        FilterChannel andFilter = new FilterChannel(new FilterForChannelType("TV"),chanRes);
        // Oder VErknüpfung
        FilterChannel chanFilter = new FilterChannel(null,andFilter);
        CompleteFilter filter = new CompleteFilter(satFilter,transFilter,chanFilter);
        //  view and count settings
        ViewCode view = ViewCode.SC;
        CountCode count = CountCode.no;
        Aggregat aggregat = new Aggregat(filter,view,count);
        return aggregat;
    }
}

