package model;

public class Monster extends Card implements SpecialMonstersFunction {
    protected int attackLevel;
    protected int defenseLevel;
    protected Enum kindOfWarrior;
    protected boolean isAttacked = false;
    protected String cardStatus;

    public Monster(String cardType, String name, String description, String upDown, int attackLevel, int defenseLevel, Enum kindOfWarrior) {
        super(cardType, name, description, upDown);
        setAttackLevel(attackLevel);
        setDefenseLevel(defenseLevel);
        setKindOfWarrior(kindOfWarrior);
    }

    public int getAttackLevel() {
        return attackLevel;
    }

    public void setAttackLevel(int attackLevel) {
        this.attackLevel = attackLevel;
    }

    public int getDefenseLevel() {
        return defenseLevel;
    }

    public void setDefenseLevel(int defenseLevel) {
        this.defenseLevel = defenseLevel;
    }

    public Enum getKindOfWarrior() {
        return kindOfWarrior;
    }

    public void setKindOfWarrior(Enum kindOfWarrior) {
        this.kindOfWarrior = kindOfWarrior;
    }

    public Enum attack(Player attackingPlayer, Player opponentPlayer, Board attackingPlayerBoard, Board opponentPlayerBoard, int numberToAttack) {
        Monster attackingCard = (Monster) attackingPlayerBoard.getSelectedOwnCard();
        Monster opponentCard = opponentPlayerBoard.getMonstersZone()[numberToAttack];
        if (opponentCard.defense(attackingPlayer, opponentPlayer, attackingPlayerBoard, opponentPlayerBoard, attackingCard, opponentCard, numberToAttack) != null) {
           if (opponentCard.print().equals("OO"))

            return
        } else
            return opponentCard.defense(attackingPlayer, opponentPlayer, attackingPlayerBoard, opponentPlayerBoard, attackingCard, opponentCard, numberToAttack);
    }

    public Enum defense(Player attackingPlayer, Player opponentPlayer, Board attackingPlayerBoard, Board opponentPlayerBoard, Monster attackingCard, Monster opponentCard, int numberToAttack) {
        if (this.getName().equals("Command knight")) {
            commandKnightFunction(opponentPlayerBoard);
        } else if (this.getName().equals("Yomi Ship")) {
            return yomiShipFunction(attackingPlayerBoard, attackingCard, opponentCard);
        } else if (this.getName().equals("Suijin")) {
            return suijinFunction(attackingCard);
        } else if (this.getName().equals("Marshmallon")) {
            return marshmallonFunction(attackingPlayer);
        } else if (this.getName().equals("Texchanger")) {
            return texchangerFunction(opponentCard);
        } else if (this.getName().equals("Exploder Dragon")) {
            return exploderDragon(attackingPlayer, opponentPlayer, attackingPlayerBoard, opponentPlayerBoard, attackingCard, opponentCard, numberToAttack);
        }
        return null;
    }


    public String print() {

        if (this.getUpDown().equals("down") && this.cardStatus.equals("defense"))
            return "DH";
        else if (this.getUpDown().equals("up") && this.cardStatus.equals("defense"))
            return "DO";
        else if (this.getUpDown().equals("up") && this.cardStatus.equals("attack"))
            return "OO";
        return "E ";
    }

    public void setAttacked(boolean attacked) {
        isAttacked = attacked;
    }

    public boolean getAttacked() {
        return this.isAttacked;
    }

    public void addAmountToAttack(int amount) {
        this.attackLevel += amount;
    }

    public void addAmountToDefense(int amount) {
        this.defenseLevel += amount;
    }
}
