package OutputAggregat;

import org.jetbrains.annotations.NotNull;

import java.util.function.BiConsumer;
import javax.swing.*;

public class OutputConsole implements BiConsumer<String, JFrame> {

    @Override
    public void accept(String content, JFrame jf) {
        JOptionPane.showMessageDialog(jf, content);
    }
}
