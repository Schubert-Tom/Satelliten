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
        nameOfClass = nameOfClass.split(".class")[0];
        Loader.loadClass(location, nameOfClass);
        try{
            Class<? extends BiConsumer<String, JFrame>> outputClass = (Class<? extends BiConsumer<String, JFrame>>) Class.forName(nameOfClass);
            Object output = Loader.buildObject(outputClass);
            Method methode = outputClass.getMethod("accept", String.class, JFrame.class);
            methode.invoke(output, content, jFrame);
        } catch(ClassNotFoundException|NoSuchMethodException| IllegalAccessException|InvocationTargetException e) {
            e.printStackTrace();
            throw new RuntimeException("Laden und Ausführen der Ausgabe nicht möglich.");
        }
    }
}
