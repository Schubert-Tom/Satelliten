package Controller;

import Model.Channel;
import Model.Data;

import java.util.regex.Pattern;

public abstract class FilterChannel implements Filter{
    private String sollwert;
    public abstract Data filter_data(Data data);
}
