package meth;

import data.Game;
import data.Release;
import data.UniverseGame;
import gui.AddRelease;

import java.io.File;
import java.util.ArrayList;

import static meth.Meth.*;
import static meth.XStreamMeth.objToXML;

public class AddReleaseMeth {

    static String universe, selectedGame, year, platform, notes;
    static boolean validFill, validNum, validIsNumber, validExists, isUni, valid;
    static final String PATH = "files/data/game/";
    static final String PATHUNI = "files/data/game/universe/";
    static final String END = ".xml";
    static File folder = new File("files/data/game");
    static File folderUni = new File("files/data/game/universe");
    static UniverseGame uniGame;
    static Game game;

    public static void createRelease(String universe, String game, String year, String platform, String notes) {
        isUni = false;
        validFill = true;
        validNum = true;
        validIsNumber = true;
        validExists = true;

        AddReleaseMeth.universe = universe;
        AddReleaseMeth.selectedGame = game;
        AddReleaseMeth.year = year;
        AddReleaseMeth.platform = platform;
        AddReleaseMeth.notes = notes;

        checkFill();
        checkExists();

        valid = validFill && validNum && validIsNumber && validExists;

        if (valid) {
            createNewRelease();
            AddRelease.closeWindow();
        }
    }

    private static void checkFill() {
        if (year.equals("") || platform.equals("")) {
            validFill = false;
        }
        AddRelease.updateGuiFill(validFill);


        if (year.contains(" ")) {
            validNum = false;
        }
        AddRelease.updateGuiValidNum(validNum);

        if (!year.equals("") && !checkNumber(year)) {
            validIsNumber = false;
        }
        AddRelease.updateGuiIsNum(validIsNumber);
    }

    private static void checkExists() {

        if (validExists) {
            ArrayList<String> allNames = readName(folder);
            for (String element : allNames) {
                String name = convertName(removeEnding(element));

                if (selectedGame.equals(name)) {
                    game = (Game) readFile(folder, element);

                    for (Release release : game.getPublished()) {
                        if (year.equals(release.getYear())) {
                            validExists = false;
                            break;
                        }
                    }
                }
            }
        }
        if (validExists) {
            ArrayList<String> allNames = readName(folderUni);
            for (String element : allNames) {
                String name = convertName(removeEnding(element));

                if (universe.equals(name)) {
                    uniGame = (UniverseGame) readFile(folderUni, element);
                    isUni = true;
                    ArrayList<Game> listGame = uniGame.getGame();

                    for (Game game : listGame) {
                        if (selectedGame.equals(game.getName())){
                            ArrayList<Release> listRelease = game.getPublished();
                            for (Release release  : listRelease) {
                                if (year.equals(release.getYear())) {
                                    validExists = false;
                                    break;
                                }
                            }
                        }
                    }
                }
            }
        }
        AddRelease.updateGuiValid(validExists);
    }

    private static void createNewRelease() {
        Release release = new Release();
        release.setYear(year);
        release.setPlatform(strToList(platform));
        release.setNote(strToList(notes));

        if (isUni) {
            addToUni(release);
        } else {
            addToGame(release);
        }
    }

    private static void addToGame(Release release) {
        ArrayList<Release> currentReleases = game.getPublished();
        currentReleases.add(release);
        game.setPublished(currentReleases);
        objToXML(game, createFilePath(PATH, createFileName(game.getName()), END));
    }

    private static void addToUni(Release release) {
        ArrayList<Game> games = uniGame.getGame();
        for (Game element : games) {
            if(selectedGame.equals(element.getName())){
                ArrayList<Release> currentReleases = element.getPublished();
                System.out.println(currentReleases);
                currentReleases.add(release);
                System.out.println(currentReleases);
                element.setPublished(currentReleases);
                System.out.println(element.getPublished());
                objToXML(uniGame, createFilePath(PATHUNI, createFileName(uniGame.getName()), END));

            }
        }
    }
}
