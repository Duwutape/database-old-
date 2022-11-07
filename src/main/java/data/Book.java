package data;

import java.util.ArrayList;

public class Book {

    private String id;
    private String num;
    private ArrayList<String> alias;
    private String universe;
    private ArrayList<String> author;
    private String name;
    private String date;
    private ArrayList<Book> prequel;
    private ArrayList<Book> sequel;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public ArrayList<String> getAlias() {
        return alias;
    }

    public void setAlias(ArrayList<String> alias) {
        this.alias = alias;
    }

    public String getUniverse() {
        return universe;
    }

    public void setUniverse(String universe) {
        this.universe = universe;
    }

    public ArrayList<String> getAuthor() {
        return author;
    }

    public void setAuthor(ArrayList<String> author) {
        this.author = author;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public ArrayList<Book> getPrequel() {
        return prequel;
    }

    public void setPrequel(ArrayList<Book> prequel) {
        this.prequel = prequel;
    }

    public ArrayList<Book> getSequel() {
        return sequel;
    }

    public void setSequel(ArrayList<Book> sequel) {
        this.sequel = sequel;
    }
}
