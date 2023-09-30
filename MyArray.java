/**
 * 
 */
package lab1;

import java.util.Arrays;

/**
 * This is a class to solve some common problem related to one dimensional
 * arrays. The class include 6 method to solve 4 different problem. 
 * This class is demonstrates task1 in lab1.
 * 
 * @author hp
 *
 */
public class MyArray {
	private int[] array;

	// This is the constructor of class MyArray. The constructor have 1 input.
	public MyArray(int[] array) {
		super();
		this.array = array;
	}

	
	// Method mirror that outputs the contents of an array in a reverse order like a mirror
	//  
	//Example: 
	//Input: 1, 2, 3 
	//Output: 1, 2, 3, 3, 2, 1
	 
	public int[] mirror() {
		int[] result = new int[this.array.length * 2];
		for (int i = 0; i < array.length; i++) {
			result[i] = array[i];
			result[result.length - 1 - i] = array[i];
		}

		return result;
	}

	
	// Method countDuplicate that count the number is duplicate. This method is
	//support to method removeDuplicates.
	  
	// But I think this method has problem. Because if I try with an array that is
	//too long, method removeDuplicates will give wrong results.
	 
	public int countDuplicate(int[] array) {
		int count = 0;
		for (int i = 1; i < array.length; i++) {
			for (int j = 0; j < i; j++) {
				if (array[i] == array[j]) {
					count += 1;
				}
			}
		}
		return count;
	}


	// Method removeDuplicates that removes all duplicate elements from an array and
	// returns a new array 
	// Example: 
	// Input: 1 3 5 1 3 7 9 8 
	// Output: 1 3 5 7 9 8
	 
	public int[] removeDuplicates() {

		// Create the count value of the class MyArray.
		// Because method countDuplicate and removeDuplicates isn't static.
		MyArray count = new MyArray(array);
		int countDup = count.countDuplicate(array);

		int[] result = new int[this.array.length - countDup];// Element of result equal the length of array minus the
																// element duplicate
		result[0] = array[0];
		int n = 1; // declare the value is index of the result.

		for (int i = 1; i < array.length; i++) {
			for (int j = 0; j < i && n < result.length; j++) {
				if (array[i] != array[j]) {

					if (j == i - 1) { // This line is very necessary.Without it the result has the duplicate number.
										// Example I{1,3,5,7,9}; O{1,3,5,5,7,7,7,9,9,9,9).

						result[n] = array[i];
						n++;
					}
				} else {
					break;
				}

			}
		}
		return result;
	}

	// Method countNumberMissing is count the missing number in consucative number
	// array.
	public int countNumberMissing(int[] array) {
		int countNumMissing = 0;// Declare a value to count the number is missing in consucative number array.
		int numMissing = 0;
		for (int i = 1; i < array.length; i++) {
			if (array[i] - array[i - 1] != 1) {
				numMissing = array[i] - array[i - 1] - 1;
				countNumMissing += numMissing;
			}
		}
		return countNumMissing;
	}


	// Method getMissingValues that determine missing values from a sorted array.
	// Example: 
	// Input: 10 11 12 13 14 16 17 19 20 
	// Output: 15 18
	 
	public int[] getMissingValues() {

		// Create the count value of the class MyArray.
		// Because method countNumberMissing and getMissingValues isn't static.
		MyArray missingValue = new MyArray(array);
		int countNumMissing = missingValue.countNumberMissing(array);

		int[] result = new int[countNumMissing];
		int n = 0;// declare the value is index of the result.

		for (int i = 1; i < array.length; i++) {
			if (array[i] - array[i - 1] != 1) {
				int numlarger = array[i] - array[i - 1];
				for (int j = 1; j < numlarger; j++) {
					result[n] = array[i - 1] + j;
					n++;
				}
			}
		}

		return result;
	}

	
	// Method fillMissingValues that fill missing data by the minimal average of its
	// k neighbors 
	// Example: 
	// Input: 10 11 12 -1 14 16 17 19 20 
	// Output(k =3) : 10 11 12 12 14 16 17 19 20
	 
	public int[] fillMissingValues(int k) {
		int[] result = new int[array.length];
		for (int i = 0; i < array.length; i++) {
			if (array[i] > 0) {
				result[i] = array[i];
			} else {
				if (i == 0) {
					result[i] = array[i + 1];

				} else if (i == array.length - 1) {
					result[i] = array[array.length - 2];
				} else {
					if (k % 2 == 0) {
						int num = 0, sum = 0;
						for (int j = k / 2; j > 0; j--) {
							if (i - j >= 0 && i + j < array.length) {
								sum += array[i - j] + array[i + j];
							}
						}
						num = sum / k;
						result[i] = num;

					} else {
						int num = 0, sum = array[i - k / 2 - 1];
						for (int j = k / 2; j > 0; j--) {
							if (i - j >= 0 && i + j < array.length) {
								sum += array[i - j] + array[i + j];
							}
						}
						num = sum / k;
						result[i] = num;
					}

				}
			}
		}
		return result;
	}

	
	 //This is the main method.
	public static void main(String[] args) {

		// This is the testcase of method mirror.
		int[] array1 = { 1, 2, 3 };
		MyArray ma1 = new MyArray(array1);
		int[] result1 = ma1.mirror();
		System.out.println("The array printed from mirror method: " + Arrays.toString(result1));

		// This is the testcase of method removeDuplicates.
		int[] array2 = { 1, 3, 5, 1, 3, 7, 9, 8 };
		MyArray ma2 = new MyArray(array2);
		int[] result2 = ma2.removeDuplicates();
		System.out.println("The array printed from removeDuplicate method: " + Arrays.toString(result2));

		// This is the testcase of method getMissingValues.
		int[] array3 = { 10, 11, 12, 13, 14, 16, 17, 19, 20 };
		MyArray ma3 = new MyArray(array3);
		int[] result3 = ma3.getMissingValues();
		System.out.println("The array printed from getMissingValues method: " + Arrays.toString(result3));

		// This is the testcase of method fillMissingValues.
		int[] array4 = { 10, 11, 12, -1, 14, 16, 17, 19, 20 };
		MyArray ma4 = new MyArray(array4);
		int[] result4 = ma4.fillMissingValues(3); // k=3
		System.out.println("The array printed from fillMissingValues method: " + Arrays.toString(result4));

	}

}
