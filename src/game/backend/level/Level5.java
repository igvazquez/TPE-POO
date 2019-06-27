package game.backend.level;

import game.backend.GameState;
import game.backend.Grid;
import game.backend.cell.SpecialCandyGeneratorCell;
import game.backend.element.Element;
import game.backend.element.UncombinableElement;
import game.backend.element.UncombinableElementType;
import game.backend.move.MoveMakerWithUncombinable;

public class Level5 extends Grid {
    public static final int REQUIRED_UNCOMBINABLES = 5;

    public static final int UNCOMBINABLE_FRECUENCY = 5;
    public static final int MAX_MOVES = 70;


    @Override
    protected GameState newState() {
        return new Level5State(REQUIRED_UNCOMBINABLES);
    }

    private boolean levelRemoveCellCriteria(int i, int j){
        return !g()[i][j].getContent().isUncombinable() || i == SIZE-1;
    }

    @Override
    protected void setMoveMaker() {
        moveMaker = new MoveMakerWithUncombinable(this);
    }

    private void uncombinableRemoval(){
        for(int i = 0; i < SIZE; i++){
            if(g()[SIZE-1][i].getContent().isUncombinable()){
                clearContent(SIZE-1, i);
                ((Level5State)state()).addRemovedUncombinable();
            }
        }
        fallElements();
    }

    @Override
    public boolean tryMove(int i1, int j1, int i2, int j2) {
        boolean ret;
        if (ret = super.tryMove(i1, j1, i2, j2)) {
            state().addMove();
            uncombinableRemoval();
        }
        return ret;
    }

    @Override
    public Element getSpecialLevelElement() {
        int i = (int)(Math.random() * UncombinableElementType.values().length);
        return new UncombinableElement(UncombinableElementType.values()[i]);
    }

    @Override
    protected void setCandyCellGenerator() {
        candyGenCell = new SpecialCandyGeneratorCell(this, UNCOMBINABLE_FRECUENCY, REQUIRED_UNCOMBINABLES);
    }

    @Override
    public void clearContent(int i, int j) {
        if(levelRemoveCellCriteria(i, j))
            super.clearContent(i, j);
    }
    private class Level5State extends GameState{


        private int uncombinablesLeft;

        public Level5State(int uncombinablesLeft) {
            this.uncombinablesLeft = uncombinablesLeft;
        }

        @Override
        public boolean gameOver() {
            return playerWon() || getMoves() >= MAX_MOVES;
        }

        @Override
        public boolean playerWon() {
            return uncombinablesLeft <= 0;
        }
        public void addRemovedUncombinable(){
            uncombinablesLeft--;
        }

        @Override
        public boolean hasExtraScoreInfo() {
            return true;
        }

        @Override
        public String getExtraScoreMessage() {
            return "Fruits left: ";
        }

        @Override
        public String getExtraScoreValue() {
            return String.valueOf(uncombinablesLeft);
        }

    }
}
