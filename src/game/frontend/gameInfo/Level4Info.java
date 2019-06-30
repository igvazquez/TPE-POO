package game.frontend.gameInfo;

import game.backend.element.Element;
import game.backend.element.TimeCandy;
import game.backend.level.gameState.GameState;
import game.backend.level.gameState.Level4State;

public class Level4Info extends LevelInfo {

    private static final int SECOND = 1000;

    public Level4Info(GameState gameState) {
        super(gameState);
    }

    @Override
    protected String auxLevelStateInfo() {
        return "Time Left: " + ((Level4State)gameState).getTime() + super.auxLevelStateInfo();
    }

    @Override
    public String levelName() {
        return "Level 4";
    }

    @Override
    public String getElementText(Element element) {
        if (element.hasBonus())
            return "+" + ((TimeCandy)element).getBonusTime();
        else
            return null;
    }

    @Override
    public boolean hasToUpdateInfo() {
        return true;
    }

    @Override
    public int getInfoRefreshRate() {
        return SECOND/2;
    }
}


