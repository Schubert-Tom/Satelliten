package Model.Filter.Satellit;

import Controller.FilterForSatellit;
import Model.Satellit;

/**
 * Klasse zum Filtern eines Satelliten nach dem name Feld
 *
 * @author 4328112, 1319658, 1060449
 * @version 1.2
 */
public class FilterForSatellitName implements FilterForSatellit {
    private final String name;
    /**
     * Konstruktor für Klasse FilterForSatellitName
     * @param name, name String nach dem gefiltert werden soll
     * @post Instanz von FilterForSatellitName erstellt
     */
    public FilterForSatellitName(String name) {
        this.name = name;
    }
    /**
     * Funktion entscheidet ob der der übergebene Satellit dem Filterkriterium name genügt
     * @param satellit, Satelliten, der validiert wird
     * @return Boolean true-->Satellit genügt dem Kriterium||false-->Satellit genügt nicht dem Kriterium
     */
    @Override
    public Boolean filter(Satellit satellit) {
        return satellit.getName().equals(this.name);
    }
}
