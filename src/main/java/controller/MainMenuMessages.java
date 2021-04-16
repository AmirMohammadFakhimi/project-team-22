package controller;

public enum MainMenuMessages {
    INVALID_NAVIGATION("menu navigation is not possible\n"),
    EXIT_MAIN_MENU(""),
    SHOW_MENU("Main Menu\n"),
    USER_LOGGED_OUT("user logged out successfully!\n"),
    INVALID_COMMAND("invalid command\n"),
    EMPTY("");

    private final String message;

    MainMenuMessages(String message) {
        this.message = message;
    }
}
