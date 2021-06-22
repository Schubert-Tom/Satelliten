package Model;

import FileActions.Writer;
import org.json.simple.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class JavaToJson {

    private ArrayList<Satellit>satellits;
    public JavaToJson (ArrayList<Satellit>satellits){
        this.satellits = satellits;
    }
    public void transform( int view){
        //Creating a JSONObject object
        JSONObject jsonObject = new JSONObject();
        switch (view) {
            case 1 -> { //S
                removeTransponderSat();
                getAllSat();
            }
            case 2, 6 -> {//T//TS

                removeChannelsTransponder();
                getAllTransponders();
            }
            case 3 ->//C
                    getAllChannels();
            case 4 -> {//ST
                removeChannelsTransponder();
                getAllSat();
            }
            case 5 -> {//SC
                addChannelsToSat();
                removeTransponderSat();
                getAllSat();
            }
            case 7 ->//TC
                    getAllTransponders();
            case 8 -> {//CS
                addSatStringChannel();
                getAllChannels();
            }
            case 9 -> {//CT
                addTranspondersChannel();
                removeChannelsTransponder2();
                getAllChannels();
            }
            case 10 ->//STC
                    getAllSat();
            case 11 -> {//SCT
                addTranspondersChannel();
                removeChannelsTransponder2();
                addChannelsToSat();
                removeTransponderSat();
                getAllSat();
            }
            case 12 -> {//TSC
                addChannelsToSat();
                addSatTransponder();
                removeTransponderSat2();
                getAllChannels();
            }
            case 13 -> {//TCS
                addSatStringChannel();
                getAllTransponders();
            }
            case 14 -> {//CST
                addSatChannel();
                removeChannelsTransponder3();
                getAllChannels();
            }
            case 15 -> {//CTS
                addTranspondersChannel();
                removeChannelsTransponder2();
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
    public  void removeTransponderSat2(){
        satellits.forEach( satellit -> {satellit.getTransponders().forEach(transponder ->{
            transponder.getSatellit().setTransponders(null);
         });
        });
    }
    public void removeChannelsTransponder(){
        satellits.forEach( satellit -> {
            satellit.getTransponders().forEach(transponder -> {
                transponder.setChannels(null);
            });
        });
    }
    public void removeChannelsTransponder2(){
        satellits.forEach( satellit -> {
            satellit.getTransponders().forEach(transponder -> {
                transponder.getChannels().forEach(channel -> {
                    channel.getTransponder().setChannels(null);
                });
            });
        });
    }
    public void removeChannelsTransponder3(){
        satellits.forEach( satellit -> {
            satellit.getTransponders().forEach(transponder -> {
                transponder.getChannels().forEach(channel -> {
                    channel.getSatellit().getTransponders().forEach(transponder1 -> {
                        transponder1.setChannels(null);
                    });
                });
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
                    channel.setSatelit(satellit);
                });
            });
        });
    }
    public void addSatStringChannel (){
        satellits.forEach( satellit -> {
            satellit.getTransponders().forEach(transponder -> {
                transponder.getChannels().forEach( channel -> {
                    channel.setSat(satellit.getName());
                });
            });
        });
    }
}
