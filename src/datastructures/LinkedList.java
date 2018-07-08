package datastructures;
public class LinkedList<T> implements List<T> {
	private LinkedListNode<T> head;

	/**
	 * Constructs an empty list
	 */
	public LinkedList() {

	}

	/**
	 * Helper method to access the node at index. If the index is invalid (negative
	 * or bigger or equal to size of list), return null pointer.
	 * 
	 * @param index
	 *            index of node
	 * @return current LinkedListNode
	 * 
	 **/
	public LinkedListNode<T> getNode(int index) {
		if (index < 0) {
			return null;
		}
		LinkedListNode<T> current = head;
		int i = 0;
		while (i < index && current != null) {
			i++;
			current = current.getNext();

		}
		return current;
	}

	/**
	 * add a node in the LinkedList
	 * 
	 * @param index
	 *            index of node
	 * @param data
	 *            T
	 * 
	 */
	public void add(int index, T data) {
		LinkedListNode<T> newNode = new LinkedListNode<T>();
		newNode.setData(data);
		if (index == 0) {
			// if the head is null, the added node will become the head
			if (head == null) {
				head = newNode;
			} else {
				// set a pointer at head connected to the newNode, the new node added at index 0
				// will become the head and shift the head
				newNode.setNext(head);
				head = newNode;

			}

		}

		else if (index > 0) {
			// get the previous node of an index
			LinkedListNode<T> prevNode = getNode(index - 1);

			if (prevNode != null) {
				// get the pointer of the previous node to the new node
				// previous is set to be the passed not of the new node
				newNode.setNext(prevNode.getNext());
				prevNode.setNext(newNode);

			}
		}
	}

	/*
	 * method that get the data of a node (non-Javadoc)
	 * 
	 * @see List#get(int)
	 * 
	 * @param index node index
	 * 
	 * @return data of the specific node
	 */

	public T get(int index) {
		// returns the element at the specified position in this list.
		LinkedListNode<T> thisNode = getNode(index);
		if (thisNode == null)
			return null;
		else {
			return thisNode.getData();
		}
	}

	/**
	 * Method that deletes data at an index
	 * 
	 * @param index
	 *            the index of the node
	 * 
	 */
	public void delete(int index) {
		// get the index of the node
		LinkedListNode<T> thisNode = getNode(index);

		// if delete element at index=0, the new head will be the node after the head
		if (index == 0) {
			head = head.getNext();
		}

		else if (index > 0) {
			// get the previous node of a node
			LinkedListNode<T> prevNode = getNode(index - 1);
			if (prevNode != null) {
				// delete current node by connecting the previous node to the node after the
				// current one
				prevNode.setNext(thisNode.getNext());
			} else {
				// if previous node is null, meaning this node is the head
				// set the head to the next node to delete the current head
				head = head.getNext();
			}

		}
	}

	/**
	 * Method that return the size of the list
	 * 
	 * @return size int
	 */
	public int size() {
		int size = 0;

		// loop from the head till current node is null, then we reach the end of the
		// list
		// return the size
		for (LinkedListNode<T> current = head; current != null; current = current.getNext())
			size++;
		return size;
	}

	/**
	 * Method that check if the list is empty
	 * 
	 * @return true if the list is empty
	 */
	public boolean isEmpty() {
		return head == null;
	}

	/**
	 * Method that return the string of the output data
	 * 
	 * @return element String
	 */

	public String toString() {
		String elem = "";

		for (LinkedListNode<T> current = head; current != null; current = current.getNext()) {
			elem = elem + current.getData().toString() + " , ";
		}
		return elem;

	}

}
