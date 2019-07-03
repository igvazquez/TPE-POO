package game.backend.level;

import game.backend.level.gameState.GameState;
import game.backend.Grid;
import game.backend.level.gameState.Level1State;

public class Level1 extends Grid {
	
	private static int REQUIRED_SCORE = 5000; 
	private static int MAX_MOVES = 20; 

	@Override
	protected GameState newState() {
		return new Level1State(REQUIRED_SCORE, MAX_MOVES);
	}
}
