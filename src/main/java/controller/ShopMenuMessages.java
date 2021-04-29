package controller;

public enum ShopMenuMessages {
    INVALID_NAVIGATION("menu navigation is not possible\n"),
    EXIT_SHOP_MENU(""),
    SHOW_MENU("Shop Menu\n"),
    INVALID_COMMAND("invalid command\n"),
    UNAVAILABLE_CARD("there is no card with this name\n"),
    NOT_ENOUGH_MONEY("not enough money\n"),
    EMPTY(""),
    SHOW_ALL_CARDS("");

    private final String message;

    ShopMenuMessages(String message) {
        this.message = message;
    }
}
