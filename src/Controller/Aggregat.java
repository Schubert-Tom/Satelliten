package Controller;

import Model.ViewCode;
import Model.CountCode;

public class Aggregat {
    private CompleteFilter filter;
    private ViewCode view;
    private CountCode count;

    public Aggregat(CompleteFilter filter, ViewCode view, CountCode count){
        this.filter = filter;
        this.view =  view;
        this.count = count;
    }
    public ViewCode getView(){return this.view;}
    public CountCode getCount(){return this.count;}
}
