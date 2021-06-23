package Model.Filter.Channel;
import Controller.FilterForChannel;
import Model.Channel;

/**
 * Klasse zum Filtern eines Channels nach dem sid Feld
 *
 * @author 4328112, 1319658, 1060449
 * @version 1.4
 */
public class FilterForChannelSid implements FilterForChannel {
    private final String sid;
    /**
     * Konstruktor für Klasse FilterForChannelSid
     * @param sid, sid String nach dem gefiltert werden soll
     * @post Instanz von FilterForChannelSid erstellt
     */
    public FilterForChannelSid(String sid) {
        this.sid = sid;
    }
    /**
     * Funktion entscheidet ob der der übergebene Channel dem Filterkriterium sid genügt
     * @param channel, Channelinstanz, der validiert wird
     * @return Boolean true-->Channel genügt dem Kriterium||false-->Channel genügt nicht dem Kriterium
     */
    @Override
    public Boolean filter(Channel channel) {
        return channel.getSid().equals(this.sid);
    }
}