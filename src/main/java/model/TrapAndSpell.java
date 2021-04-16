package model;

public class TrapAndSpell {
    protected Enum type;
    protected Enum kind;
    protected Enum limit;

    public TrapAndSpell(Enum kind , Enum kind , Enum limit) {
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

    //public void usePower(){}
}
