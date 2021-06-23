package Controller;

import Model.Channel;
import Model.Data;
import Model.Satellit;

import java.util.List;

/*public interface FilterForChannel {
    List<Channel> filter(List<Channel> channelList);
}
*/
public interface FilterForChannel {
    Boolean filter(Channel channel);
}
