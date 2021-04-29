package controller;

public enum ProfileMenuMessages {
    NOT_UNIQUE_NICKNAME("user with nickname  <nickname>  already exists"),
    CHANGE_NICKNAME_DONE("nickname changed successfully!"),
    CHANGE_PASSWORD_DONE("password changed successfully!"),
    WRONG_CURRENT_PASSWORD("current password is invalid"),
    INVALID_COMMAND("invalid command"),
    SAME_PASSWORD("please enter a new password");
    private String message;

    ProfileMenuMessages(String message) {
        this.message = message;
    }

    public static void setNickname(String nickname) {
        ProfileMenuMessages.NOT_UNIQUE_NICKNAME.message = "user with nickname " + nickname + " already exists";
    }

    }
