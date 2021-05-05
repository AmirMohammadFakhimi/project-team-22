package controller;

public enum ProfileMenuMessages {
    NOT_UNIQUE_NICKNAME("user with nickname  <nickname>  already exists"),
    CHANGE_NICKNAME_DONE("nickname changed successfully!"),
    CHANGE_PASSWORD_DONE("password changed successfully!"),
    WRONG_CURRENT_PASSWORD("current password is invalid"),
    INVALID_COMMAND("invalid command"),
    PROFILE_MENU("profile menu"),
    EXIT_MENU("exit"),
    CANT_NAVIGATE_MENU("menu navigation is not possible"),
    SAME_PASSWORD("please enter a new password");
    private String message;

    ProfileMenuMessages(String message) {
        this.message = message;
    }

    public static void setNickname(String nickname) {
        ProfileMenuMessages.NOT_UNIQUE_NICKNAME.message = "user with nickname " + nickname + " already exists";
    }

    }
