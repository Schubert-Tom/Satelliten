package Model;
import java.util.*;
import java.util.stream.Stream;

public class Filter {
    Filterarg filarg;
    public ArrayList<Filter> filter;

    public void filter(){
        // filter model nach this.filarg über Filterarg konkrete Implementierung z.B FilterSatellit mit der methode filter
        Data data=this.filarg.filter();
        // start filter function for all filters of this.filter
            //result = Streamof(this.filter).filter();
        // Schnittmenge aus result und data

    }
}
