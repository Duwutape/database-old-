package data;

import java.util.ArrayList;

public class Movie {


    private String num;
    private String id;
    private ArrayList<String> alias;
    private String titleOV;
    private String titleGer;
    private String year;
    private String fsk;
    private String length;

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public ArrayList<String> getAlias() {
        return alias;
    }

    public void setAlias(ArrayList<String> alias) {
        this.alias = alias;
    }

    public String getTitleOV() {
        return titleOV;
    }

    public void setTitleOV(String titleOV) {
        this.titleOV = titleOV;
    }

    public String getTitleGer() {
        return titleGer;
    }

    public void setTitleGer(String titleGer) {
        this.titleGer = titleGer;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getFsk() {
        return fsk;
    }

    public void setFsk(String fsk) {
        this.fsk = fsk;
    }

    public String getLength() {
        return length;
    }

    public void setLength(String length) {
        this.length = length;
    }
}