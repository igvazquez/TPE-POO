package game.backend.element;

public enum MoveLimits {

    FIVE(5), SEVEN(7), TEN(10), TWELVE(12), FIFTEEN(15);

    int value;

    MoveLimits(int number) {
        this.value = number;
    }

    public int getValue() {
        return value;
    }
}
