package data;

import java.util.ArrayList;

public class UniverseGame {

    private String name;
    private ArrayList<String> alias;
    private ArrayList<Game> game;

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

    public ArrayList<Game> getGame() {
        return game;
    }

    public void setGame(ArrayList<Game> game) {
        this.game = game;
    }
}
