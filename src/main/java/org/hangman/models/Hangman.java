package org.hangman.models;

import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.hangman.models.dictionary.Dictionary;
import org.hangman.models.symbol.LetterStorage;
import org.hangman.models.symbol.SymbolStorage;
import org.hangman.models.word.Word;

/**
 * @author Maxim Krisanov
 * @version 1.0
 */
public class Hangman {

  private Dictionary dictionary;

  private List<String> wordsList;

  @Getter
  private SymbolStorage symbolStorage;

  private Word word;

  @Getter
  private StringBuilder currentWordState;

  @Getter
  @Setter
  private int livesCounter;

  public static final int INITIATION_LIVES = 8;

  public Hangman() {
    this.dictionary = new Dictionary();
    this.wordsList = dictionary.getWordsList();
    this.symbolStorage = new LetterStorage();
    this.word = new Word(wordsList);
    this.currentWordState = new StringBuilder();
    for (int i = 0; i < word.getWord().length(); i++) {
      currentWordState.append('_');
    }
    this.livesCounter = 8;
  }

  public void checkLetter(char letter) {
    letter = Character.toLowerCase(letter);
    String guessedWord = word.getWord().toLowerCase();

    if (symbolStorage.getSymbols().contains(letter)) {
      return;
    }

    symbolStorage.collectSymbol(letter);

    boolean letterFound = false;
    for (int i = 0; i < guessedWord.length(); i++) {
      if (letter == guessedWord.charAt(i)) {
        currentWordState.setCharAt(i, letter);
        letterFound = true;
      }
    }

    if (!letterFound) {
      livesCounter--;
    }
  }

  public boolean isGuessed() {
    return word.getWord().equals(currentWordState.toString());
  }

  public String getWordValue() {
    return word.getWord();
  }
}
