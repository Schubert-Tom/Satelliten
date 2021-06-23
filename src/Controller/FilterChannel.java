package Controller;
import Model.Channel;

import java.util.ArrayList;
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
     * @param deepFilter, deepFilter der die weitere Filterstruktur beschreibt
     * @post Instanz von FilterChannel erstellt
     */
    public FilterChannel(FilterForChannel filter, List<FilterChannel> deepFilter) {
        this.filter = filter;
        this.deepFilter = deepFilter;
    }
    /**
     * Konstruktor für Klasse FilterChannel
     * @param filter, filter der einen konkreten Filter für diese Ebene definiert
     * @param deepFilter, deepFilter der nur aus einem Filter besteht --> einfaches Und
     * @post Instanz von FilterChannel erstellt
     */
    public FilterChannel(FilterForChannel filter, FilterChannel deepFilter) {
        this.filter = filter;
        this.deepFilter = new ArrayList<FilterChannel>();
        this.deepFilter.add(deepFilter);
    }
    /**
     * Set-Funktion zum überschreiben der deepfilter-Struktur
     * @param deepFilter, setzen von deepfilter
     */
    public void setDeepFilter(List<FilterChannel> deepFilter) {
        this.deepFilter = deepFilter;
    }
    /**
     * Funktion zum Durchführen des filter Filters auf dem aktuellen Channel
     * @param channel, channel der gefiltert werden soll
     * @return Boolean, ob der Channel der angeforderten Filterstruktur entspricht
     * @post Eindeutige Entscheidung ob der Channel Teil der gefilterten Struktur sein soll oder nicht
     */
    public Boolean filter_data(Channel channel){
        // use filter on data (AND operation)
        if (this.filter == null){
            return this.getDeepFilterBoolean(channel);
        }
        return this.filter.filter(channel) && this.getDeepFilterBoolean(channel);
    };
    /**
     * Funktion zum rekursiven Durchreichen des zu filternden Channels an die Filter in der deepfilter Liste
     * @param channel, channel der gefiltert werden soll
     * @return Boolean, ob der Channel der angeforderten Filterstruktur entspricht
     * @post Eindeutige Entscheidung ob der Channel Teil der gefilterten Struktur sein soll oder nicht
     */
    private Boolean getDeepFilterBoolean(Channel channel){
        if (this.deepFilter == null){
            return true;
        }
        return this.deepFilter.stream().anyMatch(filter->filter.filter_data(channel));
    }

}
