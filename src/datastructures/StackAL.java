package datastructures;
public class StackAL<T> implements Stack<T> {
	private List<T> list;

	/**
	 * Constructor
	 */
	public StackAL() {
		list = new ArrayList<T>();
	}

	/**
	 * method that pushes the data on top
	 * @param data T
	 */
	public void push(T data) {
		list.add(0, data);

	}

	/**
	 * Removes the top of the stack and returns it.
	 * 
	 * @return the popped data
	 */
	public T pop() {
		T data = list.get(0);
		list.delete(0);

		return data;
	}

	/**
	 * Gets the element at the top of the stack without removing it.
	 * 
	 * @return the peeked data
	 */
	public T peek() {
		T data = list.get(0);
		return data;
	}

	/**
	 * Tests if the stack is empty.
	 * 
	 * @return true if the stack is empty
	 */
	public boolean isEmpty() {
		return list.isEmpty();
	}

}
