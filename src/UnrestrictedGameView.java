import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 * 
 * @author LN Dec 12, 2017
 *
 */
public class UnrestrictedGameView extends JPanel implements ActionListener {
	private UnrestrictedGameModel model;

	private JButton startButton;
	private JButton yesButton;
	private JButton noButton;

	private JTextField infoText;
	private JTextField questionText;

	private JTextArea instruction;

	private JPanel southPanel;
	private JPanel northPanel;

	private JPanel gamePanel;
	// private JPanel gifPanel;

	private Icon icon;
	private JLabel label;

	private JTextField newMovie;
	private JTextField newQuestion;
	private String[] items;
	JComboBox<String> combo;

	/**
	 * Constructor
	 * 
	 * @throws MalformedURLException
	 */

	public UnrestrictedGameView() throws MalformedURLException {
		super(new BorderLayout());

		model = new UnrestrictedGameModel(this);

		southPanel = new JPanel(new BorderLayout());
		northPanel = new JPanel(new BorderLayout());

		gamePanel = new JPanel(new BorderLayout());

		// get the gif
		URL url = GuessingGameView.class.getResource("genie.gif");
		icon = new ImageIcon(url);
		label = new JLabel(icon);
		label.setBackground(Color.white);

		createView();

	}

	/**
	 * Method that gets the input question
	 * 
	 * @return newQuestion JTextField
	 */
	public JTextField getNewQuestion() {
		return newQuestion;
	}

	/**
	 * Method that gets the input title
	 * 
	 * @return newMovie JTextField
	 */
	public JTextField getNewMovie() {
		return newMovie;
	}

	/**
	 * Method that gets the data of the answer
	 * 
	 * @return answer String
	 */
	public String getNewAnswer() {
		return (String) combo.getSelectedItem();

	}

	/**
	 * Set up the pop up screen
	 * 
	 */
	public void popUp() {
		items = new String[] { "Yes", "No" };
		combo = new JComboBox<>(items);
		newMovie = new JTextField("");
		newQuestion = new JTextField("");

		yesButton.setEnabled(false);
		noButton.setEnabled(false);

		JPanel popUp = new JPanel(new GridLayout(0, 1));
		popUp.add(new JLabel("Add new movie"));
		popUp.add(newMovie);

		popUp.add(new JLabel("Enter Yes/No question for your movie"));
		popUp.add(newQuestion);

		popUp.add(new JLabel("New Answer"));
		popUp.add(combo);

		// set the the JOptionPane
		int result = JOptionPane.showConfirmDialog(null, popUp, "Input", JOptionPane.OK_CANCEL_OPTION,
				JOptionPane.PLAIN_MESSAGE);
		// save the data only if the user click OK
		if (result == JOptionPane.OK_OPTION) {
			combo.getSelectedItem();
			newMovie.getText();
			newQuestion.getText();

			model.addAnswer();
		} else if (result == JOptionPane.CANCEL_OPTION) {
			return;
		}

	}

	/**
	 * 
	 * @return
	 */
	private JTextArea createInstruction() {
		instruction = new JTextArea();
		// allow words to go to next line
		instruction.setLineWrap(true);
		instruction.setEditable(false);

		instruction.setText("\nThink of one of the listed movies:" + "\n" + "\n The Fault in Our Star" + "\tTitanic"
				+ "\t\tThe Great Gatsby " + "\t\tHer" + "\n" + "\n La La Land" + "\t\tDirty Dancing"
				+ "\t\tEternal Sunshine of the Spotless Mind" + "\tJuno" + "\n" + "\n 500 Days of Summer"
				+ "\tWhen Harry met Sally" + "\tMidnight in Paris" + "\t\tThe Notebook" + "\n" + "\n Moonrise Kingdom"
				+ "\tBefore Sunset" + "\t\tBreakfast at Tiffany's" + "\t\tP.S: I love you" + "\n" + "\n"
				+ "Genie will guess what movie you are thinking about." + "\n"
				+ "If the final result matches your thought, click Yes. Else, click Start/Restart to play again"
				+ ".Have fun!");

		return instruction;
	}

	/**
	 * Set up the south panel
	 * 
	 * @return
	 */
	private JPanel southPanel() {

		yesButton = new JButton("Yes");
		southPanel.add(yesButton, BorderLayout.WEST);
		yesButton.addActionListener(this);

		noButton = new JButton("No");
		southPanel.add(noButton, BorderLayout.EAST);
		noButton.addActionListener(this);

		startButton = new JButton("Start/Restart");

		yesButton.setEnabled(false);
		noButton.setEnabled(false);

		southPanel.add(startButton, BorderLayout.CENTER);

		startButton.addActionListener(this);
		return southPanel;

	}

	/**
	 * Set the first frame north panel
	 * 
	 * @return northPanel JPanel
	 */
	private JPanel firstNorth() {
		infoText = new JTextField("Game Info");
		infoText.setEnabled(false);

		questionText = new JTextField();

		questionText.setText("");
		questionText.setEditable(false);

		northPanel.add(infoText, BorderLayout.WEST);
		northPanel.add(questionText, BorderLayout.CENTER);

		return northPanel;

	}

	/**
	 * Set up the north panel when the game start
	 * 
	 * @return
	 */
	private JPanel secondNorth() {
		infoText = new JTextField("Game Info");
		infoText.setEnabled(false);

		questionText = new JTextField();

		//game starts with the first question
		questionText.setText(model.getRoot().getData());
		questionText.setEditable(false);
		

		northPanel.add(infoText, BorderLayout.WEST);
		northPanel.add(questionText, BorderLayout.CENTER);

		return northPanel;
	}
/**
 * Method starts the game
 */
	private void startGame() {
		// game goes to the root node every new name
		model.updateNode();
		northPanel.removeAll();

		secondNorth();

		yesButton.setEnabled(true);
		noButton.setEnabled(true);

		revalidate();
	}
/**
 * Method end the game
 */
	public void endGame() {
		yesButton.setEnabled(false);
		noButton.setEnabled(false);
	}
/**
 * Create the view
 */

	private void createView() {

		gamePanel.add(firstNorth(), BorderLayout.NORTH);

		gamePanel.add(southPanel(), BorderLayout.SOUTH);

		gamePanel.add(createInstruction(), BorderLayout.CENTER);

		gamePanel.add(label, BorderLayout.EAST);

		add(gamePanel, BorderLayout.CENTER);
	

	}

/**
 * Method that get the question from the tree
 * @return questionText JTextField
 */
	public JTextField getQuestion() {
		return questionText;
	}

/**
 * Method manipulate buttons
 * @param e ActionEvent
 */
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(startButton)) {
			startGame();

		}
		if (e.getSource().equals(yesButton)) {
			model.yes();
		}
		if (e.getSource().equals(noButton)) {
			model.no();
		}

	}

}
