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

    LEVEL1(new Level1()){
        @Override
        public GameInfo createGameInfo(){
            return new GameInfoLevel1(getLevel().getGameState());
        }
    },
    //LEVEL2(Level2.class, new GameInfoLevel2()),
    LEVEL3(new Level3()){
        @Override
        public GameInfo createGameInfo(){
            return new GameInfoLevel3(getLevel().getGameState());
        }
    },
    //LEVEL4(Level4.class, new GameInfoLevel4()),
    LEVEL5(new Level5()){
        @Override
        public GameInfo createGameInfo(){
            return new GameInfoLevel5(getLevel().getGameState());
        }
    };
    //LEVEL6(Level6.class, new GameInfoLevel6()),


    private Grid level;


    Levels(Grid level) {
        this.level = level;
    }

    public abstract GameInfo createGameInfo();

    public Grid getLevel() {
        return level;
    }
}
