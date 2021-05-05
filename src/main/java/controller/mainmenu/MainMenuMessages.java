package controller.mainmenu;

public enum MainMenuMessages {
    INVALID_NAVIGATION("menu navigation is not possible\n"),
    EXIT_MAIN_MENU(""),
    SHOW_MENU("Main Menu\n"),
    USER_LOGGED_OUT("user logged out successfully!\n"),
    UNAVAILABLE_USERNAME("there is no player with this username\n"),
    SAME_USERNAME("please enter another username\n"),
    UNAVAILABLE_ACTIVE_DECK("<username> has no active deck\n"),
    INVALID_DECK("<username>’s deck is invalid\n"),
    INVALID_ROUNDS_NUMBER("number of rounds is not supported\n"),
    INVALID_COMMAND("invalid command\n"),
    EMPTY("");

    private String message;

    MainMenuMessages(String message) {
        this.message = message;
    }

    public static void setUnavailableActiveDeck(String username) {
        UNAVAILABLE_ACTIVE_DECK.message = username + " has no active deck\n";
    }

    public static void setInvalidDeck(String username) {
        INVALID_DECK.message = username + "’s deck is invalid\n";
    }

    public String getMessage() {
        return message;
    }
}
