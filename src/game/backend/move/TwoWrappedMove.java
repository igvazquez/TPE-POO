package game.backend.move;

import game.backend.Grid;
public class TwoWrappedMove extends Move {
	
	public TwoWrappedMove(Grid grid) {
		super(grid);
	}

	//Se cambio TwoWrapped Move para que rompa lo que deberia. Ademas
	//estaba dejando las bombas sin romper.
	@Override
	public void removeElements() {

		int maxX, maxY, currI, currJ;

		if (i1 == i2) {
			maxX = 3;
			maxY = 4;
			currI = i1;
			if (j1 < j2)
				currJ = j1;
			else
				currJ = j2;
		}else {
			maxX = 4;
			maxY = 3;
			currJ = j1;
			if (i1 < i2)
				currI = i1;
			else
				currI = i2;
		}

		for(int k = -2; k < maxX; k++)
			for(int n = -2; n < maxY; n++)
				if(Grid.inBounds(currI + k, currJ + n))
					clearContent(currI + k, currJ + n);
	}

}
