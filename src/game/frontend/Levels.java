package game.frontend;

import game.backend.Grid;
import game.backend.level.*;
import game.frontend.gameInfo.*;

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
    LEVEL4(new Level4()) {
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
    },
    LEVEL6(new Level6()){
        @Override
        public LevelInfo createGameInfo(){
            return new Level6Info(getLevel().getGameState());
        }
    };


    private Grid level;


    Levels(Grid level) {
        this.level = level;
    }

    public abstract LevelInfo createGameInfo();

    public Grid getLevel() {
        return level;
    }
}
