package model;

import model.cards.Card;

import java.util.ArrayList;

public class Deck {
    private String name;
    private ArrayList<Card> cards;

    {
        cards = new ArrayList<>();
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

    public ArrayList<Card> getCards() {
        return cards;
    }

    public void addCard(Card card) {
        cards.add(card);
    }

    public Integer getNumberOfCards() {
        return cards.size();
    }
}
