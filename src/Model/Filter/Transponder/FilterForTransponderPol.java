package Model.Filter.Transponder;

import Controller.FilterForTransponder;
import Model.Transponder;

public class FilterForTransponderPol implements FilterForTransponder {
    private String pol;

    public FilterForTransponderPol(String pol){
        this.pol=pol;
    }
    @Override
    public Boolean filter(Transponder transponder) {
        return transponder.getPol().equals(this.pol);
    }
}
