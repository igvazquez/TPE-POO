package game.backend.level.gameState;

import game.backend.GameState;

public class Level5State extends GameState {

    private int fruitsLeft, maxMoves;

    public Level5State(int fruitsLeft, int maxMoves) {
        this.fruitsLeft = fruitsLeft;
        this.maxMoves = maxMoves;
    }

    @Override
    public boolean gameOver() {
        return playerWon() || getMoves() >= maxMoves;
    }

    @Override
    public boolean playerWon() {
        return fruitsLeft <= 0;
    }

    public void addRemovedFruit(){
        fruitsLeft--;
    }

    public int getMovesLeft(){
        return getMaxMoves() - getMoves();
    }

    public int getMaxMoves() {
        return maxMoves;
    }

    public int getFruitsLeft() {
        return fruitsLeft;
    }
}
