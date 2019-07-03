package game.frontend;

import game.backend.Grid;
import game.backend.level.*;
import game.backend.level.gameState.GameState;
import game.frontend.gameInfo.*;


//Enum con todos los niveles disponibles, su descripcion
// y la clase LevelInfo asociada
public enum Levels {

    LEVEL1(new Level1(), "Basic"){
        @Override
        public LevelInfo createGameInfo(GameState state) {
            return new Level1Info(state);
        }
    },
    LEVEL2(new Level2(),"Golden Board"){
        @Override
        public LevelInfo createGameInfo(GameState state){
            return new Level2Info(state);
      }
    },
    LEVEL3(new Level3(), "Time Bomb"){
        @Override
        public LevelInfo createGameInfo(GameState state){
            return new Level3Info(state);
        }
    },
    LEVEL4(new Level4(), "Time Limit") {
        @Override
        public LevelInfo createGameInfo(GameState state) {
            return new Level4Info(state);
        }
    },
    LEVEL5(new Level5(), "Fruits"){
        @Override
        public LevelInfo createGameInfo(GameState state){
            return new Level5Info(state);
        }
    };

    private Grid level;
    private String description;

    Levels(Grid level, String description) {
        this.level = level;
        this.description = description;
    }

    public abstract LevelInfo createGameInfo(GameState state);

    public String getDescription() {
        return description;
    }

    public Grid getLevel() {
        return level;
    }
}
