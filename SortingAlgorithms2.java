/**
 * 
 */
package lab4;

import java.util.Arrays;
import java.util.Random;

/**
 * This is the class to implement divide and conquer approach
 * @author hp
 *
 */
public class SortingAlgorithms2 {
	
	// Merge method is support method of mergeSort method to conquer the subarray to array is sorted.
	public static int[] merge(int[] left, int[] right) {
		int k = 0;
		int i = 0;
		int j = 0;
		int[] resultArray = new int[left.length + right.length];
		while (i < left.length && j < right.length) {
			if (left[i] < right[j]) {
				resultArray[k] = left[i];
				i++;
			} else {
				resultArray[k] = right[j];
				j++;
			}
			k++;

		}
		while (i < left.length) {
			resultArray[k] = left[i];
			i++;
			k++;
		}
		while (j < right.length) {
			resultArray[k] = right[j];
			j++;
			k++;
		}
		return resultArray;
	}

	// Task 2.1 : Merge Sort
	// sort by descending order
	public static void mergeSort(int[] array) {
		if (array.length < 2) {
			return;
		}
		int mid = array.length / 2;
		// create 2 new array. Each new array is the subarray of original array.
		int[] left = new int[mid];
		int[] right = new int[array.length - mid];

		// Here is the code to divide and copy the original to 2 new array.
		for (int i = 0; i < mid; i++) {
			left[i] = array[i];
		}
		for (int j = mid; j < array.length; j++) {
			right[j - mid] = array[j];
		}
		mergeSort(left);
		mergeSort(right);
		int[] sortedArray = merge(left, right);
		for (int i = 0; i < sortedArray.length; i++) {
			array[i] = sortedArray[i];
		}

	}

	// Task 2.2 : Quick sort
	// sort by descending order
	public static void quickSort(int[] array) {
		if (array.length < 2) {
			return;
		}
		int pivot = getPivot_MedianOfThree(array);
		int countEqual = 0;
		int countLeft = 0;
		int countRight = 0;
		for (int i = 0; i < array.length; i++) {
			if (array[i] < pivot) {
				countLeft++;
			} else if (array[i] > pivot) {
				countRight++;
			} else {
				countEqual++;
			}
		}
		// create 2 new array. Each new array is the subarray of original array.
		int[] left = new int[countLeft + countEqual - 1];
		int[] right = new int[countRight];

		// Here is the code to divide and copy the original to 2 new array.
		int k = 0, j = 0;
		for (int i = 0; i < array.length; i++) {

			if (array[i] < pivot) {
				left[k] = array[i];
				k++;
			} else if (array[i] > pivot) {
				right[j] = array[i];
				j++;
			} else if (array[i] == pivot && countEqual != 1) {
				while (countEqual > 1) {
					left[k] = array[i];
					k++;
					countEqual--;
				}

			} else {
			}
		}
		quickSort(left);
		quickSort(right);
		
		 // Copy the elements from the left array, pivot, and right array back to the original array.
	    System.arraycopy(left, 0, array, 0, left.length);
	    for (int i = 0; i < countEqual; i++) {
	        array[left.length + i] = pivot;
	    }
	    System.arraycopy(right, 0, array, left.length + countEqual, right.length);
	}

	// select pivot element based on the median of three strategy
	private static int getPivot_MedianOfThree(int[] array) {
		int mid = array.length / 2;
		int medianNum = 0;
		if (array[0] < array[mid] && array[mid] < array[array.length - 1]) {
			medianNum = array[mid];
		} else if (array[mid] < array[0] && array[0] < array[array.length - 1]) {
			medianNum = array[0];
		} else {
			medianNum = array[array.length - 1];
		}
		return medianNum;
	}

	// select pivot element based on the first element in the array
	private static int getPivot_First(int[] array) {

		return 0;
	}

	// select pivot element based on the last element in the array
	private static int getPivot_Last(int[] array) {

		return array.length - 1;
	}

	// select pivot element based on choosing a randomly element in the array
	private static int getPivot_Random(int[] array) {
		Random random = new Random();
		int randomIndex = random.nextInt(array.length);
		int randomNumber = array[randomIndex];

		return randomNumber;
	}

	public static void main(String[] args) {
		// This is the testcase of mergeSort method
		int[] array1 = { 6, 3, 5, 6, 47, 8, 5, 5, 4, 2 };
		System.out.println("This is the array after sort by selection sort algorithms: ");
		mergeSort(array1);
		System.out.println(Arrays.toString(array1));

		// This is the testcase of quickSort method
		int[] array2 = { 6, 3, 5, 6, 47, 8, 5, 5, 4, 2 };
		System.out.println("This is the array after sort by selection sort algorithms: ");
		quickSort(array2);
		System.out.println(Arrays.toString(array2));
	}

}
