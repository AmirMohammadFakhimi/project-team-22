package controller.shopmenu;

public enum ShopMenuRegexes {
    ENTER_A_MENU("^menu enter (?i)(Login|Main|Duel|Deck|Scoreboard|Profile|Shop) Menu$"),
    BUY_CARD("^shop buy ([^\n]+)$");

    private final String regex;

    ShopMenuRegexes(String regex) {
        this.regex = regex;
    }

    public String getRegex() {
        return regex;
    }
}
