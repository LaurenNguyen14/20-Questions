
import java.net.MalformedURLException;

import javax.swing.JFrame;

/**
 * Application class for original guessing game
 * 
 * @author LN Dec 12,2017
 *
 */
public class GuessingGameApplication {
	/**
	 * Main method
	 * 
	 * @param args
	 *            String
	 * @throws MalformedURLException
	 */

	public static void main(String[] args) throws MalformedURLException {

		JFrame guiFrame;
		guiFrame = new JFrame("Genie guess your movie");
		guiFrame.getContentPane().add(new GuessingGameView());
		guiFrame.setSize(1100, 500);

		guiFrame.setLocationRelativeTo(null);
		guiFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		guiFrame.setVisible(true);
	}

}
