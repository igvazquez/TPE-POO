package game.backend.move;

import game.backend.Grid;

public class InvalidMove extends Move{

    public InvalidMove(Grid grid) {
        super(grid);
    }

    @Override
    public boolean isValid() {
        return false;
    }

    @Override
    public void removeElements() {
        throw new RuntimeException();
    }
}
