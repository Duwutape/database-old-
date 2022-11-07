package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static meth.AddSeasonMeth.createSeason;
import static meth.Meth.createList;
import static meth.SwingMeth.addToPanel;

public class AddSeason extends JFrame implements ActionListener {

    static JFrame frame;
    static JPanel panel;
    JLabel series, num, yearOV, yearGer, fsk, genre, platform, numEpi, lenEpi;
    static JLabel invalidFill, invalidNum, invalidNumArr, invalidIsNum, invalidExists;
    JTextField tfNum, tfYearOV, tfYearGer, tfFsk, tfGenre, tfPlatform, tfNumEpi, tfLenEpi;
    JButton button;
    JComboBox<String> comboBox;
    String inputSeries, inputNum, inputYearOV, inputYearGer, inputFsk, inputGenre, inputPlatform, inputNumEpi, inputLenEpi;
    final String PATH = "files/data/series";

    public AddSeason() {

        createWindow();
        createGui();
    }

    private void createWindow() {
        frame = new JFrame("Add Season");
        frame.setSize(600, 400);
        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);

        panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        frame.getContentPane().add(panel);
        frame.setVisible(true);
    }

    private void createGui() {

        series = new JLabel("Select Series");
        num = new JLabel("Season number (*|**)");
        yearOV = new JLabel("Release year OV (***)");
        yearGer = new JLabel("Release year Ger (***)");
        fsk = new JLabel("FSK (*|**)");
        genre = new JLabel("Genre");
        platform = new JLabel("Platform");
        numEpi = new JLabel("Number of Episodes (*|**)");
        lenEpi = new JLabel("Length of Episodes in minutes (*|**)");
        tfNum = new JTextField(30);
        tfYearOV = new JTextField(30);
        tfYearGer = new JTextField(30);
        tfFsk = new JTextField(30);
        tfGenre = new JTextField(30);
        tfPlatform = new JTextField(30);
        tfNumEpi = new JTextField(30);
        tfLenEpi = new JTextField(30);
        comboBox = new JComboBox<String>(createList(PATH));
        button = new JButton("Submit");
        invalidFill = new JLabel("Season number must be filled in");
        invalidNum = new JLabel("All marked with ** need to be only one number");
        invalidNumArr = new JLabel("All marked with *** could contain more numbers");
        invalidIsNum = new JLabel("All marked with * must be only digits");
        invalidExists = new JLabel("Season already exists");

        addToPanel(panel, series, 0.5, 1, 0, 1);
        addToPanel(panel, comboBox, 0.5, 2, 0, 2);
        addToPanel(panel, num, 0.5, 1, 1, 1);
        addToPanel(panel, tfNum, 0.5, 2, 1, 2);
        addToPanel(panel, yearOV, 0.5, 1, 2, 1);
        addToPanel(panel, tfYearOV, 0.5, 2, 2, 2);
        addToPanel(panel, yearGer, 0.5, 1, 3, 1);
        addToPanel(panel, tfYearGer, 0.5, 2, 3, 2);
        addToPanel(panel, fsk, 0.5, 1, 4, 1);
        addToPanel(panel, tfFsk, 0.5, 2, 4, 2);
        addToPanel(panel, genre, 0.5, 1, 5, 1);
        addToPanel(panel, tfGenre, 0.5, 2, 5, 2);
        addToPanel(panel, platform, 0.5, 1, 6, 1);
        addToPanel(panel, tfPlatform, 0.5, 2, 6, 2);
        addToPanel(panel, numEpi, 0.5, 1, 7, 1);
        addToPanel(panel, tfNumEpi, 0.5, 2, 7, 2);
        addToPanel(panel, lenEpi, 0.5, 1, 8, 1);
        addToPanel(panel, tfLenEpi, 0.5, 2, 8, 2);
        addToPanel(panel, button, 0.5, 2, 9, 2);

        button.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {

        inputSeries = comboBox.getItemAt(comboBox.getSelectedIndex());
        inputNum = tfNum.getText();
        inputYearOV = tfYearOV.getText();
        inputYearGer = tfYearGer.getText();
        inputFsk = tfFsk.getText();
        inputGenre = tfGenre.getText();
        inputPlatform = tfPlatform.getText();
        inputNumEpi = tfNumEpi.getText();
        inputLenEpi = tfLenEpi.getText();

        createSeason(inputSeries, inputNum, inputYearOV, inputYearGer, inputFsk, inputGenre, inputPlatform, inputNumEpi, inputLenEpi);
    }

    public static void updateGuiFill(boolean valid) {
        if (valid) {
            panel.remove(invalidFill);
        } else {
            addToPanel(panel, invalidFill, 0.5, 2, 10, 2);
        }
        frame.setVisible(true);
    }

    public static void updateGuiValidNum(boolean valid) {
        if (valid) {
            panel.remove(invalidNum);
            panel.remove(invalidNumArr);
        } else {
            addToPanel(panel, invalidNum, 0.5, 2, 11, 2);
            addToPanel(panel, invalidNumArr, 0.5, 2, 12, 2);
        }
        frame.setVisible(true);
    }

    public static void updateGuiIsNum(boolean valid) {
        if (valid) {
            panel.remove(invalidIsNum);
        } else {
            addToPanel(panel, invalidIsNum, 0.5, 2, 13, 2);
        }
        frame.setVisible(true);
    }

    public static void updateGuiValid(boolean valid) {
        if (valid) {
            panel.remove(invalidExists);
        } else {
            addToPanel(panel, invalidExists, 0.5, 2, 14, 2);
        }
        frame.setVisible(true);
    }

    public static void closeWindow(){
        frame.dispose();
    }
}
