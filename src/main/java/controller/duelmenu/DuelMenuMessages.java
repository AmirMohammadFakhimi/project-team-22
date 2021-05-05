package controller.duelmenu;

import model.Player;

public enum DuelMenuMessages {
    MINI_GAME_INVALID_CHOICE("please enter a valid option\n"),
    DRAW("draw\nplease try again:\n"),
    SHOW_TURN_PLAYER("<username> should start first\n"),
    SHOW_GRAVEYARD(""),

    EMPTY(""),
    INVALID_COMMAND("invalid command\n");

    private String message;

    DuelMenuMessages(String message) {
        this.message = message;
    }

    public static void setShowTurnPlayer(Player player) {
        SHOW_TURN_PLAYER.message = player.getUsername() + " should start first";
    }

    public String getMessage() {
        return message;
    }
}
