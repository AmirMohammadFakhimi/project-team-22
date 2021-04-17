package controller;

import model.Player;

public class DuelMenuController {
//    TODO: how to handle board
//    TODO: how to handle graveyard --> ArrayList --> put it in Player class/DuelMenuController/board class??
    private Player turnPlayer;
    private Player notTurnPlayer;
    private Enum phase;

    public DuelMenuController(Player turnPlayer, Player notTurnPlayer, Enum phase) {
        setTurnPlayer(turnPlayer);
        setNotTurnPlayer(notTurnPlayer);
        setPhase(phase);
    }

    public static Player specifyTurnPlayer(Player firstPlayer, Player secondPlayer) {

    }

    public void setTurnPlayer(Player turnPlayer) {
        this.turnPlayer = turnPlayer;
    }

    public void setNotTurnPlayer(Player notTurnPlayer) {
        this.notTurnPlayer = notTurnPlayer;
    }

    public void setPhase(Enum phase) {
        this.phase = phase;
    }

    public Enum findCommand(String command) {

    }

    private Enum selectCard(String command) {

    }

    private Enum checkSelectCard(String command) {

    }

    private Enum deselectCard(String command) {

    }

    private Enum checkDeselectCard(String command) {

    }

    private Enum summonMonster(String command) {
//        TODO: maybe change the name to --> summonCard
    }

    private Enum checkSummonMonster(String command) {
//        TODO: maybe change the name to --> checkSummonCard
    }

    private void victimize() {
//        TODO: handle it!
    }

    private Enum setAMonster(String command) {

    }

    private Enum checkSetAMonster(String command) {

    }

    private Enum changePosition(String command) {

    }

    private Enum checkChangePosition(String command) {

    }

    private void updateGraveyard() {
//        TODO: handle it!
    }

    private Enum flipSummon(String command) {

    }

    private Enum checkFlipSummon(String command) {

    }

    private Enum attack(String command) {

    }

    private Enum checkAttack(String command) {
//        TODO: maybe merge with checkDirectAttack function
    }

    private Enum directAttack(String command) {

    }

    private Enum checkDirectAttack(String command) {
//        TODO: maybe merge with checkAttack function
    }

    private Enum activeASpellCard(String command) {

    }

    private Enum checkActiveASpellCard(String command) {

    }

    private Enum setASpell(String command) {

    }

    private Enum checkSetASpell(String command) {

    }

//    TODO: handle activeASpellInOpponentTurn
//    TODO: -----------------------------------------------
//    TODO: we are not sure about under functions

    private Enum ritualSummon(String command) {

    }

    private Enum specialSummon(String command) {

    }

    private Player/*or Enum*/ checkWinner() {

    }

//    TODO: -----------------------------------------------

}
