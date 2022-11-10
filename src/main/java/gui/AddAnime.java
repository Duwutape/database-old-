package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static meth.AddAnimeMeth.createAnime;
import static meth.SwingMeth.addToPanel;

public class AddAnime implements ActionListener {
    static JFrame frame;
    static JPanel panel;
    JLabel titleJap, titleEng, titleGer, year, fsk, genre, numEpi, lenEpi, alias;
    static JLabel invalidFill, invalidNum, invalidNumArr, invalidIsNum, invalidExists;
    JTextField tfTitleJap, tfTitleEng, tfTitleGer, tfYear, tfFsk, tfGenre, tfNumEpi, tfLenEpi, tfAlias;
    JButton button;
    String inputTitleJap, inputTitleEng, inputTitleGer, inputYear, inputFsk, inputGenre, inputNumEpi, inputLenEpi, inputAlias;

    public AddAnime() {

        createWindow();
        createGui();
    }

    private void createWindow() {
        frame = new JFrame("Add Anime");
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

        titleJap = new JLabel("Title Jap");
        titleEng = new JLabel("Title Eng");
        titleGer = new JLabel("Title Ger");
        year = new JLabel("Year Jap (***)");
        fsk = new JLabel("FSK (*|**)");
        genre = new JLabel("Genre");
        numEpi = new JLabel("Number of Episodes (*|**)");
        lenEpi = new JLabel("Length of Episodes in minutes (*|**)");
        alias = new JLabel("Alias");
        tfTitleJap = new JTextField(30);
        tfTitleEng = new JTextField(30);
        tfTitleGer = new JTextField(30);
        tfYear = new JTextField(30);
        tfFsk = new JTextField(30);
        tfGenre = new JTextField(30);
        tfNumEpi = new JTextField(30);
        tfLenEpi = new JTextField(30);
        tfAlias = new JTextField(30);
        button = new JButton("Submit");
        invalidFill = new JLabel("Title Jap must be filled in");
        invalidNum = new JLabel("All marked with ** need to be only one number");
        invalidNumArr = new JLabel("All marked with *** could contain more numbers");
        invalidIsNum = new JLabel("All marked with * must be only digits");
        invalidExists = new JLabel("Anime already exists");

        addToPanel(panel, titleJap, 0.5, 1, 0, 1);
        addToPanel(panel, tfTitleJap, 0.5, 2, 0, 2);
        addToPanel(panel, titleEng, 0.5, 1, 1, 1);
        addToPanel(panel, tfTitleEng, 0.5, 2, 1, 2);
        addToPanel(panel, titleGer, 0.5, 1, 2, 1);
        addToPanel(panel, tfTitleGer, 0.5, 2, 2, 2);
        addToPanel(panel, year, 0.5, 1, 3, 1);
        addToPanel(panel, tfYear, 0.5, 2, 3, 2);
        addToPanel(panel, fsk, 0.5, 1, 4, 1);
        addToPanel(panel, tfFsk, 0.5, 2, 4, 2);
        addToPanel(panel, genre, 0.5, 1, 5, 1);
        addToPanel(panel, tfGenre, 0.5, 2, 5, 2);
        addToPanel(panel, numEpi, 0.5, 1, 6, 1);
        addToPanel(panel, tfNumEpi, 0.5, 2, 6, 2);
        addToPanel(panel, lenEpi, 0.5, 1, 7, 1);
        addToPanel(panel, tfLenEpi, 0.5, 2, 7, 2);
        addToPanel(panel, alias, 0.5, 1, 8, 1);
        addToPanel(panel, tfAlias, 0.5, 2, 8, 2);
        addToPanel(panel, button, 0.5, 2, 9, 2);

        button.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        inputTitleJap = tfTitleJap.getText();
        inputTitleEng = tfTitleEng.getText();
        inputTitleGer = tfTitleGer.getText();
        inputYear = tfYear.getText();
        inputFsk = tfFsk.getText();
        inputGenre = tfGenre.getText();
        inputNumEpi = tfNumEpi.getText();
        inputLenEpi = tfLenEpi.getText();
        inputAlias = tfAlias.getText();

        createAnime(inputTitleJap, inputTitleEng, inputTitleGer, inputYear, inputFsk, inputGenre, inputNumEpi, inputLenEpi, inputAlias);
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
