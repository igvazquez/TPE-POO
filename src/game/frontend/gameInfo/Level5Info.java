package game.frontend.gameInfo;

import game.backend.level.gameState.GameState;
import game.backend.level.gameState.Level5State;

public class Level5Info extends MovementDependantLevelInfo {

    public Level5Info(GameState gameState) {
        super(gameState);
    }

    @Override
    protected String auxLevelStateInfo() {
        return  fruitsLeft()  + " - " + super.auxLevelStateInfo();
    }

    private String fruitsLeft(){
        return " Fruits left: " + ((Level5State)gameState).getFruitsLeft();
    }
}
