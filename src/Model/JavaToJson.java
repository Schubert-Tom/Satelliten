package Model;

import FileActions.Writer;
import org.json.simple.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class JavaToJson {

    private List<Satellit>satellits;

    public JavaToJson (List<Satellit>satellits){
        this.satellits = satellits;
    }

    public String transform( int view, int count){
        //Creating a JSONObject object
        JSONObject jsonObject = new JSONObject();
        switch (view) {
            case 1 -> { //S
                removeTransponderFromSat();
                return getAllSat();
            }
            case 2, 6 -> {//T//TS

                removeChannelsFromTransponder();
                return getAllTransponders();
            }
            case 3 ->{//C
                return getAllChannels();
            }
            case 4 -> {//ST //count T
                removeChannelsFromTransponder();
                if(count ==1)
                   countTranspondersForSat();
                return getAllSat();
            }
            case 5 -> {//SC //count C
                addChannelsToSat();
                removeTransponderFromSat();
                if(count ==1)
                    countChannelsForSat();
                return getAllSat();
            }
            case 7 ->{//TC //count C
                if(count ==1)
                    countChannelsForTrans();
                return getAllTransponders();
            }
            case 8 -> {//CS
                addSatStringToChannel();
                return getAllChannels();
            }
            case 9, 15 -> {//CT//CTS
                addTranspondersToChannel();
                removeChannelsFromTransponder2();
                return getAllChannels();
            }
            case 10 ->{//STC //count T //count C
                if(count == 1 || count ==3)
                    countTranspondersForSat();
                if(count == 2 || count ==3)
                    countChannelsForTrans();
                return getAllSat();
            }
            case 11 -> {//SCT //count C
                addTranspondersToChannel();
                removeChannelsFromTransponder2();
                addChannelsToSat();
                removeTransponderFromSat();
                if(count ==1)
                    countChannelsForSat();
                return getAllSat();
            }
            case 12 -> {//TSC //count C
                addChannelsToSat();
                addSatToTransponder();
                removeTransponderFromSat2();
                removeChannelsFromTransponder();
                if(count == 2)
                    countChannelsForSat2();
                return getAllTransponders();
            }
            case 13 -> {//TCS //count C
                addSatStringToChannel();
                if(count == 1)
                    countChannelsForTrans();
                return getAllTransponders();
            }
            case 14 -> {//CST //count T
                addSatToChannel();
                removeChannelsFromTransponder3();
                if(count == 2)
                    countTranspondersForSat2();
                return getAllChannels();
            }

        }
        return null;
    }
    public String putJson(String key, List value){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put(key, value);
        //Writer writer = new Writer("","output.txt");
        return jsonObject.toJSONString();
    }
    public String getAllSat(){
        return putJson("sat",satellits);
    }
    public String getAllTransponders(){
        List<Transponder>transponders = new ArrayList<Transponder>();
        satellits.forEach( satellit -> {
            transponders.addAll(satellit.getTransponders());
        });
        return putJson("transponders", transponders);
    }
    public String getAllChannels(){
        List<Channel>channels = new ArrayList<Channel>();
        satellits.forEach( satellit -> {
            satellit.getTransponders().forEach(transponder -> {
                channels.addAll(transponder.getChannels());
            });
        });
        return putJson("channels",channels);
    }
    public void countTranspondersForSat(){
        satellits.forEach(satellit -> {
            satellit.setCount(satellit.getTransponders().size());
        });
    }
    public void countTranspondersForSat2(){
        satellits.forEach(satellit -> {
            satellit.getTransponders().forEach(transponder -> {
                transponder.getChannels().forEach(channel -> {
                    channel.getSatellit().setCount(channel.getSatellit().getTransponders().size());
                });
            });
        });
    }
    public void countChannelsForSat(){
        satellits.forEach(satellit -> {
            satellit.setCount(satellit.getChannels().size());
        });
    }
    public void countChannelsForSat2(){
        satellits.forEach(satellit -> {
            satellit.getTransponders().forEach(transponder -> {
                transponder.getSatellit().setCount(transponder.getSatellit().getChannels().size());
            });
        });
    }
    public void countChannelsForTrans(){
        satellits.forEach(satellit -> {
            satellit.getTransponders().forEach(transponder -> {
                transponder.setCount(transponder.getChannels().size());
            });
        });
    }
    public  void removeTransponderFromSat(){
        satellits.forEach( satellit -> {satellit.setTransponders(null);});
    }
    public  void removeTransponderFromSat2(){
        satellits.forEach( satellit -> {satellit.getTransponders().forEach(transponder ->{
            transponder.getSatellit().setTransponders(null);
         });
        });
    }
    public void removeChannelsFromTransponder(){
        satellits.forEach( satellit -> {
            satellit.getTransponders().forEach(transponder -> {
                transponder.setChannels(null);
            });
        });
    }
    public void removeChannelsFromTransponder2(){
        satellits.forEach( satellit -> {
            satellit.getTransponders().forEach(transponder -> {
                transponder.getChannels().forEach(channel -> {
                    channel.getTransponder().setChannels(null);
                });
            });
        });
    }
    public void removeChannelsFromTransponder3(){
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
    public void addSatToTransponder(){
        satellits.forEach( satellit -> {
            satellit.getTransponders().forEach(transponder -> {
                transponder.setSatellit(satellit);
            });
        });
    }
    public void addTranspondersToChannel (){
        satellits.forEach( satellit -> {
            satellit.getTransponders().forEach(transponder -> {
                transponder.getChannels().forEach( channel -> {
                    channel.setTransponder(transponder);
                });
            });
        });
    }
    public void addSatToChannel (){
        satellits.forEach( satellit -> {
            satellit.getTransponders().forEach(transponder -> {
                transponder.getChannels().forEach( channel -> {
                    channel.setSatellit(satellit);
                });
            });
        });
    }
    public void addSatStringToChannel(){
        satellits.forEach( satellit -> {
            satellit.getTransponders().forEach(transponder -> {
                transponder.getChannels().forEach( channel -> {
                    channel.setSat(satellit.getName());
                });
            });
        });
    }

}
