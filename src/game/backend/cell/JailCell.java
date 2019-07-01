package game.backend.cell;

import game.backend.Grid;
import game.backend.element.Nothing;

public class JailCell extends Cell {
    private boolean unlocked;

    public String getKey(){
        return "JAIL" + super.getKey();
    }

    public JailCell(Grid grid) {
        super(grid);
        unlocked = false;
    }

    public JailCell(){}

    @Override
    public void clearContent() {
        if (!isMovable()) {
            unlocked = true;
            grid.cellExplosion(new Nothing());
            grid.fallElements();
            grid.tryRemove(this);
        }
        else
            super.clearContent();
    }

    @Override
    public boolean isMovable() {
        return unlocked && super.isMovable();
    }


}
