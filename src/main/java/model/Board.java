package model;

import model.cards.Card;
import model.cards.MagicCard;
import model.cards.MonsterCard;

import java.util.ArrayList;

public class Board {
    private MonsterCard[] monstersZone;
    private MagicCard[] spellsAndTrapsZone;
    private ArrayList<Card> graveyard;
    private Deck deck;
    private MagicCard fieldZone;//TODO: maybe it should be from these classes --> Spell / fieldSpell

    {
        monstersZone = new MonsterCard[6];
        spellsAndTrapsZone = new MagicCard[6];
        graveyard = new ArrayList<>();
    }

    public void setDeck(Deck deck) {
        this.deck = deck;//TODO: maybe we should have a copy of deck in duel menu --> if all changes don't apply in main deck
    }
}
