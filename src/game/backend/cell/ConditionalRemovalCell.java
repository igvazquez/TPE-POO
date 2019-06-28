package game.backend.cell;

import game.backend.Grid;
import game.backend.move.Direction;

public class ConditionalRemovalCell extends Cell {


    public ConditionalRemovalCell(Grid grid) {
        super(grid);
        around = new ConditionalRemovalCell[Direction.values().length];
    }

    @Override
    public void clearContent() {
        if(grid.cellRemovalCriteria())
        super.clearContent();
    }
}
