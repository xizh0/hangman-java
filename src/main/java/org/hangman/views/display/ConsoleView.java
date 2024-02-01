package org.hangman.views.display;

import java.util.List;
import org.hangman.application.Constants;

/**
 * @author Maxim Krisanov
 * @version 1.0
 */
public class ConsoleView implements View {

  @Override
  public void displayState(String currentWordState, List<Character> guessedLetters, int lives) {
    switch (lives) {
      case 8 -> print("You have all attempts");
      case 7 -> print(Constants.GALLOWS[0]);
      case 6 -> print(Constants.GALLOWS[1]);
      case 5 -> print(Constants.GALLOWS[2]);
      case 4 -> print(Constants.GALLOWS[3]);
      case 3 -> print(Constants.GALLOWS[4]);
      case 2 -> print(Constants.GALLOWS[5]);
      case 1 -> print(Constants.GALLOWS[6]);
      default -> {
        print(Constants.GALLOWS[7]);
        print("You're dead");
        return;
      }
    }

    print(currentWordState);
    print(guessedLetters.toString());
    print("Lives left: " + lives);
  }

  @Override
  public void print(String msg) {
    System.out.println(msg);
  }
}
