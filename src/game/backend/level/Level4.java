package game.backend.level;

import game.backend.Figure;
import game.backend.GameListener;
import game.backend.Grid;
import game.backend.cell.Cell;
import game.backend.cell.SpecialCandyGeneratorCell;
import game.backend.element.*;
import game.backend.level.gameState.GameState;
import game.backend.level.gameState.Level3State;
import game.backend.level.gameState.Level4State;

import java.util.Timer;
import java.util.TimerTask;

public class Level4 extends Grid {

    private static final int SECOND = 1000;
    private static final int TIMER_DELAY = SECOND/2;
    private static final int INITIAL_TIME = 120;
    private static final int FREQUENCY = 3;
    private static final int INITIAL_AMOUNT = 3;
    private static final int REQUIRED_SCORE = 12000;

    private Timer timer;
    private TimerTask task;

    @Override
    protected GameState newState() {
        return new Level4State(INITIAL_TIME, REQUIRED_SCORE);
    }

    @Override
    public void initialize() {
        super.initialize();
        timer = new Timer();
        task = new TimerTask() {
            @Override
            public void run() {
                ((Level4State)state()).subSecond();
            }
        };
        timer.scheduleAtFixedRate(task, TIMER_DELAY, SECOND);

    }

    @Override
    public void finish() {
        task.cancel();
        timer.cancel();
    }

    @Override
    protected void setCandyCellGenerator() {
        candyGenCell = new SpecialCandyGeneratorCell(this, FREQUENCY, SpecialCandyGeneratorCell.UNLIMITED_AMOUNT_KEY, INITIAL_AMOUNT);
    }

    @Override
    public void cellExplosion(Element e){
        int bonus = 0;
        if(e.hasBonus()){
            bonus = ((TimeCandy)e).getBonusTime();
        }
        ((Level4State)state()).addTime(bonus);
        super.cellExplosion(e);
    }

    @Override
    public Element getSpecialLevelElement() {

        int i = (int)(Math.random() * CandyColor.values().length);
        int j = (int)(Math.random() * BonusTimesEnum.values().length);

        return new TimeCandy(CandyColor.values()[i], BonusTimesEnum.values()[j].getValue());
    }

    @Override
    public boolean tryMove(int i1, int j1, int i2, int j2) {
        boolean rta;
        if(rta = super.tryMove(i1, j1, i2, j2))
            state().addMove();
        return rta;
    }
}
