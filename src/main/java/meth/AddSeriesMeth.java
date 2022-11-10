package meth;

import data.Season;
import data.Series;
import gui.AddSeries;

import java.io.File;
import java.util.ArrayList;

import static meth.Meth.*;
import static meth.XStreamMeth.objToXML;

public class AddSeriesMeth {

    static String nameOV, language, nameGer, alias;
    static boolean validFill, validExists, valid;
    static final String PATH = "files/data/series/";
    static final String END = ".xml";
    static File folder = new File("files/data/series");

    public static void createSeries(String nameOV, String language, String nameGer, String alias) {
        validFill = true;
        validExists = true;

        AddSeriesMeth.nameOV = nameOV;
        AddSeriesMeth.language = language;
        AddSeriesMeth.nameGer = nameGer;
        AddSeriesMeth.alias = alias;

        checkFill();
        checkExists();

        valid = validFill && validExists;
        if (valid) {
            createNewSeries();
            AddSeries.closeWindow();
        }
    }

    private static void checkFill() {
        if (nameOV.equals("") || (language.equals("")) || (nameGer.equals(""))) {

            validFill = false;
        }
        AddSeries.updateGuiFill(validFill);
    }

    private static void checkExists() {

        ArrayList<String> allNames = readName(folder);

        for (String element : allNames) {
            String name = convertName(removeEnding(element));

            if (nameGer.equals(name)) {
                validExists = false;
            }
        }
        AddSeries.updateGuiValid(validExists);
    }

    private static void createNewSeries() {
        Series series = new Series();
        ArrayList<Season> list = new ArrayList<>();
        series.setNameOV(nameOV);
        series.setLanguage(language);
        series.setNameGer(nameGer);
        series.setAlias(strToList(alias));
        series.setSeasons(list);

        objToXML(series, createFilePath(PATH, createFileName(nameGer), END));
    }
}
