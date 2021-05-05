package controller.duelmenu;

public enum MiniGameChoices {
    STONE("stone"),
    PAPER("paper"),
    SCISSOR("scissor");

    private final String choice;

    MiniGameChoices(String choice) {
        this.choice = choice;
    }

    public String getChoice() {
        return choice;
    }
}
