package Model;

import FileActions.Writer;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.ArrayList;
import java.util.List;

public class JavaToJson {

    private List<Satellit>satellits;

    public JavaToJson (List<Satellit>satellits){
        this.satellits = satellits;
    }

    public String transform( ViewCode view, CountCode count){


        switch (view) {
            case S -> { //S
                removeTransponderFromSat();
                return getAllSat();
            }
            case T, TS -> {//T//TS

                removeChannelsFromTransponder();
                return getAllTransponders();
            }
            case C ->{//C
                return getAllChannels();
            }
            case ST -> {//ST //count T
                removeChannelsFromTransponder();
                if(count ==CountCode.countFirstOrder)
                   countTranspondersForSat();
                return getAllSat();
            }
            case SC -> {//SC //count C
                addChannelsToSat();
                removeTransponderFromSat();
                if(count == CountCode.countFirstOrder)
                    countChannelsForSat();
                return getAllSat();
            }
            case TC ->{//TC //count C
                if(count ==CountCode.countFirstOrder)
                    countChannelsForTrans();
                return getAllTransponders();
            }
            case CS -> {//CS
                addSatStringToChannel();
                return getAllChannels();
            }
            case CT, CTS -> {//CT//CTS
                addTranspondersToChannel();
                removeChannelsFromTransponder2();
                return getAllChannels();
            }
            case STC ->{//STC //count T //count C
                if(count == CountCode.countFirstOrder || count ==CountCode.getCountFirstAndSecondOrder)
                    countTranspondersForSat();
                if(count == CountCode.countSecondOrder || count ==CountCode.getCountFirstAndSecondOrder)
                    countChannelsForTrans();
                return getAllSat();
            }
            case SCT -> {//SCT //count C
                addTranspondersToChannel();
                removeChannelsFromTransponder2();
                addChannelsToSat();
                removeTransponderFromSat();
                if(count ==CountCode.countFirstOrder)
                    countChannelsForSat();
                return getAllSat();
            }
            case TSC -> {//TSC //count C
                addChannelsToSat();
                addSatToTransponder();
                removeTransponderFromSat2();
                removeChannelsFromTransponder();
                if(count == CountCode.countSecondOrder)
                    countChannelsForSat2();
                return getAllTransponders();
            }
            case TCS -> {//TCS //count C
                addSatStringToChannel();
                if(count == CountCode.countFirstOrder)
                    countChannelsForTrans();
                return getAllTransponders();
            }
            case CST -> {//CST //count T
                addSatToChannel();
                removeChannelsFromTransponder3();
                if(count == CountCode.countSecondOrder)
                    countTranspondersForSat2();
                return getAllChannels();
            }

        }
        return null;
    }
    public String putJson(String key, List<?> value){

        String json = null;
        try {
            json = new ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(value);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        //Writer writer = new Writer("","output.txt");
        return json;
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
