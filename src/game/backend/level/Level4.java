package game.backend.level;

import game.backend.Grid;
import game.backend.cell.SpecialItemAndCandyGeneratorCell;
import game.backend.element.*;
import game.backend.level.gameState.GameState;
import game.backend.level.gameState.Level4State;

import java.util.Timer;
import java.util.TimerTask;

public class Level4 extends Grid implements SpecialItemLevel{

    private static final int SECOND = 1000;
    private static final int TIMER_DELAY = SECOND/2;
    private static final int INITIAL_TIME = 120;
    private static final int SPECIAL_ITEM_FREQUENCY = 5;
    private static final int SPECIAL_ITEM_INITIAL_AMOUNT = 3;
    private static final int REQUIRED_SCORE = 12000;

    private Timer timer; //Lo guardamos para cuando se termine el nivel, cortarlo.
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
    protected void setCandyCellGenerator() {
        candyGenCell = new SpecialItemAndCandyGeneratorCell(this, SPECIAL_ITEM_FREQUENCY, SpecialItemAndCandyGeneratorCell.UNLIMITED_AMOUNT_KEY, SPECIAL_ITEM_INITIAL_AMOUNT);
    }

    @Override
    public void cellExplosion(Element e){

        if(e.hasBonus())
            ((Level4State)state()).addTime(((TimeCandy)e).getBonusTime());

        super.cellExplosion(e);
    }

    @Override
    public Element getSpecialLevelElement() {

        int i = (int)(Math.random() * CandyColor.values().length);
        int j = (int)(Math.random() * BonusTimesEnum.values().length);

        return new TimeCandy(CandyColor.values()[i], BonusTimesEnum.values()[j].getValue());
    }

    @Override
    public void finish() {
        if(timer != null)
            timer.cancel();
        if(task != null)
            task.cancel();
    }
}
