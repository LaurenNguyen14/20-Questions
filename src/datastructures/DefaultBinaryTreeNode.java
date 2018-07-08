/**
 * Class that implement BinaryTreeNode
 * 
 * @author LN
 *
 * @param <T>
 */
package datastructures;
public class DefaultBinaryTreeNode<T> implements BinaryTreeNode<T> {
	private T data;
	private BinaryTreeNode<T> left, right;

	/**
	 * Method the gets the data
	 * 
	 * @return data T
	 */
	public T getData() {
		return data;

	}

	/**
	 * Method that sets the data
	 * 
	 * @param data
	 *            T
	 */
	public void setData(T data) {
		this.data = data;

	}

	/**
	 * Method the get the left child of tree
	 * 
	 * @return left BinaryTreeNode
	 */
	public BinaryTreeNode<T> getLeftChild() {
		return left;
	}

	/**
	 * Method that get the right child of tree
	 * 
	 * @return right BinaryTreeNode
	 */
	public BinaryTreeNode<T> getRightChild() {
		return right;
	}

	/**
	 * Method that set a node to the left of a tree
	 * 
	 * @param left
	 *            BinaryTreeNode
	 */
	public void setLeftChild(BinaryTreeNode<T> left) {
		this.left = left;
	}

	/**
	 * Method that set a node to the right of a tree
	 * 
	 * @param right
	 *            BinaryTreeNode
	 */
	public void setRightChild(BinaryTreeNode<T> right) {
		this.right = right;

	}

	/**
	 * Method that checks if the Node is a leaf
	 * 
	 * @return false if it is not
	 */
	public boolean isLeaf() {
		if (left == null && right == null)
			return true;
		return false;
	}
}
