package game.frontend.gameInfo;

import game.backend.level.gameState.GameState;
import game.backend.Grid;
import game.backend.element.Element;
import game.backend.element.ExpirableCandy;
import game.backend.level.Level3;
import game.backend.level.gameState.Level3State;

public class Level3Info extends LevelInfo {

    public Level3Info(GameState gameState) {
        super(gameState);
    }

    @Override
    protected String auxLevelStateInfo() {
        return movementsLeft() + " - " + super.auxLevelStateInfo();
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

/*    @Override
    public boolean hasCandyText() {
        return true;
    }*/

    @Override
    public String getElementText(Element candy, Grid level) { //CAMBIAR METODO, NO RECIBE GRID.
        String candyText = null;
        if (candy.isExpirable())
            candyText = String.valueOf(((ExpirableCandy)candy).getExpirationMove() - gameState.getMoves());

        return candyText;
    }
}



