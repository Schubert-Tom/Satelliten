package Controller;

import Model.Satellit;

public class filterForSatalliteName implements FilterForSatellit{
    private String name;
    public filterForSatalliteName(String name){
        this.name = name;
    }
    @Override
    public Boolean filter(Satellit satellit) {
        return satellit.getName().equals(this.name);
    }
}
