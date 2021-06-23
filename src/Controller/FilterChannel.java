package Controller;
import Model.Channel;
import java.util.List;

/**
 * Klasse beschreibt das Vorgehen zum Filtern auf Channel-Ebene.
 * Der Filter filter hält einen Filter zum validieren des Channels.
 * Die List<FilterChannel> hält weitere Filter die mit dem Filter filter verundet sind.
 * Die List<FilterChannel> hält weitere Filter die untereinander verodert sind.
 * @author 4328112, 1319658, 1060449
 * @version 4.1
 */
public class FilterChannel{
    // filter und deepfilter werden miteinander verundet
    private FilterForChannel filter;
    // FilterSatelliten in deepfilter werden miteinander verodert
    private java.util.List<FilterChannel> deepFilter;
    /**
     * Konstruktor für Klasse FilterChannel
     * @param filter, filter der einen konkreten Filter für diese Ebene definiert
     * @param deepFilter, deepFilter der die Filterstruktur auf Satelliten-Ebene beschreibt
     * @post Instanz von CompleteFilter erstellt
     */
    public FilterChannel(FilterForChannel filter, List<FilterChannel> deepFilter) {
        this.filter = filter;
        this.deepFilter = deepFilter;
    }
    /**
     * Set-Funktion zum überschreiben der deepfilter-Struktur
     * @param deepFilter, setzen von deepfilter
     */
    public void setDeepFilter(List<FilterChannel> deepFilter) {
        this.deepFilter = deepFilter;
    }
    /**
     * Funktion zum rekursiven Bauen des Filters
     * @param channel, channel
     * @post Instanz von CompleteFilter erstellt
     */
    public Boolean filter_data(Channel channel){
        // use filter on data (AND operation)
        if (this.filter == null){
            return this.getDeepFilterBoolean(channel);
        }
        return this.filter.filter(channel) && this.getDeepFilterBoolean(channel);
    };

    public Boolean getDeepFilterBoolean(Channel channel){
        if (this.deepFilter == null){
            return true;
        }
        return this.deepFilter.stream().anyMatch(filter->filter.filter_data(channel));
    }

}
