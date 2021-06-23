package Model;

import Controller.FilterForTransponder;

public class FilterForTransponderPol implements FilterForTransponder {
    private String pol;
    public FilterForTransponderPol(String pol){
        this.pol=pol;
    }
    @Override
    public Boolean filter(Transponder transponder) {
        return transponder.getPol().equals(pol);
    }
}
