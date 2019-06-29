package game.frontend.gameInfo;

import game.backend.GameState;

public class GameInfoLevel1 extends GameInfo{
    public GameInfoLevel1(GameState gameState) {
        super(gameState);
    }

    @Override
    public String levelName() {
        return "Level 1";
    }
}
