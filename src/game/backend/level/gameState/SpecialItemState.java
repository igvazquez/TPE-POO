package game.backend.level.gameState;

public class SpecialItemState extends GameState {

    private int specialItemLeft, maxMoves;

    public SpecialItemState(int specialItemLeft, int maxMoves) {
        this.specialItemLeft = specialItemLeft;
        this.maxMoves = maxMoves;
    }

    @Override
    public boolean gameOver() {
        return playerWon() || getMoves() >= maxMoves;
    }

    @Override
    public boolean playerWon() {
        return specialItemLeft <= 0;
    }

    public void decrementSpecialItem(){
        specialItemLeft--;
    }

    public int getMovesLeft(){
        return getMaxMoves() - getMoves();
    }

    public int getMaxMoves() {
        return maxMoves;
    }

    public int getSpecialItemLeft() {
        return specialItemLeft;
    }
}
