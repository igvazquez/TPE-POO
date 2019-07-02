package game.backend.level.gameState;

public abstract class MovementDependantState extends GameState {
    protected int maxMoves;

    @Override
    public boolean playerLost() {
        return getMoves() >= maxMoves;
    }
    public int getMaxMoves() {
        return maxMoves;
    }

    public int getMovesLeft(){
        return getMaxMoves() - getMoves();
    }


}
