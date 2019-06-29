package game.backend.level.gameState;

import game.backend.GameState;

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
