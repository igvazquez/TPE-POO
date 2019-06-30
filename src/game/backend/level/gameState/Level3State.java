package game.backend.level.gameState;

public class Level3State extends GameState {

    private int requiredScore;
    private Integer closestExpirationMove;

    public Level3State(int requiredScore) {
        this.requiredScore = requiredScore;
    }

    public void setClosestExpirationMove(Integer time){
        closestExpirationMove = time;
    }

    @Override
    public boolean gameOver() {
        return playerWon() || (closestExpirationMove != null && closestExpirationMove <= getMoves());
    }

    @Override
    public boolean playerWon() {
        return requiredScore <= getScore();
    }

    public Integer getMovementsLeft(){
        if(closestExpirationMove != null)
            return closestExpirationMove - getMoves();
        return null;
    }
}
