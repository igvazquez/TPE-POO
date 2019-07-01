package game.backend.element;

public enum BonusTimesEnum {

    FIVE(5), TEN(10), FIFTEEN(15);

    private int value;

    BonusTimesEnum(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
