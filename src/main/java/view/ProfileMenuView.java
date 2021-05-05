package view;

import controller.MainMenuController;
import controller.ProfileMenuController;
import controller.ProfileMenuMessages;
import controller.Utils;
import model.Player;

import java.util.Scanner;

public class ProfileMenuView {
    private Player loggedInPlayer;

    public ProfileMenuView(Player loggedInPlayer) {
        setLoggedInPlayer(loggedInPlayer);
    }

    public void setLoggedInPlayer(Player loggedInPlayer) {
        this.loggedInPlayer = loggedInPlayer;
    }

    public void profileMenuView() {
        while (true) {
            String command = Utils.getScanner().nextLine().trim();
            ProfileMenuController profileMenuController = new ProfileMenuController(loggedInPlayer);
            Enum result = profileMenuController.findCommand(command);
            if (result.equals(ProfileMenuMessages.EXIT_MENU))
                break;
            else
            System.out.print(result);
        }
    }
}
