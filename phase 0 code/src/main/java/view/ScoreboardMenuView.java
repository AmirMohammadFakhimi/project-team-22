package view;

import controller.ScoreboardMenuController;
import controller.ScoreboardMenuMessages;
import controller.Utils;
import model.Player;

public class ScoreboardMenuView {
    private Player loggedInPlayer;

    public ScoreboardMenuView(Player loggedInPlayer) {
        setLoggedInPlayer(loggedInPlayer);
    }

    public void setLoggedInPlayer(Player loggedInPlayer) {
        this.loggedInPlayer = loggedInPlayer;
    }

    public void scoreboardMenuView() {
        while (true) {
            String command = Utils.getScanner().nextLine().trim();
            ScoreboardMenuController scoreboardMenuController = new ScoreboardMenuController(loggedInPlayer);
            Enum result = scoreboardMenuController.findCommand(command);

            System.out.print(result);

            if (result.equals(ScoreboardMenuMessages.EXIT_SCOREBOARD_MENU)) break;
            else if (result.equals(ScoreboardMenuMessages.SCOREBOARD_SHOW)) rank();
        }
    }

    private void rank() {
    }

}