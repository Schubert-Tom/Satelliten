package ViewClasses;
import Model.Channel;
import Model.Satellit;
import org.apache.commons.beanutils.BeanUtils;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

public class SatellitView extends Model.Satellit {
    private List<Channel> channels = null;
    private Integer count = null;

    public SatellitView(List<Channel> channels, Satellit satellit) throws InvocationTargetException, IllegalAccessException {
        BeanUtils.copyProperties(this, satellit);
        this.channels = channels;
        this.setTransponders(null);
    }

    public SatellitView(int count, Satellit satellit) throws InvocationTargetException, IllegalAccessException {
        BeanUtils.copyProperties(this, satellit);
        this.count = count;
    }

    public void setChannels(List<Channel> channels) {
        this.channels = channels;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public List<Channel> getChannels() {
        return channels;
    }

    public Integer getCount() {
        return count;
    }
}
