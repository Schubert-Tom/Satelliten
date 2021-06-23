package Model;

import java.util.ArrayList;
import java.util.List;
/**
 * Klasse transformiert den konvertierten JSON String  zur gewünschten Objektstruktur STC
 * @author 4328112, 1319658, 1060449
 * @version 2.3
 */
public class Transformer {
    private List<Transponder> transponders;

    /**
     * Konstruktor für Klasse Transformer
     * @param transponders, zu transformierende transponder Liste
     * @post Instanz von Transformer erstellt
     */
    public Transformer(List<Transponder> transponders) {
        this.transponders = transponders;
    }

    /**
     * Funktion zum Durchführen des filter Filters auf dem aktuellen Channel
     * @return List<Satellit> Liste von Satelliten
     * @post neue Objektstruktur STC
     */
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



