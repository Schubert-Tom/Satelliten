package OutputAggregat;
import FileActions.Reader;
import Model.JsonConverter;
import Model.Transformer;
import View.Gui;

import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.function.BiConsumer;

public class OutputJSON implements BiConsumer<String, JFrame>{

    @Override
    public void accept(String content, JFrame jf) {
        String path = choosePath(jf);
        if(path != null)
            write(path, content);
    }

    private String choosePath(JFrame jf) {
        JFileChooser c = new JFileChooser();
        c.setAcceptAllFileFilterUsed(false);

        c.setFileFilter(new FileFilter() {

            public String getDescription() {
                return "JSON Files (*.json)";
            }

            public boolean accept(File f) {
                if (f.isDirectory()) {
                    return true;
                } else {
                    String filename = f.getName().toLowerCase();
                    return filename.endsWith(".json");
                }
            }
        });
        int rVal = c.showOpenDialog(jf);
        if (rVal == JFileChooser.APPROVE_OPTION) {
            return  c.getCurrentDirectory().toString()+File.separator+c.getSelectedFile().getName();
        }
        return null;
    }

    private void write(String filePath, String content)
    {
        Path path = Paths.get(filePath);
        try {
            final BufferedWriter writer = Files.newBufferedWriter(path, StandardCharsets.UTF_8,
                    StandardOpenOption.CREATE);
            writer.write(content);
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
