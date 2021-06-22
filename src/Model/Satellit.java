package Model;

import java.nio.channels.Channels;
import java.util.List;

public class Satellit{
    private List<Transponder> transponders;
    private String name;
    private List<Channel> channels;

    public Satellit(List<Transponder> transponders, String name, List<Channel> channels) {
        this.transponders = transponders;
        this.name = name;
        this.channels = channels;
    }

    public String getName() {
        return name;
    }

    public List<Channel> getChannels() {
        return channels;
    }

    public List<Transponder> getTransponders() {
        return transponders;
    }

    public void setTransponders(List<Transponder> transponders) {
        this.transponders = transponders;
    }
}
