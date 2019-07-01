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
        for (int k = 0; k < SIZE; k++)
            if (k != 5) {
                Element aux = g[5][k].getContent();
                g[5][k] = new JailCell(this);
                g[5][k].setContent(aux);
                jails++;
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
