package ViewClasses;

import Model.Channel;
import Model.Satellit;
import Model.Transponder;
import org.apache.commons.beanutils.BeanUtils;

import java.lang.reflect.InvocationTargetException;

public class ChannelView extends Channel {
    //Für view
    private Transponder transponder = null;
    private Satellit satellit = null;
    private String sat = null;
    private Integer count = null;

    public ChannelView(Transponder transponder, Channel channel) throws InvocationTargetException, IllegalAccessException {
        BeanUtils.copyProperties(this, channel);
        this.transponder = transponder;
    }

    public ChannelView(Satellit satellit, Channel channel) throws InvocationTargetException, IllegalAccessException {
        BeanUtils.copyProperties(this, channel);
        this.satellit = satellit;
    }

    public ChannelView(String sat, Channel channel) throws InvocationTargetException, IllegalAccessException {
        BeanUtils.copyProperties(this, channel);
        this.sat = sat;
    }

    public Transponder getTransponder() {
        return transponder;
    }

    public Satellit getSatellit() {
        return satellit;
    }

    public String getSat() {
        return sat;
    }

    public Integer getCount() {
        return count;
    }

    public void setTransponder(Transponder transponder) {
        this.transponder = transponder;
    }

    public void setSatellit(Satellit satellit) {
        this.satellit = satellit;
    }

    public void setSat(String sat) {
        this.sat = sat;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}
