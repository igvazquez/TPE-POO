package test;

import game.backend.element.Candy;
import game.backend.element.CandyColor;

public class Level2Test1 extends Level2Test{

    @Override
    public void initialize() {
        super.initialize();
        g()[5][2].setContent(new Candy(CandyColor.RED));
        g()[4][4].setContent(new Candy(CandyColor.RED));
    }
}
