/**
 *
 * List interface for simplest ADT of sequentially stored data with changing
 * length.
 * 
 * @author astjohn
 *
 *
 * 
 */
package datastructures;

public interface List<T> {

	/**
	 * Add (insert) data at specific index in list, e.g., add( 0, data ) inserts
	 * data to front/head of list
	 * @param index int
	 * @param data T
	 **/
	public void add(int index, T data);

	/**
	 * Get data stored at specific index in list.
	 * @param index int
	 * @return data T
	 **/
	public T get(int index);

	
	/**
	 * Delete data at specific index in list, e.g., delete( 0 ) removes the
	 * first element from the list
	 * @param index int
	 **/
	public void delete(int index);

	/**
	 * Get the number of elements in this list.
	 * @return size int
	 **/
	public int size();

	/**
	 * Check if the list is empty.
	 * @return boolean
	 * 
	 **/
	public boolean isEmpty();
}