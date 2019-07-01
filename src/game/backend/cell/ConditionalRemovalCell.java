package game.backend.cell;

import game.backend.Grid;

public class ConditionalRemovalCell extends Cell {

    public ConditionalRemovalCell(Grid grid) {
        super(grid);
    }

    @Override
    public void clearContent() {
        if(grid.cellRemovalCriteria(this))
            return super.clearContent();
        return false;
    }


}
