package Model.Filter.Transponder;

import Controller.FilterForTransponder;
import Model.Transponder;

/**
 * Klasse zum Filtern eines Transponders nach dem pol Feld
 *
 * @author 4328112, 1319658, 1060449
 * @version 1.2
 */
public class FilterForTransponderPol implements FilterForTransponder {
    private String pol;
    /**
     * Konstruktor für Klasse FilterForTransponderPol
     * @param pol, pol String nach dem gefiltert werden soll
     * @post Instanz von FilterForTransponderPol erstellt
     */
    public FilterForTransponderPol(String pol){
        this.pol=pol;
    }
    /**
     * Funktion entscheidet ob der der übergebene Transponder dem Filterkriterium pol genügt
     * @param transponder, Transponder, der validiert wird
     * @return Boolean true-->Transponder genügt dem Kriterium||false-->Transponder genügt nicht dem Kriterium
     */
    @Override
    public Boolean filter(Transponder transponder) {
        return transponder.getPol().equals(this.pol);
    }
}
