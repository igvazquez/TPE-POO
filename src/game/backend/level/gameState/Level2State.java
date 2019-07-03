package game.backend.level.gameState;

public class Level2State extends MovementDependantState {

    private int lightedCells;
    private int totalCells;

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
