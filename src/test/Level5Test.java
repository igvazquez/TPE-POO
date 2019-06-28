package test;

import game.backend.cell.Cell;
import game.backend.element.*;
import game.backend.level.Level5;

public class Level5Test extends Level5 {

    private Cell wallCell;
    private Cell candyGenCell;

    @Override
    public void initialize(){
        super.initialize();
        //fallElementsMonito();

 /*       Cell cell = new Cell(this);
        cell.setContent(new Candy(CandyColor.RED));

        g()[0][0].setAround(cell, g()[1][0], wallCell, g()[0][1]);
        g()[0][SIZE-1].setAround(new Cell(this), g()[1][SIZE-1], g()[0][SIZE-2], wallCell);
        for(int i =1; i < SIZE - 1 ; i++)
            g()[0][i].setAround(new Cell(this),g()[1][i],g()[0][i-1],g()[0][i+1]);*/

        Fruit uc = new Fruit(FruitType.CHERRY);
        g()[SIZE-2][5].setContent(uc);
        g()[SIZE-2][4].setContent(new Bomb());


    }
}
