package Controller;

import Model.Data;

public class CompleteFilter implements Filter {
    private FilterSatellit filterSatellit;
    private FilterTransponder filterTransponder;
    private FilterChannel filterChannel;

    public void filter(Data data){
        Data filtered_data=this.filterSatellit.filter_data(data);
        filtered_data=this.filterTransponder.filter_data(filtered_data);
        filtered_data=this.filterChannel.filter_data(filtered_data;
        return filtered_data;
    }
}
