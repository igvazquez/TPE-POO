package game.frontend.gameInfo;

import game.backend.level.gameState.GameState;
import game.backend.element.Element;
import game.backend.element.ExpirableCandy;
import game.backend.level.gameState.Level3State;

public class Level3Info extends LevelInfo {

    public Level3Info(GameState gameState) {
        super(gameState);
    }

    @Override
    protected String auxLevelStateInfo() {
        return movementsLeft() + " - " + super.auxLevelStateInfo();
    }

    private String movementsLeft() {
        Integer movsLeft = ((Level3State) gameState).getMovementsLeft();
        String message = "Moves left: ";
        if(movsLeft != null)
            message += movsLeft;
        else
            message += "Unlimited";
        return message;
    }

    @Override
    public String getElementText(Element element) {
        String candyText = null;
        if (element.isExpirable())
            candyText = String.valueOf(((ExpirableCandy)element).getExpirationMove() - gameState.getMoves());

        return candyText;
    }
}



