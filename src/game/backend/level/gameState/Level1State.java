package game.backend.level.gameState;

public class Level1State extends GameState{

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

        public Long getMovesLeft() {
            return maxMoves - getMoves();
        }
}
