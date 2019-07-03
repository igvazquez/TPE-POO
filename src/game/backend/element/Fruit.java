package game.backend.element;

public class Fruit extends Element{

    private FruitType type;

    public Fruit(FruitType type) {
        this.type = type;
    }

    public Fruit(){} //Para ser coherentes con la implementacion de MoveMaker y Candy debemos agregar un constructor vacio.

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
