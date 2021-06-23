package Formatter;

/*

1. Aufbau 1. Stufe      S           T           C
          2. STufe      T k Ck      C k S k     T? S?   --> filter nach TRansponder mit kanal und entnehme?
          3. Stufe      C k T?*     S?* ...













*/

import Model.Satellit;
import ViewClasses.SatellitView;
import org.apache.commons.beanutils.BeanUtils;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

public class SatellitFormatter extends Formatter{

    public SatellitFormatter(char back, int place, List<Satellit> satellits) {
        //this.front = front;
        this.back = back;
        this.place = place;
        this.satellits = satellits;
    }


    public List<?> format(char back, List<Satellit> satellitsList) {


            if( back == 'T') {
                return satellitsList;
            }else if (back == ' '){
                //TO DO
                List<Satellit> satellits1 = new ArrayList<Satellit>();
                satellitsList.forEach(satellit -> {
                    Satellit sat = new Satellit();
                    try {
                        BeanUtils.copyProperties(sat, satellit);
                    } catch (IllegalAccessException | InvocationTargetException e) {
                        e.printStackTrace();
                    }
                    sat.setTransponders(null);
                    satellits1.add(sat);
                });
                return satellits1;

            }else if(back == 'C'){
                List<SatellitView> satellitViewsList = new ArrayList<SatellitView>();
                satellitsList.forEach(satellit -> {
                    try {
                        SatellitView sat = new SatellitView(getAllChannels(),satellit);
                        sat.setTransponders(null);
                        satellitViewsList.add(sat);
                    } catch (InvocationTargetException | IllegalAccessException e) {
                        e.printStackTrace();
                    }
                });
                return satellitViewsList;
            }


        return list;
    }
}
