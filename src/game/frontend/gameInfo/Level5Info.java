package game.frontend.gameInfo;

import game.backend.level.gameState.GameState;
import game.backend.level.gameState.Level5State;
import game.backend.level.gameState.MovementDependantState;

public class Level5Info extends MovementDependantLevelInfo {

    public Level5Info(GameState gameState) {
        super(gameState);
    }

    @Override
    protected String auxLevelStateInfo() {
        return  fruitsLeft()  + " - " + super.auxLevelStateInfo();
    }

    @Override
    public String levelName() {
        return "Level 5";
    }

    public String fruitsLeft(){
        return " Fruits left: " + ((Level5State)gameState).getFruitsLeft();
    }
}
