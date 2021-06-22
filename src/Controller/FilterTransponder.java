package Controller;

import Model.Channel;
import Model.Data;
public abstract class FilterTransponder implements Filter {
    private String sollwert;
    public abstract Data filter_data(Data model);
}
