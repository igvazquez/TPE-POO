package game.backend.level;

import game.backend.Grid;
import game.backend.cell.JailCell;
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
    }

    public int setJails() {
        int row = SIZE / 2;
        for (int k = 0; k < SIZE; k++) {
            if (k != SIZE / 2) {
                Element aux = g[5][k].getContent();
                g[row][k] = new JailCell(this);
                g[row][k].setContent(aux);

                if (k == 0)
                    g[row][k].setAround(g[row - 1][k], g[row + 1][k], wallCell, g[row][k + 1]);
                else if (k == SIZE - 1)
                    g[row][k].setAround(g[row - 1][k], g[row + 1][k], g[row][k - 1], wallCell);
                else
                    g[row][k].setAround(g[row - 1][k], g[row + 1][k], g[row][k - 1], g[row][k + 1]);

                jails++;
            }
        }
        return jails;
    }

    @Override
    protected GameState newState() {
        return  new SpecialItemState(jails, MAX_MOVES);
    }

    @Override
    public void cellExplosion(Element e) {
        if(!e.isSolid())
            ((SpecialItemState)state()).decrementSpecialItem();
        super.cellExplosion(e);
    }
}
