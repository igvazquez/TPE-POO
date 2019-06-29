package game.frontend.gameInfo;

import game.backend.GameState;

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

    //public abstract boolean hasCandyText();

    public String getCandyText(String key){
        throw new IllegalArgumentException();
    }
}
