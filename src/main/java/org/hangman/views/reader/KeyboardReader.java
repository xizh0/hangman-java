package org.hangman.views.reader;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author Maxim Krisanov
 * @version 1.0
 */
public class KeyboardReader implements Reader {

  private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

  @Override
  public int readNumber() {
    try {
      return Integer.parseInt(reader.readLine().trim());
    } catch (IOException | NumberFormatException e) {
      throw new RuntimeException(e);
    }
  }

  @Override
  public String readString() {
    try {
      return reader.readLine();
    } catch (IOException | IllegalArgumentException e) {
      throw new RuntimeException(e);
    }
  }
}
