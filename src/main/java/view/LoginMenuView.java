package view;

import controller.LoginMenuController;
import controller.LoginMenuMessages;
import controller.Utils;

public class LoginMenuView {
    public static void loginMenuView() {
        while (true) {
            String command = Utils.getScanner().nextLine().trim();
            LoginMenuController loginMenuController = new LoginMenuController();
            LoginMenuMessages result = loginMenuController.findCommand(command);

            System.out.println(result);

            if (result.equals(LoginMenuMessages.USER_LOGGED_IN)) LoginMenuController.loginUser(command);
        }
    }
}
