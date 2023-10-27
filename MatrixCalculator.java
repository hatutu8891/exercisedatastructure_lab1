/**
 * 
 */
package lab5;

import java.util.Arrays;

/**
 * TASK 1 : BASIC PROBLEMS This is the class to implement a algorthims to
 * 
 * calculate 2 matrices. This class contain 4 method to implement 4 algorthims
 * adding 2 matrices, subtracting 2 matrices, multiplying 2 matrices,
 * transposing matrix.
 * 
 * @author hp
 *
 */
public class MatrixCalculator {

	// Task 1.1 : Adding 2 matrices
	// add 2 matrices.
	public static int[][] add(int[][] a, int[][] b) throws IndexOutOfBoundsException {
		int result[][] = new int[a.length][a[0].length];
		// Condition to add 2 matrices is the rows of both are equals and elements in
		// each row are equals.
		// A solution has not been given for the elements in each row to be equal.
		if (a.length == b.length && a[0].length == b[0].length && a[a.length - 1].length == b[b.length - 1].length) {
			for (int i = 0; i < result.length; i++) {
				for (int j = 0; j < result[i].length; j++) {
					result[i][j] = a[i][j] + b[i][j];

				}
			}
			return result;
		} else
			throw new ArrayIndexOutOfBoundsException("ERROR: THE ELEMENTS IN MATRIX IS NOT FULL."); // Catching
																									// exceptions

	}

	// Task 1.2 : Subtracting 2 matrices
	// subtract 2 matrices
	public static int[][] subtract(int[][] a, int[][] b) throws IndexOutOfBoundsException {
		int result[][] = new int[a.length][a[0].length];
		// Condition to subtract 2 matrices is the rows of both are equals and elements
		// in
		// each row are equals.
		// A solution has not been given for the elements in each row to be equal.
		if (a.length == b.length && a[0].length == b[0].length && a[a.length - 1].length == b[b.length - 1].length) {
			for (int i = 0; i < result.length; i++) {
				for (int j = 0; j < result[i].length; j++) {
					result[i][j] = a[i][j] - b[i][j];
				}
			}
			return result;
		} else
			throw new ArrayIndexOutOfBoundsException("ERROR: THE ELEMENTS IN MATRIX IS NOT FULL."); // Catching
																									// exceptions

	}

	// Task 1.3 : Multiplying 2 matrices
	// multiply 2 matrices
	public static int[][] multiply(int[][] a, int[][] b) throws IndexOutOfBoundsException {

		// The result matrix has the rows equal the rows of matrix a and the column
		// equal the elements of each row in matrix b.
		int result[][] = new int[a.length][b[0].length];

		if (a[0].length == b.length) { // The condition to multiply 2 matrices are the elements of each row in matrix a
										// equal with the rows of matrix b
			for (int k = 0; k < result.length; k++) {
				for (int i = 0; i < b[0].length; i++) {
					for (int j = 0; j < a[0].length; j++) {
						result[k][i] += a[k][j] * b[j][i];

					}
				}
			}
			return result;
		} else
			throw new ArrayIndexOutOfBoundsException("ERROR: 2 MATRICES TO MULTIPLY DO NOT SATISFY THE CONDITION.");// Catching
																													// exceptions

	}

	// Task 1.4 : Tranpose a given matrix
	// tranpose a matrix
	public static int[][] transpose(int[][] a) {
		int result[][] = new int[a[0].length][a.length];
		for (int i = 0; i < a[0].length; i++) {
			for (int j = 0; j < a.length; j++) {
				result[i][j] = a[j][i];
			}
		}

		return result;
	}

	//This is the main method of this class
	public static void main(String[] args) {

		// This is the testcase of add method
		int[][] array1 = { { 1, 2, 3, 4 }, { 4, 6, 2, -5 }, { 8, 3, 5, 0 } };
		int[][] array2 = { { 10, 6, 2, -10 }, { 4, 12, 1, 22 }, { 4, 9, 3, 6 } };
		int[][] result1 = add(array1, array2);
		System.out.println("Here's the result of add 2 matrices: " + '\n' + Arrays.deepToString(result1));

		// This is the testcase of subtract method
		int[][] array3 = { { 1, 2, 3 }, { 4, 6, 2 }, { 8, 3, 5 } };
		int[][] array4 = { { 10, 6, 2 }, { 4, 12, 1 }, { 4, 9, 3 } };
		int[][] result2 = subtract(array3, array4);
		System.out.println("Here's the result of subtract 2 matrices: " + '\n' + Arrays.deepToString(result2));

		// This is the testcase of multiply method
		int[][] array5 = { { 2, 3 }, { 1, 1 }, { 2, 1 } };
		int[][] array6 = { { 1, 2, 3 }, { 3, 1, 2 } };
		int[][] result3 = multiply(array5, array6);
		System.out.println("Here's the result of multiply 2 matrices: " + '\n' + Arrays.deepToString(result3));

		// This is the testcase of transpose method
		int[][] array7 = { { 11, 4, 9, 23 }, { 2, 8, 21, 0 }, { 1, 3, 15, -2 } };
		int[][] result4 = transpose(array7);
		System.out.println("Here's the matrix after transpose : " + '\n' + Arrays.deepToString(result4));

	}

}
