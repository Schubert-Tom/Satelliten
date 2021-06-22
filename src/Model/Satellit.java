package Model;

import java.util.List;



public class Satellit {
    private String name;
    private List<Transponder> transponders;

    //Für view
    private List<Channel>channels;

    public Satellit(List<Transponder> transponders, String name) {
        this.transponders = transponders;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public List<Transponder> getTransponders() {
        return transponders;
    }

    public void setTransponders(List<Transponder> transponders) {
        this.transponders = transponders;
    }



}

