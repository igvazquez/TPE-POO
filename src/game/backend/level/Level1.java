package game.backend.level;

import game.backend.GameState;
import game.backend.Grid;

public class Level1 extends Grid {
	
	private static int REQUIRED_SCORE = 5000; 
	private static int MAX_MOVES = 20; 

	@Override
	protected GameState newState() {
		return new Level1State(REQUIRED_SCORE, MAX_MOVES);
	}


	//suma cada vez que se concrete un movimiento
	@Override
	public boolean tryMove(int i1, int j1, int i2, int j2) {
		boolean ret;
		if (ret = super.tryMove(i1, j1, i2, j2)) {
			state().addMove();
		}
		return ret;
	}
	
	private class Level1State extends GameState {
		private long requiredScore;
		private long maxMoves;
		
		public Level1State(long requiredScore, int maxMoves) {
			this.requiredScore = requiredScore;
			this.maxMoves = maxMoves;
		}
		
		public boolean gameOver() {
			return playerWon() || getMoves() >= maxMoves;
		}
		
		public boolean playerWon() {
			return getScore() > requiredScore;
		}

		@Override
		public boolean hasExtraScoreInfo() {
			return true;
		}

		@Override
		public String getExtraScoreMessage() {
			return "Moves left: ";
		}

		public Long getMovesLeft() {
			return maxMoves - getMoves();
		}

		@Override
		public String getExtraScoreValue() {
			return getMovesLeft().toString();
		}
	}

}
