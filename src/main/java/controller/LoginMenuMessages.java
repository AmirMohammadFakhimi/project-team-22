package controller;

public enum LoginMenuMessages {
    ENTER_ANOTHER_MENU("please login first"),
    SHOW_MENU("Login Menu"),
    USER_CREATED("user created successfully!"),
    USERNAME_EXISTS("user with username <username> already exists"),
    NICKNAME_EXISTS("user with nickname <nickname> already exists"),
    USER_LOGGED_IN("user logged in successfully!"),
    UNMATCHED_USERNAME_AND_PASSWORD("Username and password didn’t match!"),
    INVALID_COMMAND("invalid command");

    private String label;

    LoginMenuMessages(String label) {
        this.label = label;
    }

    public static void setUsername(String username) {
        LoginMenuMessages.USERNAME_EXISTS.label = "user with username " + username + " already exists";
    }

    public static void setNickname(String nickname) {
        LoginMenuMessages.NICKNAME_EXISTS.label = "user with nickname " + nickname + " already exists";
    }
}
