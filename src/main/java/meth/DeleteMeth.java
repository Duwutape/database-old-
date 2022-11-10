package meth;

import gui.DeleteUser;

import java.io.File;

import static meth.Meth.createFileName;
import static meth.Meth.createFilePath;

public class DeleteMeth {

    final static String PATHUSER = "files/user/";
    final static String END = ".xml";


    public static void deleteUserMeth(String name) {
        File oldFile = new File(createFilePath(PATHUSER, createFileName(name), END));
        boolean test = oldFile.delete();
        System.out.println(test);
        DeleteUser.closeWindow();
    }
}
