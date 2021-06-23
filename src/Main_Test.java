import java.io.File;

import Model.Filter;
import Model.*;
import View.Gui;
import com.google.gson.*;
import org.jetbrains.annotations.NotNull;
//import org.json.simple.JSONArray;
//import org.json.simple.JSONObject;
//import org.json.simple.parser.JSONParser;

import java.io.FileReader;
import java.util.*;

public class Main {


    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Gui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Gui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Gui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Gui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Gui().setVisible(true);
            }
        });
    }


















    public static void main(String[] args) {
        Satellit sat = new Satellit("This is the Sat Name");

        Channel chan1 = new Channel("SID 1234");
        Channel chan2 = new Channel("SID 4567");
        List<Channel> listChannels = new ArrayList<>();
        listChannels.add(chan1);
        listChannels.add(chan2);
        extraLists<Satellit, Channel> el = new extraLists<>(listChannels, sat);
    }
        String json = "{\n" +
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
