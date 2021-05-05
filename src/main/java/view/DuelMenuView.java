package view;

import controller.DuelMenuController;
import controller.Utils;
import model.*;

public class DuelMenuView {
    private Player loggedInPlayer;
    private Player opponentPlayer;
    private Enum phase;
    private Board loggedInPlayerBoard;
    private Board opponentPlayerBoard;
    private int turnFlag = 0;

    {
        loggedInPlayerBoard = new Board();
        opponentPlayerBoard = new Board();
    }

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

    private void showBoard(Board playerBoard, Board opponentBoard) {
        showCartInHand(opponentBoard);
        showLeftCardDeck(opponentBoard);//??????????????????????
        showOpponentTrapAndSpellZone(opponentBoard);
        showOpponentMonsterZone(opponentBoard);
        showGrave(opponentBoard);
        System.out.println("--------------------------");
        showCartInHand(playerBoard);
        showLeftCardDeck(playerBoard);//????????
        showTrapAndSpellZone(playerBoard);
        showMonsterZone(playerBoard);
        showGrave(playerBoard);
    }

    private void showMonsterZone(Board board){
        Monster[] monsters = board.getMonstersZone();
        monsters[5].print();
        System.out.print(monsters[5].print() + "    ");
        System.out.print(monsters[3].print() + "    ");
        System.out.print(monsters[1].print() + "    ");
        System.out.print(monsters[2].print() + "    ");
        System.out.print(monsters[4].print() + "    ");
        System.out.println();
    }

   private void showTrapAndSpellZone(Board board){
       TraoAndSpell[] spellsAndTrapsZone = board.getSpellsAndTrapsZone()
       spellsAndTrapsZone[5].print();
       spellsAndTrapsZone[3].print();
       spellsAndTrapsZone[1].print();
       spellsAndTrapsZone[2].print();
       spellsAndTrapsZone[4].print();
   }

    private void showOpponentMonsterZone(Board board) {
        Monster[] monsters = board.getMonstersZone();
        System.out.print(monsters[4].print() + "    ");
        System.out.print(monsters[2].print() + "    ");
        System.out.print(monsters[1].print() + "    ");
        System.out.print(monsters[3].print() + "    ");
        System.out.print(monsters[5].print() + "    ");
    }

    private void showOpponentTrapAndSpellZone(Board board) {
        TraoAndSpell[] spellsAndTrapsZone = board.getSpellsAndTrapsZone()
        spellsAndTrapsZone[4].print();
        spellsAndTrapsZone[2].print();
        spellsAndTrapsZone[1].print();
        spellsAndTrapsZone[3].print();
        spellsAndTrapsZone[5].print();
    }

    private void showCartInHand(Board board) {
        for (int i = 0; i < board.; i++) {
            System.out.print("C ");
        }
        System.out.println();
        ;
    }

    private void showGraveyard(Board board) {
        if (board.getGraveyard().size() != 0) {
            for (int i = 0; i < board.getGraveyard().size(); i++) {
                System.out.println(board.getGraveyard().get(i).getName() + " " + board.getGraveyard().get(i).getDescription());
            }
        } else System.out.println("graveyard empty");
        while (true) {
            String input = Utils.getScanner().nextLine();
            if (input.equals("back"))
                break;
        }
    }
}
