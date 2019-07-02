package game.backend.level;

import game.backend.Figure;
import game.backend.Grid;
import game.backend.cell.LightableCell;
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
    public void onFigureRemoval(int i, int j, Figure f) {
        Point[] figurePoints = f.getPoints();

        if (Arrays.stream(figurePoints).filter(e -> e.x == 0).count() > 1)
            for(int k = 0; k < SIZE; k++)
                lightCell((LightableCell)g()[i][k]);

        if (Arrays.stream(figurePoints).filter(e -> e.y == 0).count() > 1)
            for(int k = 0; k < SIZE; k++)
                lightCell((LightableCell)g()[k][j]);

    }

    public void lightCell(LightableCell cell){
        if(!cell.isLighted()){
            cell.light();
            ((Level2State)state()).turnOnCell();
        }
    }




}
