package meth;

import data.Movie;
import data.UniverseMovie;
import gui.AddMovie;

import java.io.File;
import java.util.ArrayList;

import static meth.Meth.*;
import static meth.XStreamMeth.objToXML;

public class AddMovieMeth {

    public static String universe, num, titleOV, titleGer, year, fsk, genre, len, alias;
    public static boolean validFill, validNum, validIsNumber, validExists, valid;
    static final String PATH = "files/data/movie/";
    static final String END = ".xml";
    static File folder = new File("files/data/movie/universe");
    static UniverseMovie uniMov;

    public static void createMovie(String universe, String num, String titleOV, String titleGer, String year, String fsk, String genre, String len, String alias) {
        validFill = true;
        validNum = true;
        validIsNumber = true;
        validExists = true;

        AddMovieMeth.universe = universe;
        AddMovieMeth.num = num;
        AddMovieMeth.titleOV = titleOV;
        AddMovieMeth.titleGer = titleGer;
        AddMovieMeth.year = year;
        AddMovieMeth.fsk = fsk;
        AddMovieMeth.genre = genre;
        AddMovieMeth.len = len;
        AddMovieMeth.alias = alias;

        checkFill();
        checkExists();

        valid = validFill && validNum && validIsNumber && validExists;

        if (valid) {
            createNewMovie();
            AddMovie.closeWindow();
        }
    }

    private static void checkFill() {
        if (titleOV.equals("")) {
            validFill = false;
        }
        AddMovie.updateGuiFill(validFill);

        if (universe.equals("NONE")) {
            if (fsk.contains(" ") || len.contains(" ") || year.contains(" ")) {
                validNum = false;
            }

            if ((!year.equals("") && !checkNumber(year)) ||
                    (!fsk.equals("") && !checkNumber(fsk)) ||
                    (!len.equals("") && !checkNumber(len))) {
                validIsNumber = false;
            }
        } else {
            if (fsk.contains(" ") || len.contains(" ") || year.contains(" ") || num.contains(" ")) {
                validNum = false;
            }

            if ((!year.equals("") && !checkNumber(year)) ||
                    (!fsk.equals("") && !checkNumber(fsk)) ||
                    (!len.equals("") && !checkNumber(len)) ||
                    (!num.equals("") && !checkNumber(num))) {
                validIsNumber = false;
            }
        }
        AddMovie.updateGuiValidNum(validNum);
        AddMovie.updateGuiIsNum(validIsNumber);
    }

    private static void checkExists() {

        ArrayList<String> allNames = readName(folder);

        for (String element : allNames) {
            String name = convertName(removeEnding(element));

            if (universe.equals("NONE")) {
                if (titleOV.equals(name)) {
                    validExists = false;
                    break;
                }
            } else {
                if (universe.equals(name)) {
                    uniMov = (UniverseMovie) readFile(folder, element);

                    for (Movie movie : uniMov.getMovie()) {
                        if (titleOV.equals(movie.getTitleOV())) {
                            validExists = false;
                            break;
                        }
                    }
                }
            }
        }
        AddMovie.updateGuiValid(validExists);
    }

    private static void createNewMovie() {
        Movie movie = new Movie();
        movie.setTitleOV(titleOV);
        movie.setTitleGer(titleGer);
        movie.setYear(year);
        movie.setFsk(fsk);
        movie.setLength(len);

        if (universe.equals("NONE")) {
            movie.setAlias(strToList(alias));

            objToXML(movie, createFilePath(PATH, createFileName(titleOV), END));
        } else {
            movie.setNum(num);
            addToUni(movie);
        }
    }

    private static void addToUni(Movie movie) {
        ArrayList<Movie> currentMovies = uniMov.getMovie();
        currentMovies.add(movie);
        uniMov.setMovie(currentMovies);
        objToXML(uniMov, createFilePath(PATH, createFileName(uniMov.getName()), END));
    }
}
