/**
 * 
 */
package lab5;

import java.util.Arrays;

/**
 * TASK 2 : APPLICATION OF 2D ARRAYS (TIC TAC TOE GAME)
 * 
 * This is the class to implement the tic tac toe game. To play the game player
 * need the board. The board is an 3*3 matrix containing symbols 'X','O',or an
 * empty char(' ')
 * 
 * To win the game, player need 3 checks in rows or 3 checks in column or 3
 * checks in diagonals.
 * 
 * @author hp
 *
 */
public class TicTacToe {
	private static final char EMPTY = ' ';
	private char[][] board;

	/*
	 * Task 2.1 : Checking rows This method checks all rows and returns true if any
	 * of them are marked with all of a single player's markers. Othewise, returns
	 * false.
	 */
	public boolean checkRows() {
		for (int i = 0; i < board.length; i++) {
			if (board[i][0] != EMPTY && board[i][0] == board[i][1] && board[i][1] == board[i][2]) {
				return true;
			}
		}
		return false;
	}

	/*
	 * Task 2.2 : Checking columns This method checks all columns and returns true
	 * if any of them are marked with all of a single player's markers. Othewise,
	 * returns false.
	 */
	public boolean checkColumns() {
		for (int i = 0; i < board[0].length; i++) {
			if (board[0][i] != EMPTY && board[0][i] == board[1][i] && board[1][i] == board[2][i]) {
				return true;
			}
		}
		return false;
	}

	/*
	 * Task 2.3 : Checking diagonals This method checks both diagonals and returns
	 * true if any of them are marked with all of a single player's markers.
	 * Othewise, returns false.
	 */
	public boolean checkDiagonals() {
		// Check top-left to bottom-right
		if (board[0][0] != EMPTY && board[0][0] == board[1][1] && board[1][1] == board[2][2]) {
			return true;
		}

		// Check bottom-left to top-right
		else if (board[2][0] != EMPTY && board[2][0] == board[1][1] && board[1][1] == board[0][2]) {
			return true;
		}

		return false;
	}

	// This is the main method of this class
	public static void main(String[] args) {

		// This is the testcase1
		TicTacToe game = new TicTacToe();

		game.board = new char[][] { { 'X', 'O', 'X' }, { 'O', 'X', 'O' }, { 'X', 'O', ' ' } };

		boolean rows = game.checkRows();
		boolean columns = game.checkColumns();
		boolean diagonals = game.checkDiagonals();

		if (rows || columns || diagonals) {
			System.out.println(Arrays.deepToString(game.board) + '\n' + "There was a winner");
		} else {
			System.out.println(Arrays.deepToString(game.board) + '\n' + "There is no winner yet");
		}

		// This is the testcase2
		TicTacToe game1 = new TicTacToe();

		game1.board = new char[][] { { 'X', 'X', 'O' }, { 'O', 'X', 'X' }, { 'X', 'O', 'O' } };

		boolean rows1 = game1.checkRows();
		boolean columns1 = game1.checkColumns();
		boolean diagonals1 = game1.checkDiagonals();

		if (rows1 || columns1 || diagonals1) {
			System.out.println(Arrays.deepToString(game1.board) + '\n' + "There was a winner");
		} else {
			System.out.println(Arrays.deepToString(game1.board) + '\n' + "There is no winner yet");
		}

	}

}
