package view;

import controller.Utils;
import controller.duelmenu.DuelMenuController;
import model.Player;
import model.cards.Card;

public class DuelMenuView {
    private Player turnPlayer;
    private Player notTurnPlayer;
    private Enum phase;

    public DuelMenuView(Player turnPlayer, Player notTurnPlayer) {
        setTurnPlayer(turnPlayer);
        setNotTurnPlayer(notTurnPlayer);
    }

    public static void showSelectedCard(Card card) {

    }

    public void setTurnPlayer(Player turnPlayer) {
        this.turnPlayer = turnPlayer;
    }

    public void setNotTurnPlayer(Player notTurnPlayer) {
        this.notTurnPlayer = notTurnPlayer;
    }

    public void duelMenuView() {
        String command = Utils.getScanner().nextLine().trim();
        DuelMenuController duelMenuController = new DuelMenuController(turnPlayer, notTurnPlayer, phase);
        Enum result = duelMenuController.findCommand(command);

        System.out.println(result);
    }

    private void showGraveyard() {

    }
}