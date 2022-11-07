package meth;

import data.Book;
import data.UniverseBook;
import gui.AddBook;

import java.io.File;
import java.util.ArrayList;

import static meth.Meth.*;
import static meth.XStreamMeth.objToXML;

public class AddBookMeth {

    public static String universe, num, name, author, date, alias;
    public static boolean validFill, validNum, validIsNumber, validExists, validDate, valid;
    static final String PATH = "files/data/book/";
    static final String END = ".xml";
    static File folder = new File("files/data/book");
    static UniverseBook uniBook;

    public static void createBook(String universe, String num, String name, String author, String date, String alias) {
        validFill = true;
        validNum = true;
        validIsNumber = true;
        validDate = true;
        validExists = true;

        AddBookMeth.universe = universe;
        AddBookMeth.num = num;
        AddBookMeth.name = name;
        AddBookMeth.author = author;
        AddBookMeth.date = date;
        AddBookMeth.alias = alias;

        checkFill();
        checkExists();

        valid = validFill && validNum && validIsNumber && validExists;

        if (valid) {
            createNewBook();
            AddBook.closeWindow();
        }
    }

    private static void checkFill() {
        if (name.equals("")) {
            validFill = false;
        }
        AddBook.updateGuiFill(validFill);

        if (universe.equals("NONE")) {
            if (date.contains(" ")) {
                validNum = false;
            }
        } else {
            if (date.contains(" ") || num.contains(" ")) {
                validNum = false;
            }

            if ((!num.equals("") && !checkNumber(num))) {
                validIsNumber = false;
            }
        }
        if ((!date.equals("") && !checkDate(date))) {
            validIsNumber = false;
            validDate = false;
        }
        AddBook.updateGuiValidNum(validNum);
        AddBook.updateGuiIsNum(validIsNumber);
        AddBook.updateGuiDate(validDate);
    }

    private static void checkExists() {
        ArrayList<String> allNames = readName(folder);

        for (String element : allNames) {
            String books = convertName(removeEnding(element));

            if (universe.equals("NONE")) {
                if (name.equals(books)) {
                    validExists = false;
                    break;
                }
            } else {
                if (universe.equals(books)) {
                    uniBook = (UniverseBook) readFile(folder, element);

                    for (Book book : uniBook.getBook()) {
                        if (name.equals(book.getName())) {
                            validExists = false;
                            break;
                        }
                    }
                }
            }
        }
        AddBook.updateGuiValid(validExists);
    }

    private static void createNewBook() {
        Book book = new Book();
        book.setName(name);
        book.setAuthor(strToList(author));
        book.setDate(date);

        if (universe.equals("NONE")) {
            book.setAlias(strToList(alias));

            objToXML(book, createFilePath(PATH, createFileName(name), END));
        } else {
            book.setNum(num);
            addToUni(book);
        }
    }

    private static void addToUni(Book book) {
        ArrayList<Book> currentBooks = uniBook.getBook();
        currentBooks.add(book);
        uniBook.setBook(currentBooks);
        objToXML(uniBook, createFilePath(PATH, createFileName(uniBook.getName()), END));
    }
}
