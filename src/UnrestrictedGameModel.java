import datastructures.DefaultBinaryTree;
import datastructures.DefaultBinaryTreeNode;

/**
 * Game model for unrestricted model
 * 
 * @author LN Dec 12
 *
 */
public class UnrestrictedGameModel {
	private MovieFileReader file;
	private UnrestrictedGameView view;

	private DefaultBinaryTree<String> tree;
	private DefaultBinaryTreeNode<String> node;

	/**
	 * Constructor
	 * 
	 * @param view
	 *            UnrestrcitedGameView
	 */
	public UnrestrictedGameModel(UnrestrictedGameView view) {
		this.view = view;

		file = new MovieFileReader();
		tree = new DefaultBinaryTree<String>();
		// get the tree from the file reader class
		tree = (DefaultBinaryTree<String>) file.fileReader("movies_guess.xml");

	}

	/**
	 * update to the root when game restart
	 * 
	 */
	public void updateNode() {
		node = (DefaultBinaryTreeNode<String>) tree.getRoot();
	}

	/**
	 * Get the current node from the tree
	 * 
	 * @return node DefaultBinaryTreeNode
	 */
	public DefaultBinaryTreeNode<String> getCurrentNode() {

		return node;
	}

	/**
	 * get the root of the tree
	 * 
	 * @return root DefaultBinaryTreeNode
	 */
	public DefaultBinaryTreeNode<String> getRoot() {
		return (DefaultBinaryTreeNode<String>) tree.getRoot();
	}

	/**
	 * Handle the game when the answer is yes
	 */
	public void yes() {
		// if the node is a leaf
		if (node.getLeftChild() == null && node.getRightChild() == null) {
			view.endGame();
			view.getQuestion()
					.setText("The movie you are thinking about is definitely: " + node.getData() + "." + "Yay!");

		} else {

			node = (DefaultBinaryTreeNode<String>) node.getLeftChild();
			view.getQuestion().setText((String) node.getData());

		}

	}

	/**
	 * Method that run when the user enter a new data
	 */
	public void addAnswer() {
		// save data from current node
		String oldData = node.getData();

		// save the answer from the user choice
		String value = view.getNewAnswer();

		// set the old node to new input question
		node.setData(view.getNewQuestion().getText());

		// if input answer is yes
		if (value.equals("Yes")) {
			// create a new node on the left
			DefaultBinaryTreeNode<String> leftChild1 = new DefaultBinaryTreeNode<>();
			node.setLeftChild(leftChild1);
			// set left child data to be new question
			leftChild1.setData(view.getNewMovie().getText());

			// create new node on the right
			DefaultBinaryTreeNode<String> rightChild1 = new DefaultBinaryTreeNode<>();
			node.setRightChild(rightChild1);
			// put the old movie answer to the right child
			rightChild1.setData(oldData);

			// if input answer is no
		} else if (value.equals("No")) {
			// create new node on the right
			DefaultBinaryTreeNode<String> rightChild2 = new DefaultBinaryTreeNode<>();
			node.setRightChild(rightChild2);
			// set data of right child to be new data
			rightChild2.setData(view.getNewMovie().getText());

			// create a left child
			DefaultBinaryTreeNode<String> leftChild2 = new DefaultBinaryTreeNode<>();
			node.setLeftChild(leftChild2);

			// put old data in the left child
			leftChild2.setData(oldData);
		}

	}

	/**
	 * Method navigates program when user answers no
	 */
	public void no() {
		// if the node is the leaf
		if (node.getLeftChild() == null && node.getRightChild() == null) {
			// pop up message
			view.popUp();

		}

		else {
			// if the node is not the leaf, traverse the same way in the original game
			node = (DefaultBinaryTreeNode<String>) node.getRightChild();

			view.getQuestion().setText((String) node.getData());

		}

	}

}
