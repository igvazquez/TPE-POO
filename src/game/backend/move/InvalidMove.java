package game.backend.move;

import game.backend.Grid;

public class InvalidMove extends Move{

    //Se crea para modelar los movimientos invalidos como el de una bomba con un cherry
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
