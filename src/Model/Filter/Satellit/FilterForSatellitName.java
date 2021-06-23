package Model.Filter.Satellit;

import Controller.FilterForSatellit;
import Model.Satellit;

public class FilterForSatellitName implements FilterForSatellit {
    private final String name;

    public FilterForSatellitName(String name) {
        this.name = name;
    }

    @Override
    public Boolean filter(Satellit satellit) {
        return satellit.getName().equals(this.name);
    }
}
