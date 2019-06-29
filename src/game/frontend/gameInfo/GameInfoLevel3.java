package game.frontend.gameInfo;

import game.backend.GameState;
import game.backend.Grid;
import game.backend.element.Element;
import game.backend.element.TimeElement;
import game.backend.level.Level3;
import game.backend.level.gameState.Level3State;

public class GameInfoLevel3 extends GameInfo {

    public GameInfoLevel3(GameState gameState) {
        super(gameState);
    }

    @Override
    protected String auxBottomPanelInfo() {
        return movementsLeft() + " - " + super.auxBottomPanelInfo();
    }

    @Override
    public String levelName() {
        return "Level 3";
    }

    private String movementsLeft() {
        Integer movsLeft = ((Level3State) gameState).getMovementsLeft();
        String message = "Movements left: ";
        if(movsLeft != null)
            message += movsLeft;
        else
            message += "Infinit";
        return message;
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


