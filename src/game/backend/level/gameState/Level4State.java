package game.backend.level.gameState;

public class Level4State extends ScoreDependantState{

    private int time; //Seconds

    public Level4State(int initTime, int requiredScore) {
        time = initTime;
        this.requiredScore = requiredScore;
    }

    @Override
    public boolean playerLost() {
        return time <= 0;
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
