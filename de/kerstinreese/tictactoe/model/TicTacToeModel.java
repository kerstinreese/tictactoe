package de.kerstinreese.tictactoe.model;

public class TicTacToeModel {

	private static final char EMPTY_FIELD = '-';
	public static final char STONE_X = 'X';
	public static final char STONE_O = 'O';
	private char[][] board = new char[3][3];

	private int turnCounter;

	public TicTacToeModel() {
		initBoard();
	}

	private void initBoard() {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				board[i][j] = EMPTY_FIELD;
			}
		}
		turnCounter = 0;
	}

	public String toString() {
		String output = new String();
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				output = output + board[i][j];
			}
			output = output + '\n';
		}
		return output;
	}

	public boolean setStone(char stone, Coordinate coordinate) {

		boolean isEmpty = (board[coordinate.getRow()][coordinate.getColumn()] == EMPTY_FIELD);
		if (isEmpty) {
			board[coordinate.getRow()][coordinate.getColumn()] = stone;
			turnCounter++;
		}
		return isEmpty;
	}

	public boolean gameEnded() {
		return turnCounter == 9;
	}

	public boolean isVictory() {
		return checkVictory(STONE_O) || checkVictory(STONE_X);
	}

	private boolean checkVictory(char stone) {
		return checkHorizontal(stone) || checkVertical(stone)
				|| checkDiagonal(stone);

	}

	private boolean checkHorizontal(char stone) {
		for (int row = 0; row < 3; row++) {
			if (board[row][0] == stone && board[row][1] == stone
					&& board[row][2] == stone) {
				return true;
			}
		}
		return false;
	}

	private boolean checkVertical(char stone) {
		for (int column = 0; column < 3; column++) {
			if (board[0][column] == stone && board[1][column] == stone
					&& board[2][column] == stone) {
				return true;
			}
		}
		return false;
	}

	private boolean checkDiagonal(char stone) {
		return (board[0][0] == stone && board[1][1] == stone && board[2][2] == stone)
				|| (board[0][2] == stone && board[1][1] == stone && board[2][0] == stone);
	}

}
