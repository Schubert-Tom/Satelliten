package Model.Filter.Channel;
import Controller.FilterForChannel;
import Model.Channel;


/**
 * Klasse zum Filtern eines Channels nach dem compression Feld
 *
 * @author 4328112, 1319658, 1060449
 * @version 1.1
 */
public class FilterForChannelCompression implements FilterForChannel {
    private final String compression;
    /**
     * Konstruktor für Klasse FilterForChannelCompression
     * @param compression, compression String nach dem gefiltert werden soll
     * @post Instanz von FilterForChannelCompression erstellt
     */
    public FilterForChannelCompression(String compression) {
        this.compression = compression;
    }
    /**
     * Funktion entscheidet ob der der übergebene Channel dem Filterkriterium compression genügt
     * @param channel, Channelinstanz, der validiert wird
     * @return Boolean true-->Channel genügt dem Kriterium||false-->Channel genügt nicht dem Kriterium
     */
    @Override
    public Boolean filter(Channel channel) {
        return channel.getCompression().equals(this.compression);
    }
}


