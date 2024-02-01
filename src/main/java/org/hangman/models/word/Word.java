package org.hangman.models.word;

import java.util.List;
import java.util.Random;
import lombok.Getter;
import org.hangman.models.word.GenerateWord;

/**
 * @author Maxim Krisanov
 * @version 1.0
 */
public class Word implements GenerateWord {

  @Getter
  private String word;

  public Word(List<String> wordsList) {
    this.word = generateWord(wordsList);
  }

  @Override
  public String generateWord(List<String> wordsList) {
    return wordsList.get(new Random().nextInt(wordsList.size()));
  }

  public void setWord(List<String> wordsList) {
    word = generateWord(wordsList);
  }
}
