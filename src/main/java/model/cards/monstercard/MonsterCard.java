package model.cards.monstercard;

import model.cards.Card;
import model.cards.CardTypes;

public class MonsterCard extends Card {
    protected transient short level;
    protected transient MonsterCardAttributes attribute;
    protected transient String monsterType;
    protected transient int attackPoints;
    protected transient int defensePoints;

    public MonsterCard(String name, short level, MonsterCardAttributes attribute, String monsterType, CardTypes cardType,
                       int attackPoints, int defensePoints, String description, int price) {
        super(name, description, cardType, price);
        setLevel(level);
        setAttribute(attribute);
        setMonsterType(monsterType);
        setAttackPoints(attackPoints);
        setDefensePoints(defensePoints);
        allCards.put(name, this);
    }

    public MonsterCard(MonsterCard monsterCard) {
        super(monsterCard.name, monsterCard.description, monsterCard.cardType, monsterCard.price);
        this.level = monsterCard.level;
        this.attribute = monsterCard.attribute;
        this.monsterType = monsterCard.monsterType;
        this.attackPoints = monsterCard.attackPoints;
        this.defensePoints = monsterCard.defensePoints;
    }

    public short getLevel() {
        return level;
    }

    public void setLevel(short level) {
        this.level = level;
    }

    public MonsterCardAttributes getAttribute() {
        return attribute;
    }

    public void setAttribute(MonsterCardAttributes attribute) {
        this.attribute = attribute;
    }

    public String getMonsterType() {
        return monsterType;
    }

    public void setMonsterType(String monsterType) {
        this.monsterType = monsterType;
    }

    public int getAttackPoints() {
        return attackPoints;
    }

    public void setAttackPoints(int attackPoints) {
        this.attackPoints = attackPoints;
    }

    public int getDefensePoints() {
        return defensePoints;
    }

    public void setDefensePoints(int defensePoints) {
        this.defensePoints = defensePoints;
    }
}
