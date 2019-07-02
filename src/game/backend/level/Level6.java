package game.backend.level;

import game.backend.Grid;
import game.backend.cell.JailCell;
import game.backend.element.Candy;
import game.backend.element.CandyColor;
import game.backend.element.Element;
import game.backend.level.gameState.GameState;
import game.backend.level.gameState.SpecialItemState;

public class Level6 extends Grid {
    public static final int MAX_MOVES = 70;
    private int jails;

    @Override
    public void initialize() {
        super.initialize();
        jails = setJails();
        g[5][0].setContent(new Candy(CandyColor.RED));
        g[5][1].setContent(new Candy(CandyColor.RED));
        g[5][3].setContent(new Candy(CandyColor.RED));
        g[2][2].setContent(new Candy(CandyColor.RED));
        g[4][2].setContent(new Candy(CandyColor.BLUE));
        g[3][3].setContent(new Candy(CandyColor.BLUE));
        g[5][2].setContent(new Candy(CandyColor.BLUE));
        g[6][2].setContent(new Candy(CandyColor.GREEN));
        g[6][3].setContent(new Candy(CandyColor.GREEN));
        g[7][4].setContent(new Candy(CandyColor.GREEN));
        //g[5][3].setContent(new Candy(CandyColor.GREEN));
        //g[5][4].setContent(new Candy(CandyColor.GREEN));
       // g[4][5].setContent(new Candy(CandyColor.GREEN));
        //g[5][6].setContent(new Candy(CandyColor.GREEN));

    }

    public int setJails() {
        int row = SIZE / 2;
        for (int k = 0; k < SIZE; k++) {
            if (k != SIZE / 2) {
                Element aux = g[row][k].getContent();
                g[row][k] = new JailCell(this);
                g[row][k].setContent(aux);
            }
        }

        for (int k = 0; k < SIZE; k++) {
                int i = row;
                if (k == 0)
                    g[i][k].setAround(g[i - 1][k], g[i + 1][k], wallCell, g[i][k + 1]);
                else if (k == SIZE - 1)
                    g[i][k].setAround(g[i - 1][k], g[i + 1][k], g[i][k - 1], wallCell);
                else
                    g[i][k].setAround(g[i - 1][k], g[i + 1][k], g[i][k - 1], g[i][k + 1]);


                for( i = row - 1; i <= row + 1; i++ ) {
                    if (k == 0)
                        g[i][k].setAround(g[i - 1][k], g[i + 1][k], wallCell, g[i][k + 1]);
                    else if (k == SIZE - 1)
                        g[i][k].setAround(g[i - 1][k], g[i + 1][k], g[i][k - 1], wallCell);
                    else
                        g[i][k].setAround(g[i - 1][k], g[i + 1][k], g[i][k - 1], g[i][k + 1]);
                }

                jails++;
            }
        return jails;
    }

    @Override
    public boolean tryMove(int i1, int j1, int i2, int j2) {
        if(g()[i1][j1].isMovable() && g()[i2][j2].isMovable() && super.tryMove(i1, j1, i2, j2) ) {
            tryRemove(g()[i1][j1]);
            tryRemove(g()[i2][j2]);
            fallElements();
            wasUpdated();
            return true;
            }
        return false;
    }

    @Override
    protected GameState newState() {
        return new SpecialItemState(jails, MAX_MOVES);
    }

    @Override
    public void cellExplosion(Element e) {
        if(!e.isSolid())
            ((SpecialItemState)state()).decrementSpecialItem();
        super.cellExplosion(e);
    }
}
