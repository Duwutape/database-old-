package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static meth.AddUniverseBookMeth.createUniBook;
import static meth.AddUniverseGameMeth.createUniGame;
import static meth.AddUniverseMovieMeth.createUniMov;
import static meth.SwingMeth.addToPanel;

public class AddUniverse implements ActionListener {

    static JFrame frame;
    static JPanel panel;
    JLabel select, name, alias, error;
    static JLabel invalidFill, invalidExists;
    JTextField tfName, tfAlias;
    JButton button;
    JComboBox<String> comboBox;
    String inputName, inputAlias;
    String[] list = {"Movie", "Book", "Game"};

    public AddUniverse() {

        createWindow();
        createGui();
    }

    private void createWindow() {
        frame = new JFrame("Add Universe");
        frame.setSize(500, 150);
        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);

        panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        frame.getContentPane().add(panel);
        frame.setVisible(true);
    }

    private void createGui() {

        select = new JLabel("Select universe type");
        name = new JLabel("Name");
        alias = new JLabel("Alias");
        tfName = new JTextField(30);
        tfAlias = new JTextField(30);
        button = new JButton("Submit");
        comboBox = new JComboBox<>(list);
        invalidFill = new JLabel("Name must be filled in");
        invalidExists = new JLabel("Universe already exists");
        error = new JLabel("impossible error");

        addToPanel(panel, select, 0.5, 1, 0, 1);
        addToPanel(panel, comboBox, 0.5, 2, 0, 2);
        addToPanel(panel, name, 0.5, 1, 1, 1);
        addToPanel(panel, tfName, 0.5, 2, 1, 2);
        addToPanel(panel, alias, 0.5, 1, 2, 1);
        addToPanel(panel, tfAlias, 0.5, 2, 2, 2);
        addToPanel(panel, button, 0.5, 2, 3, 2);

        button.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        inputName = tfName.getText();
        inputAlias = tfAlias.getText();

        if (comboBox.getItemAt(comboBox.getSelectedIndex()).equals("Movie")) {
            createUniMov(inputName, inputAlias);
        } else if (comboBox.getItemAt(comboBox.getSelectedIndex()).equals("Book")) {
            createUniBook(inputName, inputAlias);
        } else if (comboBox.getItemAt(comboBox.getSelectedIndex()).equals("Game")){
            createUniGame(inputName, inputAlias);
        } else {
            addToPanel(panel, error, 0.5, 2, 4, 2);
        }
    }

    public static void updateGuiFill(boolean valid) {
        if (valid) {
            panel.remove(invalidFill);
        } else {
            addToPanel(panel, invalidFill, 0.5, 2, 4, 2);
        }
        frame.setVisible(true);
    }

    public static void updateGuiValid(boolean valid) {
        if (valid) {
            panel.remove(invalidExists);
        } else {
            addToPanel(panel, invalidExists, 0.5, 2, 5, 2);
        }
        frame.setVisible(true);
    }

    public static void closeWindow() {
        frame.dispose();
    }
}
