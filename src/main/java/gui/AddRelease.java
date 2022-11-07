package gui;

import data.Game;
import data.UniverseGame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.File;
import java.util.ArrayList;

import static meth.AddReleaseMeth.createRelease;
import static meth.Meth.*;
import static meth.SwingMeth.addToPanel;

public class AddRelease extends JFrame implements ActionListener, ItemListener {

    static JFrame frame;
    static JPanel panel;
    JLabel universe, game, year, platform, notes;
    static JLabel invalidFill, invalidNum, invalidIsNum, invalidExists;
    JTextField tfYear, tfPlatform, tfNotes;
    JButton button;
    JComboBox<String> cBUni, cBGame;
    String inputUniverse, inputGame, inputYear, inputPlatform, inputNotes;
    final String PATH = "files/data/game";
    final String PATHUNI = "files/data/game/universe";
    File folderUni = new File(PATHUNI);
    UniverseGame uniGame;
    String[] list;

    public AddRelease() {

        createWindow();
        createGui();
    }

    private void createWindow() {
        frame = new JFrame("Add Release");
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
        game = new JLabel("Select game");
        year = new JLabel("Year (*)");
        platform = new JLabel("Platform");
        notes = new JLabel("Notes");
        cBUni = new JComboBox<>(createList(PATHUNI, "NONE"));
        list = makeList();
        cBGame = new JComboBox<String>(list);
        tfYear = new JTextField(30);
        tfPlatform = new JTextField(30);
        tfNotes = new JTextField(30);
        button = new JButton("Submit");
        invalidFill = new JLabel("Year and Platform must be filled in");
        invalidNum = new JLabel("All marked with ** need to be only one number");
        invalidIsNum = new JLabel("All marked with * must be only digits");
        invalidExists = new JLabel("Release already exists");

        addToPanel(panel, universe, 0.5, 1, 0, 1);
        addToPanel(panel, cBUni, 0.5, 2, 0, 1);
        addToPanel(panel, game, 0.5, 1, 1, 1);
        addToPanel(panel, cBGame, 0.5, 2, 1, 2);
        addToPanel(panel, year, 0.5, 1, 2, 1);
        addToPanel(panel, tfYear, 0.5, 2, 2, 2);
        addToPanel(panel, platform, 0.5, 1, 3, 1);
        addToPanel(panel, tfPlatform, 0.5, 2, 3, 2);
        addToPanel(panel, notes, 0.5, 1, 4, 1);
        addToPanel(panel, tfNotes, 0.5, 2, 4, 2);
        addToPanel(panel, button, 0.5, 2, 5, 2);

        button.addActionListener(this);
        cBUni.addItemListener(this);
    }

    private String[] makeList() {

        if (cBUni.getItemAt(cBUni.getSelectedIndex()).equals("NONE")) {
            return createList(PATH);
        } else {
            ArrayList<String> allNames = readName(folderUni);
            for (String element : allNames) {
                String name = convertName(removeEnding(element));

                if (cBUni.getItemAt(cBUni.getSelectedIndex()).equals(name)) {
                    uniGame = (UniverseGame) readFile(folderUni, element);
                    ArrayList<Game> list = uniGame.getGame();
                    ArrayList<String> out = new ArrayList<String>();
                    for (Game game : list) {
                        out.add(game.getName());
                    }
                    return out.toArray(new String[0]);
                }
            }
        }
        return createList(PATH);
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        list = makeList();
        panel.remove(cBGame);
        cBGame = new JComboBox<String>(list);
        addToPanel(panel, cBGame, 0.5, 2, 1, 2);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        inputUniverse = cBUni.getItemAt(cBUni.getSelectedIndex());
        inputGame = cBGame.getItemAt(cBGame.getSelectedIndex());
        inputYear = tfYear.getText();
        inputPlatform = tfPlatform.getText();
        inputNotes = tfNotes.getText();

        createRelease(inputUniverse, inputGame, inputYear, inputPlatform, inputNotes);
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
            addToPanel(panel, invalidExists, 0.5, 2, 9, 2);
        }
        frame.setVisible(true);
    }

    public static void closeWindow() {
        frame.dispose();
    }
}
