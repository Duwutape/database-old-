package data;

import java.util.ArrayList;

public class Game {

    private String id;
    private String num;
    private ArrayList<String> alias;
    private String universe;
    private String name;
    private String usk;
    private ArrayList<String> genre;
    private ArrayList<Release> published;


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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsk() {
        return usk;
    }

    public void setUsk(String usk) {
        this.usk = usk;
    }

    public ArrayList<String> getGenre() {
        return genre;
    }

    public void setGenre(ArrayList<String> genre) {
        this.genre = genre;
    }

    public ArrayList<Release> getPublished() {
        return published;
    }

    public void setPublished(ArrayList<Release> published) {
        this.published = published;
    }
}
