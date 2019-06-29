package game.backend.level.gameState;

import game.backend.GameState;

public class Level3State extends GameState {

    private int requiredScore;
    private Integer closestExpirationTime;

    public Level3State(int requiredScore) {
        this.requiredScore = requiredScore;
    }

    public void setClosestExpirationTime(Integer time){
        closestExpirationTime = time;
    }

    @Override
    public boolean gameOver() {
        return playerWon() || (closestExpirationTime != null && closestExpirationTime <= getMoves());
    }

    @Override
    public boolean playerWon() {
        return requiredScore <= getScore();
    }

    public Integer getMovementsLeft(){
        if(closestExpirationTime != null)
            return closestExpirationTime - getMoves();
        return null;
    }
}
