package Model;

import org.json.simple.JSONObject;

import java.util.List;

public class JavaToJson {

    public void transform(List<Satellit> satellits, char[] view){
        //Creating a JSONObject object
        JSONObject jsonObject = new JSONObject();
        for (int i=0; i < view.length; i++){
            if (view[i] == 'S'){
                jsonObject.put("sat", satellits);
            }
            SatellitWithChannels test = new SatellitWithChannels(satellits.get(0).getTransponders());
        }

    }
}
