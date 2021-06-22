package Controller;

import Model.Channel;
import Model.Data;
import Model.Satellit;
import Model.Transponder;

public interface Filter {
    public Integer filter_data(Satellit satellit);
    public Integer filter_data(Transponder transponder);
    public Integer filter_data(Channel channel);
}
