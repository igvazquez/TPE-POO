package game.frontend.gameInfo;

import game.backend.level.gameState.GameState;
import game.backend.level.gameState.SpecialItemState;

public class Level6Info extends LevelInfo {
    public Level6Info(GameState gameState) {
        super(gameState);
    }

    @Override
    protected String auxLevelStateInfo() {
        return "Jails left: " + ((SpecialItemState)gameState).getSpecialItemLeft() + " " + super.auxLevelStateInfo();
    }

    @Override
    public String levelName() {
        return "Level 6";
    }

}
