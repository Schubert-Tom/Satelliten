package FileActions;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
/**
 * Klasse zum Lesen eines Strings von einer Datei
 * @author 4328112, 1319658, 1060449
 * @version 2.1
 */
public class Reader {

    private String filePath;
    /**
     * Konstruktor für Klasse Reader
     * @param path, Dateipfad
     * @param name, Dateiname
     * @post Instanz von Reader erstellt
     */
    public Reader(String path, String name){
        this.filePath = path + File.separator +name;
    }
    /**
     * Funktion zum lesen in eine Datei
     * @return gelesener String
     */
    public String readFile() {
        try{
            return Files.readString(Paths.get(this.filePath));
        }catch(IOException e){
            e.printStackTrace();
        }
        return null;
    }

}
