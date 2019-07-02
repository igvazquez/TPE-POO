package game.backend.level.gameState;

public class Level5State extends MovementDependantState {

    private int fruitsLeft;

    public Level5State(int fruitsLeft, int maxMoves) {
        this.fruitsLeft = fruitsLeft;
        this.maxMoves = maxMoves;
    }

    @Override
    public boolean playerWon() {
        return fruitsLeft <= 0;
    }

    public void RemoveFruit(){
        fruitsLeft--;
    }

    public int getFruitsLeft() {
        return fruitsLeft;
    }
}
