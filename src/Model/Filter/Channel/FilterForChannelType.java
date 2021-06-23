package Model.Filter.Channel;
import Controller.FilterForChannel;
import Model.Channel;


/**
 * Klasse zum Filtern eines Channels nach dem type Feld
 *
 * @author 4328112, 1319658, 1060449
 * @version 1.2
 */
public class FilterForChannelType implements FilterForChannel {
    private final String type;
    /**
     * Konstruktor für Klasse FilterForChannelType
     * @param type, type String nach dem gefiltert werden soll
     * @post Instanz von FilterForChannelType erstellt
     */
    public FilterForChannelType(String type) {
        this.type = type;
    }
    /**
     * Funktion entscheidet ob der der übergebene Channel dem Filterkriterium type genügt
     * @param channel, Channelinstanz, der validiert wird
     * @return Boolean true-->Channel genügt dem Kriterium||false-->Channel genügt nicht dem Kriterium
     */
    @Override
    public Boolean filter(Channel channel) {
        return channel.getType().equals(this.type);
    }
}