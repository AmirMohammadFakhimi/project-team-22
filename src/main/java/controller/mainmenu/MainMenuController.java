package controller.mainmenu;

import controller.Utils;
import model.Player;
import view.ImportExportMenuView;
import view.ShopMenuView;

import java.util.regex.Matcher;

public class MainMenuController {
    private Player loggedInPlayer;

    public MainMenuController(Player loggedInPlayer) {
        setLoggedInPlayer(loggedInPlayer);
    }

    public void setLoggedInPlayer(Player loggedInPlayer) {
        this.loggedInPlayer = loggedInPlayer;
    }

    public MainMenuMessages findCommand(String command) {

        if (command.startsWith("menu enter")) return enterAMenu(command);
        else if (command.equals("menu exit")) return MainMenuMessages.EXIT_MAIN_MENU;
        else if (command.equals("menu show-current")) return MainMenuMessages.SHOW_MENU;
        else if (command.equals("user logout")) return MainMenuMessages.USER_LOGGED_OUT;
        else if (command.startsWith("duel")) return enterDuelMenu(command);

        return MainMenuMessages.INVALID_COMMAND;
    }

    private MainMenuMessages enterAMenu(String command) {
        Matcher matcher = Utils.getMatcher(MainMenuRegexes.ENTER_A_MENU.getRegex(), command);
        if (!matcher.find()) return MainMenuMessages.INVALID_COMMAND;

        String menu = matcher.group(1);
        if (menu.equalsIgnoreCase("Login")) {
            return MainMenuMessages.INVALID_NAVIGATION;
        } else if (menu.equalsIgnoreCase("Main")) {
            return MainMenuMessages.INVALID_NAVIGATION;
        } else if (menu.equalsIgnoreCase("Duel")) {
            return MainMenuMessages.INVALID_NAVIGATION;
        } else if (menu.equalsIgnoreCase("Deck")) {
            DeckMenuView deckMenuView = new DeckMenuView(loggedInPlayer);
            deckMenuView.deckMenuView();
        } else if (menu.equalsIgnoreCase("Scoreboard")) {
            ScoreboardMenuView scoreboardMenuView = new ScoreboardMenuView(loggedInPlayer);
            scoreboardMenuView.scoreboardMenuView();
        } else if (menu.equalsIgnoreCase("Profile")) {
            ProfileMenuView profileMenuView = new ProfileMenuView(loggedInPlayer);
            profileMenuView.profileMenuView();
        } else if (menu.equalsIgnoreCase("Shop")) {
            ShopMenuView shopMenuView = new ShopMenuView(loggedInPlayer);
            shopMenuView.shopMenuView();
        } else if (menu.equalsIgnoreCase("ImportExport")) {
            ImportExportMenuView importExportMenuView = new ImportExportMenuView();
            importExportMenuView.ImportExportMenuView();
        }

        return MainMenuMessages.EMPTY;
    }

    private MainMenuMessages enterDuelMenu(String command) {
//        TODO: complete this function.
    }
}