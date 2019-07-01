package game.backend.level.gameState;

public class Level4State extends GameState{

    private int time; //Seconds
    private int requiredScore;

    public Level4State(int initTime, int requiredScore) {
        time = initTime;
        this.requiredScore = requiredScore;
    }

    @Override
    public boolean gameOver() {
        return time <= 0;
    }

    @Override
    public boolean playerWon() {
        return getScore() >= requiredScore;
    }

    public void subSecond(){
        time--;
    }

    public void addTime(int bonusTime){
        time += bonusTime;
    }

    public int getTime() {
        return time;
    }
}
