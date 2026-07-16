package ph.edu.dlsu.lbycpob.hangman.model;

import ph.edu.dlsu.lbycpob.hangman.statistics.GameStatistics;
import java.io.Serializable;

/**
 * Mutable snapshot of one player's session: the current game plus the
 * running statistics across all games played so far.
 *
 * <p>Implements {@link Serializable} so the servlet container can persist
 * the session to disk if it needs to (required by the spec even if the
 * container never actually serialises it in development).
 *
 */
public class GameState {
    private static final long serialVersionUID = 1L;

    /**
     * The word list file currently in use (e.g. {@code "words.txt"}).
     */
    private String filename = "";

    /**
     * Upper-cased secret word for the current round.
     */
    private String secretWord = "";

    /**
     * Concatenated string of every letter the player has guessed so far,
     * in the order they were guessed – mirrors the {@code guessedLetters}
     * local variable from the original {@code playOneGame}.
     */
    private String guessedLetters = "";

    /**
     * How many incorrect guesses the player still has available.
     */
    private int guessesRemaining = 8;

}
