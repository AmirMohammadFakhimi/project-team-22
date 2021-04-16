package view;

import controller.*;
import model.Player;

public class MainMenuView {
    private Player loggedInPlayer;

    public MainMenuView(Player loggedInPlayer) {
        setLoggedInPlayer(loggedInPlayer);
    }

    public void setLoggedInPlayer(Player loggedInPlayer) {
        this.loggedInPlayer = loggedInPlayer;
    }

    public void mainMenuView() {
        while (true) {
            String command = Utils.getScanner().nextLine().trim();
            MainMenuController mainMenuController = new MainMenuController(loggedInPlayer);
            Enum result = mainMenuController.findCommand(command);

            System.out.print(result);

            if (result.equals(MainMenuMessages.EXIT_MAIN_MENU) ||
            result.equals(MainMenuMessages.USER_LOGGED_OUT)) break;
        }
    }
}
