package game.backend.level.gameInfo;

import game.backend.GameState;
import game.backend.level.gameState.Level3State;

public class GameInfoLevel3 extends GameInfo {

    public GameInfoLevel3(GameState gameState) {
        super(gameState);
    }

    @Override
    public String levelName() {
        return "Level 3";
    }

    private String movementsLeft() {
        return "Movements left" + ((Level3State) gameState).getClosestExpirationTime();
    }

    @Override
    public String getCandyText(String candy) {
        if()
    }
}


