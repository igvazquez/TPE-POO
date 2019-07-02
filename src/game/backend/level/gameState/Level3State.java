package game.backend.level.gameState;

public class Level3State extends ScoreDependantState {


    private Integer closestExpirationMove;

    public Level3State(int requiredScore) {
        this.requiredScore = requiredScore;
    }

    public void setClosestExpirationMove(Integer time){
        closestExpirationMove = time;
    }

    @Override
    public boolean playerLost() {
        return closestExpirationMove != null && closestExpirationMove <= getMoves();
    }

    public Integer getMovementsLeft(){
        if(closestExpirationMove != null)
            return closestExpirationMove - getMoves();
        return null;
    }
}
