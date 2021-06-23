package Model.Filter.Transponder;
import Controller.FilterForTransponder;
import Model.Transponder;

public class FilterForTransponderOrbital implements FilterForTransponder {
    private final String orbital;

    public FilterForTransponderOrbital(String name) {
        this.orbital = name;
    }

    @Override
    public Boolean filter(Transponder transponder) {
        return transponder.getOrbital().equals(this.orbital);
    }
}