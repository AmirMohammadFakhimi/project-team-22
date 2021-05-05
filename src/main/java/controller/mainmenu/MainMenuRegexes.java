package controller.mainmenu;

public enum MainMenuRegexes {
    ENTER_A_MENU("^menu enter (?i)(Login|Main|Duel|Deck|Scoreboard|Profile|Shop|ImportExport) Menu$"),
    ENTER_DUEL_MENU_FIRST_PATTERN("^duel --(?:new|N) --(?:((?:second-player|S) \\S+)|(?:ai|A)) --(?:rounds|R) (\\d+)$"),
    ENTER_DUEL_MENU_SECOND_PATTERN("^duel --(?:new|N) --(?:rounds|R) (\\d+) --(?:((?:second-player|S) \\S+)|(?:ai|A))$"),
    ENTER_DUEL_MENU_THIRD_PATTERN("^duel --(?:((?:second-player|S) \\S+)|(?:ai|A)) --(?:new|N) --(?:rounds|R) (\\d+)$"),
    ENTER_DUEL_MENU_FOURTH_PATTERN("^duel --(?:((?:second-player|S) \\S+)|(?:ai|A)) --(?:rounds|R) (\\d+) --(?:new|N)$"),
    ENTER_DUEL_MENU_FIFTH_PATTERN("^duel --(?:rounds|R) (\\d+) --(?:new|N) --(?:((?:second-player|S) \\S+)|(?:ai|A))$"),
    ENTER_DUEL_MENU_SIXTH_PATTERN("^duel --(?:rounds|R) (\\d+) --(?:((?:second-player|S) \\S+)|(?:ai|A)) --(?:new|N)$");

    private final String regex;

    MainMenuRegexes(String regex) {
        this.regex = regex;
    }

    public String getRegex() {
        return regex;
    }
}
