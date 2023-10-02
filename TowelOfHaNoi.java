/**
 * 
 */
package lab2;

/**
 * This is the class use recursive approach to implement Tower of Hanoi problem
 * Suggestion use the pseudo-code described This class has 1 method and main
 * method
 * 
 * @author hp
 *
 */
public class TowelOfHaNoi {
	// Method movetower is implement the code to solve the Tower of Hanoi problem.
	public static void moveTower(int disk, char source, char dest, char spare) {
		if (disk == 1) {
			System.out.println("Move disk 1 from " + source + " to " + dest);
			return;
		} else {
			moveTower(disk - 1, source, spare, dest);
			System.out.println("Move disk " + disk + " from " + source + " to " + dest);
			moveTower(disk - 1, spare, dest, source);
		}
	}

	// This is the main method
	public static void main(String[] args) {
		int disk = 4;
		char source = 'A';
		char dest = 'C';
		char spare = 'B';
		System.out.println("Here is " + (int)(Math.pow(2, disk) - 1) + " steps to solve the Tower of Hanoi problem: ");
		moveTower(disk, source, dest, spare);
	}

}
