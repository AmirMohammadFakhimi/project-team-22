package controller;

public enum DuelMenuMessages {
    NOT_SELECTED_CARD("no card is selected yet"),
    ATTACKED_BEFORE("this card already attacked"),
    NOT_SUITABLE_PHASE("you can’t do this action in this phase"),
    INVALID_CARD_SELECT("invalid selection"),
    SELECT_CARD_DONE("card selected"),
    NO_CARD_FOUND_IN_THE_POSITION("no card found in the given position"),
    CANT_ATTACK_WITH_CARD("you can’t attack with this card"),
    YOU_CANT_ATTACK_TO_THIS_CARD("you cant attack to this card"),
    ATTACK_CANCELED("attack to this card was canceled"),
    DIRECT_ATTACK_DONE("you opponent receives <damage> battle damage"),
    BOTH_CARDS_GET_DESTROYED("both you and your opponent monster cards are destroyed and no" +
            "one receives damage");
    private String message;

    DuelMenuMessages(String message) {
        this.message = message;
    }


    public static void setDamageAmount(int damageAmount) {
        DuelMenuMessages.DIRECT_ATTACK_DONE.message = "you opponent receives " + damageAmount + " battle damage";
    }
}
