package data;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import java.util.ArrayList;

@XStreamAlias("user")
public class User {

    int id;
    String name, password;
    ArrayList<String> completed, currently, hold, plan, unsure;
    boolean isAdmin;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public ArrayList<String> getCompleted() {
        return completed;
    }

    public void setCompleted(ArrayList<String> completed) {
        this.completed = completed;
    }

    public ArrayList<String> getCurrently() {
        return currently;
    }

    public void setCurrently(ArrayList<String> currently) {
        this.currently = currently;
    }

    public ArrayList<String> getHold() {
        return hold;
    }

    public void setHold(ArrayList<String> hold) {
        this.hold = hold;
    }

    public ArrayList<String> getPlan() {
        return plan;
    }

    public void setPlan(ArrayList<String> plan) {
        this.plan = plan;
    }

    public ArrayList<String> getUnsure() {
        return unsure;
    }

    public void setUnsure(ArrayList<String> unsure) {
        this.unsure = unsure;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }
}
