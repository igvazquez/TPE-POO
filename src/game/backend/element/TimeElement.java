package game.backend.element;

import java.util.Objects;

public class TimeElement extends Candy {

    private int expirationTime;

    public int getExpirationTime() {
        return expirationTime;
    }

    public TimeElement(CandyColor color, int lifeSpan, int creationMove) {
        super(color);
        this.expirationTime = lifeSpan + creationMove;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TimeElement)) return false;
        if (!super.equals(o)) return false;
        TimeElement timeElement = (TimeElement) o;
        return expirationTime == timeElement.expirationTime;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), expirationTime);
    }
}
