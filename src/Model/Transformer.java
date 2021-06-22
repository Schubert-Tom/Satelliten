package Model;

import java.util.ArrayList;
import java.util.List;

public class Transformer {
    private List<Transponder> transponders;

    public Transformer(List<Transponder> transponders) {
        this.transponders = transponders;
    }

    public List<Satellit> transform(){
          List<Satellit> satellits = new ArrayList<Satellit>();

          transponders.forEach(transponder -> {
              if(satellits.stream().noneMatch(o -> o.getName().equals(transponder.getSat()))) {
                  List<Transponder> temp = new ArrayList<Transponder>();
                  temp.add(transponder);
                  satellits.add(new Satellit(temp, transponder.getSat()));
              }else{
                  satellits.stream().filter(o -> o.getName().equals(transponder.getSat()))
                          .forEach(
                                  o -> o.getTransponders().add(transponder)
                          );
              }
          });
          return satellits;
      }
}



