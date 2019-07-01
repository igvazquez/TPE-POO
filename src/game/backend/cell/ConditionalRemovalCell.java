package game.backend.cell;

import game.backend.Grid;

public class ConditionalRemovalCell extends Cell {

    public static String getKey(){
        return "CONDCELL";
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
