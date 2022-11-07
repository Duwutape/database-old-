package meth;

import data.Game;
import data.UniverseGame;
import gui.AddUniverse;

import java.io.File;
import java.util.ArrayList;

import static meth.Meth.*;
import static meth.XStreamMeth.objToXML;

public class AddUniverseGameMeth {

    public static String name, alias;
    public static boolean validFill, validExists, valid;
    static final String PATH = "files/data/game/universe/";
    static final String END = ".xml";
    static File folder = new File("files/data/game/universe");

    public static void createUniGame(String name, String alias) {
        validFill = true;
        validExists = true;

        AddUniverseGameMeth.name = name;
        AddUniverseGameMeth.alias = alias;

        checkFill();
        checkExists();

        valid = validFill && validExists;
        if (valid) {
            createNewUniGame();
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

    private static void createNewUniGame() {
        UniverseGame universe = new UniverseGame();
        ArrayList<Game> list = new ArrayList<Game>();
        universe.setName(name);
        universe.setAlias(strToList(alias));
        universe.setGame(list);

        objToXML(universe, createFilePath(PATH, createFileName(name), END));
    }
}