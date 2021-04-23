package controller;

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
        Matcher matcher = Utils.getMatcher("^menu enter (?i)(Login|Main|Duel|Deck|Scoreboard|Profile|Shop) Menu$", command);
        if (!matcher.find()) return ShopMenuMessages.INVALID_COMMAND;

        String menu = matcher.group(1);
        if (menu.equalsIgnoreCase("Login")) {
            return LoginMenuMessages.INVALID_NAVIGATION;
        }

        return LoginMenuMessages.ENTER_ANOTHER_MENU;
    }

    private static LoginMenuMessages checkCreateUser(String command) {
//        user is same as player


        String username;
        String password;
        String nickname;

        if (Player.getPlayerByUsername(username) != null) {
            LoginMenuMessages.setUsername(username);
            return LoginMenuMessages.USERNAME_EXISTS;
        }
        if (Player.isNicknameExist(nickname)) {
            LoginMenuMessages.setNickname(nickname);
            return LoginMenuMessages.NICKNAME_EXISTS;
        }

        createUser(username, password, nickname);
        return LoginMenuMessages.USER_CREATED;
    }

    private static void createUser(String username, String password, String nickname) {
        new Player(username, password, nickname);
    }

    private static LoginMenuMessages checkLoginUser(String command) {
//        user is same as player



        String username;
        String password;

        if (!Player.isNicknameExist(username) || !Player.isPasswordCorrect(username, password)) {
            return LoginMenuMessages.UNMATCHED_USERNAME_AND_PASSWORD;
        }

        return LoginMenuMessages.USER_LOGGED_IN;
    }

    public static void loginUser(String command) {



        String username;
        MainMenuView mainMenuView = new MainMenuView(Player.getPlayerByUsername(username));
        mainMenuView.mainMenuView();
    }

    private static LoginMenuMessages checkLogoutUser(String command) {
//        user is same as player




    }
}
