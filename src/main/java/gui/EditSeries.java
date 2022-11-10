package gui;

import data.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.File;
import java.util.ArrayList;

import static meth.Meth.createList;
import static meth.Meth.readName;
import static meth.SwingMeth.addToPanel;

public class EditSeries implements ActionListener, ItemListener {
    static JFrame frame;
    static JPanel panel;
    JLabel selectSeries, nameOV, nameGer, language, alias;
    static JLabel invalidFill, invalidExists;
    JTextField tfNameOV, tfNameGer, tfLanguage, tfAlias;
    JButton button;
    JComboBox<String> comboBox;
    final String PATH = "files/series";
    File folder = new File(PATH);
    ArrayList<String> allUsers = readName(folder);
    String selectedUser;
    User user;


    public EditSeries() {

        createWindow();
        createGui();
    }

    private void createWindow() {
        frame = new JFrame("Edit Series");
        frame.setSize(400, 225);
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
        comboBox = new JComboBox<String>(createList(PATH));
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
        addToPanel(panel, nameOV, 0.5, 1, 0, 1);
        addToPanel(panel, tfNameOV, 0.5, 2, 0, 2);
        addToPanel(panel, language, 0.5, 1, 1, 1);
        addToPanel(panel, tfLanguage, 0.5, 2, 1, 2);
        addToPanel(panel, nameGer, 0.5, 1, 2, 1);
        addToPanel(panel, tfNameGer, 0.5, 2, 2, 2);
        addToPanel(panel, alias, 0.5, 1, 3, 1);
        addToPanel(panel, tfAlias, 0.5, 2, 3, 2);
        addToPanel(panel, button, 0.5, 2, 4, 2);

        button.addActionListener(this);
        comboBox.addItemListener(this);

        //createSelectedSeries();
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        //createSelectedSeries();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

}
