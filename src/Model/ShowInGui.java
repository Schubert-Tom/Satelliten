package Model;

import org.jetbrains.annotations.NotNull;

import javax.swing.*;

public class ShowInGui implements OutputAggregat{


        public void useAggregat(@NotNull JTextArea jta) {
            jta.setText("Output string");
    }
}
