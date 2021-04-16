package model;

import java.util.ArrayList;
import java.util.TreeMap;

public class Card {
    protected static ArrayList<Card> ALL_CARDS = new ArrayList<Card>();
    protected String cardType;
    protected String name;
    protected String description;
    protected String upDown;


    public Card(String cardType, String name, String description, String upDown) {
        setCardType(cardType);
        setName(name);
        setDescription(description);
        setUpDown(upDown);
        ALL_CARDS.add(this);
    }

    public static ArrayList<Card> getAllCards() {
        return ALL_CARDS;
    }

    public static void setAllCards(ArrayList<Card> allCards) {
        ALL_CARDS = allCards;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCardType() {
        return cardType;
    }

    public void setCardType(String cardType) {
        this.cardType = cardType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUpDown() {
        return upDown;
    }

    public void setUpDown(String upDown) {
        this.upDown = upDown;
    }

    //public void callCard(){}

    public void turnCard() {
        setUpDown("up");
    }

    public Card getCardByName(String name) {
        for (int i = 0; i < ALL_CARDS.size(); i++) {
            if (ALL_CARDS.get(i).getName().equals(name))
                return ALL_CARDS.get(i);
        }
        return null;
    }

    public TreeMap<String, String> getListOfCards() {
    }
}
