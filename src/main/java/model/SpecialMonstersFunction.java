package model;

import controller.DuelMenuMessages;

import java.util.ArrayList;

public interface SpecialMonstersFunction {


    default Enum texchangerFunction(Monster opponentCard) {
        if (!opponentCard.getIsPowerUsed()) {
            opponentCard.setPowerUsed(true);
            // choosing a card ehzar???????
            return DuelMenuMessages.ATTACK_CANCELED;
        }
        return null;
    }

    default Enum commandKnightFunction(Board opponentPlayerBoard) {
        int i = 1;
        for (i = 1; i <= 5; i++) {
            if (opponentPlayerBoard.getMonstersZone()[i] != null && !opponentPlayerBoard.getMonstersZone()[i].getName().equals("Command knight")) {
                return DuelMenuMessages.YOU_CANT_ATTACK_TO_THIS_CARD;
            }
        }
        return null;
    }

    default Enum yomiShipFunction(Board attackingPlayerBoard, Monster attackingCard, Monster opponentCard) {
        if (opponentCard.print().equals("OO") && attackingCard.attackLevel > opponentCard.getAttackLevel()) {
            attackingPlayerBoard.getGraveyard().add(attackingCard);
            deleteMonsterFromZone(attackingCard, attackingPlayerBoard.getMonstersZone());
        }
        if (opponentCard.print().equals("DO") || opponentCard.print().equals("DH") && attackingCard.attackLevel > opponentCard.getDefenseLevel()) {
            attackingPlayerBoard.getGraveyard().add(attackingCard);
            deleteMonsterFromZone(attackingCard, attackingPlayerBoard.getMonstersZone());
        }
        return null;
    }

    default Enum suijinFunction(Monster attackingCard) {
        attackingCard.setAttackLevel(0);
        return null;
    }

    default Enum marshmallonFunction(Player attackingPlayer) {
        attackingPlayer.addAmountToLifePoint(-1000);
        return null;
    }

    default Enum exploderDragon(Player attackingPlayer, Player opponentPlayer, Board attackingPlayerBoard, Board opponentPlayerBoard, Monster attackingCard, Monster opponentCard, int number) {
        if (opponentCard.print().equals("OO") && attackingCard.attackLevel > opponentCard.getAttackLevel()) {
            attackingPlayerBoard.getGraveyard().add(attackingCard);
            opponentPlayerBoard.getGraveyard().add(opponentCard);
            attackingPlayerBoard.getMonstersZone()[number] = null;
            deleteMonsterFromZone(attackingCard, attackingPlayerBoard.getMonstersZone());
            return DuelMenuMessages.BOTH_CARDS_GET_DESTROYED;
        }
        if (opponentCard.print().equals("DO") || opponentCard.print().equals("DH") && attackingCard.attackLevel > opponentCard.getDefenseLevel()) {
            attackingPlayerBoard.getGraveyard().add(attackingCard);
            opponentPlayerBoard.getGraveyard().add(opponentCard);
            attackingPlayerBoard.getMonstersZone()[number] = null;
            deleteMonsterFromZone(attackingCard, attackingPlayerBoard.getMonstersZone());
            return DuelMenuMessages.BOTH_CARDS_GET_DESTROYED;
        }
        return null;
    }

    private void deleteMonsterFromZone(Monster monster, Monster[] monstersZone) {
        for (int i = 1; i < monstersZone.length; i++) {
            if (monstersZone[i].equals(monster)) {
                monstersZone[i] = null;
                break;
            }
        }
    }
}
