package controller;

import model.Player;

import java.util.regex.Matcher;

public class MainMenuController {
    private Player loggedInPlayer;

    public MainMenuController(Player loggedInPlayer) {
        setLoggedInPlayer(loggedInPlayer);
    }

    public void setLoggedInPlayer(Player loggedInPlayer) {
        this.loggedInPlayer = loggedInPlayer;
    }

    public Enum findCommand(String command) {

        if (command.startsWith("menu enter")) return enterAMenu(command);
        else if (command.equals("menu exit")) return MainMenuMessages.EXIT_MAIN_MENU;
        else if (command.equals("menu show-current")) return MainMenuMessages.SHOW_MENU;
        else if (command.equals("user logout")) return MainMenuMessages.USER_LOGGED_OUT;

        return LoginMenuMessages.INVALID_COMMAND;
    }

    private Enum enterAMenu(String command) {
        Matcher matcher = Utils.getMatcher("^menu enter (?i)(Login|MAin|Duel|Deck|Scoreboard|Profile|Shop) Menu$", command);
        if (!matcher.find()) return MainMenuMessages.INVALID_COMMAND;

        String menu = matcher.group(1);
        if (menu.equalsIgnoreCase("Login")) {
            return MainMenuMessages.INVALID_NAVIGATION;
        } else if (menu.equalsIgnoreCase("Main")) {

        } else if (menu.equalsIgnoreCase("Duel")) {

        } else if (menu.equalsIgnoreCase("Deck")) {

        } else if (menu.equalsIgnoreCase("Scoreboard")) {

        } else if (menu.equalsIgnoreCase("Profile")) {

        } else if (menu.equalsIgnoreCase("Shop")) {

        }

        return MainMenuMessages.EMPTY;
    }
}
