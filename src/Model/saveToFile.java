package Model;

import javax.swing.*;
import java.io.BufferedWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class saveToFile implements OutputAggregat {
    @Override
    public void useAggregat(JTextArea jta) {
        jta.setText("Saving in file: output.txt ATTENTION Overwrite possible");
        final String content = "TEST";
        final Path path = Paths.get("output.txt");

        try (
                final BufferedWriter writer = Files.newBufferedWriter(path,
                        StandardCharsets.UTF_8, StandardOpenOption.CREATE);
        ) {
            writer.write(content);
            writer.flush();
        }catch(Exception e){
            jta.setText("ERROR SAVING FAILED");    }
    }
}

