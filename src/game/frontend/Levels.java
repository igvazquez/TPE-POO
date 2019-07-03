package game.frontend;

import game.backend.Grid;
import game.backend.level.*;
import game.frontend.gameInfo.*;


//Enum con todos los niveles disponibles, su descripcion
// y la clase LevelInfo asociada
public enum Levels {

    LEVEL1(new Level1(), "Basic"){
        @Override
        public LevelInfo createGameInfo(){
            return new Level1Info(getLevel().getGameState());
        }
    },
    LEVEL2(new Level2(),"Golden Board"){
        @Override
        public LevelInfo createGameInfo(){
            return new Level2Info(getLevel().getGameState());
      }
    },
    LEVEL3(new Level3(), "Time Bomb"){
        @Override
        public LevelInfo createGameInfo(){
            return new Level3Info(getLevel().getGameState());
        }
    },
    LEVEL4(new Level4(), "Time Limit") {
        @Override
        public LevelInfo createGameInfo() {
            return new Level4Info(getLevel().getGameState());
        }
    },
    LEVEL5(new Level5(), "Fruits"){
        @Override
        public LevelInfo createGameInfo(){
            return new Level5Info(getLevel().getGameState());
        }
    };

    private Grid level;
    private String description;

    Levels(Grid level, String description) {
        this.level = level;
        this.description = description;
    }

    public abstract LevelInfo createGameInfo();

    public String getDescription() {
        return description;
    }

    public Grid getLevel() {
        return level;
    }
}
