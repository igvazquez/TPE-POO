package game.backend.level.gameState;

public class Level2State extends GameState {
    public int lightedCells;
    private int maxMoves;
    protected int totalCells;

    public Level2State(int totalCells, int maxMoves) {
        this.totalCells = totalCells;
        this.maxMoves = maxMoves;
    }

    public void turnOnCell(){
        lightedCells++;
    }

    @Override
    public boolean gameOver() {
        return playerWon() || getMoves() >= maxMoves ;
    }

    @Override
    public boolean playerWon() {
        return lightedCells >= totalCells;
    }

    public int getLightedCells() {
        return lightedCells;
    }
    public int getOffCells(){
        return totalCells-lightedCells;
    }

    public void turnOffCell() {
        lightedCells--;
    }
    public int getMovesLeft(){
        return getMaxMoves() - getMoves();
    }

    public int getMaxMoves() {
        return maxMoves;
    }
}
