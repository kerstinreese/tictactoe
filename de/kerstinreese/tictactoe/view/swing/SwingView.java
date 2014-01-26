package de.kerstinreese.tictactoe.view.swing;

import javax.swing.JFrame;

import de.kerstinreese.tictactoe.model.Coordinate;
import de.kerstinreese.tictactoe.model.TicTacToeModel;
import de.kerstinreese.tictactoe.view.TicTacToeView;

public class SwingView extends JFrame implements TicTacToeView {

	private static final long serialVersionUID = 1L;

	public SwingView() {
		super("TicTacToe");

		this.setSize(300, 300);

	}

	@Override
	public void gameStartedNotification() {
		this.setVisible(true);
	}

	@Override
	public void isWinnerNotification(char stone) {
		// TODO Auto-generated method stub

	}

	@Override
	public void noWinnerNotification() {
		// TODO Auto-generated method stub

	}

	@Override
	public void gameEndedNotification() {
		// TODO Auto-generated method stub

	}

	@Override
	public void turnNotification(char stone) {
		// TODO Auto-generated method stub

	}

	@Override
	public Coordinate getCoordinate() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void invalidTurnNotification(char stone) {
		// TODO Auto-generated method stub

	}

	@Override
	public void drawBoard(TicTacToeModel ticTacToeModel) {
		// TODO Auto-generated method stub

	}

}
