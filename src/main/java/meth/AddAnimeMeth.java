package meth;

import data.Anime;
import gui.AddAnime;

import java.io.File;
import java.util.ArrayList;

import static meth.Meth.*;
import static meth.XStreamMeth.objToXML;

public class AddAnimeMeth {

    static String titleJap, titleEng, titleGer, year, fsk, genre, numEpi, lenEpi, alias;
    static boolean validFill, validNum, validIsNumber, validExists, valid;
    static final String PATH = "files/data/anime/";
    static final String END = ".xml";
    static File folder = new File("files/data/anime");

    public static void createAnime(String titleJap, String titleEng, String titleGer, String year, String fsk, String genre, String numEpi, String lenEpi, String alias) {
        validFill = true;
        validNum = true;
        validIsNumber = true;
        validExists = true;

        AddAnimeMeth.titleJap = titleJap;
        AddAnimeMeth.titleEng = titleEng;
        AddAnimeMeth.titleGer = titleGer;
        AddAnimeMeth.year = year;
        AddAnimeMeth.fsk = fsk;
        AddAnimeMeth.genre = genre;
        AddAnimeMeth.numEpi = numEpi;
        AddAnimeMeth.lenEpi = lenEpi;
        AddAnimeMeth.alias = alias;

        checkFill();
        checkExists();

        valid = validFill && validNum && validIsNumber && validExists;

        if (valid) {
            createNewAnime();
            AddAnime.closeWindow();
        }
    }

    private static void checkFill() {
        if (titleJap.equals("")) {
            validFill = false;
        }
        AddAnime.updateGuiFill(validFill);

        if (fsk.contains(" ") || numEpi.contains(" ") || lenEpi.contains(" ")) {
            validNum = false;
        }
        AddAnime.updateGuiValidNum(validNum);

        if ((!fsk.equals("") && !checkNumber(fsk)) ||
                (!numEpi.equals("") && !checkNumber(numEpi)) ||
                (!lenEpi.equals("") && !checkNumber(lenEpi))) {
            validIsNumber = false;
        }
        AddAnime.updateGuiIsNum(validIsNumber);
    }

    private static void checkExists() {

        ArrayList<String> allNames = readName(folder);

        for (String element : allNames) {
            String name = convertName(removeEnding(element));

            if (titleJap.equals(name)) {
                validExists = false;
                break;
            }
        }
        AddAnime.updateGuiValid(validExists);
    }

    private static void createNewAnime() {
        Anime anime = new Anime();
        anime.setTitleJap(titleJap);
        anime.setTitleEng(titleEng);
        anime.setTitleGer(titleGer);
        anime.setYear(strToList(year));
        anime.setFsk(fsk);
        anime.setGenre(strToList(genre));
        anime.setNumEpisodes(numEpi);
        anime.setLengthEpisodes(lenEpi);
        anime.setLengthAll(calculateLen(numEpi, lenEpi));
        anime.setAlias(strToList(alias));

        objToXML(anime, createFilePath(PATH, createFileName(titleJap), END));

    }
}

