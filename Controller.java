import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.awt.event.*;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
public class Controller implements ActionListener {
  private final WordCounterGUI view;

  /**
  The Controller class implements the ActionListener interface and is 
  responsible for handling the events triggered by the user
  interaction with the graphical user interface. It also 
  creates an instance of the WordCounterGUI class and sets it visible.
  */

  /**
   * Constructs a new Controller object and creates an instance of WordCounterGUI
   */
  public Controller() {
    view = new WordCounterGUI(this);
    view.setVisible(true);
  }

  /**
   * Responds to the user's interaction with the graphical user interface by handling events triggered by
   * the ActionEvent object. When the "Open File" button is clicked, it opens a file chooser window
   * and allows the user to select a text file. If a file is chosen, it reads the contents of the file and
   * counts the number of words in it. The result is then displayed in the text area of the WordCounterGUI.
   *
   * @param ae the ActionEvent object representing the user's interaction with the graphical user interface
   */

  @Override
  public void actionPerformed(ActionEvent ae) {
    System.out.println("Button Pushed");

    JFileChooser chooser = new JFileChooser();
    chooser.setFileFilter(new FileNameExtensionFilter("Text Files", "txt", "text"));
    int chooserSuccess = chooser.showOpenDialog(null);
    if (chooserSuccess == JFileChooser.APPROVE_OPTION) {
      File chosenFile = chooser.getSelectedFile();
      try {
        // Get the text from the JTextArea in WordCounterGUI and store it in the result variable
        String result = this.view.textArea.getText();
        // Create a new instance of StreamFile and use it to count the words in the chosen file
        StreamFile streamFile = new StreamFile();
        streamFile.countWords(chosenFile.getAbsolutePath());
        // Get the results of the word count and append them to the JTextArea in WordCounterGUI
        result = streamFile.printResults();
        String s = ae.getActionCommand();
        System.out.print(ae.getActionCommand());
        if (s.equals("Open File")) {
          this.view.textArea.append(result);
        }
      } catch (FileNotFoundException ex) {
        System.out.print("Error: File not found");
      } catch (IOException ex) {
        System.out.print("Error: IOException");
      }
    } else {
      System.out.println("The user must have cancelled");
    }
  }

}