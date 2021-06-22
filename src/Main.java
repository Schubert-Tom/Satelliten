import java.io.File;

import Model.Filter;
import Model.*;
import com.google.gson.*;
import org.jetbrains.annotations.NotNull;
//import org.json.simple.JSONArray;
//import org.json.simple.JSONObject;
//import org.json.simple.parser.JSONParser;

import java.io.FileReader;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Satellit sat = new Satellit("This is the Sat Name");

        Channel chan1 = new Channel("SID 1234");
        Channel chan2 = new Channel("SID 4567");
        List<Channel> listChannels = new ArrayList<>();
        listChannels.add(chan1);
        listChannels.add(chan2);
        extraLists<Satellit, Channel> el = new extraLists<>(listChannels, sat);
    }
       /* String json = "{\n" +
                "  \"filarg\": null,\n" +
                "  \"filter\": [\n" +
                "    {\n" +
                "      \"filarg\": \"Channel ARD\",\n" +
                "      \"filter\": [\n" +
                "        {\n" +
                "          \"filarg\": \"Transponder A\",\n" +
                "          \"filter\": [\n" +
                "            {\n" +
                "              \"filarg\": \"TV Channel\",\n" +
                "              \"filter\": []\n" +
                "            },\n" +
                "            {\n" +
                "              \"filarg\": \"Radio Channel\",\n" +
                "              \"filter\": []\n" +
                "            }\n" +
                "          ]\n" +
                "        },\n" +
                "        {\n" +
                "          \"filarg\": \"Transponder B\",\n" +
                "          \"filter\": []\n" +
                "        }\n" +
                "      ]\n" +
                "    },\n" +
                "    {\n" +
                "      \"filarg\": \"Satelit B\",\n" +
                "      \"filter\": [\n" +
                "        {\n" +
                "          \"filarg\": \"Transponder C\",\n" +
                "          \"filter\": []\n" +
                "        },\n" +
                "        {\n" +
                "          \"filarg\": \"Transponder D\",\n" +
                "          \"filter\": []\n" +
                "        }\n" +
                "      ]\n" +
                "    }\n" +
                "  ]\n" +
                "}\n";
        Gson gson = new Gson();

        Filter filter = gson.fromJson(json, Filter.class);
        int a =0;
    }
    public class Car {
        public String brand = null;
        public Integer doors = 0;
        public Integer test = 1;
    }

  /*  private static final Type REVIEW_TYPE = new TypeToken<List<Review>>() {
    }.getType();
    Gson gson = new Gson();
    JsonReader reader = new JsonReader(new FileReader(filename));
    List<Review> data = gson.fromJson(reader, REVIEW_TYPE); // contains the whole reviews list
    data.toScreen(); // prints to screen some values
*/
}
