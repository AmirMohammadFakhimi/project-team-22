package model;

import java.util.ArrayList;

public class Board {


    private Monster[] monstersZone;
    private TraoAndSpell[] spellsAndTrapsZone;
    private ArrayList<Card> graveyard;
    private Deck deck;
    //  private MagicCard fieldZone;//TODO: maybe it should be from these classes --> Spell / fieldSpell
    private Card selectedOwnCard;
    private Card selectedOpponentCard;
    {
        monstersZone = new Monster[6];
        spellsAndTrapsZone = new TraoAndSpell[6];
        graveyard = new ArrayList<>();
        selectedOpponentCard = null;
        selectedOwnCard = null;
    }

    public void setSelectedOpponentCard(Card selectedOpponentCard) {
        this.selectedOpponentCard = selectedOpponentCard;
    }

    public void setSelectedOwnCard(Card selectedOwnCard) {
        this.selectedOwnCard = selectedOwnCard;
    }

    public Card getSelectedOpponentCard() {
        return selectedOpponentCard;
    }

    public Card getSelectedOwnCard() {
        return selectedOwnCard;
    }

    public ArrayList<Card> getGraveyard() {
        return graveyard;
    }

    public TraoAndSpell[] getSpellsAndTrapsZone() {
        return spellsAndTrapsZone;
    }

    public Monster[] getMonstersZone() {
        return monstersZone;
    }

    public void setDeck(Deck deck) {
        this.deck = deck;//TODO: maybe we should have a copy of deck in duel menu --> if all changes don't apply in main deck
    }

}
