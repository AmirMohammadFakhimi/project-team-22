package controller;

import model.Player;

import java.util.regex.Matcher;

public class ProfileMenuController {
    private Player loggedInPlayer;

    public ProfileMenuController(Player loggedInPlayer) {
        setLoggedInPlayer(loggedInPlayer);
    }

    public void setLoggedInPlayer(Player loggedInPlayer) {
        this.loggedInPlayer = loggedInPlayer;
    }

    public Enum findCommand(String command) {

    }

    public Enum changeNickname(String input) {
    }

    public Enum checkChangeNickName(Matcher matcher, Player player) {
    }

    public Enum changePassword(String input) {
    }

    public Enum checkChangePassword(Matcher matcher, Player player) {
    }
}
