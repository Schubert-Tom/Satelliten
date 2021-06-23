package ExternalWorkload;

import Controller.Aggregat;

import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.function.Supplier;

public class GetAggregat{
    public static Aggregat get(String location, String nameOfClass) {
        //nameOfClass = nameOfClass.split(".class")[0];
        Aggregat ag;

        String pathString = location + File.separator + nameOfClass;
        nameOfClass = "te.MyClass";
        Path path = Paths.get(pathString);//.toAbsolutePath();
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
