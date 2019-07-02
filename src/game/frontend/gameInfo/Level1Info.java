package game.frontend.gameInfo;

import game.backend.level.gameState.GameState;
import game.backend.level.gameState.Level1State;
import game.backend.level.gameState.MovementDependantState;

public class Level1Info extends MovementDependantLevelInfo {

    public Level1Info(GameState gameState) {
        super(gameState);
    }

    @Override
    public String levelName() {
        return "Level 1";
    }

    @Override
    protected String auxLevelStateInfo() {
        return super.auxLevelStateInfo();
    }
}
