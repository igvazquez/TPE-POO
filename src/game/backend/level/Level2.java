package game.backend.level;

import game.backend.GameState;
import game.backend.cell.Cell;

public class Level2 extends Level1 {

    @Override
    protected GameState newState() {
        return new Level1State(REQUIRED_SCORE, MAX_MOVES);
    }

    private boolean levelRemoveCellCriteria(int i, int j){
        return !g()[i][j].getContent().isUncombinable() || i == SIZE-1;
    }

    private void uncombinableRemoval(){
        for(int i = 0; i < SIZE; i++){
            if(g()[SIZE-1][i].getContent().isUncombinable()){
                clearContent(SIZE-1, i);
                //Le sumo al GAMESTATE un cherry;
            }
        }
        fallElements();
    }

    @Override
    public void clearContent(int i, int j) {
        if(levelRemoveCellCriteria(i, j))
            super.clearContent(i, j);
    }

    private class Level5State





}
