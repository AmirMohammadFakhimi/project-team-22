package model.cards.magiccard;

import model.cards.Card;
import model.cards.CardTypes;

public class MagicCard extends Card {
    protected transient String icon;
    protected transient MagicCardStatuses status;

    public MagicCard(String name, CardTypes cardType, String icon, String description, MagicCardStatuses status, int price) {
        super(name, description, cardType, price);
        setIcon(icon);
        setStatus(status);
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

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public MagicCardStatuses getStatus() {
        return status;
    }

    public void setStatus(MagicCardStatuses status) {
        this.status = status;
    }
}
