/**
 * 
 */
package lab4;

import java.util.Arrays;

/**
 * This is the class to implement basic sorting algorithms
 * 
 * @author hp
 *
 */
public class SortingAlgorithms {

	// Task 1.1 : selection sort
	// sort by descending order
	// Selection sort is sorting algorithms that find the smallest number in the
	// unsorted array.Then swap that smallest number with the number at first of
	// unsorted array and consider that number at first is the sorted subarray.
	// Continue with the rest unsorted subarray.
	public static void selectionSort(int[] array) {
		for (int i = 0; i < array.length - 1; i++) {
			int smallestNum = array[i];
			int index = i;
			for (int j = i + 1; j < array.length; j++) {
				if (array[j] < smallestNum) {
					smallestNum = array[j];
					index = j;
				}
			}
			swap(array, i, index);
		}
		System.out.println(Arrays.toString(array));
	}

	// Task 1.2 : bubble sort
	// sort by descending order
	// Bubble sort is sorting algorithms that compare 2 adjacent numbers in array.
	// Which numbers is smaller will come first.Continue until the end of the
	// array.Then repeat until all element in the array is sorted.
	public static void bubbleSort(int[] array) {
		for (int i = 0; i < array.length - 1; i++) {

			// condition minus i because the largest num in unsorted array is always moved
			// to the end of the unsorted array
			for (int j = 0; j < array.length - 1 - i; j++) {
				if (array[j] > array[j + 1]) {
					swap(array, j, j + 1);
				}
			}
		}
		System.out.println(Arrays.toString(array));
	}

	// Task 1.3 : insertion sort
	// sort by descending order
	// Insertion sort is sorting algorithms that consider the first number in array
	// is the sorted array.Then add one by one the number from unsorted array to
	// sorted array. The number added will stand in front of the number in sorted
	// array if that is smaller and stand behind it if that is larger.
	public static void insertionSort(int[] array) {
		for (int i = 1; i < array.length; i++) {
			for (int j = 0; j < i; j++) {
				if (array[i] < array[j]) {
					increseOneIndex(array, i, j);
				}
			}
		}
		System.out.println(Arrays.toString(array));

	}

	// This is the support method to sort the array.
	// This method to swap 2 number in 2 another index.
	public static void swap(int[] array, int i, int j) {
		int temp = 0;
		temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}

	// This is the support method of insertionSort method.
	// increseOneIndex method is move each number (after index need to insert the
	// number already sorted) up 1 index
	//
	// Example: arr={1,2,4,5,6,7}; Please enter 1 number to complete the consecutive
	// number array.
	// We need to insert the number 3 between 2 and 4, so that we move 7 up 1 index,
	// 6 up 1 index, 5 up 1 index, 4 up 1 index
	// Then we has vacant position between 2 and 4, we just add number 3 in that
	// vacant position to complete the consecutive number array.
	// Result : arr={1,2, ,4,5,6,7} =="add 3"==> arr={1,2,3,4,5,6,7};

	public static void increseOneIndex(int[] array, int i, int j) {
		int temp = array[i];
		for (int index = i - 1; index >= j; index--) {
			array[index + 1] = array[index];
		}
		array[j] = temp;
	}

	public static void main(String[] args) {
		// This is the testcase of selectionSort method
		int[] array1 = { 6, 3, 5, 6, 47, 8, 5, 5, 4, 2 };
		System.out.println("This is the array after sort by selection sort algorithms: ");
		selectionSort(array1);

		// This is the testcase of bubbleSort method
		int[] array2 = { 6, 3, 5, 6, 47, 8, 5, 5, 4, 2 };
		System.out.println("This is the array after sort by bubble sort algorithms: ");
		bubbleSort(array2);

		// This is the testcase of insertionSort method
		int[] array3 = { 6, 3, 5, 6, 47, 8, 5, 5, 4, 2 };
		System.out.println("This is the array after sort by insertion sort algorithms: ");
		insertionSort(array3);
	}
}
