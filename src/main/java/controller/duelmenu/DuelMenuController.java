package controller.duelmenu;

import model.Player;
import view.DuelMenuView;

import java.util.Collections;

public class DuelMenuController {
//    TODO: how to handle board
//    TODO: how to handle graveyard --> ArrayList --> put it in Player class/DuelMenuController/board class??
    private Player turnPlayer;
    private Player notTurnPlayer;
    private Phases phase;

    public static String specifyTurnPlayer(Player firstPlayer, Player secondPlayer) {
        String firstPlayerChoiceInString = DuelMenuView.findChooseOfPlayerInMiniGame(firstPlayer);
        if (!isMiniGameChoiceValid(firstPlayerChoiceInString)) return "invalid choice";
        MiniGameChoices firstPlayerChoice = MiniGameChoices.valueOf(firstPlayerChoiceInString.toUpperCase());

        String secondPlayerChoiceInString = DuelMenuView.findChooseOfPlayerInMiniGame(secondPlayer);
        if (!isMiniGameChoiceValid(secondPlayerChoiceInString)) return "invalid choice";
        MiniGameChoices secondPlayerChoice = MiniGameChoices.valueOf(secondPlayerChoiceInString.toUpperCase());

        if (firstPlayerChoice.equals(secondPlayerChoice)) return "draw";

        return findMiniGameWinner(firstPlayer, secondPlayer, firstPlayerChoice, secondPlayerChoice);
    }

    private static boolean isMiniGameChoiceValid(String choice) {
        try {
            MiniGameChoices.valueOf(choice.toUpperCase());
            return true;
        } catch (Exception exception) {
            return false;
        }
    }

    private static String findMiniGameWinner(Player firstPlayer, Player secondPlayer,
                                             MiniGameChoices firstPlayerChoice, MiniGameChoices secondPlayerChoice) {
        switch (firstPlayerChoice) {
            case STONE:
                if (secondPlayerChoice.equals(MiniGameChoices.PAPER)) {
                    DuelMenuMessages.setShowTurnPlayer(secondPlayer);
                    return secondPlayer.getUsername();
                } else {
                    DuelMenuMessages.setShowTurnPlayer(firstPlayer);
                    return firstPlayer.getUsername();
                }
            case PAPER:
                if (secondPlayerChoice.equals(MiniGameChoices.SCISSOR)) {
                    DuelMenuMessages.setShowTurnPlayer(secondPlayer);
                    return secondPlayer.getUsername();
                } else {
                    DuelMenuMessages.setShowTurnPlayer(firstPlayer);
                    return firstPlayer.getUsername();
                }
            case SCISSOR:
                if (secondPlayerChoice.equals(MiniGameChoices.STONE)) {
                    DuelMenuMessages.setShowTurnPlayer(secondPlayer);
                    return secondPlayer.getUsername();
                } else {
                    DuelMenuMessages.setShowTurnPlayer(firstPlayer);
                    return firstPlayer.getUsername();
                }
        }

//        this is never happen
        return null;
    }

    public DuelMenuMessages initialGame(Player firstPlayer, Player secondPlayer) {
        String result = specifyTurnPlayer(firstPlayer, secondPlayer);
        if (result.equals("invalid choice")) return DuelMenuMessages.MINI_GAME_INVALID_CHOICE;
        else if (result.equals("draw")) return DuelMenuMessages.DRAW;
        else turnPlayer = Player.getPlayerByUsername(result);

        if (turnPlayer.equals(firstPlayer)) notTurnPlayer = secondPlayer;
        else notTurnPlayer = firstPlayer;

//        shuffle main cards of players
        Collections.shuffle(firstPlayer.getActivatedDeck().getMainCards());
        Collections.shuffle(secondPlayer.getActivatedDeck().getMainCards());

        return DuelMenuMessages.SHOW_TURN_PLAYER;
    }

    public DuelMenuMessages findCommand(String command) {

        if (command.startsWith("select")) return checkSelectCard(command);
        else if (command.equals("select -d")) return checkDeselectCard();
        else if (command.equals("summon")) return checkSummonMonster();
        else if (command.equals("set")) return checkSetACard();
        else if (command.startsWith("set --position")) return checkChangePosition(command);
        else if (command.equals("flip-summon")) return checkFlipSummon();
        else if (command.equals("attack direct")) return checkDirectAttack();
        else if (command.startsWith("attack")) return checkAttack(command);
        else if (command.equals("activate effect")) return checkActiveASpellCard();
        else if (command.equals("show graveyard")) return DuelMenuMessages.SHOW_GRAVEYARD;
        else if (command.equals("back")) checkBack();
        else if (command.equals("card show --selected")) {
            DuelMenuView.showSelectedCard();
            return DuelMenuMessages.EMPTY;
        } else if (command.equals("cancel")) cancelCommand();
        else if (command.equals("surrender")) /*TODO*/;

//        TODO: handle cheat/debug commands

        return DuelMenuMessages.INVALID_COMMAND;
    }

    private DuelMenuMessages checkSelectCard(String command) {

    }

    private DuelMenuMessages selectCard(String command) {

    }

    private DuelMenuMessages checkDeselectCard() {

    }

    private DuelMenuMessages deselectCard() {

    }

    private DuelMenuMessages checkSummonMonster() {
//        TODO: maybe change the name to --> checkSummonCard
    }

    private DuelMenuMessages summonMonster() {
//        TODO: maybe change the name to --> summonCard
    }

    private void victimize() {
//        TODO: handle it!
    }

    private DuelMenuMessages checkSetACard() {

    }

    private DuelMenuMessages checkSetAMonster() {

    }

    private DuelMenuMessages setAMonster() {

    }

    private DuelMenuMessages checkChangePosition(String command) {

    }

    private DuelMenuMessages changePosition(String command) {

    }

    private void updateGraveyard() {
//        TODO: handle it!
    }

    private DuelMenuMessages checkFlipSummon() {

    }

    private DuelMenuMessages flipSummon() {

    }

    private DuelMenuMessages checkDirectAttack() {
//        TODO: maybe merge with checkAttack function
    }

    private DuelMenuMessages directAttack() {

    }

    private DuelMenuMessages checkAttack(String command) {
//        TODO: maybe merge with checkDirectAttack function
    }

    private DuelMenuMessages attack(String command) {

    }

    private DuelMenuMessages checkActiveASpellCard() {

    }

    private DuelMenuMessages activeASpellCard() {

    }

    private DuelMenuMessages checkSetASpell() {

    }

    private DuelMenuMessages setASpell() {

    }

    private DuelMenuMessages checkBack() {

    }

    private void cancelCommand() {

    }

////    TODO: handle activeASpellInOpponentTurn
////    TODO: -----------------------------------------------
////    TODO: we are not sure about under functions
//
//    private DuelMenuMessages ritualSummon(String command) {
//
//    }
//
//    private DuelMenuMessages specialSummon(String command) {
//
//    }
//
//    private Player/*or Enum*/ checkWinner() {
//
//    }
//
////    TODO: -----------------------------------------------

}
