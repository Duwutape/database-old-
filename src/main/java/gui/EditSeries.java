package gui;

import data.Series;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.File;
import java.util.ArrayList;

import static meth.EditSeriesMeth.editSeries;
import static meth.Meth.*;
import static meth.SwingMeth.addToPanel;

public class EditSeries implements ActionListener, ItemListener {
    static JFrame frame;
    static JPanel panel;
    JLabel selectSeries, nameOV, nameGer, language, alias;
    static JLabel invalidFill, invalidExists;
    JTextField tfNameOV, tfNameGer, tfLanguage, tfAlias;
    JButton button;
    JComboBox<String> comboBox;
    final String PATH = "files/data/series";
    File folder = new File(PATH);
    ArrayList<String> allSeries = readName(folder);
    String selectedSeries, inputNameOV, inputNameGer, inputLanguage, inputAlias;
    Series series;

    public EditSeries() {

        createWindow();
        createGui();
    }

    private void createWindow() {
        frame = new JFrame("Edit Series");
        frame.setSize(450, 225);
        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);

        panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        frame.getContentPane().add(panel);

        frame.setVisible(true);
    }

    private void createGui() {
        selectSeries = new JLabel("select series");
        comboBox = new JComboBox<>(createList(PATH));
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
        invalidExists = new JLabel("Series already exists");

        addToPanel(panel, selectSeries, 0.5, 1, 0, 1);
        addToPanel(panel, comboBox, 0.5, 2, 0, 1);
        addToPanel(panel, nameOV, 0.5, 1, 1, 1);
        addToPanel(panel, tfNameOV, 0.5, 2, 1, 2);
        addToPanel(panel, language, 0.5, 1, 2, 1);
        addToPanel(panel, tfLanguage, 0.5, 2, 2, 2);
        addToPanel(panel, nameGer, 0.5, 1, 3, 1);
        addToPanel(panel, tfNameGer, 0.5, 2, 3, 2);
        addToPanel(panel, alias, 0.5, 1, 4, 1);
        addToPanel(panel, tfAlias, 0.5, 2, 4, 2);
        addToPanel(panel, button, 0.5, 2, 5, 2);

        button.addActionListener(this);
        comboBox.addItemListener(this);

        updateGui();
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        updateGui();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        inputNameOV = tfNameOV.getText();
        inputLanguage = tfLanguage.getText();
        inputNameGer = tfNameGer.getText();
        inputAlias = tfAlias.getText();

        editSeries(series, inputNameOV, inputLanguage, inputNameGer, inputAlias);
    }

    private void updateGui() {
        createSelectedSeries();

        panel.remove(tfNameOV);
        panel.remove(tfNameGer);
        panel.remove(tfLanguage);
        panel.remove(tfAlias);

        tfNameOV = new JTextField(series.getNameOV(), 30);
        tfLanguage = new JTextField(series.getLanguage(), 30);
        tfNameGer = new JTextField(series.getNameGer(), 30);
        tfAlias = new JTextField(listToStr(series.getAlias()), 30);

        addToPanel(panel, tfNameOV, 0.5, 2, 1, 2);
        addToPanel(panel, tfLanguage, 0.5, 2, 2, 2);
        addToPanel(panel, tfNameGer, 0.5, 2, 3, 2);
        addToPanel(panel, tfAlias, 0.5, 2, 4, 2);
        frame.setVisible(true);
    }

    private void createSelectedSeries() {
        selectedSeries = comboBox.getItemAt(comboBox.getSelectedIndex());

        for (String element : allSeries) {
            String name = convertName(removeEnding(element));

            if (selectedSeries.equals(name)) {
                series = (Series) readFile(folder, element);
                break;
            }
        }
    }

    public static void updateGuiValid(boolean valid) {
        if (valid) {
            panel.remove(invalidExists);
        } else {
            addToPanel(panel, invalidExists, 0.5, 1, 6, 1);
        }
        frame.setVisible(true);
    }

    public static void closeWindow() {
        frame.dispose();
    }
}
