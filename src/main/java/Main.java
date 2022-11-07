import gui.Login;

import java.io.File;

import static meth.AddUserMeth.createAdmin;

public class Main {
    public static void main(String[] args) {

        //create folder
        createDir();

        //check if there is at least one user
        File folder = new File("files/user");

        if (folder.listFiles().length == 0) {
            createAdmin();
        }

        //create login window
        new Login();
    }

    private static void createDir() {
        new File("files").mkdir();
        new File("files/user").mkdir();
        new File("files/data").mkdir();
        new File("files/data/series").mkdir();
        new File("files/data/anime").mkdir();
        new File("files/data/movie").mkdir();
        new File("files/data/movie/universe").mkdir();
        new File("files/data/book").mkdir();
        new File("files/data/book/universe").mkdir();
        new File("files/data/game").mkdir();
        new File("files/data/game/universe").mkdir();
    }


}