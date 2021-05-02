package controller.loginmenu;

import controller.Utils;
import model.Player;
import view.MainMenuView;

import java.util.regex.Matcher;

public class LoginMenuController {
    public static LoginMenuMessages findCommand(String command) {

        if (command.startsWith("menu enter")) return enterAMenu(command);
        else if (command.equals("menu exit")) System.exit(0);
        else if (command.equals("menu show-current")) return LoginMenuMessages.SHOW_MENU;
        else if (command.startsWith("user create")) {
            return checkCreateUser(command);
        } else if (command.startsWith("user login")) {
            return checkLoginUser(command);
        }

        return LoginMenuMessages.INVALID_COMMAND;
    }

    private static LoginMenuMessages enterAMenu(String command) {
        Matcher matcher = Utils.getMatcher(LoginMenuRegexes.ENTER_A_MENU.getRegex(), command);
        if (!matcher.find()) return LoginMenuMessages.INVALID_COMMAND;

        String menu = matcher.group(1);
        if (menu.equalsIgnoreCase("Login")) {
            return LoginMenuMessages.INVALID_NAVIGATION;
        }

        return LoginMenuMessages.ENTER_ANOTHER_MENU;
    }

    private static LoginMenuMessages checkCreateUser(String command) {
        Matcher matcher;
        String username, nickname, password;
        if (( matcher = Utils.getMatcher(LoginMenuRegexes.CREATE_USER_FIRST_PATTERN.getRegex(), command) ).find()) {
            username = matcher.group(1);
            nickname = matcher.group(2);
            password = matcher.group(3);
        } else if (( matcher = Utils.getMatcher(LoginMenuRegexes.CREATE_USER_SECOND_PATTERN.getRegex(), command) ).find()) {
            username = matcher.group(1);
            nickname = matcher.group(3);
            password = matcher.group(2);
        } else if (( matcher = Utils.getMatcher(LoginMenuRegexes.CREATE_USER_THIRD_PATTERN.getRegex(), command) ).find()) {
            username = matcher.group(2);
            nickname = matcher.group(1);
            password = matcher.group(3);
        } else if (( matcher = Utils.getMatcher(LoginMenuRegexes.CREATE_USER_FOURTH_PATTERN.getRegex(), command) ).find()) {
            username = matcher.group(3);
            nickname = matcher.group(1);
            password = matcher.group(2);
        } else if (( matcher = Utils.getMatcher(LoginMenuRegexes.CREATE_USER_FIFTH_PATTERN.getRegex(), command) ).find()) {
            username = matcher.group(2);
            nickname = matcher.group(3);
            password = matcher.group(1);
        } else if (( matcher = Utils.getMatcher(LoginMenuRegexes.CREATE_USER_SIXTH_PATTERN.getRegex(), command) ).find()) {
            username = matcher.group(3);
            nickname = matcher.group(2);
            password = matcher.group(1);
        } else {
            return LoginMenuMessages.INVALID_COMMAND;
        }


        if (Player.getPlayerByUsername(username) != null) {
            LoginMenuMessages.setUsername(username);
            return LoginMenuMessages.USERNAME_EXISTS;
        }
        if (Player.isNicknameExist(nickname)) {
            LoginMenuMessages.setNickname(nickname);
            return LoginMenuMessages.NICKNAME_EXISTS;
        }

//        TODO: handle to have "strong password" error
        createUser(username, password, nickname);
        return LoginMenuMessages.USER_CREATED;
    }

    private static void createUser(String username, String password, String nickname) {
        new Player(username, password, nickname);
    }

    private static LoginMenuMessages checkLoginUser(String command) {
        Matcher matcher;
        String username, password;
        if (( matcher = Utils.getMatcher(LoginMenuRegexes.LOGIN_USER_USERNAME_PATTERN.getRegex(), command) ).find()) {
            username = matcher.group(1);
            password = matcher.group(2);
        } else if (( matcher = Utils.getMatcher(LoginMenuRegexes.LOGIN_USER_PASSWORD_PATTERN.getRegex(), command) ).find()) {
            username = matcher.group(2);
            password = matcher.group(1);
        } else {
            return LoginMenuMessages.INVALID_COMMAND;
        }


        if (!Player.isPasswordCorrect(username, password)) {
            return LoginMenuMessages.UNMATCHED_USERNAME_AND_PASSWORD;
        }

        return LoginMenuMessages.USER_LOGGED_IN;
    }

    public static void loginUser(String command) {
        Matcher matcher;
        String username = null;
        if (( matcher = Utils.getMatcher(LoginMenuRegexes.LOGIN_USER_USERNAME_PATTERN.getRegex(), command) ).find()) {
            username = matcher.group(1);
        } else if (( matcher = Utils.getMatcher(LoginMenuRegexes.LOGIN_USER_PASSWORD_PATTERN.getRegex(), command) ).find()) {
            username = matcher.group(2);
        }


        MainMenuView mainMenuView = new MainMenuView(Player.getPlayerByUsername(username));
        mainMenuView.mainMenuView();
    }
}
