package controller.shopmenu;

import controller.Database;
import controller.Utils;
import model.Player;
import model.cards.Card;

import java.util.regex.Matcher;

public class ShopMenuController {
    private Player loggedInPlayer;

    public ShopMenuController(Player loggedInPlayer) {
        setLoggedInPlayer(loggedInPlayer);
    }

    public void setLoggedInPlayer(Player loggedInPlayer) {
        this.loggedInPlayer = loggedInPlayer;
    }

    public ShopMenuMessages findCommand(String command) {

        if (command.startsWith("menu enter")) return enterAMenu(command);
        else if (command.equals("menu exit")) return ShopMenuMessages.EXIT_SHOP_MENU;
        else if (command.equals("menu show-current")) return ShopMenuMessages.SHOW_MENU;
        else if (command.startsWith("shop buy")) return buyACard(command);
        else if (command.equals("shop show --all")) return ShopMenuMessages.SHOW_ALL_CARDS;

        return ShopMenuMessages.INVALID_COMMAND;
    }

    private ShopMenuMessages enterAMenu(String command) {
        Matcher matcher = Utils.getMatcher(ShopMenuRegexes.ENTER_A_MENU.getRegex(), command);
        if (!matcher.find()) return ShopMenuMessages.INVALID_COMMAND;

        return ShopMenuMessages.INVALID_NAVIGATION;
    }

    private ShopMenuMessages buyACard(String command) {
        Matcher matcher = Utils.getMatcher(ShopMenuRegexes.BUY_CARD.getRegex(), command);
        if (!matcher.find()) return ShopMenuMessages.INVALID_COMMAND;

        String cardName = matcher.group(1);
        Card boughtCard = Card.getCardByName(cardName);
        if (boughtCard == null) return ShopMenuMessages.UNAVAILABLE_CARD;
        if (boughtCard.getPrice() > loggedInPlayer.getMoney()) return ShopMenuMessages.NOT_ENOUGH_MONEY;

        loggedInPlayer.addCardToBoughtCards(boughtCard);
        Database.updatePlayerInformationInDatabase(loggedInPlayer);
        return ShopMenuMessages.EMPTY;
    }
}
