package Model;

import java.util.List;



public class Satellit {
    private String name = null;
    private List<Transponder> transponders = null;



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
}

