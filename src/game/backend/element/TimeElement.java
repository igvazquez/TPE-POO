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
}
