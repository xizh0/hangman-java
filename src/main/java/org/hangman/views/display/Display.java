package org.hangman.views.display;

import java.util.List;

/**
 * @author Maxim Krisanov
 * @version 1.0
 */
public interface Display {

  void displayState(String currentWordState, List<Character> guessedLetters, int lives);
}
