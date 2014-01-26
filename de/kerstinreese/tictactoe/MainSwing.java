package de.kerstinreese.tictactoe;

import de.kerstinreese.tictactoe.presenter.TicTacToePresenter;
import de.kerstinreese.tictactoe.view.swing.SwingView;

public class MainSwing {

	public static void main(final String[] args) {
		SwingView swingView = new SwingView();

		TicTacToePresenter ticTacToePresenter = new TicTacToePresenter(
				swingView);

		ticTacToePresenter.play();

	}

}
