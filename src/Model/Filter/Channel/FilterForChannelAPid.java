package Model.Filter.Channel;
import Controller.FilterForChannel;
import Model.Channel;

public class FilterForChannelAPid implements FilterForChannel {
    private final String a_pid;

    public FilterForChannelAPid(String a_pid) {
        this.a_pid = a_pid;
    }
    @Override
    public Boolean filter(Channel channel) {
        return channel.getA_pid().equals(this.a_pid);
    }
}


