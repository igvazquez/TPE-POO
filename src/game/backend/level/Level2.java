package game.backend.level;

import game.backend.Grid;
import game.backend.cell.Cell;
import game.backend.cell.LightableCell;
import game.backend.level.gameState.GameState;
import game.backend.level.gameState.Level2State;


public class Level2 extends Grid {

    private static final int MAX_MOVES = 70;
    private static final int INITIALS_OFF_CELLS = SIZE*SIZE;

    @Override
    protected GameState newState() {
        return new Level2State(INITIALS_OFF_CELLS, MAX_MOVES);
    }

    @Override
    protected Cell cellCreator() {
        return new LightableCell(this);
    }

    @Override
    public boolean tryMove(int i1, int j1, int i2, int j2) {
        if(super.tryMove(i1, j1, i2, j2)){
            lightCorrespondingCells(i1, j1, i2, j2);
            return true;
        }
        return false;
    }

    private void lightCell(LightableCell cell){
        if(!cell.isLighted()){
            cell.light();
            ((Level2State)state()).turnOnCell();
        }
    }

    private void lightCorrespondingCells(int i1, int j1, int i2, int j2){
        if (i1 == i2)
            for(int k = 0; k < SIZE; k++)
                lightCell((LightableCell)g()[i1][k]);

        if (j1 == j2)
            for(int k = 0; k < SIZE; k++)
                lightCell((LightableCell)g()[k][j1]);
    }
}
