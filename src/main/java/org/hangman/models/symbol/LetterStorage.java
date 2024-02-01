package org.hangman.models.symbol;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Maxim Krisanov
 * @version 1.0
 */
public class LetterStorage implements SymbolStorage {

  private List<Character> collectedLetters;

  public LetterStorage() {
    this.collectedLetters = new ArrayList<>();
  }

  @Override
  public int collectSymbol(char symbol) {
    if (!Character.isAlphabetic(symbol)) {
      return -1;
    }

    if (collectedLetters.contains(symbol)) {
      return 0;
    }

    collectedLetters.add(symbol);
    return 1;
  }

  @Override
  public List<Character> getSymbols() {
    return collectedLetters;
  }
}
