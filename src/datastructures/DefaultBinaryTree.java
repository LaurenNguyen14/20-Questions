/**
 * This class implements a Binary Tree
 * 
 * @author LN Nov 27
 * @param <T>
 */
package datastructures;
public class DefaultBinaryTree<T> implements BinaryTree<T> {
	private LinkedList<T> list;
	protected BinaryTreeNode<T> root;

	public DefaultBinaryTree() {

	}

	/**
	 * Method that gets the root of the tree
	 * 
	 * @return root
	 */
	public BinaryTreeNode<T> getRoot() {
		if (root == null)
			return null;
		return this.root;
	}

	/**
	 * Method that set the root
	 * 
	 * @param root
	 *            BinaryTreeNode
	 */
	public void setRoot(BinaryTreeNode<T> root) {
		this.root = root;
	}

	/**
	 * Method that check if the tree is empty
	 * 
	 * @return root==null
	 */
	public boolean isEmpty() {
		return root == null;
	}

	/**
	 * Method that traverse the tree in order
	 * 
	 * @return list LinkedList
	 */
	public LinkedList<T> inorderTraversal() {
		list = new LinkedList<T>();
		inorderTraversal(root, list);
		return list;

	}

	/**
	 * Method that carry out the process of traversing in order
	 * 
	 * @param node
	 *            BinaryTreeNode
	 * @param traversal
	 *            LinkedList
	 */
	private void inorderTraversal(BinaryTreeNode<T> node, LinkedList<T> traversal) {

		if (node != null) {
			{
				// traverse through the left-most leaf
				// recursively add node from left to root, to right of the tree to the list
				inorderTraversal(node.getLeftChild(), traversal);
				traversal.add(traversal.size(), node.getData());
				inorderTraversal(node.getRightChild(), traversal);

			}
		}
	}

	/**
	 * Method that return a list which is traversed preorderly
	 * 
	 * @return list LinkedList
	 */
	public LinkedList<T> preorderTraversal() {
		list = new LinkedList<T>();
		preorderTraversal(root, list);
		return list;
	}

	/**
	 * Method that carries out the process of preorder traversal
	 * 
	 * @param node
	 *            BinaryTreeNode
	 * @param traversal
	 *            LinkedList
	 */
	private void preorderTraversal(BinaryTreeNode<T> node, LinkedList<T> traversal) {

		if (node != null) {

			/*
			 * recursively add value of nodes from root, to left, to right of tree into the
			 * list
			 */

			traversal.add(traversal.size(), node.getData());
			preorderTraversal(node.getLeftChild(), traversal);

			preorderTraversal(node.getRightChild(), traversal);

		}
	}

	/**
	 * Method that returns a list which has been traversed postorderly
	 * 
	 * @return list LinkedList
	 */
	public LinkedList<T> postorderTraversal() {
		list = new LinkedList<T>();
		postorderTraversal(root, list);
		return list;
	}

	/**
	 * Method that carries out the process of post order Traversal
	 * 
	 * @param node
	 *            BinaryTreeNode
	 * @param traversal
	 *            LinkedList
	 */
	private void postorderTraversal(BinaryTreeNode<T> node, LinkedList<T> traversal) {
		if (node != null) {

			/*
			 * recursively add value of nodes from down left, right then root of tree to
			 * list
			 */
			postorderTraversal(node.getLeftChild(), traversal);
			postorderTraversal(node.getRightChild(), traversal);
			traversal.add(traversal.size(), node.getData());

		}
	}

	/**
	 * Main method that manually create a binary tree
	 * 
	 * @param args
	 *            String array
	 */
	public static void main(String[] args) {
		DefaultBinaryTree<String> tree = new DefaultBinaryTree<>();

		DefaultBinaryTreeNode<String> happy = new DefaultBinaryTreeNode<>();
		happy.setData("happy");
		DefaultBinaryTreeNode<String> doc = new DefaultBinaryTreeNode<>();
		doc.setData("doc");
		DefaultBinaryTreeNode<String> sleepy = new DefaultBinaryTreeNode<>();
		sleepy.setData("sleppy");
		DefaultBinaryTreeNode<String> bashful = new DefaultBinaryTreeNode<>();
		bashful.setData("bashful");
		DefaultBinaryTreeNode<String> grumpy = new DefaultBinaryTreeNode<>();
		grumpy.setData("grumpy");
		DefaultBinaryTreeNode<String> sneezy = new DefaultBinaryTreeNode<>();
		sneezy.setData("sneezy");

		tree.setRoot(happy); // root of tree is "happy"

		happy.setLeftChild(doc);
		doc.setLeftChild(bashful);
		doc.setRightChild(grumpy);

		happy.setRightChild(sleepy);
		sleepy.setRightChild(sneezy);

		System.out.println("In order traversal : " + " " + tree.inorderTraversal());
		System.out.println("Preorder traversal" + ":" + " " + tree.preorderTraversal());
		System.out.println("Post order traversal" + ":" + " " + tree.postorderTraversal());

	}

}
