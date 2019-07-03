package test;

import game.backend.Grid;
import game.frontend.Levels;

public enum Tests {

    TEST2_1(new Level2Test1(), Levels.LEVEL2),
    TEST2_2(new Level2Test2(), Levels.LEVEL2),
    TEST2_3(new Level2Test3(), Levels.LEVEL2),
    TEST5(new Level5Test(), Levels.LEVEL5);

    private Grid level;
    private Levels parentLevel;

    Tests(Grid level, Levels parentLevel) {
        this.level = level;
        this.parentLevel = parentLevel;
    }

    public Grid getLevel() {
        return level;
    }

    public Levels getParentLevel() {
        return parentLevel;
    }
}
