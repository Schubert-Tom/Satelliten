package Controller;

import Model.Transponder;

import java.util.ArrayList;
import java.util.List;

/**
 * Klasse beschreibt das Vorgehen zum Filtern auf Transponder-Ebene.
 * Der Filter filter hält einen Filter zum validieren des Transponders.
 * Die List<FilterChannel> hält weitere Filter die mit dem Filter filter verundet sind.
 * Die List<FilterChannel> hält weitere Filter die untereinander verodert sind.
 * @author 4328112, 1319658, 1060449
 * @version 4.0
 */
public class FilterTransponder{
    // filter und deepfilter werden miteinander verundet
    private FilterForTransponder filter;
    // FilterSatelliten in deepfilter werden miteinander verodert
    private java.util.List<FilterTransponder> deepFilter;
    /**
     * Konstruktor für Klasse FilterTransponder
     * @param filter, filter der einen konkreten Filter für diese Ebene definiert
     * @param deepFilter, deepFilter der die weitere Filterstruktur beschreibt
     * @post Instanz von FilterTransponder erstellt
     */
    public FilterTransponder(FilterForTransponder filter, List<FilterTransponder> deepFilter) {
        this.filter = filter;
        this.deepFilter = deepFilter;
    }
    /**
     * Konstruktor für Klasse FilterChannel
     * @param filter, filter der einen konkreten Filter für diese Ebene definiert
     * @param deepFilter, deepFilter der nur aus einem Filter besteht --> einfaches Und
     * @post Instanz von FilterChannel erstellt
     */
    public FilterTransponder(FilterForTransponder filter, FilterTransponder deepFilter) {
        this.filter = filter;
        this.deepFilter = new ArrayList<FilterTransponder>();
        this.deepFilter.add(deepFilter);
    }
    /**
     * Set-Funktion zum überschreiben der deepfilter-Struktur
     * @param deepFilter, setzen von deepfilter
     */
    public void setDeepFilter(List<FilterTransponder> deepFilter) {
        this.deepFilter = deepFilter;
    }
    /**
     * Funktion zum Durchführen des filter Filters auf dem aktuellen Transponder
     * @param transponder, Tatellit der gefiltert werden soll
     * @return Boolean, ob der Transponder der angeforderten Filterstruktur entspricht
     * @post Eindeutige Entscheidung ob der Transponder Teil der gefilterten Struktur sein soll oder nicht
     */
    public Boolean filter_data(Transponder transponder){
        // use filter on data (AND operation)
        if (this.filter == null){
            return this.getDeepFilterBoolean(transponder);
        }
        return this.filter.filter(transponder) && this.getDeepFilterBoolean(transponder);
    }
    /**
     * Funktion zum rekursiven Durchreichen des zu filternden Transponders an die Filter in der deepfilter Liste
     * @param transponder, Transponder der gefiltert werden soll
     * @return Boolean, ob der der Transponder der angeforderten Filterstruktur entspricht
     * @post Eindeutige Entscheidung ob der Transponder Teil der gefilterten Struktur sein soll oder nicht
     */
    public Boolean getDeepFilterBoolean(Transponder transponder){
        if (this.deepFilter == null){
            return true;
        }
        return this.deepFilter.stream().anyMatch(filter->filter.filter_data(transponder));
    }
}
