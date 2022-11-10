package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static meth.AddSeriesMeth.createSeries;
import static meth.SwingMeth.addToPanel;

public class AddSeries implements ActionListener{

    static JFrame frame;
    static JPanel panel;
    JLabel nameOV, nameGer, language, alias;
    static JLabel invalidFill, invalidExists;
    JTextField tfNameOV, tfNameGer, tfLanguage, tfAlias;
    JButton button;
    String inputNameOV, inputLanguage, inputNameGer, inputAlias;

    public AddSeries() {

        createWindow();
        createGui();
    }

    private void createWindow() {
        frame = new JFrame("Add Series");
        frame.setSize(500, 200);
        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);

        panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        frame.getContentPane().add(panel);
        frame.setVisible(true);
    }

    private void createGui() {

        nameOV = new JLabel("Name OV*");
        language = new JLabel("Language OV*");
        nameGer = new JLabel("Name Ger*");
        alias = new JLabel("Alias");
        tfNameOV = new JTextField(30);
        tfLanguage = new JTextField(30);
        tfNameGer = new JTextField(30);
        tfAlias = new JTextField(30);
        button = new JButton("Submit");
        invalidFill = new JLabel("All with * marked fields must be filled in");
        invalidExists =new JLabel("Series already exists");

        addToPanel(panel, nameOV, 0.5 ,1, 0, 1);
        addToPanel(panel, tfNameOV, 0.5 ,2, 0, 2);
        addToPanel(panel, language, 0.5 ,1, 1, 1);
        addToPanel(panel, tfLanguage, 0.5 ,2, 1, 2);
        addToPanel(panel, nameGer, 0.5 ,1, 2, 1);
        addToPanel(panel, tfNameGer, 0.5 ,2, 2, 2);
        addToPanel(panel, alias, 0.5 ,1, 3, 1);
        addToPanel(panel, tfAlias, 0.5 ,2, 3, 2);
        addToPanel(panel, button, 0.5 ,2, 4, 2);

        button.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        inputNameOV = tfNameOV.getText();
        inputLanguage = tfLanguage.getText();
        inputNameGer = tfNameGer.getText();
        inputAlias = tfAlias.getText();

        createSeries(inputNameOV, inputLanguage, inputNameGer, inputAlias);
    }

    public static void updateGuiFill(boolean valid) {
        if (valid) {
            panel.remove(invalidFill);
        } else {
            addToPanel(panel, invalidFill, 0.5, 2, 5, 2);
        }
        frame.setVisible(true);
    }

    public static void updateGuiValid(boolean valid){
        if(valid){
            panel.remove(invalidExists);
        }else{
            addToPanel(panel, invalidExists, 0.5, 2, 6, 2);
        }
        frame.setVisible(true);
    }

    public static void closeWindow(){
        frame.dispose();
    }
}
