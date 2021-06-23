package Model.Filter.Channel;
import Controller.FilterForChannel;
import Model.Channel;


/**
 * Klasse zum Filtern eines Channels nach dem name Feld
 *
 * @author 4328112, 1319658, 1060449
 * @version 1.2
 */
public class FilterForChannelName implements FilterForChannel {
    private final String name;
    /**
     * Konstruktor für Klasse FilterForChannelName
     * @param name, name String nach dem gefiltert werden soll
     * @post Instanz von FilterForChannelName erstellt
     */
    public FilterForChannelName(String name) {
        this.name = name;
    }
    /**
     * Funktion entscheidet ob der der übergebene Channel dem Filterkriterium name genügt
     * @param channel, Channelinstanz, der validiert wird
     * @return Boolean true-->Channel genügt dem Kriterium||false-->Channel genügt nicht dem Kriterium
     */
    @Override
    public Boolean filter(Channel channel) {
        return channel.getEnc().equals(this.name);
    }
}