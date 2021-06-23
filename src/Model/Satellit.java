package Model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class Satellit {
    private String name = null;
    private List<Transponder> transponders = null;

    //Für View
    private List<Channel> channels = null;
    private Integer count = null;

    public Satellit(List<Transponder> transponders, String name) {
        this.transponders = transponders;
        this.name = name;
    }

    public Satellit() {
    }

    public List<Transponder> getTransponders() {
        return transponders;
    }

    public String getName() {
        return name;
    }

    public void setTransponders(List<Transponder> transponders) {
        this.transponders = transponders;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Channel> getChannels() {
        return channels;
    }

    public void setChannels(List<Channel> channels) {
        this.channels = channels;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}

