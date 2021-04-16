package model;

public class Monster extends Card{
    protected int attackLevel;
    protected int deffenseLevel;
    protected Enum kindOfWarrior;
    public Monster(String cardType, String name, String description, String upDown , int attackLevel , int deffenseLevel , Enum kindOfWarrior) {
        super(cardType, name, description, upDown);
        setAttackLevel(attackLevel);
        setDeffenseLevel(deffenseLevel);
        setKindOfWarrior(kindOfWarrior);
    }

    public int getAttackLevel() {
        return attackLevel;
    }

    public void setAttackLevel(int attackLevel) {
        this.attackLevel = attackLevel;
    }

    public int getDeffenseLevel() {
        return deffenseLevel;
    }

    public void setDeffenseLevel(int deffenseLevel) {
        this.deffenseLevel = deffenseLevel;
    }

    public Enum getKindOfWarrior() {
        return kindOfWarrior;
    }

    public void setKindOfWarrior(Enum kindOfWarrior) {
        this.kindOfWarrior = kindOfWarrior;
    }

    //public void attck(){}

    //public void deffense(){}

    public void addAmountToAttack(int amount){
        this.attackLevel+=amount;
    }

    public void addAmountToDeffense(int amount){
        this.deffenseLevel+=amount;
    }
}
