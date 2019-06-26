package test;

import game.backend.GameState;
import game.backend.Grid;
import game.backend.cell.CandyGeneratorCell;
import game.backend.cell.Cell;
import game.backend.element.*;
import game.backend.level.Level1;

public class Level1Test extends Level1 {
    private static int REQUIRED_SCORE = 5000;
    private static int MAX_MOVES = 20;

    private Cell wallCell;
    private Cell candyGenCell;


   @Override
   public void initialize(){
       super.initialize();
       //fallElementsMonito();

       Cell cell = new Cell(this);
       cell.setContent(new Candy(CandyColor.RED));

       g()[0][0].setAround(cell, g()[1][0], wallCell, g()[0][1]);
       g()[0][SIZE-1].setAround(new Cell(this), g()[1][SIZE-1], g()[0][SIZE-2], wallCell);
       for(int i =1; i < SIZE - 1 ; i++)
           g()[0][i].setAround(new Cell(this),g()[1][i],g()[0][i-1],g()[0][i+1]);

       WrappedCandy wC = new WrappedCandy(); wC.setColor(CandyColor.RED);
       g()[5][5].setContent(wC);
       g()[5][4].setContent(wC);


   }

   /* @Override
    public void fallElements(){}

    public void fallElementsMonito(){
       super.fallElements();
    }*/
}
