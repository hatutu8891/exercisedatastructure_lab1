/**
 * 
 */
package lab6;

/**
 * TASK 2: MYLINKEDLIST
 * This is the class to implement some basic method of own LinkedList
 * @author hp
 *
 */
public class Node<E> {//Generic
	private E data;
	private Node<E>next;
	
	/**
	 * This is the constructor of class Node. This has 1 attribute is:
	 * @param data
	 */
	public Node(E data) {
		this.data = data;
	}

	/**
	 * This is the constructor of class Node. This has 2 attribute is:
	 * @param data
	 * @param next
	 */
	public Node(E data, Node<E> next) {
		super();
		this.data = data;
		this.next = next;
	}

	/**
	 * @return the data
	 */
	public E getData() {
		return data;
	}

	/**
	 * @return the next
	 */
	public Node<E> getNext() {
		return next;
	}

	/**
	 * @param next the next to set
	 */
	public void setNext(Node<E> next) {
		this.next = next;
	}
	
	
	
	
	

}
