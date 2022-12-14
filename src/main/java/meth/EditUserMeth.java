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

    public static void editUser(User user, String name, String oldPass, String pass, String rePass, boolean check) {
        validFill = true;
        validUser = true;
        validPass = false;

        EditUserMeth.user = user;
        EditUserMeth.name = name;
        EditUserMeth.oldPass = oldPass;
        EditUserMeth.pass = pass;
        EditUserMeth.rePass = rePass;
        EditUserMeth.check = check;

        if(!name.equals("admin")){
            //check if username is available
            if (!name.equals(user.getName())) {
                checkUsername();
            }
            if (!pass.equals("")){
                //check if password is correct
                checkPassword();
            }
            if (check != user.isAdmin()) {
                editAdmin();
            }
        }
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
        if (oldPass.equals(user.getPassword()) && pass.equals(rePass)) {
            validPass = true;
            editUserPass();
        }

        EditUser.updateGuiPass(validPass);
    }

    private static void editUserName() {
        File oldFile = new File(createFilePath(PATH, createFileName(user.getName()), END));
        boolean state = oldFile.delete();
        if(state) {
            user.setName(name);
            objToXML(user, createFilePath(PATH, createFileName(name), END));
            EditUser.closeWindow();
        } else {
            System.out.println("something went wrong");
        }
        EditUser.updateGuiDel(state);

    }

    private static void editUserPass() {
        user.setPassword(pass);
        objToXML(user, createFilePath(PATH, createFileName(user.getName()), END));
        EditUser.closeWindow();
    }

    private static void editAdmin() {
        user.setAdmin(check);
        objToXML(user, createFilePath(PATH, createFileName(user.getName()), END));
        EditUser.closeWindow();
    }
}
