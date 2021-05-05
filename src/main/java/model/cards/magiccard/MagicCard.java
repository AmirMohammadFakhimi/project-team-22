package model.cards.magiccard;

import model.cards.Card;
import model.cards.CardTypes;

public class MagicCard extends Card {
    protected final transient String icon;
    protected final transient MagicCardStatuses status;

    public MagicCard(String name, CardTypes cardType, String icon, String description, MagicCardStatuses status, int price) {
        super(name, description, cardType, price);
        this.icon = icon;
        this.status = status;
        allCards.put(name, this);
    }

    public MagicCard(MagicCard magicCard) {
        super(magicCard.name, magicCard.description, magicCard.cardType, magicCard.price);
        this.icon = magicCard.icon;
        this.status = magicCard.status;
    }

    public String getIcon() {
        return icon;
    }

    public MagicCardStatuses getStatus() {
        return status;
    }
}
