package game.backend.move;

import game.backend.Grid;
import game.backend.element.*;

public class MoveMakerWithUncombinable extends MoveMaker{

    public MoveMakerWithUncombinable(Grid grid) {
        super(grid);
    }

    @Override
    protected void initMap() {
        super.initMap();

        String specialKey = new UncombinableElement().getKey();

        map.put(specialKey + new Candy().getKey(), new CandyMove(grid));
        map.put(new Candy().getKey() + specialKey, new CandyMove(grid));


        map.put(specialKey + new HorizontalStripedCandy().getKey(), new CandyMove(grid));
        map.put(new HorizontalStripedCandy().getKey() + specialKey, new CandyMove(grid));

        map.put(specialKey + new VerticalStripedCandy().getKey(), new CandyMove(grid));
        map.put(new VerticalStripedCandy().getKey() + specialKey, new CandyMove(grid));

        map.put(new WrappedCandy().getKey() + specialKey, new CandyMove(grid));
        map.put(specialKey + new WrappedCandy().getKey(), new CandyMove(grid));

        map.put(specialKey + new Bomb().getKey(), new InvalidMove(grid));
        map.put(new Bomb().getKey() + specialKey, new InvalidMove(grid));

    }
}
