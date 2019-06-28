package game.backend.cell;

import game.backend.Grid;
import game.backend.element.Element;

public class SpecialCandyGeneratorCell extends CandyGeneratorCell {

    private int frequency;
    private int amount;
    private int lastMove;

    public SpecialCandyGeneratorCell(Grid grid, int frequency, int amount) {
        super(grid);
        this.frequency = frequency;
        this.amount = amount;
        lastMove = 0;
    }

    @Override
    public Element getContent() {
        if(validation())
            return grid.getSpecialLevelElement();
        return super.getContent();
    }

    private boolean validation(){
        if(grid.getCurrentMoves() % frequency == 0 && grid.getCurrentMoves() != lastMove ) {
            lastMove = grid.getCurrentMoves();
            return grid.getCurrentMoves() / frequency <= amount;
        }
        return false;
    }

}
