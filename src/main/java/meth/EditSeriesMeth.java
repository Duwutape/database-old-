package meth;

import data.Series;

public class EditSeriesMeth {

    static String nameOV, language, nameGer, alias;
    static Series series;

    public static void editSeries(Series series, String nameOV, String language, String nameGer, String alias) {

        EditSeriesMeth.series = series;
        EditSeriesMeth.nameOV = nameOV;
        EditSeriesMeth.language = language;
        EditSeriesMeth.nameGer = nameGer;
        EditSeriesMeth.alias = alias;
    }
}
