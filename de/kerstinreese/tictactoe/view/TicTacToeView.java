package de.kerstinreese.tictactoe.view;

import de.kerstinreese.tictactoe.model.Coordinate;
import de.kerstinreese.tictactoe.model.TicTacToeModel;

public interface TicTacToeView {

	public void gameStartedNotification();

	public void isWinnerNotification(char stone);

	public void noWinnerNotification();

	public void gameEndedNotification();

	public void turnNotification(char stone);

	public Coordinate getCoordinate();

	public void invalidTurnNotification(char stone);

	public void drawBoard(TicTacToeModel ticTacToeModel);
}
