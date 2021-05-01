package view;

import controller.Utils;
import controller.loginmenu.LoginMenuController;
import controller.loginmenu.LoginMenuMessages;

public class LoginMenuView {
    public static void loginMenuView() {
        while (true) {
            String command = Utils.getScanner().nextLine().trim();
            LoginMenuController loginMenuController = new LoginMenuController();
            LoginMenuMessages result = loginMenuController.findCommand(command);

            System.out.println(result.getMessage());

            if (result.equals(LoginMenuMessages.USER_LOGGED_IN)) LoginMenuController.loginUser(command);
        }
    }
}
