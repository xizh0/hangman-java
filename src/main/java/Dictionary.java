import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Represents a dictionary containing a list of words.
 *
 * @author Maxim Krisanov
 * @version 1.0, 01/28/2024
 */
public class Dictionary {

  /**
   * Dictionary with a list of words read from the file.
   */
  private List<String> wordsList = new ArrayList<>();

  /**
   * Constructs a new Dictionary object.
   *
   * @param filename the name of the file containing the dictionary
   * @throws FileNotFoundException if the file is not found
   */
  public Dictionary(String filename) throws FileNotFoundException {
    try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
      String line;

      while ((line = reader.readLine()) != null) {
        wordsList.add(line);
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  /**
   * Returns the list of words in the dictionary.
   *
   * @return the list of words in the dictionary
   */
  public List<String> getWordsList() {
    return wordsList;
  }
}
