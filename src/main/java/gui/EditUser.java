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

import static meth.AddUserMeth.createUser;
import static meth.Meth.*;
import static meth.SwingMeth.addToPanel;

public class EditUser extends JFrame implements ActionListener, ItemListener {

    static JFrame frame;
    static JPanel panel;
    JLabel name, password, repeatPass, makeAdmin, getUser;
    static JLabel invalidUser;
    static JLabel invalidPass;
    static JLabel invalidFill;
    JTextField tfName;
    JPasswordField tfPass, tfRePass;
    JButton button;
    JCheckBox checkBox;
    JComboBox<String> comboBox;
    boolean inputCheck;
    String inputName, inputPass, inputRePass;
    final String PATH = "files/user";
    File folder = new File(PATH);
    String selectedUser;
    User user;


    public EditUser() {

        createWindow();
        createGui();
    }

    private void createWindow() {
        frame = new JFrame("Edit User");
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
        comboBox = new JComboBox<String>(createList(PATH));
        getUser = new JLabel("select User");
        name = new JLabel("Username");
        password = new JLabel("Password");
        repeatPass = new JLabel("Repeat Password");
        makeAdmin = new JLabel("Make this user admin?");
        tfName = new JTextField(15);
        tfPass = new JPasswordField(15);
        tfRePass = new JPasswordField(15);
        button = new JButton("Submit");
        checkBox = new JCheckBox();
        invalidUser = new JLabel("Username is already taken");
        invalidPass = new JLabel("Password is not correct");
        invalidFill = new JLabel("All fields must be filled in");

        addToPanel(panel, getUser, 0.5, 1, 0, 1);
        addToPanel(panel, comboBox, 0.5, 2, 0, 1);
        addToPanel(panel, name, 0.5, 1, 1, 1);
        addToPanel(panel, tfName, 0.5, 2, 1, 1);
        addToPanel(panel, password, 0.5, 1, 2, 1);
        addToPanel(panel, tfPass, 0.5, 2, 2, 1);
        addToPanel(panel, repeatPass, 0.5, 1, 3, 1);
        addToPanel(panel, tfRePass, 0.5, 2, 3, 1);
        addToPanel(panel, makeAdmin, 0.5, 1, 4, 1);
        addToPanel(panel, checkBox, 0.5, 2, 4, 1);
        addToPanel(panel, button, 0.5, 2, 5, 1);

        button.addActionListener(this);
        comboBox.addItemListener(this);
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        selectedUser = comboBox.getItemAt(comboBox.getSelectedIndex());
        ArrayList<String> allNames = readName(folder);

        for (String element : allNames) {
            String users = convertName(removeEnding(element));

            if (selectedUser.equals(users)) {
                user = (User) readFile(folder, element);
            }
        }
        panel.remove(tfName);
        tfName = new JTextField(user.getName(), 15);
        addToPanel(panel, tfName, 0.5, 2, 1, 1);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        inputName = tfName.getText();
        inputPass = tfPass.getText();
        inputRePass = tfRePass.getText();
        inputCheck = checkBox.isSelected();

        createUser(inputName, inputPass, inputRePass, inputCheck);
    }

    public static void updateGuiFill(boolean valid) {
        if (valid) {
            panel.remove(invalidFill);
        } else {
            addToPanel(panel, invalidFill, 0.5, 2, 5, 1);
        }
        frame.setVisible(true);
    }

    public static void updateGuiUser(boolean valid) {
        if (valid) {
            panel.remove(invalidUser);
        } else {
            addToPanel(panel, invalidUser, 0.5, 2, 6, 1);
        }
        frame.setVisible(true);
    }

    public static void updateGuiPass(boolean valid) {
        if (valid) {
            panel.remove(invalidPass);
        } else {
            addToPanel(panel, invalidPass, 0.5, 2, 5, 1);
        }
        frame.setVisible(true);
    }

    public static void closeWindow() {
        frame.dispose();
    }

}
