/**
 * 
 */
package lab2;

/**
 * This is the class is use recursive approach to implement the following
 * Algebra problems
 * 
 * @author hp
 *
 */
public class Task1_1 {

	// S(n)=1-2+3-4+...+((-1)^(n+1))*n, n>0
	public static int getSn1(int n) {
		if (n == 1) {
			return 1;
		} else {
			return (int) (n * Math.pow(-1, n + 1) + getSn1(n - 1));
		}

	}

	// Method getFactorial is a support to solve the method getSn2
	public static int getFactorial(int n) {
		if (n == 1) {
			return 1;
		} else {
			return n * getFactorial(n - 1);
		}
	}

	// S(n)=1+1*2+1*2*3+...+1*2*3*...*n, n>0
	public static int getSn2(int n) {
		if (n == 1) {
			return 1;
		} else {
			return getFactorial(n) + getSn2(n - 1);
		}

	}

	// S(n)=1^2+2^2+3^2+...+n^2, n>0
	public static int getSn3(int n) {
		if (n == 1) {
			return 1;
		} else {
			return (n * n) + getSn3(n - 1);
		}

	}

	// Method getFraction is a support to solve getSn4 method
	public static double getFraction(int n) {
		if (n == 1) {
			return 1.0 / 2;
		} else {
			return (1.0 / (2 * n)) * getFraction(n - 1);
		}
	}

	// S(n)=1+1/2+1/(2*4)+1/(2*4*6)+...+1/(2*4*6*2n), n>=0
	public static double getSn4(int n) {
		if (n == 0) {
			return 1;
		} else {
			return getFraction(n) + getSn4(n - 1);
		}

	}

	// This is the main method
	public static void main(String[] args) {

		// This is the testcase of getSn1 method
		int n1 = 6;
		System.out.println("The result of getSn1 method is: " + "S(" + n1 + ") = " + getSn1(n1));

		// This is the testcase of getSn2 method
		int n2 = 7;
		System.out.println("The result of getSn2 method is: " + "S(" + n2 + ") = " + getSn2(n2));

		// This is the testcase of getSn3 method
		int n3 = 5;
		System.out.println("The result of getSn3 method is: " + "S(" + n3 + ") = " + getSn3(n3));

		// This is the testcase of getSn4 method
		int n4 = 9;
		System.out.println("The result of getSn4 method is: " + "S(" + n4 + ") = " + getSn4(n4));
	}
}
