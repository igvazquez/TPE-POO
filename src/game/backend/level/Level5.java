package game.backend.level;

import game.backend.GameState;
import game.backend.cell.Cell;

public class Level5 extends Level1 {

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
        }
        return ret;
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
    }





}
