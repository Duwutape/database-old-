package data;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import java.util.ArrayList;

@XStreamAlias("season")
public class Season {

    private String id;
    private String num;
    private ArrayList<String> yearOV;
    private ArrayList<String> yearGer;
    private String fsk;
    private ArrayList<String> genre;
    private ArrayList<String> platform;
    private String numEpisodes;
    private String lengthEpisodes;
    private String lengthSeason;


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

    public ArrayList<String> getYearOV() {
        return yearOV;
    }

    public void setYearOV(ArrayList<String> yearOV) {
        this.yearOV = yearOV;
    }

    public ArrayList<String> getYearGer() {
        return yearGer;
    }

    public void setYearGer(ArrayList<String> yearGer) {
        this.yearGer = yearGer;
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

    public ArrayList<String> getPlatform() {
        return platform;
    }

    public void setPlatform(ArrayList<String> platform) {
        this.platform = platform;
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

    public String getLengthSeason() {
        return lengthSeason;
    }

    public void setLengthSeason(String lengthSeason) {
        this.lengthSeason = lengthSeason;
    }
}
