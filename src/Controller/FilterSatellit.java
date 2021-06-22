package Controller;

import Model.Data;

public abstract class FilterSatellit implements Filter {
    private String sollwert;
    public abstract Data filter_data(Data model);
}
