package meth;

import data.Series;
import gui.EditSeries;

import java.io.File;
import java.util.ArrayList;

import static meth.Meth.*;

public class EditSeriesMeth {

    static String nameOV, language, nameGer, alias;
    static Series series;
    static File folder = new File("files/data/series");
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

    }
}
