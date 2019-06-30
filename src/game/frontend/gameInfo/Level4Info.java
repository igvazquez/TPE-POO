package game.frontend.gameInfo;

import game.backend.element.Element;
import game.backend.level.gameState.GameState;

public class Level4Info extends LevelInfo{

    public Level4Info(GameState gameState) {
        super(gameState);
    }

    @Override
    protected String auxLevelStateInfo() {
        return ;
    }

    @Override
    public String levelStateInfo() {
        return super.levelStateInfo();
    }

    @Override
    public String levelName() {
        return "Level 4";
    }

    @Override
    public String getElementText(Element element) {
        return super.getElementText(element);
    }
}
