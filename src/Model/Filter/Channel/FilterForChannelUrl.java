package Model.Filter.Channel;
import Controller.FilterForChannel;
import Model.Channel;


/**
 * Klasse zum Filtern eines Channels nach dem url Feld
 *
 * @author 4328112, 1319658, 1060449
 * @version 1.2
 */
public class FilterForChannelUrl implements FilterForChannel {
    private final String url;
    /**
     * Konstruktor für Klasse FilterForChannelUrl
     * @param url, url String nach dem gefiltert werden soll
     * @post Instanz von FilterForChannelUrl erstellt
     */
    public FilterForChannelUrl(String url) {
        this.url = url;
    }
    /**
     * Funktion entscheidet ob der der übergebene Channel dem Filterkriterium url genügt
     * @param channel, Channelinstanz, der validiert wird
     * @return Boolean true-->Channel genügt dem Kriterium||false-->Channel genügt nicht dem Kriterium
     */
    @Override
    public Boolean filter(Channel channel) {
        return channel.getUrl().equals(this.url);
    }
}


