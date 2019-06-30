package game.backend.element;

public class ExpirableCandy extends Candy {

    private int expirationMove;

    public int getExpirationMove() {
        return expirationMove;
    }

    public ExpirableCandy(CandyColor color, int lifeSpan, int creationMove) {
        super(color);
        this.expirationMove = lifeSpan + creationMove;
    }

    @Override
    public boolean isExpirable(){
        return true;
    }
}
