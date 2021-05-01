package controller.loginmenu;

public enum LoginMenuMessages {
    ENTER_ANOTHER_MENU("please login first"),
    INVALID_NAVIGATION("menu navigation is not possible"),
    SHOW_MENU("Login Menu"),
    USER_CREATED("user created successfully!"),
    USERNAME_EXISTS("user with username <username> already exists"),
    NICKNAME_EXISTS("user with nickname <nickname> already exists"),
    USER_LOGGED_IN("user logged in successfully!"),
    UNMATCHED_USERNAME_AND_PASSWORD("Username and password didn’t match!"),
    INVALID_COMMAND("invalid command");

    private String message;

    LoginMenuMessages(String message) {
        this.message = message;
    }

    public static void setUsername(String username) {
        LoginMenuMessages.USERNAME_EXISTS.message = "user with username " + username + " already exists";
    }

    public static void setNickname(String nickname) {
        LoginMenuMessages.NICKNAME_EXISTS.message = "user with nickname " + nickname + " already exists";
    }

    public String getMessage() {
        return message;
    }
}
