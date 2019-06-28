package game.backend.move;

import game.backend.Grid;

public class WrappedStripedMove extends Move {

	public WrappedStripedMove(Grid grid) {
		super(grid);
	}
	
	@Override
	public void removeElements() {

		//Franja horizontal
		for(int i = -1; i < 2; i++) {
			for (int j = 0; j < Grid.SIZE; j++) {
				if (Grid.inBounds(i2 + i, j)) {
					clearContent(i2 + i, j);
				}
			}
		}

		//Franja vertical
		for(int j = -1; j < 2; j++) {
			for(int i = 0; i < Grid.SIZE; i++) {
				if (Grid.inBounds(i,j2 + j)) {
					clearContent(i, j2 + j);
				}
			}
		}
	}

}
