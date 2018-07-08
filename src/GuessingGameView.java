import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 * Controller class that also acts as the view of the game
 * 
 * @author LN Dec 12, 2017
 *
 */
public class GuessingGameView extends JPanel implements ActionListener {

	private GuessingGameModel model;

	private JButton startButton; // button that Start/Restart
	private JButton yesButton;
	private JButton noButton;

	private JTextField infoText;
	private JTextField questionText;// Text field that shows the question and the current state of the game

	private JTextArea instruction;// Text area that shows the instruction of the game

	private JPanel southPanel; // Panel that holds start button and answers
	private JPanel northPanel; // Panel that holds questions

	private JPanel gamePanel; // panel that includes game and gif

	// gif components
	private Icon icon;
	private JLabel label;

	/**
	 * Constructor
	 * 
	 * @throws MalformedURLException
	 */
	public GuessingGameView() throws MalformedURLException {
		super(new BorderLayout());

		model = new GuessingGameModel(this);

		southPanel = new JPanel(new BorderLayout());
		northPanel = new JPanel(new BorderLayout());

		gamePanel = new JPanel(new BorderLayout());

		// embed the gif
		URL url = GuessingGameView.class.getResource("genie.gif");
		icon = new ImageIcon(url);
		label = new JLabel(icon);
		label.setBackground(Color.white);

		// create the view
		createView();

	}
/**
 * Method that creates instruction
 * @return instruction JTextArea
 */
	private JTextArea createInstruction() {
		instruction = new JTextArea();
		// allow words to go to next line
		instruction.setLineWrap(true);
		instruction.setEditable(false);

		instruction.setText("\nThink of one of the listed movies:" + "\n" 
				+ "\n The Fault in Our Star" + "\tTitanic"+ "\t\tThe Great Gatsby " +"\t\tHer"+ "\n" 
				+ "\n La La Land" + "\t\tDirty Dancing"+ "\t\tEternal Sunshine of the Spotless Mind" + "\tJuno"+"\n"
				+ "\n 500 Days of Summer"+ "\tWhen Harry met Sally" + "\tMidnight in Paris"+ "\t\tThe Notebook"+"\n" 
				+ "\n Moonrise Kingdom" + "\tBefore Sunset" + "\t\tBreakfast at Tiffany's"	+ "\t\tP.S: I love you" +"\n"
				+ "\n"
				+ "Genie will guess what movie you are thinking about."
				+ "\n"
				+ "If the final result matches your thought, click Yes. Else, click Start/Restart to play again"
				+ ".Have fun!");
		return instruction;
	}
/**
 * Method that creates the south panel
 * @return
 */
	private JPanel southPanel() {
		//set up yesButton
		yesButton = new JButton("Yes");
		southPanel.add(yesButton, BorderLayout.WEST);

		yesButton.addActionListener(this);

		//set up noButton
		noButton = new JButton("No");
		southPanel.add(noButton, BorderLayout.EAST);
		noButton.addActionListener(this);

		startButton = new JButton("Start/Restart");
		
		// disable to 2 buttons in initial frame
		yesButton.setEnabled(false);
		noButton.setEnabled(false);

		southPanel.add(startButton, BorderLayout.CENTER);

		startButton.addActionListener(this);
		return southPanel;

	}
/**
 * Create the first frame
 * @return first frame JPanel
 */
	private JPanel firstNorth() {
		infoText = new JTextField("Game Info");

		questionText = new JTextField();

		questionText.setText("");
		questionText.setEditable(false);
		infoText.setEnabled(false);
		northPanel.add(infoText, BorderLayout.WEST);
		northPanel.add(questionText, BorderLayout.CENTER);

		return northPanel;

	}
/**
 * Create the north panel after the game begin
 * @return north panel JPanel
 */
	private JPanel secondNorth() {
		infoText = new JTextField("Game Info");

		questionText = new JTextField();

		questionText.setText(model.getRoot().getData());
		questionText.setEditable(false);
		infoText.setEnabled(false);
		
		northPanel.add(infoText, BorderLayout.WEST);
		northPanel.add(questionText, BorderLayout.CENTER);

		return northPanel;
	}
/**
 * Method that starts the game
 */
	private void startGame() {
		model = new GuessingGameModel(this);
		//remove the first panel
		northPanel.removeAll();
		//create the second panel
		secondNorth();
		//enable buttons
		yesButton.setEnabled(true);
		noButton.setEnabled(true);

		revalidate();
	}
/**
 * Method that ends the game
 */
	public void endGame() {
		//disable buttons
		yesButton.setEnabled(false);
		noButton.setEnabled(false);
	}
/**
 * create the original view of the game
 */
	private void createView() {

		gamePanel.add(firstNorth(), BorderLayout.NORTH);

		gamePanel.add(southPanel(), BorderLayout.SOUTH);

		gamePanel.add(createInstruction(), BorderLayout.CENTER);

		gamePanel.add(label, BorderLayout.EAST);

		add(gamePanel, BorderLayout.CENTER);
	

	}
/**
 * Get the question from the question textField
 * @return questionText JTextField
 */
	public JTextField getQuestion() {
		return questionText;
	}

/**
 * Method that perform actions when buttons clicked
 * 
 */
	public void actionPerformed(ActionEvent e) {
		// start the game when user click start
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
