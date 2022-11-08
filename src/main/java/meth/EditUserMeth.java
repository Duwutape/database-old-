package meth;

import data.User;
import gui.EditUser;

import java.io.File;
import java.util.ArrayList;

import static meth.Meth.*;
import static meth.XStreamMeth.objToXML;

public class EditUserMeth {

    static boolean validFill, validUser, validPass, check;
    static String name, oldPass, pass, rePass;
    static final String PATH = "files/user/";
    static final String END = ".xml";
    static File folder = new File("files/user");
    static ArrayList<String> allNames;
    static User user;

    public static void editUser(String name, String oldPass, String pass, String rePass, boolean check) {
        validFill = true;
        validUser = true;
        validPass = false;

        EditUserMeth.name = name;
        EditUserMeth.oldPass = oldPass;
        EditUserMeth.pass = pass;
        EditUserMeth.rePass = rePass;
        EditUserMeth.check = check;


        //check if username is available
        if (!name.equals(user.getName()))
            checkUsername();

        //check if password is correct
        checkPassword();
    }

    private static void checkUsername() {

        allNames = readName(folder);

        for (String element : allNames) {
            String users = convertName(removeEnding(element));

            if (name.equals(users)) {
                validUser = false;
                break;
            }
        }
        EditUser.updateGuiUser(validUser);
        if (validUser) {
            editUserName();
        }
    }

    private static void checkPassword() {
        for (String element : allNames) {
            String users = convertName(removeEnding(element));

            if (name.equals(users)) {
                user = (User) readFile(folder, element);
                if (oldPass.equals(user.getPassword()) && pass.equals(rePass)) {
                    editUserPass();
                }
            }
            EditUser.updateGuiPass(validPass);
        }
    }

    private static void editUserName() {
        File oldFile = new File(createFilePath(PATH, createFileName(user.getName()), END));
        oldFile.delete();

        user.setName(name);

        objToXML(user, createFilePath(PATH, createFileName(name), END));
        EditUser.closeWindow();
    }

    private static void editUserPass() {
        user.setPassword(pass);
        objToXML(user, createFilePath(PATH, createFileName(user.getName()), END));
    }
}
