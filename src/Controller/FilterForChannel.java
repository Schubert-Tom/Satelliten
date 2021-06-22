package Controller;

import Model.Channel;
import Model.Data;
import java.util.List;

public interface FilterForChannel {
    List<Channel> filter(List<Channel> channelList);
}
