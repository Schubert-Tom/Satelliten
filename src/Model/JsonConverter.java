package Model;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.List;


/**
 * Klasse konvertiert den Transponder JSON String zur entsprechenden Java Objektstruktur
 * @author 4328112, 1319658, 1060449
 * @version 2.3
 */
public class JsonConverter {
    /**
     * Funktion zum Konvertieren des Json String
     * @param json, zu konvertierender JSON String
     * @return transponders, List of transponders entsprechend im JSON
     */
    public List<Transponder> convert(String json) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            List<Transponder> transponders = mapper.readValue(json, mapper.getTypeFactory().constructCollectionType(List.class, Transponder.class));
            System.out.println(transponders.size());
            return transponders;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}