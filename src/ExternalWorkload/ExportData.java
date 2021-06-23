package ExternalWorkload;

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
 * location = path zum directory, nameOfClass = Name (evtl noch .class wegschneiden), jFrame, content = jsonString
 */

public class ExportData {
    public static void export(String location, String nameOfClass, JFrame jFrame, String content){
        String pathString = location + File.separator + nameOfClass;
        Path path = Paths.get(pathString);
        ByteClassLoader loader = new ByteClassLoader();

        try{
            loader.defineClass(nameOfClass, Files.readAllBytes(path));
            loader.loadClass(nameOfClass);
        } catch(ClassNotFoundException| IOException e){
            e.printStackTrace();
        }

        try{
            Class<? extends BiConsumer<String, JFrame>> outputClass = (Class<? extends BiConsumer<String, JFrame>>) Class.forName(nameOfClass);
            Constructor<? extends BiConsumer<String, JFrame>> constructor = outputClass.getConstructor();
            Object output = constructor.newInstance();
            Method methode = outputClass.getMethod("accept", String.class, JFrame.class);
            methode.invoke(output, content, jFrame);
        } catch(ClassNotFoundException|NoSuchMethodException|InstantiationException|IllegalAccessException|InvocationTargetException e) {
            e.printStackTrace();
            throw new RuntimeException("Laden und Ausführen der Ausgabe nicht möglich.");
        }
    }
}
