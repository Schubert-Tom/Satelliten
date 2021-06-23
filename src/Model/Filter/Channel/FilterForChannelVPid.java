package Model.Filter.Channel;
import Controller.FilterForChannel;
import Model.Channel;


/**
 * Klasse zum Filtern eines Channels nach dem v_pid Feld
 *
 * @author 4328112, 1319658, 1060449
 * @version 1.2
 */
public class FilterForChannelVPid implements FilterForChannel {
    private final String v_pid;
    /**
     * Konstruktor für Klasse FilterForChannelVPid
     * @param v_pid, v_pid String nach dem gefiltert werden soll
     * @post Instanz von FilterForChannelVPid erstellt
     */
    public FilterForChannelVPid(String v_pid) {
        this.v_pid = v_pid;
    }
    /**
     * Funktion entscheidet ob der der übergebene Channel dem Filterkriterium v_pid genügt
     * @param channel, Channelinstanz, der validiert wird
     * @return Boolean true-->Channel genügt dem Kriterium||false-->Channel genügt nicht dem Kriterium
     */
    @Override
    public Boolean filter(Channel channel) {
        return channel.getV_pid().equals(this.v_pid);
    }
}