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

    @Override
    public boolean hasExtraScoreInfo() {
        return true;
    }

    @Override
    public String getExtraScoreMessage() {
        return "Fruits left: ";
    }

    @Override
    public String getExtraScoreValue() {
        return String.valueOf(fruitsLeft);
    }

}
