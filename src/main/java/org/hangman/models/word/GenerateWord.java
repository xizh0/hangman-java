package org.hangman.models.word;

import java.util.List;

/**
 * @author Maxim Krisanov
 * @version 1.0
 */
public interface GenerateWord {

  String generateWord(List<String> wordsList);
}
