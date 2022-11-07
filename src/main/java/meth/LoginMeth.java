package meth;

import data.User;
import gui.Login;
import gui.Menu;

import java.io.File;
import java.util.ArrayList;

import static meth.Meth.*;

public class LoginMeth {

    static boolean success;
    static String username, password;
    static File folder = new File("files/user");
    static User user;

    public static void checkData(String name, String pass) {

        success = false;
        username = name;
        password = pass;

        //create list of files
        ArrayList<String> allNames = readName(folder);

        //check if username is valid
        if (!(username.equals(""))) {
            for (String element : allNames) {
                String clearName = convertName(removeEnding(element));

                if (username.equals(clearName)) {

                    user = (User) readFile(folder, element);

                    if (user != null) {

                        if (password.equals(user.getPassword())) {
                            success = true;
                            Login.closeWindow();

                            //open new window
                            new Menu(user.isAdmin());
                            break;
                        }
                    }
                }
            }
        }

        if (!success) {
            Login.updateGuiValid();
        }
    }
}