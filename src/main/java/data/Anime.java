package data;

import java.util.ArrayList;

public class Anime {

    private String id;
    private ArrayList<String> alias;
    private String titleJap;
    private String titleEng;
    private String titleGer;
    private ArrayList<String> year;
    private String fsk;
    private ArrayList<String> genre;
    private  String numEpisodes;
    private String lengthEpisodes;
    private String lengthAll;
    private ArrayList<Anime> prequel;
    private ArrayList<Anime> sequel;

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

    public String getTitleJap() {
        return titleJap;
    }

    public void setTitleJap(String titleJap) {
        this.titleJap = titleJap;
    }

    public String getTitleEng() {
        return titleEng;
    }

    public void setTitleEng(String titleEng) {
        this.titleEng = titleEng;
    }

    public String getTitleGer() {
        return titleGer;
    }

    public void setTitleGer(String titleGer) {
        this.titleGer = titleGer;
    }

    public ArrayList<String> getYear() {
        return year;
    }

    public void setYear(ArrayList<String> year) {
        this.year = year;
    }

    public String getFsk() {
        return fsk;
    }

    public void setFsk(String fsk) {
        this.fsk = fsk;
    }

    public ArrayList<String> getGenre() {
        return genre;
    }

    public void setGenre(ArrayList<String> genre) {
        this.genre = genre;
    }

    public String getNumEpisodes() {
        return numEpisodes;
    }

    public void setNumEpisodes(String numEpisodes) {
        this.numEpisodes = numEpisodes;
    }

    public String getLengthEpisodes() {
        return lengthEpisodes;
    }

    public void setLengthEpisodes(String lengthEpisodes) {
        this.lengthEpisodes = lengthEpisodes;
    }

    public String getLengthAll() {
        return lengthAll;
    }

    public void setLengthAll(String lengthAll) {
        this.lengthAll = lengthAll;
    }

    public ArrayList<Anime> getPrequel() {
        return prequel;
    }

    public void setPrequel(ArrayList<Anime> prequel) {
        this.prequel = prequel;
    }

    public ArrayList<Anime> getSequel() {
        return sequel;
    }

    public void setSequel(ArrayList<Anime> sequel) {
        this.sequel = sequel;
    }
}
