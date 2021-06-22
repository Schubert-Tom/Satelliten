package Model;

import java.util.List;

public class Satellit {
    private String sat;
    private List<Transponder> transonder;

    public Satellit()
    {};
    public Satellit (String sat)
    {
        this.sat = sat;
    }

    public List<Transponder> getTransonder() {
        return transonder;
    }
}
