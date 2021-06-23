package ExternalWorkload;

import Controller.Aggregat;

import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Constructor;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.function.BiConsumer;

/**
 * Klasse um Aggregate aus externen Directories zu laden
 *@author 4328112, 1319658, 1060449
 *@version 3.4
 */


public class ExportData {

    /**
     * Lädt Output-Klasse an angegebener Location mit dem Namen nameOfClass und übergibt das aktuelle Fenster und die zu schreibenden Daten
     *
     * @param location, Pfad zur Klasse
     * @param nameOfClass, Name der Klasse
     * @param jFrame, Fenster
     * @param content, zu schreibende JSOn Daten
     */
    public static void export(String location, String nameOfClass, JFrame jFrame, String content){
        String[] pathElements = location.split(File.separator);
        String pathString = location + File.separator + nameOfClass;
        nameOfClass = pathElements[pathElements.length-1] + "." + nameOfClass.split(".class")[0];
        Path path = Paths.get(pathString);
        ByteClassLoader loader = new ByteClassLoader();

        try {
            loader.defineClass(nameOfClass, Files.readAllBytes(path));
            loader.loadClass(nameOfClass);
        } catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }
        try{
            Class<? extends BiConsumer<String, JFrame>> outputClass = (Class<? extends BiConsumer<String, JFrame>>) Class.forName(nameOfClass);
            Constructor<? extends BiConsumer<String, JFrame>> constructor = outputClass.getConstructor();
            Object output = constructor.newInstance();
            Method methode = outputClass.getMethod("accept", String.class, JFrame.class);
            methode.invoke(output, content, jFrame);
        } catch(ClassNotFoundException | NoSuchMethodException | IllegalAccessException | InvocationTargetException | InstantiationException e) {
            e.printStackTrace();
            throw new RuntimeException("Laden und Ausführen der Ausgabe nicht möglich.");
        }
    }
}
