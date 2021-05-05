package view;

import controller.Utils;
import controller.mainmenu.MainMenuController;
import controller.mainmenu.MainMenuMessages;
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
        MainMenuController mainMenuController = new MainMenuController(loggedInPlayer);
        while (true) {
            String command = Utils.getScanner().nextLine().trim();
            MainMenuMessages result = mainMenuController.findCommand(command);

            System.out.print(result.getMessage());

            if (result.equals(MainMenuMessages.EXIT_MAIN_MENU) ||
            result.equals(MainMenuMessages.USER_LOGGED_OUT)) break;
        }
    }
}
