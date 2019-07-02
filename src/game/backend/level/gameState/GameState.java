package game.backend.level.gameState;

public abstract class GameState {
	
	private long score = 0;
	private int moves = 0;
	
	public void addScore(long value) {
		this.score = this.score + value;
	}
	
	public long getScore(){
		return score;
	}
	
	public void addMove() {
		moves++;
	}
	
	public int getMoves() {
		return moves;
	}

	public abstract boolean playerLost();

	public abstract boolean playerWon();

	public  boolean gameOver(){ return playerWon() || playerLost();}
	

}
