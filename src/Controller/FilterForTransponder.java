package Controller;
import Model.Transponder;
/**
 * Interface zur allgemeinen Definition eines Filters für einen Transponder
 * @author 4328112, 1319658, 1060449
 * @version 3.1
 */
public interface FilterForTransponder {
    /**
     * Funktion zum Filtern eines Transponders
     * @param transponder, Transponder der gefiltert werden soll
     * @return Boolean, ob der der Transponder der angeforderten Filterstruktur entspricht
     * @post Eindeutige Entscheidung ob der Transponder Teil der gefilterten Struktur sein soll oder nicht
     */
    Boolean filter(Transponder transponder);
}

