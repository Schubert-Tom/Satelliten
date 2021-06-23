package Model.Filter.Channel;
import Controller.FilterForChannel;
import Model.Channel;

/**
 * Klasse zum Filtern eines Channels nach dem enc Feld
 *
 * @author 4328112, 1319658, 1060449
 * @version 1.0
 */
public class FilterForChannelEnc implements FilterForChannel {
    private final String enc;
    /**
     * Konstruktor für Klasse FilterForChannelEnc
     * @param enc, enc String nach dem gefiltert werden soll
     * @post Instanz von FilterForChannelEnc erstellt
     */
    public FilterForChannelEnc(String enc) {
        this.enc = enc;
    }
    /**
     * Funktion entscheidet ob der der übergebene Channel dem Filterkriterium enc genügt
     * @param channel, Channelinstanz, der validiert wird
     * @return Boolean true-->Channel genügt dem Kriterium||false-->Channel genügt nicht dem Kriterium
     */
    @Override
    public Boolean filter(Channel channel) {
        return channel.getEnc().equals(this.enc);
    }
}