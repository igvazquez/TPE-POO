package game.frontend.gameInfo;

import game.backend.GameState;
import game.backend.Grid;
import game.backend.element.Element;

public abstract class GameInfo {
    protected GameState gameState;

    public void setGameState(GameState gameState){
        this.gameState = gameState;
    }

    public String bottomPanelInfo() {
        StringBuilder message = new StringBuilder("Score:").append(gameState.getScore());
        if(gameState.gameOver())
            if(gameState.playerWon())
                message.append(wonMessage());
            message.append(lossMessage());
        return message.toString();
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
