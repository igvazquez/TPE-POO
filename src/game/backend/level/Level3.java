package game.backend.level;

import game.backend.level.gameState.GameState;
import game.backend.Grid;
import game.backend.cell.SpecialItemAndCandyGeneratorCell;
import game.backend.element.CandyColor;
import game.backend.element.Element;
import game.backend.element.MoveLimits;
import game.backend.element.ExpirableCandy;
import game.backend.level.gameState.Level3State;

import java.util.SortedMap;
import java.util.TreeMap;

public class Level3 extends Grid implements SpecialItemLevel{

    private static final int SPECIAL_ITEM_INITIAL_AMOUNT = 2;
    private static int REQUIRED_SCORE = 5000;
    private static final int SPECIAL_ITEM_FREQUENCY = 3;

    private SortedMap<Integer,Integer> expirablesTracker;

    @Override
    public void initialize() {
        expirablesTracker = new TreeMap<>();
        super.initialize();
    }

    @Override
    protected GameState newState() {
        return new Level3State(REQUIRED_SCORE) ;
    }

    @Override
    protected void setCandyCellGenerator() {
        candyGenCell = new SpecialItemAndCandyGeneratorCell(this, SPECIAL_ITEM_FREQUENCY, SpecialItemAndCandyGeneratorCell.UNLIMITED_AMOUNT_KEY, SPECIAL_ITEM_INITIAL_AMOUNT);
    }

    @Override
    public void cellExplosion(Element e) {
        if(e.isExpirable())
            removeExpirableElement((ExpirableCandy) e);
        super.cellExplosion(e);
    }

    private void removeExpirableElement(ExpirableCandy e){
        Integer aux = e.getExpirationMove();
        if (expirablesTracker.get(aux) <= 1)
            expirablesTracker.remove(aux);
        else
            expirablesTracker.put(aux, expirablesTracker.get(aux) - 1);
    }

    private void addExpirableElement(ExpirableCandy e){
        if(expirablesTracker.containsKey(e.getExpirationMove()))
            expirablesTracker.put( e.getExpirationMove(), expirablesTracker.get(e.getExpirationMove()) + 1);
        else
            expirablesTracker.put( e.getExpirationMove(), 1);
    }


    private Integer getClosestExpirationTime(){
        if(!expirablesTracker.isEmpty())
            return expirablesTracker.firstKey();
        return null;
    }

    @Override
    public boolean tryMove(int i1, int j1, int i2, int j2) {
        boolean rta;
        if(rta = super.tryMove(i1, j1, i2, j2)) {
            ((Level3State) state()).setClosestExpirationMove(getClosestExpirationTime());
        }
        return rta;
    }

    @Override
    public Element getSpecialLevelElement() {

        int i = (int)(Math.random() * CandyColor.values().length);
        int j = (int)(Math.random() * MoveLimits.values().length);

        ExpirableCandy ans = new ExpirableCandy(CandyColor.values()[i], MoveLimits.values()[j].getValue(), state().getMoves());
        addExpirableElement(ans);

        return ans;
    }

}
