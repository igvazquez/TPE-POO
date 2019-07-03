package test;

import game.backend.element.*;
import game.backend.level.Level5;

public class Level5Test extends Level5 {

    @Override
        public void initialize(){
            super.initialize();
            for(int i = 0, aux = 0; i< SIZE ; i++)
                for(int j = 0; j < SIZE; j++, aux++)
                    g()[i][j].setContent(new Candy(CandyColor.values()
                            [aux % CandyColor.values().length]));

            g()[SIZE-2][2].setContent(new Candy(CandyColor.RED));
            g()[SIZE-3][2].setContent(new Candy(CandyColor.RED));
            g()[SIZE-1][1].setContent(new Candy(CandyColor.RED));
            g()[SIZE-4][2].setContent(new Fruit(FruitType.CHERRY));
            g()[SIZE-5][2].setContent(new Fruit(FruitType.CHERRY));


    }

}
