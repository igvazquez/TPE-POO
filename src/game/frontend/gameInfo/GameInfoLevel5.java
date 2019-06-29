package game.frontend.gameInfo;

import game.backend.GameState;
import game.backend.level.gameState.Level5State;

public class GameInfoLevel5 extends GameInfo {

    public GameInfoLevel5(GameState gameState) {
        super(gameState);
    }

    @Override
    protected String auxBottomPanelInfo() {
        return movementsLeft() + " - " + fruitsLeft() + " - " + super.auxBottomPanelInfo();
    }

    @Override
    public String levelName() {
        return "Level 5";
    }
    public String movementsLeft(){
        return " Movements left: " + ((Level5State)gameState).getMovesLeft();
    }
    public String fruitsLeft(){
        return " Fruits left: " + ((Level5State)gameState).getFruitsLeft();
    }
}
