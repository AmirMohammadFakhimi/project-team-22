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
        String[] split = command.split("\\s+");
        if (split.length<2){
            return ProfileMenuMessages.INVALID_COMMAND;
        }
        else if (split[1].equals("enter")){
            return ProfileMenuMessages.CANT_NAVIGATE_MENU;
        }
        else if (split[1].equals("exit")){
            return ProfileMenuMessages.EXIT_MENU;
        }
        else if (split[1].equals("show")){
            return ProfileMenuMessages.PROFILE_MENU;
        }
        else if (split[2].equals("--nickname")){
            return changeNickname(command);
        }
        else if (split[2].equals("--password")){
            return changePassword(command);
        }
        else {
            return ProfileMenuMessages.INVALID_COMMAND;

        }
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
