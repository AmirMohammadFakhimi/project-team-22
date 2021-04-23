package model;

import java.util.ArrayList;

public class Board {
    private Monster[] monstersZone;
    private SpellAndTrap[] spellsAndTrapsZone;
    private ArrayList<Card> graveyard;
    private Deck deck;
    private SpellAndTrap fieldZone;//TODO: maybe it should be from these classes --> Spell / fieldSpell

    {
        monstersZone = new Monster[5];
        spellsAndTrapsZone = new SpellAndTrap[5];
        graveyard = new ArrayList<>();
    }

    public void setDeck(Deck deck) {
        this.deck = deck;//TODO: maybe we should have a copy of deck in duel menu --> if all changes don't apply in main deck
    }
}
