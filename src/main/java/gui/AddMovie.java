package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import static meth.AddMovieMeth.createMovie;
import static meth.Meth.createList;
import static meth.SwingMeth.addToPanel;

public class AddMovie implements ActionListener, ItemListener {
    static JFrame frame;
    static JPanel panel;
    JLabel universe, num, titleOV, titleGer, year, fsk, genre, len, alias;
    static JLabel invalidFill, invalidNum, invalidNumArr, invalidIsNum, invalidExists;
    JTextField tfNum, tfTitleOV, tfTitleGer, tfYear, tfFsk, tfGenre, tfLen, tfAlias;
    JButton button;
    JComboBox<String> comboBox;
    String inputUniverse, inputNum, inputTitleOV, inputTitleGer, inputYear, inputFsk, inputGenre, inputLen, inputAlias;
    final String PATH = "files/data/movie";


    public AddMovie() {

        createWindow();
        createGui();
    }

    private void createWindow() {
        frame = new JFrame("Add Movie");
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
        universe = new JLabel("Select universe");
        num = new JLabel("Number in universe (*|**)");
        titleOV = new JLabel("Title OV");
        titleGer = new JLabel("Title Ger");
        year = new JLabel("Year (*|**)");
        fsk = new JLabel("FSK (*|**)");
        genre = new JLabel("Genre");
        len = new JLabel("Length in minutes (*|**)");
        alias = new JLabel("Alias");
        comboBox = new JComboBox<>(createList(PATH, "NONE"));
        tfNum = new JTextField(30);
        tfTitleOV = new JTextField(30);
        tfTitleGer = new JTextField(30);
        tfYear = new JTextField(30);
        tfFsk = new JTextField(30);
        tfGenre = new JTextField(30);
        tfLen = new JTextField(30);
        tfAlias = new JTextField(30);
        button = new JButton("Submit");
        invalidFill = new JLabel("Title OV must be filled in");
        invalidNum = new JLabel("All marked with ** need to be only one number");
        invalidNumArr = new JLabel("All marked with *** could contain more numbers");
        invalidIsNum = new JLabel("All marked with * must be only digits");
        invalidExists = new JLabel("Movie already exists");

        addToPanel(panel, universe, 0.5, 1, 0, 1);
        addToPanel(panel, comboBox, 0.5, 2, 0, 2);
        addToPanel(panel, titleOV, 0.5, 1, 2, 1);
        addToPanel(panel, tfTitleOV, 0.5, 2, 2, 2);
        addToPanel(panel, titleGer, 0.5, 1, 3, 1);
        addToPanel(panel, tfTitleGer, 0.5, 2, 3, 2);
        addToPanel(panel, year, 0.5, 1, 4, 1);
        addToPanel(panel, tfYear, 0.5, 2, 4, 2);
        addToPanel(panel, fsk, 0.5, 1, 5, 1);
        addToPanel(panel, tfFsk, 0.5, 2, 5, 2);
        addToPanel(panel, genre, 0.5, 1, 6, 1);
        addToPanel(panel, tfGenre, 0.5, 2, 6, 2);
        addToPanel(panel, len, 0.5, 1, 7, 1);
        addToPanel(panel, tfLen, 0.5, 2, 7, 2);
        addToPanel(panel, alias, 0.5, 1, 8, 1);
        addToPanel(panel, tfAlias, 0.5, 2, 8, 2);
        addToPanel(panel, button, 0.5, 2, 9, 2);

        button.addActionListener(this);
        comboBox.addItemListener(this);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        inputUniverse = comboBox.getItemAt(comboBox.getSelectedIndex());
        inputNum = tfNum.getText();
        inputTitleOV = tfTitleOV.getText();
        inputTitleGer = tfTitleGer.getText();
        inputYear = tfYear.getText();
        inputFsk = tfFsk.getText();
        inputGenre = tfGenre.getText();
        inputLen = tfLen.getText();
        inputAlias = tfAlias.getText();

        createMovie(inputUniverse, inputNum, inputTitleOV, inputTitleGer, inputYear, inputFsk, inputGenre, inputLen, inputAlias);
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        if (comboBox.getItemAt(comboBox.getSelectedIndex()).equals("NONE")) {
            panel.remove(num);
            panel.remove(tfNum);
            addToPanel(panel, alias, 0.5, 1, 8, 1);
            addToPanel(panel, tfAlias, 0.5, 2, 8, 2);
        } else {
            panel.remove(alias);
            panel.remove(tfAlias);
            addToPanel(panel, num, 0.5, 1, 1, 1);
            addToPanel(panel, tfNum, 0.5, 2, 1, 2);
        }
        frame.setVisible(true);
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
