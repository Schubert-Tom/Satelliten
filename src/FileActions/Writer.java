package FileActions;

import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class Writer {

    private String filePath;

    public Writer(String path, String name){
        this.filePath = path + File.pathSeparator + name;
    }

    public <T extends ErrorHandler> void write(String content,  T errorHandler)
    {
        Path path = Paths.get(this.filePath);
        try {
            final BufferedWriter writer = Files.newBufferedWriter(path, StandardCharsets.UTF_8,
                    StandardOpenOption.CREATE);
            writer.write(content);
            writer.flush();
        } catch(IOException e)
        {
            String message = "An error occurred whilst writing the result to the given path.\n Error Message: " + e;
            errorHandler.resolveError(message);
        }
    }
}
