package game.backend.level.gameState;

public class Level4State extends GameState{

    private int time; //Seconds

    public Level4State(int initTime) {
        time = initTime;
    }

    @Override
    public boolean gameOver() {
        return false;
    }

    @Override
    public boolean playerWon() {
        return false;
    }

    public void subSecond(){
        time--;
    }
}
