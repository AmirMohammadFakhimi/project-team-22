package model;

public class Spell extends Card {
    protected Enum type;
    protected Enum kind;
    protected Enum limit;

    public Spell(String cardType, String name, String description, String upDown, Enum type , Enum kind , Enum limit) {
        super(cardType, name, description, upDown);
        setType(type);
        setLimit(limit);
        setKind(kind);
    }

    public Enum getKind() {
        return kind;
    }

    public void setKind(Enum kind) {
        this.kind = kind;
    }

    public Enum getLimit() {
        return limit;
    }

    public void setLimit(Enum limit) {
        this.limit = limit;
    }

    public Enum getType() {
        return type;
    }

    public void setType(Enum type) {
        this.type = type;
    }

    //public void usePower(){}
}
