package Model;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.List;



public class JsonConverter {

    public List<Transponder> convert(String json) {
      //  String json = reader.readFile();
        ObjectMapper mapper = new ObjectMapper();
        try {
            List<Transponder> transponders = mapper.readValue(json, mapper.getTypeFactory().constructCollectionType(List.class, Transponder.class));
            System.out.println(transponders.size());
           // System.out.println(transponders.get(0).getCodeName());
            return transponders;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}