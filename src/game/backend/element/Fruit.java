package game.backend.element;

public class Fruit extends Element{

    private FruitType type;

    public Fruit(FruitType type) {
        this.type = type;
    }
    public Fruit(){}

    @Override
    public boolean isMovable() {
        return true;
    }

    @Override
    public String getKey() {
        return "FRUIT";
    }

    @Override
    public String getFullKey() {
        return getKey() + "-" + type.toString();
    }

    @Override
    public boolean isCombinable() {
        return false;
    }
}
