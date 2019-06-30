package game.backend.level;

import game.backend.Figure;
import game.backend.GameListener;
import game.backend.Grid;
import game.backend.cell.Cell;
import game.backend.element.Element;
import game.backend.level.gameState.GameState;
import game.backend.level.gameState.Level4State;

import java.util.Timer;
import java.util.TimerTask;

public class Level4 extends Grid {

    private static final int SECOND = 1000;
    private static final int TIMER_DELAY = SECOND/2;
    private static final int INITIAL_TIME = 120*SECOND;


    private Timer timer;

    @Override
    protected GameState newState() {
        return new Level4State();
    }

    @Override
    public void initialize() {
        super.initialize();
        timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                ((Level4State)state()).subSecond();
            }
        }, TIMER_DELAY, INITIAL_TIME);
    }

    @Override
    protected Cell cellCreator() {
        return super.cellCreator();
    }

    @Override
    protected void setCandyCellGenerator() {
        super.setCandyCellGenerator();
    }

    @Override
    protected void setFigureDetector() {
        super.setFigureDetector();
    }

    @Override
    protected void setMoveMaker() {
        super.setMoveMaker();
    }

    @Override
    public Element get(int i, int j) {
        return super.get(i, j);
    }

    @Override
    public Cell getCell(int i, int j) {
        return super.getCell(i, j);
    }

    @Override
    public void fallElements() {
        super.fallElements();
    }

    @Override
    public void clearContent(int i, int j) {
        super.clearContent(i, j);
    }

    @Override
    public void setContent(int i, int j, Element e) {
        super.setContent(i, j, e);
    }

    @Override
    public boolean tryMove(int i1, int j1, int i2, int j2) {
        return super.tryMove(i1, j1, i2, j2);
    }

    @Override
    public Figure tryRemove(Cell cell) {
        return super.tryRemove(cell);
    }

    @Override
    public void swapContent(int i1, int j1, int i2, int j2) {
        super.swapContent(i1, j1, i2, j2);
    }

    @Override
    public GameState getGameState() {
        return super.getGameState();
    }

    @Override
    public GameState createState() {
        return super.createState();
    }

    @Override
    public void addListener(GameListener listener) {
        super.addListener(listener);
    }

    @Override
    public void wasUpdated() {
        super.wasUpdated();
    }

    @Override
    public void cellExplosion(Element e) {
        super.cellExplosion(e);
    }

    @Override
    public Element getSpecialLevelElement() {
        return super.getSpecialLevelElement();
    }

    @Override
    protected void fillCells() {
        super.fillCells();
    }

    @Override
    public boolean cellRemovalCriteria(Cell cell) {
        return super.cellRemovalCriteria(cell);
    }

    @Override
    public boolean cellRemovalCriteria(int i, int j) {
        return super.cellRemovalCriteria(i, j);
    }
}
