package game.backend.level.gameState;

public class Level1State extends MovementDependantState{

        private long requiredScore;

        public Level1State(long requiredScore, int maxMoves) {
            this.requiredScore = requiredScore;
            this.maxMoves = maxMoves;
        }


        public boolean playerWon() {
            return getScore() > requiredScore;
        }


}
