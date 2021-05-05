package view;

import controller.Utils;
import controller.shopmenu.ShopMenuController;
import controller.shopmenu.ShopMenuMessages;
import model.Player;
import model.cards.Card;

import java.util.TreeMap;

public class ShopMenuView {
    private Player loggedInPlayer;

    public ShopMenuView(Player loggedInPlayer) {
        setLoggedInPlayer(loggedInPlayer);
    }

    private static void showListOfCards() {
        TreeMap<String, Integer> listOfCards = Card.getListOfCards();
        for (String cardName : listOfCards.keySet()) {
            System.out.println(cardName + ": " + listOfCards.get(cardName));
        }
    }

    public void setLoggedInPlayer(Player loggedInPlayer) {
        this.loggedInPlayer = loggedInPlayer;
    }

    public void shopMenuView() {
        ShopMenuController shopMenuController = new ShopMenuController(loggedInPlayer);
        while (true) {
            String command = Utils.getScanner().nextLine().trim();
            ShopMenuMessages result = shopMenuController.findCommand(command);

            System.out.print(result.getMessage());

            if (result.equals(ShopMenuMessages.EXIT_SHOP_MENU)) break;
            else if (result.equals(ShopMenuMessages.SHOW_ALL_CARDS)) showListOfCards();
        }
    }
}
