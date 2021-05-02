package model.cards;

import model.cards.monstercard.MonsterCard;

import java.util.HashMap;
import java.util.TreeMap;

public class Card {
    protected transient static HashMap<String, Card> allCards;

    static {
         allCards = new HashMap<>();
    }

    protected String name;
    protected transient String description;
    protected transient CardTypes cardType;
    protected transient int price;
//    if this boolean equals "false" so we can conclude that card is "face down"
    protected transient Boolean isCardFaceUp;

    {
        isCardFaceUp = false;
    }

    public Card(String name, String description, CardTypes cardType, int price) {
        setName(name);
        setDescription(description);
        setCardType(cardType);
        setPrice(price);
    }

    public static Card getCardByName(String name) {
        return allCards.get(name);
    }

    public static TreeMap<String, Integer> getListOfCards() {
        TreeMap<String, Integer> listOfCards = new TreeMap<>();
        for (String cardName : allCards.keySet()) {
            Integer cardPrice = allCards.get(cardName).getPrice();
            listOfCards.put(cardName, cardPrice);
        }
        return listOfCards;
    }

    public static boolean isMonsterCard(Card card) {
        try {
            MonsterCard monsterCard = (MonsterCard) card;
            return true;
        } catch (Exception exception) {
            return false;
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public CardTypes getCardType() {
        return cardType;
    }

    public void setCardType(CardTypes cardType) {
        this.cardType = cardType;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
