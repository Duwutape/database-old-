package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static meth.LoginMeth.checkData;
import static meth.SwingMeth.addToPanel;

public class Login extends JFrame implements ActionListener {

    static JFrame frame;
    static JPanel panel;
    JButton button;
    JLabel login;
    JLabel username;
    JLabel password;
    static JLabel invalid;
    JTextField textField, passwordField;

    public Login() {

        createWindow();
        createGui();
        frame.setVisible(true);

    }

    private void createWindow() {
        frame = new JFrame("Login");
        frame.setSize(300, 150);
        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);

        panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        frame.getContentPane().add(panel);
    }

    private void createGui() {
        login = new JLabel("Login");
        username = new JLabel("Username");
        textField = new JTextField(15);
        password = new JLabel("Password");
        passwordField = new JPasswordField(15);
        button = new JButton("Login");
        invalid = new JLabel("Username and/or password is invalid");

        addToPanel(panel, login, 0.5 ,2, 0, 1);
        addToPanel(panel, username, 0.5 ,1, 1, 1);
        addToPanel(panel, textField, 0.5 ,2, 1, 1);
        addToPanel(panel, password, 0.5 ,1, 2, 1);
        addToPanel(panel, passwordField, 0.5 ,2, 2, 1);
        addToPanel(panel, button, 0.5 ,2, 3, 1);

        button.addActionListener(this);

    }

    public void actionPerformed(ActionEvent e) {
        String username = textField.getText();
        String password = passwordField.getText();
        checkData(username, password);
    }

    public static void closeWindow() {
        frame.dispose();
    }

    public static void updateGuiValid() {

        addToPanel(panel, invalid, 0.5, 2, 4 , 1);
        frame.setVisible(true);
    }
}