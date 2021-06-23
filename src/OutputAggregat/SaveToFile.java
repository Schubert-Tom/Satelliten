package OutputAggregat;

import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import java.io.BufferedWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

import FileActions.Writer;

public class SaveToFile implements OutputAggregat {

    public void useAggregat(@NotNull JTextArea jta, String jsonString) {

        jta.setText("Saving in file: output.json");
        Writer writer = new Writer("","output.json");
        writer.write(jsonString);
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
    }

         */
    }
}

