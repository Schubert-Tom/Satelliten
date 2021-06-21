package Model;

import javax.swing.*;

public class ShowInGui implements OutputAggregat{


    @Override
    public void useAggregat(JTextArea jta) {
        jta.setText("Output string");
    }
}
