package game.frontend.gameInfo;

import game.backend.level.gameState.GameState;
import game.backend.Grid;
import game.backend.element.Element;

public abstract class LevelInfo {
    protected GameState gameState;

    public LevelInfo(GameState gameState) {
        this.gameState = gameState;
    }

    protected String auxLevelStateInfo() {
        return "Score: " + gameState.getScore();
    }

    public String levelStateInfo(){
        if(gameState.gameOver()) {
            if (gameState.playerWon())
                return wonMessage();
            else
                return lossMessage();
        }
        return auxLevelStateInfo();
    }

    private String wonMessage(){
        return "You won! Congratulations";
    }
    private String lossMessage(){ return "You lost! Oh no";}
    public boolean hasToUpdateInfo(){
        return false;
    }
    public int getInfoRefreshRate(){
        throw new IllegalStateException();
    }

    public String getElementText(Element element){
            return null;
    }

    public boolean areCellsLightable(){
        return false;
    }
}
