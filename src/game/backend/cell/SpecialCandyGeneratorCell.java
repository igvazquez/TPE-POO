package game.backend.cell;

import com.sun.tools.javac.code.Attribute;
import game.backend.Grid;
import game.backend.element.Element;
import game.backend.element.UncombinableElement;
import game.backend.element.UncombinableElementType;

public class SpecialCandyGeneratorCell extends CandyGeneratorCell {

    private int frequency;
    private int counter;
    private int amount;

    public SpecialCandyGeneratorCell(Grid grid, int frequency, int amount) {
        super(grid);
        this.frequency = frequency;
        this.amount = amount;
        counter = 0;
    }

    @Override
    public Element getContent() {
        if(++counter % frequency != 0 || counter / frequency >= amount)
            return super.getContent();
        return grid.getSpecialLevelElement();
    }

}
