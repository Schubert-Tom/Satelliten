package Model.Filter.Transponder;
import Controller.FilterForTransponder;
import Model.Transponder;

/**
 * Klasse zum Filtern eines Transponders nach dem freq Feld
 *
 * @author 4328112, 1319658, 1060449
 * @version 1.2
 */
public class FilterForTransponderFreq implements FilterForTransponder {
    private final String freq;
    /**
     * Konstruktor für Klasse FilterForTransponderFreq
     * @param freq, freq String nach dem gefiltert werden soll
     * @post Instanz von FilterForTransponderFreq erstellt
     */
    public FilterForTransponderFreq(String freq) {
        this.freq = freq;
    }
    /**
     * Funktion entscheidet ob der der übergebene Transponder dem Filterkriterium freq genügt
     * @param transponder, Transponder, der validiert wird
     * @return Boolean true-->Transponder genügt dem Kriterium||false-->Transponder genügt nicht dem Kriterium
     */
    @Override
    public Boolean filter(Transponder transponder) {
        return transponder.getFreq().equals(this.freq);
    }
}