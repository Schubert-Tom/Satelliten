package ExternalWorkload;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Loader {
    public static void loadClass(String location, String nameOfClass)
    {
        String pathString = location + File.separator + nameOfClass;
        Path path = Paths.get(pathString);
        ByteClassLoader loader = new ByteClassLoader();

        try {
            loader.defineClass(nameOfClass, Files.readAllBytes(path));
            loader.loadClass(nameOfClass);
        } catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }
    }

    public static <T> T buildObject(Class<T> outputClass){
        T output;
        try {
            Constructor<? extends T> constructor = outputClass.getConstructor();
            output = constructor.newInstance();
        } catch(NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
            throw new RuntimeException("Laden des Aggregats nicht möglich.");
        }
        return output;
    }

}
