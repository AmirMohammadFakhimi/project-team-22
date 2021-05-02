package model.cards.magiccard;

public enum MagicCardStatuses {
    LIMITED("Limited"),
    UNLIMITED("Unlimited");

    private final String regex;

    MagicCardStatuses(String regex) {
        this.regex = regex;
    }

    public String getRegex() {
        return regex;
    }
}
