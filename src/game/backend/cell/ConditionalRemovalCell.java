package game.backend.cell;

import game.backend.Grid;
import game.backend.level.ConditionalCellRemovalLevel;

public class ConditionalRemovalCell extends Cell {

    public ConditionalRemovalCell(Grid grid) {
        super(grid);
    }

    @Override
    public boolean clearContent() {
        if(((ConditionalCellRemovalLevel)grid).cellRemovalCriteria(this))
            return super.clearContent();
        return false;
    }


}
