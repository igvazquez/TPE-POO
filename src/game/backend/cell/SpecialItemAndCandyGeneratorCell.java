package game.backend.cell;

import game.backend.Grid;
import game.backend.element.Element;
import game.backend.level.SpecialItemLevel;

import java.util.ArrayList;
import java.util.List;

public class SpecialItemAndCandyGeneratorCell extends CandyGeneratorCell {

    public static final int UNLIMITED_AMOUNT_KEY = -1;
    private int frequency;
    private int amount;
    private int lastMove;
    private int counter;
    private List<Integer> initialValues;


    public SpecialItemAndCandyGeneratorCell(Grid grid, int frequency, int amount, int initialAmount) {

        super(grid);

        this.frequency = frequency;
        this.amount = amount;

        if(amount != UNLIMITED_AMOUNT_KEY)
            this.amount -= initialAmount;

        createInitialSpecialElementPositionsSet(initialAmount);
    }

    @Override
    public Element getContent() {
        if(validation())
            return ((SpecialItemLevel)grid).getSpecialLevelElement(); //El casteo es correcto pues esta celda solo se usa en
        return super.getContent();                                    //niveles que tienen un special Item (implementan SpecialItemLevel).
    }

    private boolean validation(){
        if( initializingValidation() || inGameValidation() ) {
            lastMove = grid.getCurrentMoves();
            return true;
        }
        return false;
    }

    private boolean inGameValidation() {
        return (grid.getCurrentMoves() != lastMove) &&  (grid.getCurrentMoves() % frequency == 0) &&
                ( amount == UNLIMITED_AMOUNT_KEY || (grid.getCurrentMoves() / frequency <= amount));
    }

    private boolean initializingValidation(){
        return lastMove == 0 && initialValues.contains(counter++);
    }

    private void createInitialSpecialElementPositionsSet(int initialAmount){

        int aux;
        initialValues = new ArrayList<>();

        for(int i = 0; i < initialAmount ; i++) {
            do {
                aux = (int) (Math.random() * (Grid.SIZE * Grid.SIZE - 1)); //Numero entre 0 y 80
            }while (initialValues.contains(aux));//Sin repetidos
            initialValues.add(aux);
        }
    }
}
