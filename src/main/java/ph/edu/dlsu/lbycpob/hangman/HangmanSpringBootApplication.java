package ph.edu.dlsu.lbycpob.hangman;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import ph.edu.dlsu.lbycpob.hangman.render.AsciiArtRenderer;
import ph.edu.dlsu.lbycpob.hangman.render.HangmanRenderer;
import ph.edu.dlsu.lbycpob.hangman.repository.ClasspathWordRepository;
import ph.edu.dlsu.lbycpob.hangman.repository.WordRepository;

import java.util.Random;

@SpringBootApplication
public class HangmanSpringBootApplication {

    /** Shared classpath root – mirrors the original {@code GAME_ASSETS_BASE_PATH}. */
    private static final String GAME_ASSETS_BASE_PATH = "/game-assets";

    static void main(String[] args) {
        SpringApplication.run(HangmanSpringBootApplication.class, args);
    }
}
