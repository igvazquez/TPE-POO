package game.frontend.gameInfo;

import game.backend.level.gameState.GameState;
import game.backend.level.gameState.Level2State;


public class Level2Info extends LevelInfo{

    public Level2Info(GameState gameState) {
        super(gameState);
    }

    @Override
    protected String auxLevelStateInfo() {
        return "Cells remaining: " + ((Level2State)gameState).getOffCells() + " " +movementsLeft() + " " + super.auxLevelStateInfo();
    }

    @Override
    public String levelName() {
        return "Level2";
    }

    @Override
    public boolean areCellsLightable() {
        return true;
    }
    public String movementsLeft(){
        return " Movements left: " + ((Level2State)gameState).getMovesLeft();
    }
}
