package game.backend.cell;

import game.backend.Grid;

public class LightableCell extends Cell{

    private boolean lit;

    public LightableCell(Grid grid) {
        super(grid);
        lit = false;
    }

    public void light(){
        lit = true;
    }

    public boolean isLighted(){
        return lit;
    }
}
