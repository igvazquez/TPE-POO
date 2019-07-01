package game.backend.level.gameState;

public class Level6State extends GameState {

    private int maxMoves, jailsLeft;

    public Level6State(int maxMoves, int jailsLeft) {
        this.maxMoves = maxMoves;
        this.jailsLeft = jailsLeft;
    }

    @Override
    public boolean gameOver() {
        return playerWon() || getMoves() >= maxMoves;
    }

    @Override
    public boolean playerWon() {
        return jailsLeft <= 0;
    }
    public void removedJail(){
        jailsLeft--;
    }
}
