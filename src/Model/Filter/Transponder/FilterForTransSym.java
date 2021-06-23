package Model.Filter.Transponder;
import Controller.FilterForTransponder;
import Model.Transponder;

public class FilterForTransSym implements FilterForTransponder {
    private final String sym;
    public FilterForTransSym(String sym) {
        this.sym = sym;
    }

    @Override
    public Boolean filter(Transponder transponder) {
        return transponder.getSym().equals(this.sym);
    }
}
