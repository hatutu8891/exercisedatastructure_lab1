/**
 * 
 */
package lab3;

import java.util.Arrays;

/**
 * This is the class implement linear search and binary search. 
 * This class has 8 method(include main method).
 * 
 * @author hp
 *
 */
public class MyArray {
	private int[] array;

	/**
	 * This is the constructor of MyArray class.
	 * 
	 * @param array
	 */
	public MyArray(int[] array) {
		super();
		this.array = array;
	}

	// To find the index of the target in the array. If the target is not found in
	// the array, then the method returns -1.
	// Input: int[] array ={12, 10, 9, 45, 2, 10, 10, 45} , 45
	// Output: 3
	public int iterativeLinearSearch(int target) {
		for (int i = 0; i < array.length; i++) {
			if (target == array[i]) {
				return i;
			}
		}

		return -1;
	}

	// To find the index of the target in the array. If the target is not found in
	// the array, then the method returns -1.
	// Input: int[] array ={12, 10, 9, 45, 2, 10, 10, 45} , 15
	// Output: -1
	public int recursiveLinearSearch(int target) {
//		
		return recursiveLinearSearch(array, target, 0);
	}

	// This method is support method to recursiveBinarySearch method
	public int recursiveLinearSearch(int[] newArray, int target, int index) {
		if (index >= newArray.length) {
			return -1;
		}
		if (newArray[index] == target) {
			return index;
		}
		return recursiveLinearSearch(newArray, target, index + 1);

	}

	// Here's the code to sort the array.
	// This method is support method to recursiveBinarySearch and
	// iterativeBinarySearch method
	public int[] sortArray() {
		int temp = 0;
		for (int i = 1; i < array.length; i++) {
			for (int j = 0; j < i; j++) {
				if (array[i] < array[j]) {
					temp = array[i];
					array[i] = array[j];
					array[j] = temp;
				}
			}
		}
		return array;
	}

	// To find the index of the target in the sorted array. If the target is not
	// found in the array, then the method returns -1.
	public int iterativeBinarySearch(int target) {
		int low = 0, mid = 0;
		int high = array.length - 1;

		MyArray ma = new MyArray(array);
		int[] newArray = ma.sortArray();

		while (low < high) {
			mid = (low + high) / 2;
			if (target == newArray[mid]) {
				return mid;
			} else if (target > newArray[mid]) {
				low = mid + 1;
			} else {
				high = mid - 1;
			}
		}

		return -1;
	}

	// To find the index of the target in the sorted array. If the target is not
	// found in the array, then the method returns -1.
	public int recursiveBinarySearch(int target) {

		return recursiveBinarySearch(target, 0, array.length - 1);

	}

	// This method is support method to recursiveBinarySearch method
	public int recursiveBinarySearch(int target, int low, int high) {
		MyArray ma = new MyArray(array);
		int[] newArray = ma.sortArray();

		if (low > high) {
			return -1;
		} else {
			int mid = (low + high) / 2;
			if (newArray[mid] == target) {
				return mid;
			} else if (newArray[mid] < target) {
				return recursiveBinarySearch(target, mid + 1, high);
			} else {
				return recursiveBinarySearch(target, low, mid - 1);
			}
		}
	}

	// This is the main method
	public static void main(String[] args) {

		// This is the testcase of iterativeLinearSearch method
		int[] array1 = { 12, 10, 9, 45, 2, 10, 10, 45 };
		int target1 = 10;
		MyArray ma1 = new MyArray(array1);
		int result1 = ma1.iterativeLinearSearch(target1);
		System.out.println("The location of number " + target1 + " in array " + Arrays.toString(array1)
				+ " when use iterativeLinearSearch method is: " + result1);

		// This is the testcase of iterativeLinearSearch method
		int[] array1_1 = { 2, 9, 10, 10, 10, 12, 45, 45 };
		int target1_1 = 15;
		MyArray ma1_1 = new MyArray(array1_1);
		int result1_1 = ma1_1.iterativeLinearSearch(target1_1);
		System.out.println("The location of number " + target1_1 + " in array " + Arrays.toString(array1_1)
				+ " when use iterativeLinearSearch method is: " + result1_1);

		// This is the testcase of recursiveLinearSearch method
		int[] array2 = { 12, 10, 9, 45, 2, 10, 10, 45 };
		int target2 = 12;
		MyArray ma2 = new MyArray(array2);
		int result2 = ma2.recursiveLinearSearch(target2);
		System.out.println("The location of number " + target2 + " in array " + Arrays.toString(array2)
				+ " when use recursiveLinearSearch method is: " + result2);

		// This is the testcase of recursiveLinearSearch method
		int[] array2_1 = { 2, 9, 10, 10, 10, 12, 45, 45 };
		int target2_1 = 5;
		MyArray ma2_1 = new MyArray(array2_1);
		int result2_1 = ma2_1.recursiveLinearSearch(target2_1);
		System.out.println("The location of number " + target2_1 + " in array " + Arrays.toString(array2_1)
				+ " when use recursiveLinearSearch method is: " + result2_1);

		// This is the testcase of iterativeBinarySearch method
		int[] array3 = { 12, 10, 9, 45, 2, 10, 10, 45 };
		int target3 = 45;
		MyArray ma3 = new MyArray(array3);
		int result3 = ma3.iterativeBinarySearch(target3);
		System.out.println("The location of number " + target3 + " in array " + Arrays.toString(array3)
				+ " when use iterativeBinarySearch method is: " + result3);

		// This is the testcase of iterativeBinarySearch method
		int[] array3_1 = { 2, 9, 10, 10, 10, 12, 45, 45 };
		int target3_1 = -45;
		MyArray ma3_1 = new MyArray(array3_1);
		int result3_1 = ma3_1.iterativeBinarySearch(target3_1);
		System.out.println("The location of number " + target3_1 + " in array " + Arrays.toString(array3_1)
				+ " when use iterativeBinarySearch method is: " + result3_1);

		// This is the testcase of recursiveBinaryrSearch method
		int[] array4 = { 12, 10, 9, 45, 2, 10, 10, 45 };
		int target4 = 0;
		MyArray ma4 = new MyArray(array4);
		int result4 = ma4.recursiveBinarySearch(target4);
		System.out.println("The location of number " + target4 + " in array " + Arrays.toString(array4)
				+ " when use recursiveBinarySearch method is: " + result4);

		// This is the testcase of recursiveBinaryrSearch method
		int[] array4_1 = { 2, 9, 10, 10, 10, 12, 45, 45 };
		int target4_1 = 2;
		MyArray ma4_1 = new MyArray(array4_1);
		int result4_1 = ma4_1.recursiveBinarySearch(target4_1);
		System.out.println("The location of number " + target4_1 + " in array " + Arrays.toString(array4_1)
				+ " when use recursiveBinarySearch method is: " + result4_1);
	}

}
