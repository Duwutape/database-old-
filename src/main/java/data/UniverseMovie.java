package data;

import java.util.ArrayList;

public class UniverseMovie {

    private String name;
    private ArrayList<String> alias;
    private ArrayList<Movie> movie;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<String> getAlias() {
        return alias;
    }

    public void setAlias(ArrayList<String> alias) {
        this.alias = alias;
    }

    public ArrayList<Movie> getMovie() {
        return movie;
    }

    public void setMovie(ArrayList<Movie> movie) {
        this.movie = movie;
    }
}
