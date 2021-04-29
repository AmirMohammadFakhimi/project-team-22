package view;

import controller.DuelMenuController;
import controller.Utils;
import model.Card;
import model.Player;

public class DuelMenuView {
    private Player loggedInPlayer;
    private Player opponentPlayer;
    private Enum phase;

    public DuelMenuView(Player loggedInPlayer, Player opponentPlayer) {
        this.loggedInPlayer = loggedInPlayer;
        this.opponentPlayer = opponentPlayer;
    }

    public static void showSelectedCard(Card card) {

    }

    public void duelMenuView() {
        String command = Utils.getScanner().nextLine().trim();
        DuelMenuController mainMenu = new DuelMenuController(loggedInPlayer, opponentPlayer, phase);
        mainMenu.findCommand(command);
    }

    private void showGraveyard() {

    }
}
