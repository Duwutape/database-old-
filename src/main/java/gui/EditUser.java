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

import static meth.EditUserMeth.editUser;
import static meth.Meth.*;
import static meth.SwingMeth.addToPanel;

public class EditUser extends JFrame implements ActionListener, ItemListener {

    static JFrame frame;
    static JPanel panel;
    JLabel name, oldPass, pass, repeatPass, makeAdmin, getUser;
    static JLabel invalidUser, invalidPass, invalidFill, invalidAdmin;
    JTextField tfName;
    JPasswordField tfOldPass, tfRePass, tfPass;
    JButton button;
    JCheckBox checkBox;
    JComboBox<String> comboBox;
    boolean inputCheck;
    String inputName, inputOldPass, inputPass, inputRePass;
    final String PATH = "files/user";
    File folder = new File(PATH);
    ArrayList<String> allUsers = readName(folder);
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
        oldPass = new JLabel("old Password");
        pass = new JLabel("new Password");
        repeatPass = new JLabel("Repeat Password");
        makeAdmin = new JLabel("Make this user admin?");
        tfName = new JTextField(15);
        tfOldPass = new JPasswordField(15);
        tfPass = new JPasswordField(15);
        tfRePass = new JPasswordField(15);
        button = new JButton("Submit");
        checkBox = new JCheckBox();
        invalidUser = new JLabel("Username is already taken");
        invalidPass = new JLabel("Password is not correct");
        invalidFill = new JLabel("All fields must be filled in");
        invalidAdmin = new JLabel("This User can't be edited");

        addToPanel(panel, getUser, 0.5, 1, 0, 1);
        addToPanel(panel, comboBox, 0.5, 2, 0, 1);
        addToPanel(panel, name, 0.5, 1, 1, 1);
        addToPanel(panel, tfName, 0.5, 2, 1, 1);
        addToPanel(panel, oldPass, 0.5, 1, 2, 1);
        addToPanel(panel, tfOldPass, 0.5, 2, 2, 1);
        addToPanel(panel, pass, 0.5, 1, 3, 1);
        addToPanel(panel, tfPass, 0.5, 2, 3, 1);
        addToPanel(panel, repeatPass, 0.5, 1, 4, 1);
        addToPanel(panel, tfRePass, 0.5, 2, 4, 1);
        addToPanel(panel, makeAdmin, 0.5, 1, 5, 1);
        addToPanel(panel, checkBox, 0.5, 2, 5, 1);
        addToPanel(panel, button, 0.5, 2, 6, 1);

        button.addActionListener(this);
        comboBox.addItemListener(this);

        createSelectedUser();
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
       createSelectedUser();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        inputName = tfName.getText();
        inputOldPass = tfOldPass.getText();
        inputPass = tfPass.getText();
        inputRePass = tfRePass.getText();
        inputCheck = checkBox.isSelected();

        editUser(user, inputName, inputOldPass, inputPass, inputRePass, inputCheck);
    }

    private void  createSelectedUser() {
        selectedUser = comboBox.getItemAt(comboBox.getSelectedIndex());

        for (String element : allUsers) {
            String users = convertName(removeEnding(element));

            if (selectedUser.equals("admin")){
                user = (User) readFile(folder, element);
                updateGuiAdmin(false);
                break;
            }
            else if (selectedUser.equals(users)) {
                user = (User) readFile(folder, element);
                updateGuiAdmin(true);
                break;
            }
        }
    }

    private void updateGuiAdmin(boolean valid) {
        if (valid) {
            panel.remove(invalidAdmin);
        } else {
            addToPanel(panel, invalidAdmin, 0.5, 2, 7, 1);
        }
        panel.remove(tfName);
        panel.remove(checkBox);
        tfName = new JTextField(user.getName(), 15);
        checkBox = new JCheckBox("",user.isAdmin());
        addToPanel(panel, tfName, 0.5, 2, 1, 1);
        addToPanel(panel, checkBox, 0.5, 2, 5,1);
        frame.setVisible(true);
    }

    public static void updateGuiFill(boolean valid) {
        if (valid) {
            panel.remove(invalidFill);
        } else {
            addToPanel(panel, invalidFill, 0.5, 2, 8, 1);
        }
        frame.setVisible(true);
    }

    public static void updateGuiUser(boolean valid) {
        if (valid) {
            panel.remove(invalidUser);
        } else {
            addToPanel(panel, invalidUser, 0.5, 2, 9, 1);
        }
        frame.setVisible(true);
    }

    public static void updateGuiPass(boolean valid) {
        if (valid) {
            panel.remove(invalidPass);
        } else {
            addToPanel(panel, invalidPass, 0.5, 2, 10, 1);
        }
        frame.setVisible(true);
    }

    public static void closeWindow() {
        frame.dispose();
    }

}
