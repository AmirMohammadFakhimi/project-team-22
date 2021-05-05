package controller.duelmenu;

public enum DuelMenuRegexes {


    private final String regex;

    DuelMenuRegexes(String message) {
        this.regex = message;
    }

    public String getRegex() {
        return regex;
    }
}
