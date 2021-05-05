package model.cards.monstercard;

import model.cards.Card;
import model.cards.CardTypes;

public class MonsterCard extends Card {
    protected final transient short level;
    protected final transient MonsterCardAttributes attribute;
    protected final transient String monsterType;
    protected transient int attackPoints;
    protected final transient int defensePoints;

    public MonsterCard(String name, short level, MonsterCardAttributes attribute, String monsterType, CardTypes cardType,
                       int attackPoints, int defensePoints, String description, int price) {
        super(name, description, cardType, price);
        this.level = level;
        this.attribute = attribute;
        this.monsterType = monsterType;
        setAttackPoints(attackPoints);
        this.defensePoints = defensePoints;
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

    public MonsterCardAttributes getAttribute() {
        return attribute;
    }

    public String getMonsterType() {
        return monsterType;
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
}
