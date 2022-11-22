package gui;

import data.Season;
import data.Series;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.File;
import java.util.ArrayList;

import static meth.Meth.*;
import static meth.SwingMeth.addToPanel;

public class EditSeason implements ItemListener, ActionListener {
    static JFrame frame;
    static JPanel panel;
    JLabel getSeries, getSeason, num, yearOV, yearGer, fsk, genre, platform, numEpisodes, lengthEpisodes;
    static JLabel invalidFill, invalidN, invalidDelete;
    JTextField tfNum, tfYearOV, tfYearGer, tfFsk, tfGenre, tfPlatform, tfNumEpi, tfLenEpi;
    JButton button;
    JComboBox<String> cBSeries;
    JComboBox<Season> cBSeason;
    String selectedSeries, inputNum, inputYearOV, inputFsk, inputGenre, inputPlatform, inputNumEpi, inputLenEpi;
    final String PATH = "files/series";
    File folder = new File(PATH);
    ArrayList<String> allSeries = readName(folder);
    Series series;
    Season season;

    public EditSeason() {

        createWindow();
        createGui();
    }

    private void createWindow() {
        frame = new JFrame("Edit Season");
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
        getSeries = new JLabel("select Series");
        cBSeries = new JComboBox<>(createList(PATH));
        getSeason = new JLabel("select Season");
        cBSeason = new JComboBox<>(createList(PATH));
        num = new JLabel("Number of Season");
        yearOV = new JLabel("Year OV");
        yearGer = new JLabel("Year Ger");
        fsk = new JLabel("FSK");
        genre = new JLabel("Genre");
        platform = new JLabel("Platform");
        numEpisodes = new JLabel("Number of Episodes");
        lengthEpisodes = new JLabel("Length of Episodes in min");
        tfNum = new JTextField(30);
        tfYearOV = new JTextField(30);
        tfYearGer = new JTextField(30);
        tfFsk = new JTextField(30);
        tfGenre = new JTextField(30);
        tfPlatform = new JTextField(30);
        tfNumEpi = new JTextField(30);
        tfLenEpi = new JTextField(30);

        addToPanel(panel, getSeries, 0.5, 1, 0, 1);
        addToPanel(panel, cBSeries, 0.5, 2, 0, 1);
        addToPanel(panel, num, 0.5, 1, 1, 1);
        addToPanel(panel, tfNum, 0.5, 2, 1, 1);
        addToPanel(panel, yearOV, 0.5, 1, 2, 1);
        addToPanel(panel, tfYearOV, 0.5, 2, 2, 1);
        addToPanel(panel, yearGer, 0.5, 1, 3, 1);
        addToPanel(panel, tfYearGer, 0.5, 2, 3, 1);
        addToPanel(panel, fsk, 0.5, 1, 4, 1);
        addToPanel(panel, tfFsk, 0.5, 2, 4, 1);
        addToPanel(panel, genre, 0.5, 1, 5, 1);
        addToPanel(panel, tfGenre, 0.5, 2, 5, 1);
        addToPanel(panel, platform, 0.5, 1, 6, 1);
        addToPanel(panel, tfPlatform, 0.5, 2, 6, 1);
        addToPanel(panel, numEpisodes, 0.5, 1, 7, 1);
        addToPanel(panel, tfNumEpi, 0.5, 2, 7, 1);
        addToPanel(panel, lengthEpisodes, 0.5, 1, 8, 1);
        addToPanel(panel, tfLenEpi, 0.5, 2, 8, 1);
        addToPanel(panel, button, 0.5, 2, 9, 1);

        button.addActionListener(this);
        cBSeries.addItemListener(e -> createSelectedSeries());
        cBSeason.addItemListener(e -> createSelectedSeason());

        createSelectedSeries();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    private void createSelectedSeries() {
        selectedSeries = cBSeries.getItemAt(cBSeries.getSelectedIndex());

        for (String element : allSeries) {
            String item = convertName(removeEnding(element));

            if (selectedSeries.equals(item)) {
                series = (Series) readFile(folder, element);
                updateGuiSeries();
                break;
            }
        }
    }

    private void updateGuiSeries() {
        panel.remove(cBSeason);
        cBSeason = new JComboBox<>((series.getSeasons());
        addToPanel(panel, cBSeason, 0.5, 2, 1, 1);
    }

    private void updateGuiSeason() {
        panel.remove(tfNum);
        panel.remove(tfYearOV);
        panel.remove(tfYearGer);
        panel.remove(tfFsk);
        panel.remove(tfGenre);
        panel.remove(tfPlatform);
        panel.remove(tfNumEpi);
        panel.remove(tfLenEpi);

    }
}
