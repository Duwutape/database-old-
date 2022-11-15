package meth;

import data.Series;
import gui.EditSeries;

import java.io.File;
import java.util.ArrayList;

import static meth.Meth.*;
import static meth.XStreamMeth.objToXML;

public class EditSeriesMeth {

    static String nameOV, language, nameGer, alias;
    static Series series;
    static File folder = new File("files/data/series");
    final static String PATH = "files/data/series/";
    final static String END = ".xml";
    static boolean validExists;

    public static void editSeries(Series series, String nameOV, String language, String nameGer, String alias) {
        validExists = true;

        EditSeriesMeth.series = series;
        EditSeriesMeth.nameOV = nameOV;
        EditSeriesMeth.language = language;
        EditSeriesMeth.nameGer = nameGer;
        EditSeriesMeth.alias = alias;

        if (!nameGer.equals(series.getNameGer())) {
            checkExists();
        }

        if (validExists) {
            editSeriesContent();
        }
    }

    private static void checkExists() {

        ArrayList<String> allNames = readName(folder);

        for (String element : allNames) {
            String name = convertName(removeEnding(element));

            if (nameGer.equals(name)) {
                validExists = false;
            }
        }
        EditSeries.updateGuiValid(validExists);
    }

    private static void editSeriesContent() {
        if (!nameGer.equals(series.getNameGer())) {
            File oldFile = new File(createFilePath(PATH, createFileName(series.getNameGer()), END));
            boolean state = oldFile.delete();
            if (state) {
                System.out.println("old file deleted");
            } else {
                System.out.println("something went wrong");
            }

            series.setNameOV(nameOV);
            series.setLanguage(language);
            series.setNameGer(nameGer);
            series.setAlias(strToList(alias));

            objToXML(series, createFilePath(PATH, createFileName(nameGer), END));
            EditSeries.closeWindow();
        }
    }
}
