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

    public Enum changeNickname(String command) {
        Matcher matcher = Utils.getMatcher("^profile change --nickname ([A-Za-z0-9]+)$", command);

        Enum holdEnum = checkChangeNickName(matcher, loggedInPlayer);

        if (holdEnum == null) {
            loggedInPlayer.setNickname(matcher.group(1));
            return ProfileMenuMessages.CHANGE_NICKNAME_DONE;
        }
        return holdEnum;
    }

    public Enum checkChangeNickName(Matcher matcher, Player player) {
        if (matcher.find()) {
            if (Player.isNicknameExist(matcher.group(1))) {
                return ProfileMenuMessages.NOT_UNIQUE_NICKNAME;
            }
            return null;
        } else return ProfileMenuMessages.INVALID_COMMAND;

    }

    public Enum changePassword(String command) {
        Matcher matcher = Utils.getMatcher("^profile change --password --current ([A-Za-z0-9]+) --new ([A-Za-z0-9]+)$", command);
        Enum holdEnum = checkChangePassword(matcher, loggedInPlayer);

        if (holdEnum == null){
            loggedInPlayer.setPassword(matcher.group(2));
            return ProfileMenuMessages.CHANGE_PASSWORD_DONE;
        }

        return holdEnum;
    }

    public Enum checkChangePassword(Matcher matcher, Player player) {
        if (matcher.find()){
            if (!player.getPassword().equals(matcher.group(1)))
                return ProfileMenuMessages.WRONG_CURRENT_PASSWORD;
            if (matcher.group(1).equals(matcher.group(2)))
                return ProfileMenuMessages.SAME_PASSWORD;
            return null;
        }else return ProfileMenuMessages.INVALID_COMMAND;
    }
}
