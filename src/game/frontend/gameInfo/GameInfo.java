package game.frontend.gameInfo;

import game.backend.GameState;
import game.backend.Grid;
import game.backend.element.Element;

public abstract class GameInfo {
    protected GameState gameState;

    public GameInfo(GameState gameState) {
        this.gameState = gameState;
    }
    public String bottomPanelInfo() {
        return "Score:" + gameState.getScore();
    }
    private String wonMessage(){
        return "Player won incredible you are the best, man";
    }

    public abstract String levelName();

    public boolean hasCandyText(){
        return false;
    }

    public String getCandyText(Element candy, Grid level){
            throw new IllegalArgumentException();
    }
}
