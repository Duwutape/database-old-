package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import static meth.AddBookMeth.createBook;
import static meth.Meth.createList;
import static meth.SwingMeth.addToPanel;

public class AddBook extends JFrame implements ActionListener, ItemListener {

    static JFrame frame;
    static JPanel panel;
    JLabel universe, num, name, author, date, alias;
    static JLabel invalidFill, invalidNum, invalidIsNum, invalidDate, invalidExists;
    JTextField tfNum, tfName, tfAuthor, tfDate, tfAlias;
    JButton button;
    JComboBox<String> comboBox;
    String inputUniverse, inputNum, inputName, inputAuthor, inputDate, inputAlias;
    final String PATH = "files/data/book/universe";

    public AddBook() {

        createWindow();
        createGui();
    }

    private void createWindow() {
        frame = new JFrame("Add Book");
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
        author = new JLabel("Author");
        date = new JLabel("Publication date (dd-mm-yyyy)");
        alias = new JLabel("Alias");
        comboBox = new JComboBox<String>(createList(PATH, "NONE"));
        tfNum = new JTextField(30);
        tfName = new JTextField(30);
        tfAuthor = new JTextField(30);
        tfDate = new JTextField(30);
        tfAlias = new JTextField(30);
        button = new JButton("Submit");
        invalidFill = new JLabel("Name must be filled in");
        invalidNum = new JLabel("All marked with ** need to be only one number");
        invalidIsNum = new JLabel("All marked with * must be only digits");
        invalidDate = new JLabel("Publication date error");
        invalidExists = new JLabel("Movie already exists");

        addToPanel(panel, universe, 0.5, 1, 0, 1);
        addToPanel(panel, comboBox, 0.5, 2, 0, 2);
        addToPanel(panel, name, 0.5, 1, 2, 1);
        addToPanel(panel, tfName, 0.5, 2, 2, 2);
        addToPanel(panel, author, 0.5, 1, 3, 1);
        addToPanel(panel, tfAuthor, 0.5, 2, 3, 2);
        addToPanel(panel, date, 0.5, 1, 4, 1);
        addToPanel(panel, tfDate, 0.5, 2, 4, 2);
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
        inputAuthor = tfAlias.getText();
        inputDate = tfDate.getText();
        inputAlias = tfAlias.getText();

        createBook(inputUniverse, inputNum, inputName, inputAuthor, inputDate, inputAlias);
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

    public static void updateGuiDate(boolean valid) {
        if (valid) {
            panel.remove(invalidDate);
        } else {
            addToPanel(panel, invalidDate, 0.5, 2, 9, 2);
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