package ph.edu.dlsu.lbycpob.hangman.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ph.edu.dlsu.lbycpob.hangman.model.GameState;
import ph.edu.dlsu.lbycpob.hangman.service.HangmanService;
import ph.edu.dlsu.lbycpob.hangman.statistics.GameStatistics;
import ph.edu.dlsu.lbycpob.hangman.statistics.StatisticsWriter;

/** HTTP controller – the web equivalent of the {@code Hangman.run()} game
 loop. */
@Controller
public class GameController {

    private static final String SESSION_KEY = "gameState";

    private final HangmanService    hangmanService;
    private final StatisticsWriter  statisticsWriter;

    public GameController(HangmanService hangmanService,
                          StatisticsWriter statisticsWriter) {
        this.hangmanService   = hangmanService;
        this.statisticsWriter = statisticsWriter;
    }

    // ------------------------------------------------------------------ //
    //  Welcome page                                                         //
    // ------------------------------------------------------------------ //

    @GetMapping("/")
    public String index() {
        return "index";
    }

    // ------------------------------------------------------------------ //
    //  Start a new session                                                  //
    // ------------------------------------------------------------------ //
    @PostMapping("/game/start")
    public String startGame(@RequestParam("filename") String filename,
                            HttpSession session) {
        GameState state = new GameState();
        state.setFilename(filename.trim());

        String word = hangmanService.getRandomWord(state.getFilename());
        state.setSecretWord(word);
        state.setGuessesRemaining(HangmanService.MAX_GUESSES);
        state.setMessage("A new word has been chosen. It has "
                + word.length() + " letter(s). Good luck!");

        session.setAttribute(SESSION_KEY, state);
        return "redirect:/game/play";
    }
