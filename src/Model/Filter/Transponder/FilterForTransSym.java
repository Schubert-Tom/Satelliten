package Model.Filter.Transponder;
import Controller.FilterForTransponder;
import Model.Transponder;


/**
 * Klasse zum Filtern eines Transponders nach dem sym Feld
 *
 * @author 4328112, 1319658, 1060449
 * @version 1.2
 */
public class FilterForTransSym implements FilterForTransponder {
    private final String sym;
    /**
     * Konstruktor für Klasse FilterForTransSym
     * @param sym, sym String nach dem gefiltert werden soll
     * @post Instanz von FilterForTransSym erstellt
     */
    public FilterForTransSym(String sym) {
        this.sym = sym;
    }
    /**
     * Funktion entscheidet ob der der übergebene Transponder dem Filterkriterium sym genügt
     * @param transponder, Transponder, der validiert wird
     * @return Boolean true-->Transponder genügt dem Kriterium||false-->Transponder genügt nicht dem Kriterium
     */
    @Override
    public Boolean filter(Transponder transponder) {
        return transponder.getSym().equals(this.sym);
    }
}
