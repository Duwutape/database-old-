package data;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import java.util.ArrayList;

@XStreamAlias("series")
public class Series {

    private int id;
    private String nameOV;
    private String language;
    private String nameGer;
    private ArrayList<Season> seasons;
    private ArrayList<String> alias;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameOV() {
        return nameOV;
    }

    public void setNameOV(String nameOV) {
        this.nameOV = nameOV;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getNameGer() {
        return nameGer;
    }

    public void setNameGer(String nameGer) {
        this.nameGer = nameGer;
    }

    public ArrayList<Season> getSeasons() {
        return seasons;
    }

    public void setSeasons(ArrayList<Season> seasons) {
        this.seasons = seasons;
    }

    public ArrayList<String> getAlias() {
        return alias;
    }

    public void setAlias(ArrayList<String> alias) {
        this.alias = alias;
    }
}