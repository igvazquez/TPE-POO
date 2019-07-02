package game.frontend.gameInfo;

import game.backend.level.gameState.GameState;
import game.backend.level.gameState.MovementDependantState;

public abstract class MovementDependantLevelInfo extends LevelInfo {
    public MovementDependantLevelInfo(GameState gameState) {
        super(gameState);
    }
    public String movementsLeft(){
        return " Movs. left: " + ((MovementDependantState)gameState).getMovesLeft();
    }
    @Override
    protected String auxLevelStateInfo() {
        return movementsLeft() + " - " + super.auxLevelStateInfo();
    }
}
