package Model.Filter.Channel;
import Controller.FilterForChannel;
import Model.Channel;

public class FilterForChannelCompression implements FilterForChannel {
    private final String compression;

    public FilterForChannelCompression(String compression) {
        this.compression = compression;
    }
    @Override
    public Boolean filter(Channel channel) {
        return channel.getCompression().equals(this.compression);
    }
}


