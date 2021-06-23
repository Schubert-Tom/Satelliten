package Model.Filter.Transponder;
import Controller.FilterForTransponder;
import Model.Transponder;

public class FilterForTransponderFreq implements FilterForTransponder {
    private final String freq;
    public FilterForTransponderFreq(String freq) {
        this.freq = freq;
    }

    @Override
    public Boolean filter(Transponder transponder) {
        return transponder.getFreq().equals(this.freq);
    }
}