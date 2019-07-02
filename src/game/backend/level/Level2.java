package game.backend.level;

import game.backend.Figure;
import game.backend.Grid;
import game.backend.cell.Cell;
import game.backend.cell.LightableCell;
import game.backend.element.Bomb;
import game.backend.element.Candy;
import game.backend.element.CandyColor;
import game.backend.element.VerticalStripedCandy;
import game.backend.level.gameState.GameState;
import game.backend.level.gameState.Level2State;

import java.awt.*;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Level2 extends Grid {
    public static final int MAX_MOVES = 70;
    public static final int INITIALS_OFF_CELLS = SIZE*SIZE;


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
            state().addMove();
            return true;
        }
        return false;
    }

    public void lightCell(LightableCell cell){
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
