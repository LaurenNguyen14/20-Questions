package datastructures;
import java.util.Arrays;


/**
 * Array list, based on java's array class. Fewer methods than java's ArrayList
 *
 * @author Amy Tayloe
 */


public class ArrayList<T> implements List<T> {
	// Note for anyone looking: this isn't a good way to do Assignment 4. Please
	// do not use this
	// as an example for how to make a linked list. Also, I got lazy and didn't
	// make any inline
	// comments. Don't be like me.

	// Java can't use generics for array
	// but we want this to logically be T[] arr
	// we use casting to maintiain types, but have to be careful to only use T
	// elements!
	private Object[] arr;
	private int listSize;

	/**
	 * Constructor, creates a new list, assumes list starts empty
	 */
	public ArrayList() {
		arr = new Object[5];
		listSize = 0;

	}

	/**
	 * Return the element at the given index
	 *
	 * @param index
	 *            the index of the element to be returned
	 * @return the element at the given location or null if invalid index
	 */
	public T get(int index) {
		if (index < listSize) {
			return (T) arr[index];
		} else {
			throw new ArrayIndexOutOfBoundsException();
		}
	}

	/**
	 * Adds an element to the specified index in the list
	 *
	 * @param elt
	 *            the element to be added to the list
	 * @param index
	 *            the location to add the T
	 */
	public void add(int index, T elt) {
		if (arr.length < listSize + 2) {
			arr = Arrays.copyOf(arr, arr.length * 2);
		}
		if (arr[index] != null) {
			for (int i = arr.length - 1; i > index; i--) {
				arr[i] = arr[i - 1];
			}
		}
		arr[index] = elt;
		listSize++;
	}

	/**
	 * Removes an element from the specified index
	 *
	 * @param index
	 *            the index of the element to be removed
	 */
	public void delete(int index) {
		if (index < listSize) {
			T elt = (T) arr[index];
			arr[index] = null;
			for (int i = index; i < listSize; i++) {
				arr[i] = arr[i + 1];
				arr[i + 1] = null;
			}
			listSize--;
		} else {
			throw new ArrayIndexOutOfBoundsException();
		}

	}

	/**
	 * Gets the size of the list
	 *
	 * @return the length of the list
	 */
	public int size() {
		return listSize;
	}

	/**
	 * Determines if the list is empty or not
	 *
	 * @return true if the list is empty, false if it is not
	 */
	public boolean isEmpty() {
		return (listSize == 0);
	}

	/**
	 * Return a String representation of the list.
	 * 
	 * @return this list as a String, e.g., (a, b, c)
	 **/
	public String toString() {
		// maybe this could be done in a more useful way...
		return arr.toString();
	}

}