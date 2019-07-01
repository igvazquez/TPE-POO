package game.frontend.gameInfo;

import game.backend.level.gameState.GameState;

public class Level6Info extends LevelInfo {
    public Level6Info(GameState gameState) {
        super(gameState);
    }

    @Override
    protected String auxLevelStateInfo() {
        return "Jails left: " + ((Level6State)gameState).getJails() + " " + super.auxLevelStateInfo();
    }

    @Override
    public String levelName() {
        return "Level 6";
    }

}
