package Model.Filter.Channel;
import Controller.FilterForChannel;
import Model.Channel;


/**
 * Klasse zum Filtern eines Channels nach dem pack Feld
 *
 * @author 4328112, 1319658, 1060449
 * @version 1.2
 */
public class FilterForChannelPack implements FilterForChannel {
    private final String pack;
    /**
     * Konstruktor für Klasse FilterForChannelPack
     * @param pack, pack String nach dem gefiltert werden soll
     * @post Instanz von FilterForChannelPack erstellt
     */
    public FilterForChannelPack(String pack) {
        this.pack = pack;
    }
    /**
     * Funktion entscheidet ob der der übergebene Channel dem Filterkriterium pack genügt
     * @param channel, Channelinstanz, der validiert wird
     * @return Boolean true-->Channel genügt dem Kriterium||false-->Channel genügt nicht dem Kriterium
     */
    @Override
    public Boolean filter(Channel channel) {
        return channel.getPack().equals(this.pack);
    }
}