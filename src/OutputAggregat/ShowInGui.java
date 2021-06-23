package OutputAggregat;

import org.jetbrains.annotations.NotNull;

import javax.swing.*;

public class ShowInGui implements OutputAggregat{


        public void useAggregat(@NotNull JTextArea jta, String jsonString) {
            jta.setText(jsonString);
    }
}
