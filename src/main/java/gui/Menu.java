package gui;

import javax.swing.*;
import java.awt.*;

import static meth.SwingMeth.addToPanel;
import static meth.SwingMeth.sepToPanel;

public class Menu extends JFrame {

    JFrame frame;
    JTabbedPane tabbedPane;
    JPanel series, anime, movie, book, game, user, adminMenu;
    JLabel adminUser, adminSeries, adminAnime, adminMovie, adminBook, adminGame, adminUniverse;
    JButton addUser, editUser, deleteUser, addSeries, editSeries, deleteSeries,
            addSeason, editSeason, deleteSeason, addAnime, editAnime, deleteAnime,
            addUniverse, editUniverse, deleteUniverse, addMovie, editMovie, deleteMovie,
            addBook, editBook, deleteBook, addGame, editGame, deleteGame, addRelease, editRelease, deleteRelease;
    JTextField tfSearchSeries, tfSearchAnime, tfSearchMovie, tfSearchBook, tfSearchGame;
    JButton bSearchSeries, bSearchAnime, bSearchMovie, bSearchBook, bSearchGame;
    JSeparator separator;
    boolean isAdmin;

    public Menu(boolean admin) {

        isAdmin = admin;

        createWindow();
        createMenu();

        if (isAdmin) {
            createAdminMenu();
        }

        createActionListenerSearch();
        createActionListenerAdd();
        createActionListenerEdit();
        createActionListenerDelete();
    }

    private void createWindow() {
        frame = new JFrame("Database");
        frame.setSize(800, 800);
        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setVisible(true);
    }

    private void createMenu() {

        tabbedPane = new JTabbedPane();
        series = new JPanel(new GridBagLayout());
        anime = new JPanel(new GridBagLayout());
        movie = new JPanel(new GridBagLayout());
        book = new JPanel(new GridBagLayout());
        game = new JPanel(new GridBagLayout());
        user = new JPanel(new GridBagLayout());

        tabbedPane.add("Series", series);
        tabbedPane.add("Anime", anime);
        tabbedPane.add("Movie", movie);
        tabbedPane.add("Book", book);
        tabbedPane.add("Game", game);
        tabbedPane.add("User", user);

        frame.add(tabbedPane);

        //create search labels
        tfSearchSeries = new JTextField(30);
        tfSearchAnime = new JTextField(30);
        tfSearchMovie = new JTextField(30);
        tfSearchBook = new JTextField(30);
        tfSearchGame = new JTextField(30);
        bSearchSeries = new JButton("Search");
        bSearchAnime = new JButton("Search");
        bSearchMovie = new JButton("Search");
        bSearchBook = new JButton("Search");
        bSearchGame = new JButton("Search");
        separator = new JSeparator(JSeparator.HORIZONTAL);

        //create Search Series Gui
        addToPanel(series, tfSearchSeries, 0.5, 0, 0, 2);
        addToPanel(series, bSearchSeries, 0.5, 2, 0, 1);
        sepToPanel(series, separator, 0, 2);

        //create Search Anime Gui
        addToPanel(anime, tfSearchAnime, 0.5, 0, 0, 2);
        addToPanel(anime, bSearchAnime, 0.5, 2, 0, 1);

        //create Search Movie Gui
        addToPanel(movie, tfSearchMovie, 0.5, 0, 0, 2);
        addToPanel(movie, bSearchMovie, 0.5, 2, 0, 1);

        //create Search Book Gui
        addToPanel(book, tfSearchBook, 0.5, 0, 0, 2);
        addToPanel(book, bSearchBook, 0.5, 2, 0, 1);

        //create Search Game Gui
        addToPanel(game, tfSearchGame, 0.5, 0, 0, 2);
        addToPanel(game, bSearchGame, 0.5, 2, 0, 1);

    }

    private void createAdminMenu() {

        adminMenu = new JPanel();
        adminMenu.setLayout(new GridBagLayout());

        tabbedPane.add("Admin", adminMenu);

        adminUser = new JLabel("User");
        adminSeries = new JLabel("Series");
        adminAnime = new JLabel("Anime");
        adminUniverse = new JLabel("Universe (Movie, Book, Game)");
        adminMovie = new JLabel("Movie");
        adminBook = new JLabel("Book");
        adminGame = new JLabel("Game");
        addUser = new JButton("add");
        editUser = new JButton("edit");
        deleteUser = new JButton("remove");
        addSeries = new JButton("add Series");
        editSeries = new JButton("edit Series");
        deleteSeries = new JButton("remove Series");
        addSeason = new JButton("add Season");
        editSeason = new JButton("edit Season");
        deleteSeason = new JButton("remove Season");
        addAnime = new JButton("add");
        editAnime = new JButton("edit");
        deleteAnime = new JButton("remove");
        addUniverse = new JButton("add");
        editUniverse = new JButton("edit");
        deleteUniverse = new JButton("remove");
        addMovie = new JButton("add");
        editMovie = new JButton("edit");
        deleteMovie = new JButton("remove");
        addBook = new JButton("add");
        editBook = new JButton("edit");
        deleteBook = new JButton("remove");
        addGame = new JButton("add Game");
        editGame = new JButton("edit Game");
        deleteGame = new JButton("remove Game");
        addRelease = new JButton("add Release");
        editRelease = new JButton("edit Release");
        deleteRelease = new JButton("remove Release");

        addToPanel(adminMenu, adminUser, 0.5, 0, 0, 1);
        addToPanel(adminMenu, addUser, 0.5, 1, 0, 1);
        addToPanel(adminMenu, editUser, 0.5, 2, 0, 1);
        addToPanel(adminMenu, deleteUser, 0.5, 3, 0, 1);
        addToPanel(adminMenu, adminSeries, 0.5, 0, 1, 1);
        addToPanel(adminMenu, addSeries, 0.5, 1, 1, 1);
        addToPanel(adminMenu, editSeries, 0.5, 2, 1, 1);
        addToPanel(adminMenu, deleteSeries, 0.5, 3, 1, 1);
        addToPanel(adminMenu, addSeason, 0.5, 1, 2, 1);
        addToPanel(adminMenu, editSeason, 0.5, 2, 2, 1);
        addToPanel(adminMenu, deleteSeason, 0.5, 3, 2, 1);
        addToPanel(adminMenu, adminAnime, 0.5, 0, 3, 1);
        addToPanel(adminMenu, addAnime, 0.5, 1, 3, 1);
        addToPanel(adminMenu, editAnime, 0.5, 2, 3, 1);
        addToPanel(adminMenu, deleteAnime, 0.5, 3, 3, 1);
        addToPanel(adminMenu, adminUniverse, 0.5, 0, 4, 1);
        addToPanel(adminMenu, addUniverse, 0.5, 1, 4, 1);
        addToPanel(adminMenu, editUniverse, 0.5, 2, 4, 1);
        addToPanel(adminMenu, deleteUniverse, 0.5, 3, 4, 1);
        addToPanel(adminMenu, adminMovie, 0.5, 0, 5, 1);
        addToPanel(adminMenu, addMovie, 0.5, 1, 5, 1);
        addToPanel(adminMenu, editMovie, 0.5, 2, 5, 1);
        addToPanel(adminMenu, deleteMovie, 0.5, 3, 5, 1);
        addToPanel(adminMenu, adminBook, 0.5, 0, 6, 1);
        addToPanel(adminMenu, addBook, 0.5, 1, 6, 1);
        addToPanel(adminMenu, editBook, 0.5, 2, 6, 1);
        addToPanel(adminMenu, deleteBook, 0.5, 3, 6, 1);
        addToPanel(adminMenu, adminGame, 0.5, 0, 7, 1);
        addToPanel(adminMenu, addGame, 0.5, 1, 7, 1);
        addToPanel(adminMenu, editGame, 0.5, 2, 7, 1);
        addToPanel(adminMenu, deleteGame, 0.5, 3, 7, 1);
        addToPanel(adminMenu, addRelease, 0.5, 1, 8, 1);
        addToPanel(adminMenu, editRelease, 0.5, 2, 8, 1);
        addToPanel(adminMenu, deleteRelease, 0.5, 3, 8, 1);
    }

    private void createActionListenerSearch() {
        bSearchSeries.addActionListener(e -> {
            //SearchSeries(tfSearch.getText());
        });

        bSearchAnime.addActionListener(e -> {
            //SearchAnime(tfSearch.getText());
        });

        bSearchMovie.addActionListener(e -> {
            //SearchMovie(tfSearch.getText());
        });

        bSearchBook.addActionListener(e -> {
            //SearchBook(tfSearch.getText());
        });

        bSearchGame.addActionListener(e -> {
            //SearchGame(tfSearch.getText())
        });
    }

    private void createActionListenerAdd() {
        /*exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });*/

        addUser.addActionListener(e -> new AddUser());

        addSeries.addActionListener(e -> new AddSeries());

        addSeason.addActionListener(e -> new AddSeason());

        addAnime.addActionListener(e -> new AddAnime());

        addUniverse.addActionListener(e -> new AddUniverse());

        addMovie.addActionListener(e -> new AddMovie());

        addBook.addActionListener(e -> new AddBook());

        addGame.addActionListener(e -> new AddGame());

        addRelease.addActionListener(e -> new AddRelease());
    }

    private void createActionListenerEdit() {

        editUser.addActionListener(e -> new EditUser());

        editSeries.addActionListener(e -> new EditSeries());

        editSeason.addActionListener(e -> {
            //new EditSeason();
        });

        editAnime.addActionListener(e -> {
            //new EditAnime();
        });

        editUniverse.addActionListener(e -> {
            //new EditUniverse();
        });

        editMovie.addActionListener(e -> {
            //new EditBook();
        });

        editBook.addActionListener(e -> {
            //new EditBook();
        });

        editGame.addActionListener(e -> {
            //new EditGame();
        });

        editRelease.addActionListener(e -> {
            //new EditRelease();
        });
    }

    private void createActionListenerDelete() {
        deleteUser.addActionListener(e -> new DeleteUser());
    }
}
