package meth;

import data.Season;
import data.Series;
import gui.AddSeason;

import java.io.File;
import java.util.ArrayList;

import static meth.Meth.*;
import static meth.XStreamMeth.objToXML;

public class AddSeasonMeth {
    static String selectedSeries, num, yearOV, yearGer, fsk, genre, platform, numEpi, lenEpi;
    static boolean validFill, validNum, validIsNumber, validExists, valid;
    static final String PATH = "files/data/series/";
    static final String END = ".xml";
    static File folder = new File("files/data/series");
    static Series series;

    public static void createSeason(String series, String num, String yearOV, String yearGer, String fsk, String genre, String platform, String numEpi, String lenEpi) {
        validFill = true;
        validNum = true;
        validIsNumber = true;
        validExists = true;

        AddSeasonMeth.selectedSeries = series;
        AddSeasonMeth.num = num;
        AddSeasonMeth.yearOV = yearOV;
        AddSeasonMeth.yearGer = yearGer;
        AddSeasonMeth.fsk = fsk;
        AddSeasonMeth.genre = genre;
        AddSeasonMeth.platform = platform;
        AddSeasonMeth.numEpi = numEpi;
        AddSeasonMeth.lenEpi = lenEpi;

        checkFill();
        checkExists();

        valid = validFill && validNum && validIsNumber && validExists;

        if(valid){
            createNewSeason();
            AddSeason.closeWindow();
        }
    }

    private static void checkFill() {
        if (num.equals("")) {
            validFill = false;
        }
        AddSeason.updateGuiFill(validFill);

        if (num.contains(" ") || fsk.contains(" ") || numEpi.contains(" ") || lenEpi.contains(" ")) {
            validNum = false;
        }
        AddSeason.updateGuiValidNum(validNum);

        if ((!num.equals("") && !checkNumber(num)) ||
                (!fsk.equals("") && !checkNumber(fsk)) ||
                (!numEpi.equals("") && !checkNumber(numEpi)) ||
                (!lenEpi.equals("") && !checkNumber(lenEpi))) {
            validIsNumber = false;
        }
        AddSeason.updateGuiIsNum(validIsNumber);
    }

    private static void checkExists() {

        ArrayList<String> allNames = readName(folder);

        for (String element : allNames) {
            String name = convertName(removeEnding(element));

            if (selectedSeries.equals(name)) {
                series = (Series) readFile(folder, element);

                for (Season season : series.getSeasons()) {
                    if (num.equals(season.getNum())) {
                        validExists = false;
                        break;
                    }
                }
            }
        }
        AddSeason.updateGuiValid(validExists);
    }

    private static void createNewSeason() {
        Season season = new Season();
        season.setNum(num);
        season.setYearOV(strToList(yearOV));
        season.setYearGer(strToList(yearGer));
        season.setFsk(fsk);
        season.setGenre(strToList(genre));
        season.setPlatform(strToList(platform));
        season.setNumEpisodes(numEpi);
        season.setLengthEpisodes(lenEpi);
        season.setLengthSeason(calculateLen(numEpi, lenEpi));

        addToSeries(season);
    }

    private static void addToSeries(Season season) {
        ArrayList<Season> currentSeasons = series.getSeasons();
        currentSeasons.add(season);
        series.setSeasons(currentSeasons);
        objToXML(series, createFilePath(PATH, createFileName(series.getNameGer()), END));
    }
}
