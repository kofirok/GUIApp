 # Word Counter GUI Application
 ## Khalid Kofiro

 This is a Java program that demonstrates how to count the occurrences of each word in a file and print the results.

# Classes
 * WordCounter.java: The main class that takes in the file as an input and prints out the amount of occurances for each word.
 StreamFile.java -The StreamFile class contains the methods for counting the occurrences of each word in a file and printing the results. The printResults method takes a filename as a parameter and reads the contents of the file, counting the occurrences of each word. It throws an IOException if an error occurs while reading the file.

 * StreamFileTest.java:  Class containing JUnit tests to confirm the functionality of the methods within the project. Tests include: testWordCounter, testPrintResults, testPunctuationRemover, the getWords and getCount methods help the JUnit tests by delivering the words/count arrays to the StreamFileTest class.


 * WordCounterGUI.java: Class that uses a JFrame class and represents the user interface for a word counter application. It includes a JTextArea to display the results of the word count and a JButton to trigger a file chooser window for selecting a text file to count the words in. It also has a constructor that takes a Controller object to handle the user's interactions with the user interface

 * Controller.java: Class containing a controller that implements the ActionListener/ActionPerformed interface and is responsible for handling events triggered by user interaction with the graphical user interface. 

# Usage

 * Clone or download the WordCounter repository to your local machine.
 Open a command prompt or terminal window and navigate to the directory containing the WordCounter files.
 * Compile the Java code by running the command: javac WordCounter.java.
 * Run the program by running the command: java WordCounter.
 * The program will read the contents of the file "wordcounter.txt" in the same directory and print the results of the word count.

 Enjoy!