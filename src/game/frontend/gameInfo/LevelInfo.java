package game.frontend.gameInfo;

import game.backend.cell.Cell;
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
        return "Player won incredible you are the best, man";
    }

    private String lossMessage(){ return "Player loss gatovich";}

    public boolean hasToUpdateInfo(){
        return false;
    }

    public int getInfoRefreshRate(){
        throw new IllegalStateException();
    }

    public abstract String levelName();

   /*public boolean hasCandyText(){
        return false;
    }*/

    public String getElementText(Element element){
            return null;
    }

    public boolean hasOverlappingImage(Cell cell){
        return false;
    }

}
