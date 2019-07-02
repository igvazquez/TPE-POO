package game.backend.level.gameState;

public abstract class ScoreDependantState extends GameState {
    protected int requiredScore;
    @Override
    public boolean playerWon() {
        return getScore() >= requiredScore;
    }
}
