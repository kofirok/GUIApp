import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.*;
import java.io.IOException;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

/**

A JUnit test class for the StreamFile class that tests the countWords, printResults, and punctuationRemover methods.
*/


// TODO: Add javadoc
public class StreamFileTest {
  private StreamFile streamFile;
  private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
  private final PrintStream originalOut = System.out;

  public StreamFileTest() {}

  @BeforeAll
  public static void setUpClass() {
    System.out.println("Running BeforeAll");
  }

  @AfterAll
  public static void tearDownClass() {
    System.out.println("Running AfterAll");
  }

  @BeforeEach
  public void setUp() throws IOException {
    System.out.println("Running BeforeEach");
    streamFile = new StreamFile();
    streamFile.countWords("wordcounter.txt");
    System.setOut(new PrintStream(outContent));
  }

  @AfterEach
  public void restoreStreams() {
    System.setOut(originalOut);
  }

  /**
   * Tests the countWords method by checking the expected word and count values.
   * @throws IOException if an I/O error occurs
   */
  @Test
  public void testCountWords() throws IOException {
    System.out.println("Running countWords test");
    StreamFile instance = new StreamFile();
    instance.countWords("wordcounter.txt");
    ArrayList < String > expectedWords = instance.getWords();
    ArrayList < Integer > expectedCount = instance.getCount();
    assertEquals("bob", expectedWords.get(0));
    assertEquals(5, expectedCount.get(0));

  }

  /**
   * Tests the printResults method by checking the expected output string.
   */
  @Test
  public void testPrintResults() {
    streamFile.printResults();
    String expectedOutput = "billy occurred 2 times \nbob occurred 5 times \nsteve occurred 4 times \n";
    assertEquals(expectedOutput, outContent.toString());


  }

  /**
   * Tests the punctuationRemover method by checking the expected string with no punctuation.
   */

  @Test
  public void testPunctuationRemover() {
    StreamFile instance = new StreamFile();
    String word = "testing?! this- 'method'";
    String actualNoPunctuation = "testing this method";
    String expectedNoPunctuation = instance.punctuationRemover(word);
    assertEquals(expectedNoPunctuation, actualNoPunctuation);

  }
}