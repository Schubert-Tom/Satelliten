package FileActions;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class Writer {

    private String filePath;

    public Writer(String path, String name){
        this.filePath = filePath;
        //.getSelectedFile().getName();
        //.getCurrentDirectory().toString();
    }

    /*
    final String content = "{\"TEST\":\"test\"}";
    final Path path = Paths.get("output.json");
        try (
    final BufferedWriter writer = Files.newBufferedWriter(path,
            StandardCharsets.UTF_8, StandardOpenOption.CREATE);
        ) {
        writer.write(content);
        writer.flush();
    }catch(Exception e){
        jta.setText("ERROR SAVING FAILED");    }

     */
}
