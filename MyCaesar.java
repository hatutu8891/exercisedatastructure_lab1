/**
 * 
 */
package lab1;

import java.util.Arrays;

/**
 * This is a class to solve some common problem related to one dimensional
 * array. The class include 4 method to solve 4 different problem. This class is
 * demonstrates task2 in lab1.
 * 
 * @author hp
 *
 */
public class MyCaesar {
	public static final char[] ALPHABET = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O',
			'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z' };
	private int n;

	public MyCaesar(int shiftSteps) {
		super();
		this.n = shiftSteps;
	}

	// Encrypt a character according to the given shif steps.
	// Encrypt: En(x) = (x + n) mod 26. x reprensents the index of c in the ALPHABET
	// array.
	public char encryptChar(char c) {
		int index = Arrays.binarySearch(ALPHABET, c);// this line is determine index of the "char c"
		int result = (index + n) % 26;
		return ALPHABET[result];
	}

	// Encrypt a test using the above function for encrypting a charater.
	public String encrypt(String input) {
		MyCaesar enChar = new MyCaesar(n);

		String newString = input.toUpperCase();// this line is turning all lowercase letters in the string into
												// uppercase letters.
		char[] arrchar = newString.toCharArray();// this line is turning a string into an array
		char[] re = new char[arrchar.length];

		for (int i = 0; i < arrchar.length; i++) {

			// Without this line the space is also translated into words.
			if (arrchar[i] == ' ') {
				re[i] = ' ';
			} else {
				re[i] = enChar.encryptChar(arrchar[i]);
			}
		}
		String result = new String(re);

		return result;
	}

	// Decrypt a character according to the given shif steps.
	// Decrypt: Dn (x) = (x - n) mod 26. x reprensents the index of c in the
	// ALPHABET array.
	public char decryptChar(char c) {
		int index = Arrays.binarySearch(ALPHABET, c);// this line is determine index of the "char c"
		int reIndex = (index - n) % 26;
		char result = ' ';
		if (reIndex < 0) {
			result = ALPHABET[26 + reIndex];
		} else {
			result = ALPHABET[reIndex];
		}

		return result;
	}

	// Decrypt a encrypted text using the above function for decrypting a character.
	public String decrypt(String input) {
		MyCaesar enChar = new MyCaesar(n);

		String newString = input.toUpperCase();// this line is turning all lowercase letters in the string into
												// uppercase letters.
		char[] arrchar = newString.toCharArray();// this line is turning a string into an array.
		char[] re = new char[arrchar.length];

		for (int i = 0; i < arrchar.length; i++) {
			// Without this line the space is also translated into words.
			if (arrchar[i] == ' ') {
				re[i] = ' ';
			} else {
				re[i] = enChar.decryptChar(arrchar[i]);
			}
		}
		String result = new String(re);

		return result;

	}

	public static void main(String[] args) {

		// This is the testcase of method encryptChar
		char ch1 = 'A';
		int n1 = 13;
		MyCaesar mc1 = new MyCaesar(n1);
		char result1 = mc1.encryptChar(ch1);
		System.out.println("The letter " + ch1 + " afer move on " + n1 + " letter is :" + result1 + '\n');

		// This is the testcase of method encrypt
		String input1 = "This is a table";
		int n2 = 19;
		MyCaesar mc2 = new MyCaesar(n2);
		String result2 = mc2.encrypt(input1);
		System.out.println("The string " + '\"' + input1 + '\"' + " after move on each letter in the string " + n2
				+ " letter is :" + result2 + '\n');

		// This is the testcase of method decryptChar
		char ch3 = 'B';
		int n3 = 2;
		MyCaesar mc3 = new MyCaesar(n3);
		char result3 = mc3.decryptChar(ch3);
		System.out.println("The letter " + ch3 + " afer move back " + n3 + " letter is :" + result3 + '\n');

		// This is the testcase of method decrypt
		String input2 = "CQRB RB J CJKUN";
		int n4 = 9;
		MyCaesar mc4 = new MyCaesar(n4);
		String result4 = mc4.decrypt(input2);
		System.out.println("The string " + '\"' + input2 + '\"' + " after move back each letter in the string " + n4
				+ " letter is :" + result4);
	}

}
