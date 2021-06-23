package Controller;

import Model.Satellit;

import java.util.ArrayList;
import java.util.List;

/**
 * Klasse beschreibt das Vorgehen zum Filtern auf Satellit-Ebene.
 * Der Filter filter hält einen Filter zum validieren des Satellits.
 * Die List<FilterChannel> hält weitere Filter die mit dem Filter filter verundet sind.
 * Die List<FilterChannel> hält weitere Filter die untereinander verodert sind.
 * @author 4328112, 1319658, 1060449
 * @version 3.1
 */
public class FilterSatellit{
    // filter und deepfilter werden miteinander verundet
    private FilterForSatellit filter;
    // FilterSatelliten in deepfilter werden miteinander verodert
    private java.util.List<FilterSatellit> deepFilter;
    /**
     * Konstruktor für Klasse FilterSatellit
     * @param filter, filter der einen konkreten Filter für diese Ebene definiert
     * @param deepFilter, deepFilter der die weitere Filterstruktur beschreibt
     * @post Instanz von FilterSatellit erstellt
     */
    public FilterSatellit(FilterForSatellit filter, List<FilterSatellit> deepFilter) {
        this.filter = filter;
        this.deepFilter = deepFilter;
    }
    /**
     * Konstruktor für Klasse FilterChannel
     * @param filter, filter der einen konkreten Filter für diese Ebene definiert
     * @param deepFilter, deepFilter der nur aus einem Filter besteht --> einfaches Und
     * @post Instanz von FilterChannel erstellt
     */
    public FilterSatellit(FilterForSatellit filter, FilterSatellit deepFilter) {
        this.filter = filter;
        this.deepFilter = new ArrayList<FilterSatellit>();
        this.deepFilter.add(deepFilter);
    }
    /**
     * Set-Funktion zum überschreiben der deepfilter-Struktur
     * @param deepFilter, setzen von deepfilter
     */
    public void setDeepFilter(List<FilterSatellit> deepFilter) {
        this.deepFilter = deepFilter;
    }
    /**
     * Funktion zum Durchführen des filter Filters auf dem aktuellen Satelliten
     * @param satellit, Satellit der gefiltert werden soll
     * @return Boolean, ob der Satellit der angeforderten Filterstruktur entspricht
     * @post Eindeutige Entscheidung ob der Satellit Teil der gefilterten Struktur sein soll oder nicht
     */
    public Boolean filter_data(Satellit satellit){
        // use filter on data (AND operation)
        if (this.filter == null){
            return this.getDeepFilterBoolean(satellit);
        }
        return this.filter.filter(satellit) && this.getDeepFilterBoolean(satellit);
    };
    /**
     * Funktion zum rekursiven Durchreichen des zu filternden Satelliten an die Filter in der deepfilter Liste
     * @param satellit, Satellit der gefiltert werden soll
     * @return Boolean, ob der der Satellit der angeforderten Filterstruktur entspricht
     * @post Eindeutige Entscheidung ob der Satellit Teil der gefilterten Struktur sein soll oder nicht
     */
    public Boolean getDeepFilterBoolean(Satellit satellit){
        if (this.deepFilter == null){
            return true;
        }
        return this.deepFilter.stream().anyMatch(filter->filter.filter_data(satellit));
    }
}
