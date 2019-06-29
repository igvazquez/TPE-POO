package game.backend.level.gameState;

import game.backend.GameState;

public class Level3State extends GameState {

    private int requiredScore, closestExpirationTime;

    public Level3State(int requiredScore) {
        this.requiredScore = requiredScore;
    }

    public void setClosestExpirationTime(int time){
        closestExpirationTime = time;
    }

    @Override
    public boolean gameOver() {
        return playerWon() || closestExpirationTime <= getMoves();
    }

    @Override
    public boolean playerWon() {
        return requiredScore >= getScore();
    }

    public int getClosestExpirationTime() {
        return closestExpirationTime;
    }
}
