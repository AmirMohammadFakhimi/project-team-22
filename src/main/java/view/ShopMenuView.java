package view;

import controller.ShopMenuController;
import controller.ShopMenuMessages;
import controller.Utils;
import model.Card;
import model.Player;

import java.util.TreeMap;

public class ShopMenuView {
    private Player loggedInPlayer;

    public ShopMenuView(Player loggedInPlayer) {
        setLoggedInPlayer(loggedInPlayer);
    }

    public void setLoggedInPlayer(Player loggedInPlayer) {
        this.loggedInPlayer = loggedInPlayer;
    }

    public void shopMenuView() {
        while (true) {
            String command = Utils.getScanner().nextLine().trim();
            ShopMenuController shopMenuController = new ShopMenuController(loggedInPlayer);
            Enum result = shopMenuController.findCommand(command);

            System.out.print(result);

            if (result.equals(ShopMenuMessages.EXIT_SHOP_MENU)) break;
            else if (result.equals(ShopMenuMessages.SHOW_ALL_CARDS)) showListOfCards();
        }
    }

    private void showListOfCards() {
        TreeMap<String, String> listOfCards = Card.getListOfCards;
        for (String cardName : listOfCards.descendingKeySet()) {
            System.out.println(cardName + ": " + listOfCards.get(cardName));
        }
    }
}
