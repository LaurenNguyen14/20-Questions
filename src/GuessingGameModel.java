
import datastructures.DefaultBinaryTree;
import datastructures.DefaultBinaryTreeNode;

/**
 * Model class that handles the logic of the game
 * @author LN 
 * Dec 12, 2017
 *
 */
public class GuessingGameModel {

	private MovieFileReader file;
	private GuessingGameView view;

	private DefaultBinaryTree<String> tree;
	private DefaultBinaryTreeNode<String> node;

	/**
	 * Constructor
	 * 
	 * @param view
	 *            GuessingGameView
	 */
	public GuessingGameModel(GuessingGameView view) {

		// file = new MovieFileReader();
		this.view = view;

		file = new MovieFileReader();
		tree = new DefaultBinaryTree<String>();
		tree = (DefaultBinaryTree<String>) file.fileReader("movies_guess.xml");
		node = (DefaultBinaryTreeNode<String>) tree.getRoot();

	}

	/**
	 * Method that get the current node from a tree
	 * 
	 * @return node DefaultBinaryTreeNode
	 */

	public DefaultBinaryTreeNode<String> getCurrentNode() {

		return node;
	}

	/**
	 * Method that gets the root of the tree
	 * 
	 * @return root DefaultBinaryTreeNode
	 */
	public DefaultBinaryTreeNode<String> getRoot() {
		return (DefaultBinaryTreeNode<String>) tree.getRoot();
	}

	/**
	 * Method that navigate the game for Yes answer
	 * 
	 */
	public void yes() {
		// if the node is a leaf
		if (node.getLeftChild() == null && node.getRightChild() == null) {
			// end the game
			view.endGame();
			// confirm correct answer
			view.getQuestion()
					.setText("The movie you are thinking about is definitely: " + node.getData() + "." + "Yay!");

		} else {
			// got to the next node on the left
			node = (DefaultBinaryTreeNode<String>) node.getLeftChild();

			// show the question of the next node
			view.getQuestion().setText((String) node.getData());

		}

	}

	/**
	 * Method that navigates the game for NO answer
	 */
	public void no() {
		// if the node is a leaf
		if (node.getLeftChild() == null && node.getRightChild() == null) {
			// end the game
			view.endGame();
			// show text
			view.getQuestion()
					.setText("Oops. Sorry that I couldn't guess your movie." + "\n Press Start/Restart to play again");
		} else {
			// if it's not the leaf node, navigate to to right child
			node = (DefaultBinaryTreeNode<String>) node.getRightChild();
			// show the question on the right child
			view.getQuestion().setText((String) node.getData());

		}

	}

}