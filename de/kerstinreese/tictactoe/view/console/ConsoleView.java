package de.kerstinreese.tictactoe.view.console;

import java.util.Scanner;

import de.kerstinreese.tictactoe.model.Coordinate;
import de.kerstinreese.tictactoe.model.TicTacToeModel;
import de.kerstinreese.tictactoe.view.TicTacToeView;

public class ConsoleView implements TicTacToeView {

	TicTacToeModel ticTacToeModel;

	public ConsoleView() {
		init();
	}

	private void init() {
		ticTacToeModel = new TicTacToeModel();
	}

	@Override
	public void gameStartedNotification() {
		System.out.println("TicTacToe gestartet.");
	}

	@Override
	public void isWinnerNotification(char stone) {
		System.out.println("'" + stone + "' hat gewonnen.");
	}

	@Override
	public void noWinnerNotification() {
		System.out.println("Niemand hat gewonnen. Unentschieden.");
	}

	@Override
	public void gameEndedNotification() {
		System.out.println("Spiel beendet.\n");

	}

	@Override
	public void turnNotification(char stone) {
		System.out.println("'" + stone + "' am Zug");
	}

	@Override
	public void invalidTurnNotification(char stone) {
		System.out.println("Ungültiger Zug. Bitte Koordinate für '" + stone
				+ "' erneut eingeben.");
	}

	@Override
	public Coordinate getCoordinate() {
		Coordinate coordinate = new Coordinate();
		Scanner kb = new Scanner(System.in);

		System.out.println("Bitte Reihe eingeben 1-3:");
		char inputChar;
		while (true) {
			String tString = kb.next();
			inputChar = tString.charAt(0);
			if (isValidInput(inputChar)) {
				break;
			}
		}
		coordinate.setRow(charToInt(inputChar));

		System.out.println("Bitte Spalte eingeben 1-3:");
		while (true) {
			String tString = kb.next();
			inputChar = tString.charAt(0);
			if (isValidInput(inputChar)) {
				break;
			}
		}
		coordinate.setColumn(charToInt(inputChar));

		System.out.println("Koordinate: (" + coordinate.getRow() + ", "
				+ coordinate.getColumn() + ")");

		return coordinate;
	}

	private int charToInt(char inputChar) {
		return inputChar - '0' - 1;
	}

	private boolean isValidInput(char inputChar) {
		return inputChar == '1' || inputChar == '2' || inputChar == '3';
	}

	@Override
	public void drawBoard(TicTacToeModel ticTacToeModel) {
		System.out.println(ticTacToeModel.toString());
	}

	@Override
	public void validTurnNotification(char stone) {
		// TODO Auto-generated method stub

	}

}
