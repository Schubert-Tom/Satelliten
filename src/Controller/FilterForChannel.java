package Controller;
import Model.Channel;
/**
 * Interface zur allgemeinen Definition eines Filters für einen Channel
 * @author 4328112, 1319658, 1060449
 * @version 3.1
 */
public interface FilterForChannel {
    /**
     * Funktion zum Filtern eines Channels
     * @param channel, Transponder der gefiltert werden soll
     * @return Boolean, ob der der Transponder der angeforderten Filterstruktur entspricht
     * @post Eindeutige Entscheidung ob der Transponder Teil der gefilterten Struktur sein soll oder nicht
     */
    Boolean filter(Channel channel);
}
