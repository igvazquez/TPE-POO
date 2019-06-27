package game.backend.level;

import game.backend.GameState;
import game.backend.cell.Cell;

public class Level5 extends Level1 {

    public static final int REQUIRED_UNCOMBINABLES = 5;
    public static final int UNCOMBINABLE_FRECUENCY = 5;
    public static final int MAX_MOVES = 70;

    @Override
    protected GameState newState() {
        return new Level5State(REQUIRED_SCORE, MAX_MOVES);
    }

    private boolean levelRemoveCellCriteria(int i, int j){
        return !g()[i][j].getContent().isUncombinable() || i == SIZE-1;
    }

    private void uncombinableRemoval(){
        for(int i = 0; i < SIZE; i++){
            if(g()[SIZE-1][i].getContent().isUncombinable()){
                clearContent(SIZE-1, i);
                state().addRemovedUncombinable()
            }
        }
        fallElements();
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
