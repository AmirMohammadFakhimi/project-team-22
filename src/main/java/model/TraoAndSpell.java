package model;

public class TraoAndSpell extends Card {
    protected Enum type;
    protected Enum kind;
    protected Enum limit;

    public TraoAndSpell(Enum kind , Enum limit , Enum limit) {//????????????
        super(cardType, name, description, upDown);
        setKind(kind);
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

    public void print(){
        if (this.equals(null))
            System.out.print("E     ");
        else if (this.getUpDown().equals("up"))
            System.out.print("O     ");
        else if (this.getUpDown().equals("down"))
            System.out.print("H     ");
    }

    //public void usePower(){}
}
