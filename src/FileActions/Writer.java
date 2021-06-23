package FileActions;

import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
/**
 * Klasse zum Schreiben eines Strings in eine Datei
 * @author 4328112, 1319658, 1060449
 * @version 2.1
 */
public class Writer {

    private String filePath;
    /**
     * Konstruktor für Klasse Writer
     * @param path, Dateipfad
     * @param name, Dateiname
     * @post Instanz von Writer erstellt
     */
    public Writer(String path, String name){
        this.filePath = path + File.separator + name;
    }
    /**
     * Funktion zum Schreiben in eine Datei
     * @param content zu schreibender String
     * @post geschriebenes file
     */
    public void write(String content)
    {
        Path path = Paths.get(this.filePath);
        try {
            final BufferedWriter writer = Files.newBufferedWriter(path, StandardCharsets.UTF_8,
                    StandardOpenOption.CREATE);
            writer.write(content);
            writer.flush();
        } catch(IOException e)
        { e.printStackTrace();
        }
    }
}
