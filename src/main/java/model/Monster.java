package model;

public class Monster extends Card {
    protected int attackLevel;
    protected int defenseLevel;
    protected Enum kindOfWarrior;

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

    //public void attack(){}

    //public void defense(){}

    public void addAmountToAttack(int amount){
        this.attackLevel+=amount;
    }

    public void addAmountToDefense(int amount){
        this.defenseLevel +=amount;
    }
}
