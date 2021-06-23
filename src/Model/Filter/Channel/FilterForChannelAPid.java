package Model.Filter.Channel;
import Controller.FilterForChannel;
import Model.Channel;


/**
 * Klasse zum Filtern eines Channels nach dem a_pid Feld
 *
 * @author 4328112, 1319658, 1060449
 * @version 1.0
 */
public class FilterForChannelAPid implements FilterForChannel {
    private final String a_pid;
    /**
     * Konstruktor für Klasse FilterForChannelAPid
     * @param a_pid, a_pid String nach dem gefiltert werden soll
     * @post Instanz von FilterForChannelAPid erstellt
     */
    public FilterForChannelAPid(String a_pid) {
        this.a_pid = a_pid;
    }
    /**
     * Funktion entscheidet ob der der übergebene Channel dem Filterkriterium a_pid genügt
     * @param channel, Channelinstanz, der validiert wird
     * @return Boolean true-->Channel genügt dem Kriterium||false-->Channel genügt nicht dem Kriterium
     */
    @Override
    public Boolean filter(Channel channel) {
        return channel.getA_pid().equals(this.a_pid);
    }
}


