package game.backend.element;

public class TimeCandy extends Candy{

    private int bonusTime;

    public TimeCandy(CandyColor color, int bonusTime) {
        super(color);
        this.bonusTime = bonusTime;
    }

    @Override
    public boolean hasBonus() {
        return true;
    }

    public int getBonusTime(){
        return bonusTime;
    }
}
