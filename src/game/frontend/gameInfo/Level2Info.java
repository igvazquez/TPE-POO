package game.frontend.gameInfo;

import game.backend.cell.Cell;
import game.backend.cell.LightableCell;
import game.backend.level.gameState.GameState;
import game.backend.level.gameState.Level2State;
import game.backend.level.gameState.MovementDependantState;


public class Level2Info extends LevelInfo{

    public Level2Info(GameState gameState) {
        super(gameState);
    }

    @Override
    protected String auxLevelStateInfo() {
        return "Cells left: " + ((Level2State)gameState).getOffCells() + " " +movementsLeft() + " " + super.auxLevelStateInfo();
    }

    public String movementsLeft(){
        return " Movs. left: " + ((MovementDependantState)gameState).getMovesLeft();
    }

    @Override
    public String getCellEffect(Cell cell) {
        if( ((LightableCell)cell).isLighted() )
            return "GOLDEN";
        return super.getCellEffect(cell);
    }
}
