package org.hangman.models.symbol;

import java.util.List;

/**
 * @author Maxim Krisanov
 * @version 1.0
 */
public interface SymbolStorage {

  int collectSymbol(char symbol);

  List<Character> getSymbols();
}
