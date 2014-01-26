package de.kerstinreese.tictactoe.presenter;

import de.kerstinreese.tictactoe.model.Coordinate;
import de.kerstinreese.tictactoe.model.TicTacToeModel;
import de.kerstinreese.tictactoe.view.TicTacToeView;

public class TicTacToePresenter {

	TicTacToeModel ticTacToeModel;
	TicTacToeView ticTacToeView;

	public TicTacToePresenter(TicTacToeView ticTacToeView) {
		ticTacToeModel = new TicTacToeModel();
		this.ticTacToeView = ticTacToeView;
	}

	public void play() {
		ticTacToeView.gameStartedNotification();

		while (true) {
			turn(TicTacToeModel.STONE_O);
			if (ticTacToeModel.isVictory()) {
				ticTacToeView.drawBoard(ticTacToeModel);
				ticTacToeView.isWinnerNotification(TicTacToeModel.STONE_O);
				break;
			}
			if (ticTacToeModel.gameEnded()) {
				ticTacToeView.drawBoard(ticTacToeModel);
				ticTacToeView.noWinnerNotification();
				break;
			}

			turn(TicTacToeModel.STONE_X);
			if (ticTacToeModel.isVictory()) {
				ticTacToeView.drawBoard(ticTacToeModel);
				ticTacToeView.isWinnerNotification(TicTacToeModel.STONE_X);
				break;
			}
		}

		ticTacToeView.gameEndedNotification();
	}

	public void turn(char stone) {
		ticTacToeView.drawBoard(ticTacToeModel);
		ticTacToeView.turnNotification(stone);
		boolean valid = false;
		Coordinate coordinate;
		while (!valid) {
			coordinate = ticTacToeView.getCoordinate();

			valid = ticTacToeModel.setStone(stone, coordinate);

			if (!valid) {
				ticTacToeView.invalidTurnNotification(stone);
			}
		}
	}

}
