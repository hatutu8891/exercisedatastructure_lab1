/**
 * 
 */
package lab6;

import java.util.Arrays;

/**
 * TASK 1 : MYARRAYLIST
 * 
 * This is the class to implement some basic method of own ArrayList
 * @author hp
 *
 */
public class MyArrayList<E> {
	public static final int DEFAULT_CAPACITY = 10;
	private E[] elements;
	private int size;

	public MyArrayList() {
		this.elements = (E[]) new Object[DEFAULT_CAPACITY];
	}

	public MyArrayList(int capacity) {
		this.elements = (E[]) new Object[capacity];
	}

	// creates an array of double-size if the array of elements is full.
	public void growSize() {
		if (size == elements.length) {
			this.elements = (E[]) new Object[2 * DEFAULT_CAPACITY];
		}

	}

	// Returns the number of elements in this list.
	public int size() {
		int count = 0;
		for (int i = 0; i < elements.length; i++) {
			if (elements[i] != null) {
				count++;
			}
		}

		return count;
	}

	// Returns whether the list is empty.
	public boolean isEmpty() {
		return size() == 0;

	}

	// Returns (but does not remove) the element at index i.
	public E get(int i) throws IndexOutOfBoundsException {
		if (i < 0 || i > size() - 1)
			throw new ArrayIndexOutOfBoundsException("ERROR: THE NUMBER IS OUT OF INDEX");

		else {
			return elements[i];
		}

	}

	// Replaces the element at index i with e, and returns the replaced element.
	public E set(int i, E e) throws IndexOutOfBoundsException {
		if (i < 0 || i > size() - 1)
			throw new ArrayIndexOutOfBoundsException("ERROR: THE NUMBER IS OUT OF INDEX");
		else {
			elements[i] = e;
			return elements[i];
		}

	}

	// It is used to append the specified element at the end of a list.
	public boolean add(E e) {
		if (size < elements.length) {
			elements[size()] = e;
		} else {
			growSize();
			elements[size()] = e;
		}

		return true;
	}

	// Inserts element e to be at index i, shifting all subsequent elements later.
	public void add(int i, E e) throws IndexOutOfBoundsException {
		if (i < 0 || i > size() - 1)
			throw new ArrayIndexOutOfBoundsException("ERROR: THE NUMBER IS OUT OF INDEX");
		else {
			for (int j = size() - 1; j >= i; j--) {
				elements[j + 1] = elements[j];
			}
			elements[i] = e;
		}

	}

	// Removes and returns the element at index i, shifting subsequent elements
	// earlier.
	public E remove(int i) throws IndexOutOfBoundsException {
		if (i < 0 || i > size() - 1)
			throw new ArrayIndexOutOfBoundsException("ERROR: THE NUMBER IS OUT OF INDEX");
		else {
			for (int j = i; j < size() - 1; j++) {
				elements[i] = elements[i + 1];
			}
			elements[size() - 1] = null;
		}
		return elements[i];
	}

	// It is used to clear all elements in the list.
	public void clear() {
		for (int i = 0; i < size(); i++) {
			elements[i] = null;
		}
		size = 0;
	}

	// It is used to return the index in this list of the last occurrence of the
	// specified element, or -1 if the list does not contain this element.
	public int lastIndexOf(Object o) {
		int index = -1;
		for (int i = 0; i < size(); i++) {
			if (elements[i] == o) {
				index = i;
			}
		}
		return index;
	}

	// It is used to return an array containing all of the elements in this list in
	// the correct order.
	public E[] toArray() {
		E[] result = (E[]) new Object[size()];
		for (int i = 0; i < result.length; i++) {
			result[i] = elements[i];
		}

		return result;
	}

	// It is used to return a shallow copy of an ArrayList.
	public MyArrayList<E> clone() {
		MyArrayList<E> result = new MyArrayList<>();
		result.elements = Arrays.copyOf(elements, size());
		result.size = size;
		return result;
	}

	// It returns true if the list contains the specified element.
	public boolean contains(E o) {
		for (int i = 0; i < size(); i++) {
			return elements[i] == o;
		}

		return false;
	}

	// It is used to return the index in this list of the first occurrence of the
	// specified element, or -1 if the List does not contain this element.
	public int indexOf(E o) {
		for (int i = 0; i < size(); i++) {
			if (elements[i] == o) {
				return i;
			}
		}
		return -1;
	}

	// It is used to remove the first occurrence of the specified element.
	public boolean remove(E o) {
		for (int i = 0; i < size(); i++) {
			if (elements[i] == o) {
				for (int j = i; j < size(); j++) {
					elements[i] = elements[i + 1];
				}
				return true;
			}

		}
		return false;
	}

	// It is used to sort the elements of the list on the basis of specified
	// comparator.
	public void sort(Comparable<E> c) {
		for (int i = 1; i < size(); i++) {
			E key = elements[i];
			int j = i - 1;

			while (j >= 0 && c.compareTo(elements[j]) > 0 && c.compareTo(key) > 0) {
				elements[j + 1] = elements[j];
				j--;
			}

			elements[j + 1] = key;
		}
	}

	// It is the main method of class
	public static void main(String[] args) {

		MyArrayList<Integer> myArray = new MyArrayList<>();

		// This is the testcase of add(E e) method
		myArray.add(10);
		myArray.add(20);
		myArray.add(30);
		myArray.add(40);
		myArray.add(50);
		
		System.out.println("The element of array is: ");
		for (int i = 0; i < myArray.size(); i++) {
			System.out.println(myArray.get(i));
		}

		// This is the testcase of size() method
		System.out.println("The size of array: " + myArray.size());

		// This is the testcase of get() method
		int i1 = 3;
		System.out.println("The element in " + i1 + " index is: " + myArray.get(i1));

		// This is the testcase of isEmpty method
		System.out.println("The array is empty: " + myArray.isEmpty());

		// This is the testcase of set method
		int i2 = 2;
		System.out.println("Replaces element in " + i2 + " index by: " + myArray.set(i2, 25));

		// This is the testcase of add(index, e) method
		myArray.add(3, 30);
		System.out.println("The element of array is: ");
		for (int i = 0; i < myArray.size(); i++) {
			System.out.println(myArray.get(i));
		}

		// This is the testcase of remove(i) method
		int i3 = 2;
		myArray.remove(i3);
		System.out.println("The array after remove element in " + i3 + " index is: ");
		for (int i = 0; i < myArray.size(); i++) {
			System.out.println(myArray.get(i));
		}

		// This is the testcase of toArray() method
		System.out.println(Arrays.toString(myArray.toArray()));

		// This is the testcase of lastIndexOf method
		int value = 30;
		System.out.println("The index of the last value you are looking is: " + myArray.lastIndexOf(value));

		// This is the testcase of clone method
		MyArrayList<Integer> list1 = new MyArrayList<>();
		list1 = myArray.clone();
		System.out.println("The element of array after used the clone method is: ");
		for (int i = 0; i < myArray.size(); i++) {
			System.out.println(myArray.get(i));
		}

		// This is the method of contains method
		int value1 = 10;
		System.out.println("Is the array has " + value1 + " in the array: " + myArray.contains(value1));

		// This is the testcase of indexOf method
		int value2 = 30;
		System.out.println("The index of the first value you are looking is: " + myArray.indexOf(value2));

		// This is the testcase of remove(e) method
		int value3 = 5;
		System.out.println("Is remove the element " + value3 + " in the array: " + myArray.remove(value3));
		for (int i = 0; i < myArray.size(); i++) {
			System.out.println(myArray.get(i));
		}
		
		

		// This is the testcase of clear method
		MyArrayList<Integer> myArray1 = new MyArrayList<>();
		myArray1.add(10);
		myArray1.add(20);
		myArray1.add(30);
		myArray1.add(40);
		myArray1.add(50);
		System.out.println("The size of array before clear: " + myArray1.size());

		myArray1.clear();
		System.out.println("The size of array after clear: " + myArray1.size());
	}

}
