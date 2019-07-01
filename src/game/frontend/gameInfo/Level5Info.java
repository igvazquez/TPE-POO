package game.frontend.gameInfo;

import game.backend.level.gameState.GameState;
import game.backend.level.gameState.SpecialItemState;

public class Level5Info extends LevelInfo {

    public Level5Info(GameState gameState) {
        super(gameState);
    }

    @Override
    protected String auxLevelStateInfo() {
        return movementsLeft() + " - " + fruitsLeft() + " - " + super.auxLevelStateInfo();
    }

    @Override
    public String levelName() {
        return "Level 5";
    }

    public String movementsLeft(){
        return " Movements left: " + ((SpecialItemState)gameState).getMovesLeft();
    }

    public String fruitsLeft(){
        return " Fruits left: " + ((SpecialItemState)gameState).getSpecialItemLeft();
    }
}
