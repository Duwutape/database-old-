import gui.Login;

import java.io.File;
import java.util.ArrayList;
import java.util.Objects;

import static meth.AddUserMeth.createAdmin;

public class Main {
    public static void main(String[] args) {

        //create folder
        createDir();

        //check if there is at least one user
        File folder = new File("files/user");

        if (Objects.requireNonNull(folder.listFiles()).length == 0) {
            createAdmin();
        }

        //create login window
        new Login();
    }

    private static void createDir() {
        ArrayList<File> dirList = new ArrayList<>();
        dirList.add(new File("files"));
        dirList.add(new File("files/user"));
        dirList.add(new File("files/data"));
        dirList.add(new File("files/data/series"));
        dirList.add(new File("files/data/anime"));
        dirList.add(new File("files/data/movie"));
        dirList.add(new File("files/data/movie/universe"));
        dirList.add(new File("files/data/book"));
        dirList.add(new File("files/data/book/universe"));
        dirList.add(new File("files/data/game"));
        dirList.add(new File("files/data/game/universe"));

        for (File element : dirList) {
            boolean state = element.mkdir();
            if (!state) {
                System.out.println(element.getName() + " already exists");
            } else {
                System.out.println(element.getName() + " created");
            }
        }
    }


}