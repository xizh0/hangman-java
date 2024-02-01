package org.hangman.application;

import org.hangman.controllers.GameController;
import org.hangman.models.Hangman;
import org.hangman.views.display.ConsoleView;
import org.hangman.views.display.View;
import org.hangman.views.reader.KeyboardReader;
import org.hangman.views.reader.Reader;

/**
 * @author Maxim Krisanov
 * @version 1.0
 */
public class Application {

  public static void main(String[] args) {
    Hangman model = new Hangman();
    View view = new ConsoleView();
    Reader reader = new KeyboardReader();
    GameController gameController = new GameController(view, model, reader);

    gameController.run();
  }
}
