package controller.mainmenu;

public enum MainMenuRegexes {
    ENTER_A_MENU("^menu enter (?i)(Login|Main|Duel|Deck|Scoreboard|Profile|Shop) Menu$");

    private final String regex;

    MainMenuRegexes(String regex) {
        this.regex = regex;
    }

    public String getRegex() {
        return regex;
    }
}
