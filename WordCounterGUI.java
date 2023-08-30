import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JTextArea;
class WordCounterGUI extends JFrame {

  /**
  The WordCounterGUI class extends the JFrame class and represents
   the user interface for the word counter application. It contains a 
   JTextArea where the results of the word count are displayed and a JButton to trigger the
  file chooser window for selecting a text file to count the words in.
  */

  protected final JTextArea textArea = new JTextArea();

  /**
   * Constructs a new WordCounterGUI object with a given Controller object
   *  to handle the user's interactions with the  user interface.
   * 
   * @param cs the Controller object responsible for handling the user's interactions with the graphical user interface
   */
  public WordCounterGUI(Controller cs) {
    this.setTitle("Word Counter");
    this.setSize(500, 500);
    this.setLocation(100, 100);
    this.getContentPane().setLayout(null);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    JButton button = new JButton("Open File");
    button.setBounds(200, 415, 100, 50);
    button.addActionListener(cs);
    this.getContentPane().add(button);

    textArea.setBounds(50, 15, 400, 400);
    textArea.setEditable(false);
    textArea.setLineWrap(true);
    textArea.setWrapStyleWord(true);
    this.getContentPane().add(textArea);
  }

}