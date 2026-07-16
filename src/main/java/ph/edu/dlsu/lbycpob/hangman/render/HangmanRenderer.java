package ph.edu.dlsu.lbycpob.hangman.render;

import java.io.IOException;
import java.util.List;

public interface HangmanRenderer {
    /**
     * Returns the lines of hangman art for {@code guessesRemaining} (0–8).
     *
     * @throws IOException if the art resource cannot be located or read
     */
    List<String> render(int guessesRemaining) throws IOException;
}
