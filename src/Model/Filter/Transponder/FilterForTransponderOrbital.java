package Model.Filter.Transponder;
import Controller.FilterForTransponder;
import Model.Transponder;

/**
 * Klasse zum Filtern eines Transponders nach dem orbital Feld
 *
 * @author 4328112, 1319658, 1060449
 * @version 1.2
 */
public class FilterForTransponderOrbital implements FilterForTransponder {
    private final String orbital;
    /**
     * Konstruktor für Klasse FilterForTransponderOrbital
     * @param orbital, freq String nach dem gefiltert werden soll
     * @post Instanz von FilterForTransponderOrbital erstellt
     */
    public FilterForTransponderOrbital(String orbital) {
        this.orbital = orbital;
    }
    /**
     * Funktion entscheidet ob der der übergebene Transponder dem Filterkriterium orbital genügt
     * @param transponder, Transponder, der validiert wird
     * @return Boolean true-->Transponder genügt dem Kriterium||false-->Transponder genügt nicht dem Kriterium
     */
    @Override
    public Boolean filter(Transponder transponder) {
        return transponder.getOrbital().equals(this.orbital);
    }
}