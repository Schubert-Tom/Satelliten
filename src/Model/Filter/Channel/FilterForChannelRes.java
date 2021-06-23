package Model.Filter.Channel;
import Controller.FilterForChannel;
import Model.Channel;


/**
 * Klasse zum Filtern eines Channels nach dem res Feld
 *
 * @author 4328112, 1319658, 1060449
 * @version 1.2
 */
public class FilterForChannelRes implements FilterForChannel {
    private final String res;
    /**
     * Konstruktor für Klasse FilterForChannelRes
     * @param res, res String nach dem gefiltert werden soll
     * @post Instanz von FilterForChannelRes erstellt
     */
    public FilterForChannelRes(String res) {
        this.res = res;
    }
    /**
     * Funktion entscheidet ob der der übergebene Channel dem Filterkriterium res genügt
     * @param channel, Channelinstanz, der validiert wird
     * @return Boolean true-->Channel genügt dem Kriterium||false-->Channel genügt nicht dem Kriterium
     */
    @Override
    public Boolean filter(Channel channel) {
        return channel.getRes().equals(this.res);
    }
}