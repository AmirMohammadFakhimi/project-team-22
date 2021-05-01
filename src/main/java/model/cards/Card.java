package model.cards;

public class Card {
    protected String name;
    protected transient String number;
    protected transient String description;
    protected transient int price;
//    if this boolean equals "false" so we can conclude that card is "face down"
    protected transient Boolean isCardFaceUp;
}
