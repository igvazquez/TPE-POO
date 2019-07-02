package game.frontend.gameInfo;

import game.backend.level.gameState.GameState;
import game.backend.level.gameState.Level2State;
import game.backend.level.gameState.MovementDependantState;


public class Level2Info extends MovementDependantLevelInfo{

    public Level2Info(GameState gameState) {
        super(gameState);
    }

    @Override
    protected String auxLevelStateInfo() {
        return "Cells remaining: " + ((Level2State)gameState).getOffCells() + " - " + super.auxLevelStateInfo();
    }

    @Override
    public String levelName() {
        return "Level2";
    }

    @Override
    public boolean areCellsLightable() {
        return true;
    }

}
