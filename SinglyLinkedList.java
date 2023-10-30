/**
 * 
 */
package lab6;

/**
 * @author hp
 *
 */
public class SinglyLinkedList<E> {
	private Node<E> head = null;
	private Node<E> tail = null;
	private int size;

	/**
	 * 
	 */
	public SinglyLinkedList() {
		super();
	}

	// Returns the number of elements in the list
	public int size() {
		int count = 0;
		Node<E> currentNode = head;
		while (currentNode != null) {
			count++;
			currentNode = currentNode.getNext();
		}
		return count;
	}

	// Returns true if the list is empty, and false otherwise.
	public boolean isEmpty() {
		return size() == 0;
	}

	// Returns (but does not remove) the first element in the list.
	public E first() {
		if (isEmpty()) {
			return null;
		}
		return head.getData();
	}

	// Returns (but does not remove) the last element in the list.
	public E last() {
		if (isEmpty()) {
			return null;
		}
		return tail.getData();

	}

	// Adds a new element to the front of the list
	public void addFirst(E e) {
		Node<E> newNode = new Node<>(e);
		if (isEmpty()) {
			head = newNode;
			tail = newNode;
		} else {
			newNode.setNext(head);
			head = newNode;
		}
		size++;

	}

	// Adds a new element to the ent of the list
	public void addLast(E e) {
		Node<E> newNode = new Node<>(e);
		if (isEmpty()) {
			head = newNode;
			tail = newNode;
		} else {
			tail.setNext(newNode);
			tail = newNode;
		}
		size++;
	}

	// Removes and returns the first element of the list.
	public E removeFirst() {
		if (isEmpty()) {
			return null;
		}
		E removedData = head.getData();
		head = head.getNext();
		size--;
		if (isEmpty()) {
			tail = null;
		}
		return removedData;

	}

	// Removes and returns the last element of the list.
	public E removeLast() {
		if (isEmpty()) {
			return null;
		}
		E removedData = tail.getData();
		if (size == 1) {
			head = null;
			tail = null;
		} else {
			Node<E> currentNode = head;
			while (currentNode.getNext() != tail) {
				currentNode = currentNode.getNext();
			}
			currentNode.setNext(null);
			tail = currentNode;
		}
		size--;
		return removedData;
	}

	// This is the main method of this class
	public static void main(String[] args) {
		SinglyLinkedList<Integer> list = new SinglyLinkedList<>();

		// This is the testcase of addFirst method
		list.addFirst(5);
		list.addFirst(1);
		list.addFirst(3);

		// This is the testcase of addLast method
		list.addLast(10);
		list.addLast(15);
		list.addLast(20);

		// This is the testcase of size method
		System.out.println("The size of list is: " + list.size());

		// This is the testcase of isEmpty method
		System.out.println("The list is empty: " + list.isEmpty());

		// This is the testcase of first method
		System.out.println("The first element of list is: " + list.first());

		// This is the testcase of last method
		System.out.println("The last element of list is: " + list.last());

		// This is the testcase of removeFirst method
		System.out.println("The element at the first of list is removed : " + list.removeFirst());
		System.out.println("The first element of list after use removeFirst is: " + list.first());
		
		// This is the testcase of removeLast method
		System.out.println("The element at the last of list is removed : " + list.removeLast());
		System.out.println("The last element of list after use removeLast is: " + list.last());
	}
	

}
