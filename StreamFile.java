import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;

public class StreamFile {

  // instance variables to store words and their corresponding counts
  private ArrayList < String > words;
  private ArrayList < Integer > count;

  /**
   * Method to count the occurrences of each word in the input file
   *
   * @param fileName the name of the file to be processed
   * @throws IOException if an error occurs while reading the file
   */
  public void countWords(String fileName) throws IOException {
    // call count words on absolute file pathname
    // create a FileInputStream and Scanner to read the file
    FileInputStream inp = new FileInputStream(fileName);
    Scanner fileInput = new Scanner(inp);

    // initialize the words and count ArrayLists
    words = new ArrayList < String > ();
    count = new ArrayList < Integer > ();

    // iterate over each word in the file
    while (fileInput.hasNext()) {
      String nextWord = fileInput.next();
      nextWord = punctuationRemover(nextWord);
      // if the word is already in the words ArrayList, increment its count
      if (words.contains(nextWord)) {
        int index = words.indexOf(nextWord);
        count.set(index, count.get(index) + 1);
      } else { // if the word is not in the words ArrayList, add it and set its count to 1
        words.add(nextWord);
        count.add(1);
      }
    }

    // close the file input streams
    fileInput.close();
    inp.close();
  }

  /**
   * Method to print the results of the word count in dictionary order
   */
  public String printResults() {
    String output = "";

    // stores original values 
    ArrayList < String > originalWords = new ArrayList < String > ();
    for (int i = 0; i < words.size(); i++) {
      originalWords.add(words.get(i));
    }
    // sort the words ArrayList in dictionary order
    Collections.sort(words);

    // iterate over each word in the sorted words ArrayList and print its count
    // retrieves original values and matches them with the sorted words
    for (int i = 0; i < words.size(); i++) {
      int idx = originalWords.indexOf(words.get(i));

      output = output + words.get(i) + " occurred " + count.get(idx) + " times\n";

    }
    return output;
  }

  /**
   * Method to remove any punctuation from a given word and lower case it
   *
   * @param word the word to be processed
   * @return the processed word with no punctuation and in lower case
   */
  public String punctuationRemover(String word) {
    String processedWord = word.replaceAll("\\p{Punct}", "").toLowerCase();
    return processedWord;
  }

  /**
   * Methods used to get words/count lists for JUnit Tests
   */

  public ArrayList < String > getWords() {
    return this.words;
  }

  public ArrayList < Integer > getCount() {
    return this.count;
  }

}