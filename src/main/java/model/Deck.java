package model;

import model.cards.Card;

import java.util.ArrayList;

public class Deck {
    private String name;
    private ArrayList<Card> mainCards;
    private ArrayList<Card> sideCards;

    {
        mainCards = new ArrayList<>();
    }

//    for creating main deck
    public Deck(String name) {
        setName(name);
    }

//    for creating side deck
    public Deck() {
        setName(null);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Card> getMainCards() {
        return mainCards;
    }

    public ArrayList<Card> getSideCards() {
        return sideCards;
    }

    public void addCard(Card card) {
        mainCards.add(card);
    }
}
