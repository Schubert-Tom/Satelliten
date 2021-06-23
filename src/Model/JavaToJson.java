package Model;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.ArrayList;
import java.util.List;
/**
 * Klasse konvertiert die gegebene Struktur STC zu einer angegebenen neuen Struktur (ViewCode).
 * Nach Bedarf wird noch eine Zählung von Transponders und Kanälen durchgeführt (countCode)
 * Diese wird dann zu JSON konvertiert.
 * @author 4328112, 1319658, 1060449
 * @version 5.3
 */
public class JavaToJson {

    private List<Satellit>satellits;
    /**
     * Konstruktor für Klasse JavaToJson
     * @param satellits, Liste von Satelliten = gegebende Objektstruktur
     * @post Instanz von JavaToJson erstellt
     */
    public JavaToJson (List<Satellit>satellits){
        this.satellits = satellits;
    }

    /**
     * Funktion für Transformation der Struktur und KOnvertierung zu JSON
     * @param view, Code in welcher Struktur transfomiert werden soll
     * @param count Code ob und wo gezählt werden soll
     * @return json String of transformierte Struktur
     */
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
    /**
     * Funktion zur Konvertierung der Struktur zu JSON
     * @param key, JSON key
     * @param value, JSON value (Liste)
     * @return JSON string
     */
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
    /**
     * Funktion zum Sammeln aller Satelliten
     * @return  json String of SatellitenListe
     */
    public String getAllSat(){
        return putJson("sat",satellits);
    }
    /**
     * Funktion zum Sammeln aller Transponder
     * @return  json String of TransponderListe
     */
    public String getAllTransponders(){
        List<Transponder>transponders = new ArrayList<Transponder>();
        satellits.forEach( satellit -> {
            transponders.addAll(satellit.getTransponders());
        });
        return putJson("transponders", transponders);
    }
    /**
     * Funktion zum Sammeln aller Channels
     * @return  json String of Channelliste
     */
    public String getAllChannels(){
        List<Channel>channels = new ArrayList<Channel>();
        satellits.forEach( satellit -> {
            satellit.getTransponders().forEach(transponder -> {
                channels.addAll(transponder.getChannels());
            });
        });
        return putJson("channels",channels);
    }
    /**
     * Funktion zum Zählen aller Transponder jedes Satellits 1.Ordnung
     * Bsp: ST
     */
    public void countTranspondersForSat(){
        satellits.forEach(satellit -> {
            satellit.setCount(satellit.getTransponders().size());
        });
    }
    /**
     * Funktion zum Zählen aller Transponder jedes Satellits 2. Ordnung
     * Bsp: CST
     */
    public void countTranspondersForSat2(){
        satellits.forEach(satellit -> {
            satellit.getTransponders().forEach(transponder -> {
                transponder.getChannels().forEach(channel -> {
                    channel.getSatellit().setCount(channel.getSatellit().getTransponders().size());
                });
            });
        });
    }
    /**
     * Funktion zum Zählen aller Channels jedes Satellits 1. Ordnung
     * Bsp: SC
     */
    public void countChannelsForSat(){
        satellits.forEach(satellit -> {
            satellit.setCount(satellit.getChannels().size());
        });
    }
    /**
     * Funktion zum Zählen aller Channels jedes Satellits 2. Ordnung
     * Bsp: TSC
     */
    public void countChannelsForSat2(){
        satellits.forEach(satellit -> {
            satellit.getTransponders().forEach(transponder -> {
                transponder.getSatellit().setCount(transponder.getSatellit().getChannels().size());
            });
        });
    }
    /**
     * Funktion zum Zählen aller Channels jedes Transpoders 1. Ordnung
     * Bsp: TC
     */
    public void countChannelsForTrans(){
        satellits.forEach(satellit -> {
            satellit.getTransponders().forEach(transponder -> {
                transponder.setCount(transponder.getChannels().size());
            });
        });
    }
    /**
     * Funktion zum Entfernen der Transponderliste von Satelliten 1. Ordnung
     */
    public  void removeTransponderFromSat(){
        satellits.forEach( satellit -> {satellit.setTransponders(null);});
    }
    /**
     * Funktion zum Entfernen der Transponderliste von Satelliten 2. Ordnung
     */
    public  void removeTransponderFromSat2(){
        satellits.forEach( satellit -> {satellit.getTransponders().forEach(transponder ->{
            transponder.getSatellit().setTransponders(null);
         });
        });
    }
    /**
     * Funktion zum Entfernen der Channelliste von Transpondern 1. Ordnung
     */
    public void removeChannelsFromTransponder(){
        satellits.forEach( satellit -> {
            satellit.getTransponders().forEach(transponder -> {
                transponder.setChannels(null);
            });
        });
    }
    /**
     * Funktion zum Entfernen der Channelliste von Transpondern 2. Ordnung
     */
    public void removeChannelsFromTransponder2(){
        satellits.forEach( satellit -> {
            satellit.getTransponders().forEach(transponder -> {
                transponder.getChannels().forEach(channel -> {
                    channel.getTransponder().setChannels(null);
                });
            });
        });
    }
    /**
     * Funktion zum Entfernen der Channelliste von Transpondern 3. Ordnung
     */
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
    /**
     * Funktion zum Hinzufügen von Channelsliste zu Satelliten
     */
    public void addChannelsToSat (){
        satellits.forEach( satellit -> {
            List<Channel>channels = new ArrayList<Channel>();
            satellit.getTransponders().forEach(transponder -> {
                channels.addAll(transponder.getChannels());
            });
            satellit.setChannels(channels);
        });
    }
    /**
     * Funktion zum Hinzufügen von Satellit zu Transponder
     */
    public void addSatToTransponder(){
        satellits.forEach( satellit -> {
            satellit.getTransponders().forEach(transponder -> {
                transponder.setSatellit(satellit);
            });
        });
    }
    /**
     * Funktion zum Hinzufügen von Transponder zu Channels
     */
    public void addTranspondersToChannel (){
        satellits.forEach( satellit -> {
            satellit.getTransponders().forEach(transponder -> {
                transponder.getChannels().forEach( channel -> {
                    channel.setTransponder(transponder);
                });
            });
        });
    }
    /**
     * Funktion zum Hinzufügen von Satellit zu Channels
     */
    public void addSatToChannel (){
        satellits.forEach( satellit -> {
            satellit.getTransponders().forEach(transponder -> {
                transponder.getChannels().forEach( channel -> {
                    channel.setSatellit(satellit);
                });
            });
        });
    }
    /**
     * Funktion zum Hinzufügen von Satellit(String) zu Channels
     */
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
