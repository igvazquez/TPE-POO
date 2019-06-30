package game.backend.level;

import game.backend.level.gameState.GameState;
import game.backend.Grid;
import game.backend.cell.SpecialCandyGeneratorCell;
import game.backend.element.CandyColor;
import game.backend.element.Element;
import game.backend.element.MoveLimits;
import game.backend.element.ExpirableCandy;
import game.backend.level.gameState.Level3State;

import java.util.Comparator;
import java.util.SortedMap;
import java.util.TreeMap;

public class Level3 extends Grid {

    private static int REQUIRED_SCORE = 5000;
    private static final int EXPIRABLE_CANDY_FREQUENCY = 3;
    private static final int MAX_EXPIRABLE_CANDY_AMOUNT = 10; //Que acepte negativos para significar "infinitos"

    private SortedMap<Integer,Integer> expirablesTracker; //MODIFICAR PARA QUE LOS CANDY NO SEAN KEYS

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
        candyGenCell = new SpecialCandyGeneratorCell(this, EXPIRABLE_CANDY_FREQUENCY, MAX_EXPIRABLE_CANDY_AMOUNT);
    }

    @Override
    public void cellExplosion(Element e) {
        Integer aux;
        if(e.isExpirable()) {
            aux = ((ExpirableCandy)e).getExpirationMove();
            if (expirablesTracker.get(aux) <= 1) //ADAPTAR FUNCION PARA EL NUEVO MAP. Puede ser crear la interfaz expirable.
                expirablesTracker.remove(aux);
            else
                expirablesTracker.put(aux, expirablesTracker.get(aux) - 1);
        }
        super.cellExplosion(e);
    }


    private Integer getClosestExpirationTime(){
        if(!expirablesTracker.isEmpty())
            return expirablesTracker.firstKey().getExpirationMove(); //ADAPTAR
        return null;
    }

    @Override
    public boolean tryMove(int i1, int j1, int i2, int j2) {
        boolean rta;
        if(rta = super.tryMove(i1, j1, i2, j2)) {
            state().addMove();
            ((Level3State) state()).setClosestExpirationMove(getClosestExpirationTime());
        }
        return rta;
    }

    @Override
    public Element getSpecialLevelElement() {

        int i = (int)(Math.random() * CandyColor.values().length);
        int j = (int)(Math.random() * MoveLimits.values().length);

        ExpirableCandy ans = new ExpirableCandy(CandyColor.values()[i], MoveLimits.values()[j].getValue(), state().getMoves());

        if(expirablesTracker.containsKey(ans.getExpirationMove()))
            expirablesTracker.put( ans.getExpirationMove(), expirablesTracker.get(ans.getExpirationMove()) + 1);
        else
            expirablesTracker.put( ans.getExpirationMove(), 1);

        return ans;
    }

}
