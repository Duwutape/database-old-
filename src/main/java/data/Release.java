package data;

import java.util.ArrayList;

public class Release {

    private String year;
    private ArrayList<String> platform;
    private ArrayList<String> note;


    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public ArrayList<String> getPlatform() {
        return platform;
    }

    public void setPlatform(ArrayList<String> platform) {
        this.platform = platform;
    }

    public ArrayList<String> getNote() {
        return note;
    }

    public void setNote(ArrayList<String> note) {
        this.note = note;
    }
}
