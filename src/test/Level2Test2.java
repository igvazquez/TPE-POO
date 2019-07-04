package test;

import game.backend.element.CandyColor;
import game.backend.element.HorizontalStripedCandy;
import game.backend.element.VerticalStripedCandy;

public class Level2Test2 extends Level2Test {

    @Override
    public void initialize() {
        super.initialize();
        VerticalStripedCandy vc = new VerticalStripedCandy();
        vc.setColor(CandyColor.RED);
        HorizontalStripedCandy hc = new HorizontalStripedCandy();
        hc.setColor(CandyColor.BLUE);
        g()[5][3].setContent(hc);
        g()[4][3].setContent(vc);
    }
}
