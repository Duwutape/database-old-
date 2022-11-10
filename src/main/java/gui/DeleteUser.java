package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import static meth.DeleteMeth.deleteUserMeth;
import static meth.Meth.createList;
import static meth.SwingMeth.addToPanel;

public class DeleteUser implements ActionListener, ItemListener {

    static JFrame frame, frameConfirm;
    static JPanel panel, panelConfirm;
    JLabel selectUser, admin, warning, warningConfirm;
    JComboBox<String> cBSelUser;
    JButton button, buttonCancel, buttonConfirm;
    final String PATH = "files/user";

    public DeleteUser() {

        createWindow();
        createGui();
    }

    private void createWindow() {
        frame = new JFrame("Delete User");
        frame.setSize(400, 225);
        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);

        panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        frame.getContentPane().add(panel);

        frame.setVisible(true);
    }

    private void createGui(){
        selectUser = new JLabel("Select user");
        cBSelUser = new JComboBox<>(createList(PATH));
        warning = new JLabel("Warning: A deleted User cannot be recovered");
        admin = new JLabel("This user cannot be deleted");
        warningConfirm = new JLabel("Do you really want to delete this user?");
        button = new JButton("Delete");
        buttonCancel = new JButton("Cancel");
        buttonConfirm = new JButton("Delete");

        addToPanel(panel, selectUser, 0.5, 1, 0, 1);
        addToPanel(panel, cBSelUser, 0.5, 2, 0, 1);
        addToPanel(panel, warning, 0.5, 1, 1, 2);
        addToPanel(panel, button, 0.5, 2, 2, 1);

        if(cBSelUser.getItemAt(cBSelUser.getSelectedIndex()).equals("admin")){
            addToPanel(panel, admin, 0.5, 1, 3, 1);
        }

        button.addActionListener(this);
        cBSelUser.addItemListener(this);
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        if(cBSelUser.getItemAt(cBSelUser.getSelectedIndex()).equals("admin")){
            addToPanel(panel, admin, 0.5, 1, 3, 1);
        } else{
            panel.remove(admin);
        }
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(!cBSelUser.getItemAt(cBSelUser.getSelectedIndex()).equals("admin")){
            createConfirmWindow();
        }
    }

    private void createConfirmWindow() {
        frameConfirm = new JFrame("Confirm");
        frameConfirm.setSize(400, 225);
        frameConfirm.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        frameConfirm.setLocationRelativeTo(null);
        frameConfirm.setResizable(false);

        panelConfirm = new JPanel();
        panelConfirm.setLayout(new GridBagLayout());
        frameConfirm.getContentPane().add(panelConfirm);

        frameConfirm.setVisible(true);

        addToPanel(panelConfirm, warningConfirm, 0.5, 0, 0,2);
        addToPanel(panelConfirm, buttonCancel, 0.5, 0, 1,1);
        addToPanel(panelConfirm, buttonConfirm, 0.5, 1, 1,1);

        buttonConfirm.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deleteUserMeth(cBSelUser.getItemAt(cBSelUser.getSelectedIndex()));
            }
        });

        buttonCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frameConfirm.dispose();
            }
        });
    }

    public static void closeWindow(){
        frameConfirm.dispose();
        frame.dispose();
    }
}