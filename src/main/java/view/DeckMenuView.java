package view;

import controller.DeckMenuController;
import controller.DeckMenuMessages;
import controller.Utils;
import model.Player;

public class DeckMenuView {
    private Player loggedInPlayer;

    public DeckMenuView(Player loggedInPlayer) {
        setLoggedInPlayer(loggedInPlayer);
    }

    public void setLoggedInPlayer(Player loggedInPlayer) {
        this.loggedInPlayer = loggedInPlayer;
    }

    public void deckMenuView() {
        while (true) {
            String command = Utils.getScanner().nextLine().trim();
            DeckMenuController deckMenuController = new DeckMenuController(loggedInPlayer);
            Enum result = deckMenuController.findCommand(command);

            System.out.print(result);

            if (result.equals(DeckMenuMessages.EXIT_DECK_MENU)) break;
            else if (result.equals(DeckMenuMessages.DECK_SHOW)) deck-show();
        }
    }

    private void deck-show();