package org.hangman.models.dictionary;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import lombok.Getter;

/**
 * @author Maxim Krisanov
 * @version 1.0
 */
public class Dictionary implements ReadWords {

  @Getter
  private List<String> wordsList;

  public Dictionary() {
    this.wordsList = new ArrayList<>();
    readWords();
  }

  @Override
  public void readWords() {
    try (BufferedReader bf = new BufferedReader(new FileReader(Path.of("words.txt").toFile()))) {
      String line;

      while ((line = bf.readLine()) != null) {
        wordsList.add(line);
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
