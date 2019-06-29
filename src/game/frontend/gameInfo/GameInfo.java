package game.frontend.gameInfo;

import game.backend.GameState;
import game.backend.Grid;
import game.backend.element.Element;

public abstract class GameInfo {
    protected GameState gameState;

    public GameInfo(GameState gameState) {
        this.gameState = gameState;
    }

    protected String auxBottomPanelInfo() {
        return "Score: " + gameState.getScore();
    }

    public String bottomPanelInfo(){
        if(gameState.gameOver()) {
            if (gameState.playerWon())
                return wonMessage();
            else
                return lossMessage();
        }
        return auxBottomPanelInfo();
    }

    private String wonMessage(){
        return "Player won incredible you are the best, man";
    }
    private String lossMessage(){ return "Player loss gatovich";}

    public abstract String levelName();

    public boolean hasCandyText(){
        return false;
    }

    public String getCandyText(Element candy, Grid level){
            return null;
    }
}
