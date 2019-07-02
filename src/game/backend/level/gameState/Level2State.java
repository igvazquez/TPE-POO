package game.backend.level.gameState;

public class Level2State extends GameState {
    public int lightedCells;
    private long maxMoves;

    public Level2State(int lightedCells, long maxMoves) {
        this.lightedCells = lightedCells;
        this.maxMoves = maxMoves;
    }

    public void turnOnCell(){
        lightedCells--;
    }

    @Override
    public boolean gameOver() {
        return playerWon() || getMoves() >= maxMoves ;
    }

    @Override
    public boolean playerWon() {
        return lightedCells<=0;
    }

    public long getMaxMoves() {
        return maxMoves;
    }
}
