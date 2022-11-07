package meth;

import data.Game;
import data.Release;
import data.UniverseGame;
import gui.AddGame;

import java.io.File;
import java.util.ArrayList;

import static meth.Meth.*;
import static meth.XStreamMeth.objToXML;

public class AddGameMeth {

    public static String universe, num, name, usk, genre, alias;
    public static boolean validFill, validNum, validIsNumber, validExists, valid;
    static final String PATH = "files/data/game/";
    static final String PATHUNI = "files/data/game/universe/";
    static final String END = ".xml";
    static File folder = new File("files/data/game");
    static File folderUni = new File("files/data/game/universe");
    static UniverseGame uniGame;

    public static void createGame(String universe, String num, String name, String usk, String genre, String alias) {
        validFill = true;
        validNum = true;
        validIsNumber = true;
        validExists = true;

        AddGameMeth.universe = universe;
        AddGameMeth.num = num;
        AddGameMeth.name = name;
        AddGameMeth.usk = usk;
        AddGameMeth.genre = genre;
        AddGameMeth.alias = alias;

        checkFill();
        checkExists();

        valid = validFill && validNum && validIsNumber && validExists;

        if (valid) {
            createNewGame();
            AddGame.closeWindow();
        }
    }

    private static void checkFill() {
        if (name.equals("")) {
            validFill = false;
        }
        AddGame.updateGuiFill(validFill);

        if (universe.equals("NONE")) {
            if (usk.contains(" ")) {
                validNum = false;
            }
        } else {
            if (usk.contains(" ") || num.contains(" ")) {
                validNum = false;
            }
            AddGame.updateGuiValidNum(validNum);

            if ((!usk.equals("") && !checkNumber(num)) ||
                    (!num.equals("") && !checkNumber(num))) {
                validIsNumber = false;
            }
        }
        AddGame.updateGuiIsNum(validIsNumber);
    }

    private static void checkExists() {

        if (universe.equals("NONE")) {
            ArrayList<String> allNames = readName(folder);
            for (String element : allNames) {
                String books = convertName(removeEnding(element));

                if (name.equals(books)) {
                    validExists = false;
                    break;
                }
            }
        } else {
            ArrayList<String> allNames = readName(folderUni);
            for (String element : allNames) {
                String games = convertName(removeEnding(element));
                if (universe.equals(games)) {
                    uniGame = (UniverseGame) readFile(folderUni, element);

                    for (Game game : uniGame.getGame()) {
                        if (name.equals(game.getName())) {
                            validExists = false;
                            break;
                        }
                    }
                }
            }
        }
        AddGame.updateGuiValid(validExists);
    }

    private static void createNewGame() {
        Game game = new Game();
        ArrayList<Release> list = new ArrayList<Release>();
        game.setName(name);
        game.setUsk(usk);
        game.setGenre(strToList(genre));
        game.setPublished(list);

        if (universe.equals("NONE")) {
            game.setAlias(strToList(alias));

            objToXML(game, createFilePath(PATH, createFileName(name), END));
        } else {
            game.setNum(num);
            addToUni(game);
        }
    }

    private static void addToUni(Game game) {
        ArrayList<Game> currentGames = uniGame.getGame();
        currentGames.add(game);
        uniGame.setGame(currentGames);
        objToXML(uniGame, createFilePath(PATHUNI, createFileName(uniGame.getName()), END));
    }
}
