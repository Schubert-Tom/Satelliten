package FileActions;

import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

import com.google.gson.*;
import java.io.FileReader;

public class Reader {

    private String filePath;

    public Reader(String path, String name){
        this.filePath = path + File.pathSeparator + name;
    }

    public <T extends ErrorHandler> String read(T errorHandler)
    {
        String content = "";
        Path path = Paths.get(this.filePath);
        try {
            final BufferedWriter writer = Files.newBufferedWriter(path, StandardCharsets.UTF_8,
                    StandardOpenOption.CREATE);
            writer.write(content);
            writer.flush();


            /*
            Gson gson = new Gson();

            // 1. JSON file to Java object
            Object object = gson.fromJson(new FileReader(this.filePath), Object.class);
            */


        } catch(IOException e)
        {
            String message = "An error occurred whilst reading the JSON-File from the given path.\n Error Message: " + e;
            errorHandler.resolveError(message);
        }
        return content;
    }
}
