package game.backend.cell;

import game.backend.Grid;

public class JailCell extends Cell {
    private boolean unlocked;

    public JailCell(Grid grid) {
        super(grid);
        unlocked= false;
    }

    @Override
    public void clearContent() {
        if (!isMovable())
            unlocked = true;
        else
            super.clearContent();
    }

    @Override
    public boolean isMovable() {
        return unlocked;
    }


}
