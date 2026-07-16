package ph.edu.dlsu.lbycpob.hangman.render;

import ph.edu.dlsu.lbycpob.hangman.utils.ClasspathResources;
import java.io.IOException;
import java.util.List;
import java.util.Objects;

public class AsciiArtRenderer implements HangmanRenderer {
    private static final int MIN_GUESSES_REMAINING = 0;
    private static final int MAX_GUESSES_REMAINING = 8;

    private final String resourceBasePath;

    public AsciiArtRenderer(String resourceBasePath) {
        Objects.requireNonNull(resourceBasePath, "resourceBasePath must not be null");
        if (resourceBasePath.isBlank()) {
            throw new IllegalArgumentException("resourceBasePath must not be blank");
        }
        this.resourceBasePath = resourceBasePath.endsWith("/")
                ? resourceBasePath.substring(0, resourceBasePath.length() - 1)
                : resourceBasePath;
    }
}
