package test;

import game.backend.cell.Cell;
import game.backend.element.*;
import game.backend.level.Level1;
import game.backend.level.Level2;

public class Level2Test extends Level2 {

   @Override
   public void initialize(){
       super.initialize();
       for(int i = 0, aux = 0; i< SIZE ; i++)
           for(int j = 0; j < SIZE; j++, aux++)
               g()[i][j].setContent(new Candy(CandyColor.values()
                       [aux % CandyColor.values().length]));

   }
}
