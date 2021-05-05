package view;

import controller.Utils;
import controller.duelmenu.DuelMenuController;
import controller.duelmenu.DuelMenuMessages;
import controller.duelmenu.Phases;
import model.Player;
import model.cards.Card;

public class DuelMenuView {
    private Player firstPlayer;
    private Player secondPlayer;
    private Phases phase;

    public DuelMenuView(Player firstPlayer, Player secondPlayer) {
        setFirstPlayer(firstPlayer);
        setSecondPlayer(secondPlayer);
    }

    public static void showSelectedCard(Card card) {

    }

    public static String findChooseOfPlayerInMiniGame(Player player) {
        System.out.println(player.getUsername() + ", please choose between stone, paper and scissor:");
        return Utils.getScanner().nextLine().trim();
    }

    public void setFirstPlayer(Player firstPlayer) {
        this.firstPlayer = firstPlayer;
    }

    public void setSecondPlayer(Player secondPlayer) {
        this.secondPlayer = secondPlayer;
    }

    public void duelMenuView() {
        DuelMenuController duelMenuController = new DuelMenuController();

        DuelMenuMessages resultOfInitialGame = null;
        while (resultOfInitialGame == null || !resultOfInitialGame.equals(DuelMenuMessages.SHOW_TURN_PLAYER)) {
            resultOfInitialGame = duelMenuController.initialGame(firstPlayer, secondPlayer);
            System.out.print(resultOfInitialGame.getMessage());
        }

        while (true) {
            String command = Utils.getScanner().nextLine().trim();
            DuelMenuMessages result = duelMenuController.findCommand(command);

            System.out.print(result.getMessage());

            if (result.equals(DuelMenuMessages.SHOW_GRAVEYARD)) showGraveyard();
        }
    }

    private void showGraveyard() {

    }

    public void showCard(Card card) {

    }
}
