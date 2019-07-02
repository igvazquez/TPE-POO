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
    public void initialize() {
        super.initialize();
        turnOffAllCells();
        VerticalStripedCandy vc = new VerticalStripedCandy();
        vc.setColor(CandyColor.RED);
        g[4][5].setContent(new Bomb());
        g[5][5].setContent(new Candy(CandyColor.RED));
    }

    @Override
    protected Cell cellCreator() {
        return new LightableCell(this);
    }

    @Override
    public void onFigureRemoval(int i, int j, Figure f) {
        lightCorrespondingCells(i, j, f);
    }

    @Override
    public boolean tryMove(int i1, int j1, int i2, int j2) {
        if(super.tryMove(i1, j1, i2, j2) && (get(i1, j1) instanceof Bomb || get(i2, j2) instanceof Bomb || (get(i1, j1).hasEffect() && (get(i2, j2).hasEffect())))

    }

    public void lightCell(LightableCell cell){
        if(!cell.isLighted()){
            cell.light();
            ((Level2State)state()).turnOnCell();
        }
    }

    private void turnOffAllCells(){
        for(int i = 0; i < SIZE; i++)
            for(int j = 0; j < SIZE; j++)
                turnOff(((LightableCell)g()[i][j]));

    }

    private void turnOff(LightableCell cell) {
        if(cell.isLighted()){
            cell.turnOff();
            ((Level2State)state()).turnOffCell();
        }
    }

    private void lightCorrespondingCells(int i, int j, Figure f){
        Point[] figurePoints = f.getPoints();

        if (Arrays.stream(figurePoints).filter(e -> e.x == 0).count() > 1)
            for(int k = 0; k < SIZE; k++)
                lightCell((LightableCell)g()[i][k]);

        if (Arrays.stream(figurePoints).filter(e -> e.y == 0).count() > 1)
            for(int k = 0; k < SIZE; k++)
                lightCell((LightableCell)g()[k][j]);
    }


}
