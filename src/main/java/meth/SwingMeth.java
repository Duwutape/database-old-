package meth;

import javax.swing.*;
import java.awt.*;

public class SwingMeth {

    public static void addToPanel(JPanel panel, JComponent component, double weigthx, int gridx, int gridy, int gridwidth) {
        GridBagConstraints c = new GridBagConstraints();

        c.weightx = weigthx;
        c.gridx = gridx;
        c.gridy = gridy;
        c.gridwidth = gridwidth;
        panel.add(component, c);
    }
    public static void addToPanel(JPanel panel, JComponent component, double weigthx, int gridx, int gridy, int gridwidth, boolean isSep) {
        GridBagConstraints c = new GridBagConstraints();

        c.weightx = weigthx;
        c.gridx = gridx;
        c.gridy = gridy;
        c.gridwidth = gridwidth;

        if (isSep) {
            c.gridheight = 10;
        } else {
            c.gridheight = 1;
        }
        panel.add(component, c);
    }

    public static void sepToPanel(JPanel panel, JComponent component, int gridx, int gridy){
        GridBagConstraints c = new GridBagConstraints();

        c.gridx = gridx;
        c.gridy = gridy;
        c.weightx = 1.0;
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridwidth = GridBagConstraints.REMAINDER;
        panel.add(component, c);
    }

    /*public static void closeWindow(JFrame frame){
        frame.dispose();
    }*/
}
