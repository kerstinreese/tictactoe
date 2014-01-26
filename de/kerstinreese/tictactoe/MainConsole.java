package de.kerstinreese.tictactoe;

import de.kerstinreese.tictactoe.presenter.TicTacToePresenter;
import de.kerstinreese.tictactoe.view.console.ConsoleView;

public class MainConsole {

	public static void main(String[] args) {

		ConsoleView consoleView = new ConsoleView();

		TicTacToePresenter ticTacToePresenter = new TicTacToePresenter(
				consoleView);

		ticTacToePresenter.play();

	}

}
