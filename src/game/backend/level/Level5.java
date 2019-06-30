package game.backend.level;

import game.backend.element.*;
import game.backend.level.gameState.GameState;
import game.backend.Grid;
import game.backend.cell.Cell;
import game.backend.cell.ConditionalRemovalCell;
import game.backend.cell.SpecialCandyGeneratorCell;
import game.backend.level.gameState.Level5State;
import game.backend.move.MoveMakerWithFruits;

public class Level5 extends Grid {
    public static final int REQUIRED_FRUITS = 5;
    public static final int FRUIT_FREQUENCY = 5;
    public static final int MAX_MOVES = 70;


    @Override
    protected Cell cellCreator() {
        return new ConditionalRemovalCell(this);
    }

    @Override
    protected GameState newState() {
        return new Level5State(REQUIRED_FRUITS, MAX_MOVES);
    }

    @Override
    public boolean cellRemovalCriteria(Cell cell){
        return cell.isMovable() && (cell.getContent().isCombinable() || cell.isBottom());
    }

    @Override
    protected void setMoveMaker() {
        moveMaker = new MoveMakerWithFruits(this);
    }

    private boolean fruitRemoval(){
        boolean flag = false;

        for(int i = 0; i < SIZE; i++){
            if(!g()[SIZE-1][i].getContent().isCombinable()){
                clearContent(SIZE-1, i);
                ((Level5State)state()).addRemovedFruit();
                flag = true;
            }
        }
        fallElements();

        return flag;
    }

    @Override
    public boolean tryMove(int i1, int j1, int i2, int j2) {
        boolean ret;
        if (ret = super.tryMove(i1, j1, i2, j2)) {
            state().addMove();
            while(fruitRemoval());
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
        candyGenCell = new SpecialCandyGeneratorCell(this, FRUIT_FREQUENCY, REQUIRED_FRUITS);
    }

}
