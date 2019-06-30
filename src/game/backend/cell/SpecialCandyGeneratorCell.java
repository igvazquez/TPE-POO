package game.backend.cell;

import game.backend.Grid;
import game.backend.element.Element;

import java.util.ArrayList;
import java.util.List;

public class SpecialCandyGeneratorCell extends CandyGeneratorCell {

    public static final int UNLIMITED_AMOUNT_KEY = -1;
    private int frequency;
    private int amount;
    private int lastMove;
    private int counter;
    private List<Integer> initialValues;


    public SpecialCandyGeneratorCell(Grid grid, int frequency, int amount, int initialAmount) {

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
            return grid.getSpecialLevelElement();
        return super.getContent();
    }

    private boolean validation(){
        if( initializingValidation() || inGameValidation() ) {
            lastMove = grid.getCurrentMoves();
            return true;
        }
        return false;
    }

    private boolean belongsToMatrixBorders(int value) {
       boolean ans = value < Grid.SIZE;
       ans |= value > Grid.SIZE * ( Grid.SIZE - 1);
       ans |= value % Grid.SIZE == 0;
       ans |= value % Grid.SIZE == 8;

       return ans;
    }

    private boolean inGameValidation() {
        return (grid.getCurrentMoves() != lastMove) &&  (grid.getCurrentMoves() % frequency == 0) && ( amount == UNLIMITED_AMOUNT_KEY || (grid.getCurrentMoves() / frequency <= amount));
    }

    private boolean initializingValidation(){
        return lastMove == 0 && initialValues.contains(counter++);
    }

    private void createInitialSpecialElementPositionsSet(int initialAmount){

        int aux;
        initialValues = new ArrayList<>();

        for(int i = 0; i < initialAmount ; i++) {
            do {
                aux = (int) (Math.random() * Grid.SIZE * Grid.SIZE); //Numero entre 0 y 81
            }while (belongsToMatrixBorders(aux));//Que no se encuentre en los bordes
            initialValues.add(aux);
        }
    }
}
