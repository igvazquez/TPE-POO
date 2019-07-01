package game.backend.cell;

import game.backend.Grid;

public class ConditionalRemovalCell extends Cell {

    @Override
    public String getKey(){
        return "COND" + super.getKey();
    }

    public ConditionalRemovalCell(Grid grid) {
        super(grid);
    }

    @Override
    public void clearContent() {
        if(grid.cellRemovalCriteria(this))
            super.clearContent();
    }


}
