package model;

import controller.Database;
import model.cards.Card;
import model.cards.magiccard.MagicCard;
import model.cards.monstercard.MonsterCard;

import java.util.ArrayList;

public class Player {
    private static ArrayList<Player> allPlayers;

    static {
        allPlayers = new ArrayList<>();
    }

    private ArrayList<Card> boughtCards;
    private ArrayList<Deck> allMainDecks;
    private transient Board board;
    private Deck sideDeck;
    private Deck activatedDeck;
    private String username;
    private String password;
    private String nickname;
    private long score;
    private long money;
    private transient int lifePoint = 8000;

    {
        boughtCards = new ArrayList<>();
        allMainDecks = new ArrayList<>();
        sideDeck = new Deck();
        activatedDeck = null;
        score = 0;
        money = 100000;
    }

    public Player(String username, String password, String nickname) {
        setUsername(username);
        setPassword(password);
        setNickname(nickname);
        allPlayers.add(this);
        Database.updatePlayerInformationInDatabase(this);
    }

    public static Boolean isNicknameExist(String nickname) {
        for (Player player : allPlayers) {
            if (player.nickname.equals(nickname)) return true;
        }
        return false;
    }

    public static Boolean isPasswordCorrect(String username, String password) {
        Player player = getPlayerByUsername(username);
        if (player == null) return false;

        return player.password.equals(password);
    }

    public static Player getPlayerByUsername(String username) {
        for (Player player : allPlayers) {
            if (player.username.equals(username)) return player;
        }
        return null;
    }



    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public long getScore() {
        return score;
    }

    public long getMoney() {
        return money;
    }

    public ArrayList<Card> getBoughtCards() {
        return boughtCards;
    }

    public void increaseScore(long score) {
        this.score += score;
    }

    public void decreaseScore(long score) {
        this.score -= score;
    }

    public void increaseMoney(long money) {
        this.money += money;
    }

    public void decreaseMoney(long money) {
        this.money -= money;
    }

    public void addCardToBoughtCards(Card card) {
        if (Card.isMonsterCard(card)) {
            this.boughtCards.add(new MonsterCard((MonsterCard) card));
        } else {
            this.boughtCards.add(new MagicCard((MagicCard) card));
        }
    }

    public void addMainDeck(String deckName) {
        Deck mainDeck = new Deck(deckName);
        this.allMainDecks.add(mainDeck);
    }

    public Boolean isMainDeckExist(String deckName) {
        for (Deck deck : allMainDecks) {
            if (deck.getName().equals(deckName)) return true;
        }
        return false;
    }

    public void deleteMainDeck(String deckName) {
        Deck mainDeck = getDeckByName(deckName);
        if (mainDeck != null) {
            boughtCards.addAll(mainDeck.getCards());
            allMainDecks.remove(mainDeck);
        }
    }

    public Deck getDeckByName(String deckName) {
        for (Deck deck : allMainDecks) {
            if (deck.getName().equals(deckName)) return deck;
        }
        return null;
    }

    public void activateADeck(String deckName) {
        Deck deck = getDeckByName(deckName);
        if (deck != null) activatedDeck = deck;
    }

    public void addCardToMainDeck() {
//        TODO: ???? but remember to remove this card from boughtCards :)
    }

    public void removeACard() {
//        TODO: ???? but remember to add this card from boughtCards :)
    }

    public void decreaseLifePoint(int amount) {
        this.lifePoint -= amount;
    }

    public void createBoard() {
        board = new Board();
    }
}