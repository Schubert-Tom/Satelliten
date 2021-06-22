package Model;

import FileActions.Writer;
import org.json.simple.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class JavaToJson {

    private ArrayList<Satellit>satellits;
    public void transform( int view){
        //Creating a JSONObject object
        JSONObject jsonObject = new JSONObject();
        switch (view){
            case 1: //S
                removeTransponderSat();
                getAllSat();
                break;
            case 2://T
                removeChannelsTransponder();
                getAllTransponders();
                break;
            case 3://C
                getAllChannels();
                break;
            case 4://ST
                removeChannelsTransponder();
                putJson("sat",satellits);
                break;
            case 5://SC
                addChannelsToSat();
                removeTransponderSat();
                putJson("sat",satellits);
                break;
            case 6://TS
                addSatTransponder();
                removeChannelsTransponder();



        }

        if(view == 1){
            if(view[0] == 'S'){

            }else if(view[0] == 'T'){

            }else{

            }
        }else if (view.length == 2){
            if(view[0] == 'S' && view[1] == 'T'){

            }else if (view[0] == 'S' && view[1] == 'C'){}

        }
        for (int i=0; i < view.length; i++){
            if (view[i] == 'S'){
                if(view[i+1] != 'C') {
                    jsonObject.put("sat", satellits);
                }
            }

        }

    }
    public void putJson(String key, List value){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put(key, value);
    }
    public void getAllSat(){
        putJson("sat",satellits);
    }
    public void getAllTransponders(){
        List<Transponder>transponders = new ArrayList<Transponder>();
        satellits.forEach( satellit -> {
            transponders.addAll(satellit.getTransponders());
        });
        putJson("transponders", transponders);
    }
    public void getAllChannels(){
        List<Channel>channels = new ArrayList<Channel>();
        satellits.forEach( satellit -> {
            satellit.getTransponders().forEach(transponder -> {
                channels.addAll(transponder.getChannels());
            });
        });
        putJson("channels",channels);
    }
    public  void removeTransponderSat(){
        satellits.forEach( satellit -> {satellit.setTransponders(null);});
    }
    public void removeChannelsTransponder(){
        satellits.forEach( satellit -> {
            satellit.getTransponders().forEach(transponder -> {
                transponder.setChannels(null);
            });
        });
    }
    public void addChannelsToSat (){
        satellits.forEach( satellit -> {
            List<Channel>channels = new ArrayList<Channel>();
            satellit.getTransponders().forEach(transponder -> {
                channels.addAll(transponder.getChannels());
            });
            satellit.setChannels(channels);
        });
    }
    public void addSatTransponder (){
        satellits.forEach( satellit -> {
            satellit.getTransponders().forEach(transponder -> {
                transponder.setSatellit(satellit);
            });
        });
    }
    public void addTranspondersChannel (){
        satellits.forEach( satellit -> {
            satellit.getTransponders().forEach(transponder -> {
                transponder.getChannels().forEach( channel -> {
                    channel.setTransponder(transponder);
                });
            });
        });
    }
    public void addSatChannel (){
        satellits.forEach( satellit -> {
            satellit.getTransponders().forEach(transponder -> {
                transponder.getChannels().forEach( channel -> {
                    channel.setSat(satellit);
                });
            });
        });
    }
}
