package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import static meth.AddGameMeth.createGame;
import static meth.Meth.createList;
import static meth.SwingMeth.addToPanel;

public class AddGame extends JFrame implements ActionListener, ItemListener {
    static JFrame frame;
    static JPanel panel;
    JLabel universe, num, name, usk, genre, alias;
    static JLabel invalidFill, invalidNum, invalidIsNum, invalidExists;
    JTextField tfNum, tfName, tfUsk, tfGenre, tfAlias;
    JButton button;
    JComboBox<String> comboBox;
    String inputUniverse, inputNum, inputName, inputUsk, inputGenre, inputAlias;
    final String PATH = "files/data/game/universe";

    public AddGame() {

        createWindow();
        createGui();
    }

    private void createWindow() {
        frame = new JFrame("Add Game");
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
        name = new JLabel("Name");
        usk = new JLabel("USK (*|**)");
        genre = new JLabel("Genre");
        alias = new JLabel("Alias");
        comboBox = new JComboBox<String>(createList(PATH, "NONE"));
        tfNum = new JTextField(30);
        tfName = new JTextField(30);
        tfUsk = new JTextField(30);
        tfGenre = new JTextField(30);
        tfAlias = new JTextField(30);
        button = new JButton("Submit");
        invalidFill = new JLabel("Name must be filled in");
        invalidNum = new JLabel("All marked with ** need to be only one number");
        invalidIsNum = new JLabel("All marked with * must be only digits");
        invalidExists = new JLabel("Game already exists");

        addToPanel(panel, universe, 0.5, 1, 0, 1);
        addToPanel(panel, comboBox, 0.5, 2, 0, 2);
        addToPanel(panel, name, 0.5, 1, 2, 1);
        addToPanel(panel, tfName, 0.5, 2, 2, 2);
        addToPanel(panel, usk, 0.5, 1, 3, 1);
        addToPanel(panel, tfUsk, 0.5, 2, 3, 2);
        addToPanel(panel, genre, 0.5, 1, 4, 1);
        addToPanel(panel, tfGenre, 0.5, 2, 4, 2);
        addToPanel(panel, alias, 0.5, 1, 5, 1);
        addToPanel(panel, tfAlias, 0.5, 2, 5, 2);
        addToPanel(panel, button, 0.5, 2, 6, 2);

        button.addActionListener(this);
        comboBox.addItemListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        inputUniverse = comboBox.getItemAt(comboBox.getSelectedIndex());
        inputNum = tfNum.getText();
        inputName = tfName.getText();
        inputUsk = tfUsk.getText();
        inputGenre = tfGenre.getText();
        inputAlias = tfAlias.getText();

        createGame(inputUniverse, inputNum, inputName, inputUsk, inputGenre, inputAlias);
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        if (comboBox.getItemAt(comboBox.getSelectedIndex()).equals("NONE")) {
            panel.remove(num);
            panel.remove(tfNum);
            addToPanel(panel, alias, 0.5, 1, 5, 1);
            addToPanel(panel, tfAlias, 0.5, 2, 5, 2);
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
            addToPanel(panel, invalidFill, 0.5, 2, 6, 2);
        }
        frame.setVisible(true);
    }

    public static void updateGuiValidNum(boolean valid) {
        if (valid) {
            panel.remove(invalidNum);
        } else {
            addToPanel(panel, invalidNum, 0.5, 2, 7, 2);
        }
        frame.setVisible(true);
    }

    public static void updateGuiIsNum(boolean valid) {
        if (valid) {
            panel.remove(invalidIsNum);
        } else {
            addToPanel(panel, invalidIsNum, 0.5, 2, 8, 2);
        }
        frame.setVisible(true);
    }

    public static void updateGuiValid(boolean valid) {
        if (valid) {
            panel.remove(invalidExists);
        } else {
            addToPanel(panel, invalidExists, 0.5, 2, 10, 2);
        }
        frame.setVisible(true);
    }

    public static void closeWindow() {
        frame.dispose();
    }
}

