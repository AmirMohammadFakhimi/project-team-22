package model.cards;

public enum CardTypes {
    NORMAL("Normal"),
    EFFECT("Effect"),
    RITUAL("Ritual"),
    SPELL("Spell"),
    TRAP("Trap");

    private final String regex;

    CardTypes(String regex) {
        this.regex = regex;
    }

    public String getRegex() {
        return regex;
    }
}
