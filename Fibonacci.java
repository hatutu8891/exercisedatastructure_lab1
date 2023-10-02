/**
 * 
 */
package lab2;

import java.util.Arrays;

/**
 * This is the class use recursive approach to implement Fibonacci problem.
 * Note, Fibonacci- next number is the sum of previous two numbers.
 * 
 * @author hp
 *
 */
public class Fibonacci {

	// get the n value of the Fibonacci series
	public static int getFibonacci(int n) {
		if (n == 1) {
			return 0;
		} else if (n == 2) {
			return 1;

		} else {
			int num1 = getFibonacci(n - 2);
			int num2 = getFibonacci(n - 1);
			return num1 + num2;

		}

	}

	// This method is used to display a Fibonacci series based on the parameter
	// n.Ex.n=10==>0 1 1 2 3 5 8 13 21 34
	public static void printFibonacci(int n) {
		int[] array = new int[n];
		int[] arrResult = new int[n];
		for (int i = 0; i < array.length; i++) {
			array[i] = getFibonacci(n - i);
		}
		for (int j = 0; j < array.length; j++) {
			arrResult[j] = array[array.length - 1 - j];
		}
		System.out.println(Arrays.toString(arrResult));

	}

	// This is the main method
	public static void main(String[] args) {
		// This is the testcase of getFibonacci method
		int n1 = 10;
		System.out.println("The number located in position " + n1 + " is: " + getFibonacci(n1));

		// This is the testcase of printFibonacci method
		int n2 = 10;
		System.out.print("The fibonacci sequence consists of 10 digits is:");
		printFibonacci(n2);
	}

}
