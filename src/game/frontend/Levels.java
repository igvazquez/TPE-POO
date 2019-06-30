package game.frontend;

import game.backend.Grid;
import game.backend.level.Level1;
import game.backend.level.Level3;
import game.backend.level.Level4;
import game.backend.level.Level5;
import game.frontend.gameInfo.LevelInfo;
import game.frontend.gameInfo.Level1Info;
import game.frontend.gameInfo.Level3Info;
import game.frontend.gameInfo.Level5Info;

public enum Levels {

    LEVEL1(new Level1()){
        @Override
        public LevelInfo createGameInfo(){
            return new Level1Info(getLevel().getGameState());
        }
    },
    //LEVEL2(Level2.class){
    //    @Override
    //    public LevelInfo createGameInfo(){
    //        return new Level2Info(getLevel().getGameState());
    //  }
    //}
    LEVEL3(new Level3()){
        @Override
        public LevelInfo createGameInfo(){
            return new Level3Info(getLevel().getGameState());
        }
    },
    LEVEL4(Level4.class) {
        @Override
        public LevelInfo createGameInfo() {
            return new Level4Info(getLevel().getGameState());
        }
    },
    LEVEL5(new Level5()){
        @Override
        public LevelInfo createGameInfo(){
            return new Level5Info(getLevel().getGameState());
        }
    };
    //LEVEL6(Level6.class, new GameInfoLevel6()),


    private Grid level;


    Levels(Grid level) {
        this.level = level;
    }

    public abstract LevelInfo createGameInfo();

    public Grid getLevel() {
        return level;
    }
}
