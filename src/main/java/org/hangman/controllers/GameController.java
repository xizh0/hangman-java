package org.hangman.controllers;

import org.hangman.models.Hangman;
import org.hangman.views.display.View;
import org.hangman.views.reader.Reader;

/**
 * @author Maxim Krisanov
 * @version 1.0
 */
public class GameController {

  private View view;

  private Hangman model;

  private Reader reader;

  private boolean isGameOver;

  public GameController(View view, Hangman model, Reader reader) {
    this.view = view;
    this.model = model;
    this.reader = reader;
  }

  public void run() {
    view.print("Do you want to play Hangman?");
    view.print("1 - Start a new game");
    view.print("2 - Quit the game");

    while (!isGameOver) {
      try {
        switch (reader.readNumber()) {
          case 1 -> playGame();
          case 2 -> quitGame();
          default -> {
            view.print("Incorrect number");
            view.print("Enter only 1 or 2");
          }
        }
      } catch (RuntimeException e) {
        view.print("Incorrect input");
      }
    }
  }

  private void playGame() {
    view.print("Entry any letter");

    while (true) {
      try {
        char letter = reader.readString().trim().charAt(0);

        if (!Character.isAlphabetic(letter)) {
          continue;
        }

        model.checkLetter(letter);
        view.displayState(model.getCurrentWordState().toString(),
            model.getSymbolStorage().getSymbols(), model.getLivesCounter());

        if (model.getLivesCounter() == 0) {
          model.setLivesCounter(Hangman.INITIATION_LIVES);
          view.print("You lose");
          view.print("Word: " + model.getWordValue());
          isGameOver = true;
          break;
        }

        if (model.isGuessed()) {
          view.print("You're guessed the word");
          view.print("Word: " + model.getWordValue());
          isGameOver = true;
          break;
        }
      } catch (RuntimeException e) {
        e.printStackTrace();
      }
    }
  }

  private void quitGame() {
    System.exit(0);
  }
}
