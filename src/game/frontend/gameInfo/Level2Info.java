package game.frontend.gameInfo;

import game.backend.cell.Cell;
import game.backend.cell.LightableCell;
import game.backend.level.gameState.GameState;
import game.backend.level.gameState.Level2State;


public class Level2Info extends MovementDependantLevelInfo{

    public Level2Info(GameState gameState) {
        super(gameState);
    }

    @Override
    protected String auxLevelStateInfo() {
        return "Cells left: " + ((Level2State)gameState).getOffCells() + super.auxLevelStateInfo();
    }

    @Override
    public String getCellEffect(Cell cell) {
        if( ((LightableCell)cell).isLighted() )
            return "GOLDEN";
        return super.getCellEffect(cell);
    }
}
