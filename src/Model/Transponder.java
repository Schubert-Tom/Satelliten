package Model;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class Transponder {
    private String pol;
    private String sat;
    private String orbital;
    private String freq;
    private String sym;
    private List<Channel> channels;

    //Für View
    private Satellit satellit = null;
    private Integer count = null;

    public String getSat() {
        return sat;
    }

    public List<Channel> getChannels() {
        return channels;
    }

    public void setPol(String pol) {
        this.pol = pol;
    }

    public void setSat(String sat) {
        this.sat = sat;
    }

    public void setOrbital(String orbital) {
        this.orbital = orbital;
    }

    public void setFreq(String freq) {
        this.freq = freq;
    }

    public void setSym(String sym) {
        this.sym = sym;
    }

    public void setChannels(List<Channel> channels) {
        this.channels = channels;
    }

    public String getPol() {
        return pol;
    }

    public String getOrbital() {
        return orbital;
    }

    public String getFreq() {
        return freq;
    }

    public String getSym() {
        return sym;
    }

    public Satellit getSatellit() {
        return satellit;
    }

    public void setSatellit(Satellit satellit) {
        this.satellit = satellit;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}
