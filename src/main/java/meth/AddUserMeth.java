package meth;

import data.User;
import gui.AddUser;

import java.io.File;
import java.util.ArrayList;

import static meth.Meth.*;
import static meth.Meth.removeEnding;
import static meth.XStreamMeth.objToXML;

public class AddUserMeth {

    static boolean validFill, validUser, validPass, check;
    static String name, pass, rePass;
    static final String PATH = "files/user/";
    static final String END = ".xml";
    static File folder = new File("files/user");

    public static void createUser(String name, String pass, String rePass, boolean check) {
        validFill = true;
        validUser = true;
        validPass = false;

        AddUserMeth.name = name;
        AddUserMeth.pass = pass;
        AddUserMeth.rePass = rePass;
        AddUserMeth.check = check;

        //check if all fields are filled
        checkFill();

        //check if username is available
        checkUsername();

        //check if password is correct
        checkPassword();

        //if all valid create user
        if (validFill && validPass && validUser) {
            createNewUser();
            AddUser.closeWindow();
        }
    }

    private static void checkFill() {

        if ((name.equals("")) || (pass.equals("")) || (rePass.equals(""))) {
            validFill = false;
        }
        AddUser.updateGuiFill(validFill);
    }

    private static void checkUsername() {

        ArrayList<String> allNames = readName(folder);

        for (String element : allNames) {
            String users = convertName(removeEnding(element));

            if (name.equals(users)) {
                validUser = false;
            }
        }

        AddUser.updateGuiUser(validUser);
    }

    private static void checkPassword() {

        if (pass.equals(rePass)) {
            validPass = true;
        }
        AddUser.updateGuiPass(validPass);
    }

    private static void createNewUser() {

        User user = new User();
        user.setName(name);
        user.setPassword(pass);
        user.setAdmin(check);

        objToXML(user, createFilePath(PATH, name, END));
    }

    public static void createAdmin() {
        User admin = new User();
        admin.setId(0);
        admin.setName("admin");
        admin.setPassword("admin");
        admin.setAdmin(true);

        objToXML(admin, createFilePath(PATH, admin.getName(), END));
    }
}
