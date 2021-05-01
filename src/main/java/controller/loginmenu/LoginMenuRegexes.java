package controller.loginmenu;

public enum LoginMenuRegexes {
    CREATE_USER_FIRST_PATTERN("^user create --(?:username|U) (\\S+) --(?:nickname|N) (\\S+) --(?:password|P) (\\S+)$"),
    CREATE_USER_SECOND_PATTERN("^user create --(?:username|U) (\\S+) --(?:password|P) (\\S+) --(?:nickname|N) (\\S+)$"),
    CREATE_USER_THIRD_PATTERN("^user create --(?:nickname|N) (\\S+) --(?:username|U) (\\S+) --(?:password|P) (\\S+) $"),
    CREATE_USER_FOURTH_PATTERN("^user create --(?:nickname|N) (\\S+) --(?:password|P) (\\S+) --(?:username|U) (\\S+)$"),
    CREATE_USER_FIFTH_PATTERN("^user create --(?:password|P) (\\S+) --(?:username|U) (\\S+) --(?:nickname|N) (\\S+)$"),
    CREATE_USER_SIXTH_PATTERN("^user create --(?:password|P) (\\S+) --(?:nickname|N) (\\S+) --(?:username|U) (\\S+)$"),
    LOGIN_USER_USERNAME_PATTERN("^user login --(?:username|U) (\\S+) --(?:password|P) (\\S+)$"),
    LOGIN_USER_PASSWORD_PATTERN("^user login --(?:password|P) (\\S+) --(?:username|U) (\\S+)$");

    private final String regex;

    LoginMenuRegexes(String regex) {
        this.regex = regex;
    }

    public String getRegex() {
        return regex;
    }
}
