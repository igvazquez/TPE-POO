package game.frontend.gameInfo;

import game.backend.GameState;
import game.backend.Grid;
import game.backend.element.Element;
import game.backend.element.TimeElement;
import game.backend.level.Level3;
import game.backend.level.gameState.Level3State;

public class GameInfoLevel3 extends GameInfo {

    @Override
    public String levelName() {
        return "Level 3";
    }

    private String movementsLeft() {
        return "Movements left" + ((Level3State) gameState).getClosestExpirationTime();
    }

    @Override
    public boolean hasCandyText() {
        return true;
    }

    @Override
    public String getCandyText(Element candy, Grid level) {
        String candyText = null;
        if (((Level3)level).isElementExpirable(candy))
            candyText = String.valueOf(((TimeElement)candy).getExpirationTime() - gameState.getMoves());

        return candyText;
    }
}


