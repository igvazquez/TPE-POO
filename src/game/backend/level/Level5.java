package game.backend.level;

import game.backend.level.gameState.GameState;
import game.backend.Grid;
import game.backend.cell.Cell;
import game.backend.cell.ConditionalRemovalCell;
import game.backend.cell.SpecialItemAndCandyGeneratorCell;
import game.backend.element.Element;
import game.backend.element.Fruit;
import game.backend.element.FruitType;
import game.backend.level.gameState.Level5State;
import game.backend.move.MoveMakerWithFruits;

public class Level5 extends Grid implements SpecialItemLevel, ConditionalCellRemovalLevel{

    public static final int REQUIRED_FRUITS = 10;
    public static final int SPECIAL_ITEM_FREQUENCY = 2;
    public static final int MAX_MOVES = 50;
    private static final int SPECIAL_ITEM_INITIAL_AMOUNT = 3;


    @Override
    protected Cell cellCreator() {
        return new ConditionalRemovalCell(this);
    }

    @Override
    protected GameState newState() {
        return new Level5State(REQUIRED_FRUITS, MAX_MOVES);
    }

    //Se utiliza el criterio en la ConditionalCellRemoval para ademas evitar que las frutas exploten por una explosion en cadena.
    @Override
    public boolean cellRemovalCriteria(Cell cell){
        return cell.isMovable() && (cell.isCombinable() || cell.isBottom());
    }

    @Override
    public void initialize() {
        super.initialize();
        fruitRemoval(); //Si alguna aparece en el piso se remueve
    }

    @Override
    protected void setMoveMaker() {
        moveMaker = new MoveMakerWithFruits(this);
    }

    private void fruitRemoval(){
        boolean flag = true;
        while(flag) {
            flag = false;
            for (int i = 0; i < SIZE; i++) {
                if (!g()[SIZE - 1][i].getContent().isCombinable()) {
                    clearContent(SIZE - 1, i);
                    ((Level5State) state()).RemoveFruit();
                    flag = true;
                }
            }
            fallElements();
        }
    }

    @Override
    public boolean tryMove(int i1, int j1, int i2, int j2) {
        boolean ret;
        if (ret = super.tryMove(i1, j1, i2, j2)) {
            fruitRemoval(); //Si toca el piso se remueve
        }
        return ret;
    }

    @Override
    public Element getSpecialLevelElement() {
        int i = (int)(Math.random() * FruitType.values().length);
        return new Fruit(FruitType.values()[i]);
    }

    @Override
    protected void setCandyCellGenerator() {
        candyGenCell = new SpecialItemAndCandyGeneratorCell(this, SPECIAL_ITEM_FREQUENCY, REQUIRED_FRUITS, SPECIAL_ITEM_INITIAL_AMOUNT);
    }

}
