/**
 * 
 */
package lab2;

import java.util.Arrays;

/**
 * This is the class use recursive approach to implement Pascal's triangle
 * problem
 * 
 * 
 * @author hp
 *
 */
public class PascalTriangle {

	// This method is used to display a Pascal triangle based on the parameter n.
	// Where n represents the number of rows.
	public static void printPascalTriangle(int row) {

		for (int i = 0; i < row; i++) {
			for (int j = 0; j < row - i - 1; j++) {
				System.out.print(" ");
			}

			int[] currentRow = new int[i + 1];
			currentRow[0] = 1;

			for (int j = 1; j < i; j++) {
				currentRow[j] = currentRow[j - 1] * (i - j + 1) / j;
			}

			currentRow[i] = 1;

			System.out.println(Arrays.toString(currentRow));
		}
	}

	// get the n row.
	// For example: n=1 ==> {1}, n=2 ==> {1,1},...
	public static int[] getPascalTriangle(int n) {
		if (n == 1) {
			return new int[] { 1 };
		} else {
			int[] prevRow = getPascalTriangle(n - 1);
			return generateNextRow(prevRow);
		}

	}

	// generate the next row based on the previous row
	// Ex. prevRow = {1} ==> nextRow = {1,1}
	// Ex. prevRow = {1,1} ==> nextRow = {1,2,1}
	public static int[] generateNextRow(int[] prevRow) {
		int[] re = new int[prevRow.length + 1];
		re[0] = 1;
		re[re.length - 1] = 1;
		for (int i = 1; i < re.length - 1; i++) {
			re[i] = prevRow[i - 1] + prevRow[i];

		}
		return re;
	}

	// this is the main method
	public static void main(String[] args) {

		// This is the testcase of printPascalTriangle method
		int row1 = 6;
		printPascalTriangle(row1);
		System.out.println("Above is Pascal's triangle with " + row1 + " row");

		// This is the testcase of getPascalTriangle method
		int n1 = 4;
		System.out.println(
				'\n' + "This is the " + n1 + "th row of Pascal triangle " + Arrays.toString(getPascalTriangle(n1)));
	}

}
