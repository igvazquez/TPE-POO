package game.backend.element;

public class UncombinableElement extends Element{

    private UncombinableElementType type;

    public UncombinableElement(UncombinableElementType type) {
        this.type = type;
    }
    public UncombinableElement(){}

    @Override
    public boolean isMovable() {
        return true;
    }

    @Override
    public String getKey() {
        return "SPECIAL";
    }

    @Override
    public String getFullKey() {
        return getKey() + "-" + type.toString();
    }

    @Override
    public boolean isUncombinable() {
        return true;
    }
}
