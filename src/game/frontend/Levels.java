package game.frontend;

import game.backend.GameState;
import game.backend.Grid;
import game.backend.level.Level1;
import game.backend.level.Level3;
import game.backend.level.Level5;
import game.frontend.gameInfo.GameInfo;
import game.frontend.gameInfo.GameInfoLevel1;
import game.frontend.gameInfo.GameInfoLevel3;
import game.frontend.gameInfo.GameInfoLevel5;

public enum Levels {

    LEVEL1(new Level1(), new GameInfoLevel1()),
    //LEVEL2(Level2.class, new GameInfoLevel2()),
    LEVEL3(new Level3(), new GameInfoLevel3()),
    //LEVEL4(Level4.class, new GameInfoLevel4()),
    LEVEL5(new Level5(), new GameInfoLevel5());
    //LEVEL6(Level6.class, new GameInfoLevel6()),


    private Grid level;
    private GameInfo gameInfo;


    Levels(Grid level, GameInfo gameInfo) {
        this.level = level;
        this.gameInfo = gameInfo;
        gameInfo.setGameState(level.getGameState());
    }

    public Grid getLevel() {
        return level;
    }

    public GameInfo getGameInfo() {
        return gameInfo;
    }
}
