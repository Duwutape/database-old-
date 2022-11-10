package meth;

import data.Book;
import data.UniverseBook;
import gui.AddUniverse;

import java.io.File;
import java.util.ArrayList;

import static meth.Meth.*;
import static meth.XStreamMeth.objToXML;

public class AddUniverseBookMeth {

    static String name, alias;
    static boolean validFill, validExists, valid;
    static final String PATH = "files/data/book/universe/";
    static final String END = ".xml";
    static File folder = new File("files/data/book/universe");

    public static void createUniBook(String name, String alias) {
        validFill = true;
        validExists = true;

        AddUniverseBookMeth.name = name;
        AddUniverseBookMeth.alias = alias;

        checkFill();
        checkExists();

        valid = validFill && validExists;
        if (valid) {
            createNewUniBook();
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

    private static void createNewUniBook() {
        UniverseBook universe = new UniverseBook();
        ArrayList<Book> list = new ArrayList<>();
        universe.setName(name);
        universe.setAlias(strToList(alias));
        universe.setBook(list);

        objToXML(universe, createFilePath(PATH, createFileName(name), END));
    }
}
