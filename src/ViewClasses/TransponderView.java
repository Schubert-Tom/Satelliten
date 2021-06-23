package ViewClasses;

import Model.Satellit;
import Model.Transponder;
import org.apache.commons.beanutils.BeanUtils;

import java.lang.reflect.InvocationTargetException;

public class TransponderView extends Transponder {
    private Satellit satellit = null;
    private Integer count = null;

    public TransponderView(Satellit satellit,Transponder transponder) throws InvocationTargetException, IllegalAccessException {
        BeanUtils.copyProperties(this, transponder);
        this.satellit = satellit;
        this.setChannels(null);
    }

    public TransponderView(Integer count, Transponder transponder) throws InvocationTargetException, IllegalAccessException {
        BeanUtils.copyProperties(this, transponder);
        this.count = count;
    }

    public void setSatellit(Satellit satellit) {
        this.satellit = satellit;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Satellit getSatellit() {
        return satellit;
    }

    public Integer getCount() {
        return count;
    }


}
