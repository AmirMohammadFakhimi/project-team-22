package controller;

import model.Player;

import java.util.regex.Matcher;

public class ScoreboardMenuController {
    private Player loggedInPlayer;

    public ScoreboardMenuController(Player loggedInPlayer) {
        setLoggedInPlayer(loggedInPlayer);
    }

    public void setLoggedInPlayer(Player loggedInPlayer) {
        this.loggedInPlayer = loggedInPlayer;
    }

    public Enum findCommand(String command) {

        if (command.startsWith("menu enter")) return enterAMenu(command);
        else if (command.equals("menu exit")) return ScoreboardMenuMessages.EXIT_SCOREBOARD_MENU;
        else if (command.equals("menu show-current")) return ScoreboardMenuMessages.SHOW_MENU;
        else if (command.startsWith("scoreboard-show")) return rank(command);

        return LoginMenuMessages.INVALID_COMMAND;
    }

    private Enum enterAMenu(String command) {
        Matcher matcher = Utils.getMatcher("^menu enter (?i)(Login|MAin|Duel|Deck|Scoreboard|Profile|Shop) Menu$", command);
        if (!matcher.find()) return ScoreboardMenuMessages.INVALID_COMMAND;

        return ScoreboardMenuMessages.INVALID_NAVIGATION;
    }

    private Enum rank(String command) {
        Matcher matcher = Utils.getMatcher("^rank ([A-Za-z ]+)$", command);
        if (!matcher.find()) return ScoreboardMenuMessages.INVALID_COMMAND;

        if (ranking == null) return ScoreboardMenuMessages.UNAVAILABLE_RANKING;

        loggedInPlayer.scoreboard-show;
        return ScoreboardMenuMessages.EMPTY;
    }
}