package game.backend.level;

import game.backend.GameState;
import game.backend.Grid;
import game.backend.cell.SpecialCandyGeneratorCell;
import game.backend.element.CandyColor;
import game.backend.element.Element;
import game.backend.element.MoveLimits;
import game.backend.element.TimeElement;
import game.backend.level.gameState.Level3State;

import java.util.Comparator;
import java.util.SortedMap;
import java.util.TreeMap;

public class Level3 extends Grid {

    private static int REQUIRED_SCORE = 5000;
    private static final int FRECUENCY = 3;
    private static final int AMOUNT = 10;

    private SortedMap<TimeElement,Integer> currentBombs;

    @Override
    public void initialize() {
        currentBombs = new TreeMap<>(Comparator.comparing(TimeElement::getExpirationTime));
        super.initialize();
    }

    @Override
    protected GameState newState() {
        return new Level3State(REQUIRED_SCORE) ;//Faltaaaaaa
    }

    @Override
    protected void setCandyCellGenerator() {
        candyGenCell = new SpecialCandyGeneratorCell(this, FRECUENCY, AMOUNT);
    }

    @Override
    public void cellExplosion(Element e) {
        if(isElementExpirable(e)) {
            if (currentBombs.get(e) <= 1)
                currentBombs.remove(e);
            else
                currentBombs.put((TimeElement) e, currentBombs.get(e) - 1);
        }
        super.cellExplosion(e);
    }

    public boolean isElementExpirable(Element e){
        if(e instanceof TimeElement)
            return currentBombs.containsKey(e);
        return false;
    }

    private Integer getClosestExpirationTime(){
        if(!currentBombs.isEmpty())
            return currentBombs.firstKey().getExpirationTime();
        return null;
    }

    @Override
    public boolean tryMove(int i1, int j1, int i2, int j2) {
        boolean rta;
        if(rta = super.tryMove(i1, j1, i2, j2)) {
            state().addMove();
            ((Level3State) state()).setClosestExpirationTime(getClosestExpirationTime());
        }
        return rta;
    }

    @Override
    public Element getSpecialLevelElement() {

        int i = (int)(Math.random() * CandyColor.values().length);
        int j = (int)(Math.random() * MoveLimits.values().length);

        TimeElement ans = new TimeElement(CandyColor.values()[i], MoveLimits.values()[j].getValue(), state().getMoves());

        if(currentBombs.containsKey(ans))
            currentBombs.put( ans, currentBombs.get(ans) + 1);
        else
            currentBombs.put( ans, 1);

        return ans;
    }

}
