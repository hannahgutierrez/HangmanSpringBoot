package ph.edu.dlsu.lbycpob.hangman.statistics;

import java.util.Locale;

/**
 * Holds the running statistics for one program session: games played,
 * games won, and the best (highest) number of guesses remaining at the end
 * of any single game.
 */
public record GameStatistics(int gamesPlayed, int gamesWon, int bestGuessesRemaining) {

    /** Runs automatically every time a GameStatistics is created - checks the numbers make sense. */
    public GameStatistics {
        if (gamesPlayed < 0) {
            throw new IllegalArgumentException("gamesPlayed must be >= 0, got " + gamesPlayed);
        }
        if (gamesWon < 0 || gamesWon > gamesPlayed) {
            throw new IllegalArgumentException(
                    "gamesWon must be between 0 and gamesPlayed (" + gamesPlayed + "), got " + gamesWon);
        }
        if (bestGuessesRemaining < 0) {
            throw new IllegalArgumentException(
                    "bestGuessesRemaining must be >= 0, got " + bestGuessesRemaining);
        }
    }
