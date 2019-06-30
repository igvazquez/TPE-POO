package game.frontend.gameInfo;

import game.backend.level.gameState.GameState;

public class Level1Info extends LevelInfo {

    public Level1Info(GameState gameState) {
        super(gameState);
    }

    @Override
    public String levelName() {
        return "Level 1";
    }
}
