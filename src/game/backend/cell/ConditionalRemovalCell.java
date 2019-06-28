package game.backend.cell;

import game.backend.Grid;
import game.backend.move.Direction;

public class ConditionalRemovalCell extends Cell {

    public ConditionalRemovalCell(Grid grid) {
        super(grid);
    }

    @Override
    public void clearContent() {
        if(grid.cellRemovalCriteria(this))
            super.clearContent();
    }


}
