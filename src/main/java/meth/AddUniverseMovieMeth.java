package meth;

import data.Movie;
import data.UniverseMovie;
import gui.AddUniverse;

import java.io.File;
import java.util.ArrayList;

import static meth.Meth.*;
import static meth.XStreamMeth.objToXML;

public class AddUniverseMovieMeth {

    static String name, alias;
    static boolean validFill, validExists, valid;
    static final String PATH = "files/data/movie/universe/";
    static final String END = ".xml";
    static File folder = new File("files/data/movie/universe");

    public static void createUniMov(String name, String alias) {
        validFill = true;
        validExists = true;

        AddUniverseMovieMeth.name = name;
        AddUniverseMovieMeth.alias = alias;

        checkFill();
        checkExists();

        valid = validFill && validExists;
        if (valid) {
            createNewUniMov();
            AddUniverse.closeWindow();
        }
    }

    private static void checkFill() {
        if (name.equals("")) {

            validFill = false;
        }
        AddUniverse.updateGuiFill(validFill);
    }

    private static void checkExists() {

        ArrayList<String> allNames = readName(folder);

        for (String element : allNames) {
            String nameUni = convertName(removeEnding(element));

            if (name.equals(nameUni)) {
                validExists = false;
            }
        }
        AddUniverse.updateGuiValid(validExists);
    }

    private static void createNewUniMov() {
        UniverseMovie universe = new UniverseMovie();
        ArrayList<Movie> list = new ArrayList<>();
        universe.setName(name);
        universe.setAlias(strToList(alias));
        universe.setMovie(list);

        objToXML(universe, createFilePath(PATH, createFileName(name), END));
    }
}
