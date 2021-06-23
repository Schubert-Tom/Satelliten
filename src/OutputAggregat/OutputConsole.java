package OutputAggregat;

import org.jetbrains.annotations.NotNull;

import java.util.function.BiConsumer;
import javax.swing.*;
/**
 * Klasse um String in konsole (Popup) auszugeben
 *@author 4328112, 1319658, 1060449
 *@version 1.1
 */
public class OutputConsole implements BiConsumer<String, JFrame> {
    /**
     * Funktion Überprüfung
     */
    @Override
    public void accept(String content, JFrame jf) {
        JOptionPane.showMessageDialog(jf, content);
    }
}
