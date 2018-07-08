package datastructures;
public class LinkedListNode<T> {
	private T data;
	private LinkedListNode<T> next;

	/**
	 * Constructor
	 */
	public LinkedListNode() {

	}

	/**
	 * Set the data stored at this node.
	 * 
	 * @param data
	 *            T
	 */
	public void setData(T data) {
		this.data = data;

	}

	/**
	 * Get the data stored at this node.
	 * 
	 * @return data T
	 */
	public T getData() {
		return data;
	}

	/**
	 * Set the next pointer to passed node.
	 * 
	 * @param node
	 *            LinkedListNode
	 */
	public void setNext(LinkedListNode<T> node) {
		next = node;
	}

	/**
	 * Get (pointer to) next node.
	 * 
	 * @return next LinkedListNode
	 */
	public LinkedListNode<T> getNext() {
		return next;
	}

	/**
	 * Returns a String representation of this node.
	 * 
	 * @return data String
	 */
	public String toString() {
		return data.toString();
	}
}