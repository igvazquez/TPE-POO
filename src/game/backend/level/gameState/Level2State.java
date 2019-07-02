package game.backend.level.gameState;

public class Level2State extends MovementDependantState {
    public int lightedCells;
    protected int totalCells;

    public Level2State(int totalCells, int maxMoves) {
        this.totalCells = totalCells;
        this.maxMoves = maxMoves;
    }

    public void turnOnCell(){
        lightedCells++;
    }



    @Override
    public boolean playerWon() {
        return lightedCells >= totalCells;
    }

    public int getOffCells(){
        return totalCells-lightedCells;
    }

}
