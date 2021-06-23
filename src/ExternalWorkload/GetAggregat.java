package ExternalWorkload;

import Controller.Aggregat;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.function.Supplier;

/**
 * Klasse um Aggregate aus externen Directories zu laden
 *@author 4328112, 1319658, 1060449
 *@version 3.4
 */

public class GetAggregat{
    /**
     * Lädt aggregat an angegebener Location mit dem Namen nameOfClass
     *
     * @param location, Pfad der Aggregat Klasse
     * @param nameOfClass, Name der Klasse
     * @return Geladenes Aggregat
     */
    public static Aggregat get(String location, String nameOfClass) {
        Aggregat ag;
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

        try {
            Class<? extends Supplier<Aggregat>> outputClass = (Class<? extends Supplier<Aggregat>>) Class.forName(nameOfClass);
            Constructor<? extends Supplier<Aggregat>> constructor = outputClass.getConstructor();
            Object output = constructor.newInstance();
            Method methode = outputClass.getMethod("get");
            ag = (Aggregat) methode.invoke(output);
        } catch (ClassNotFoundException | NoSuchMethodException | IllegalAccessException | InvocationTargetException | InstantiationException e) {
            e.printStackTrace();
            throw new RuntimeException("Laden des Aggregats nicht möglich.");
        }
        return ag;
    }
}
