package de.kerstinreese.tictactoe.view.swing;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import de.kerstinreese.tictactoe.model.Coordinate;
import de.kerstinreese.tictactoe.model.TicTacToeModel;
import de.kerstinreese.tictactoe.view.TicTacToeView;

public class SwingView extends JFrame implements TicTacToeView {

	private static final long serialVersionUID = 1L;

	private JLabel lblHeading;

	private JTextArea board;

	private JLabel lblTurn;
	private JLabel lblResult;
	private JLabel lblEnd;
	private JLabel lblInvalidTurn;

	private JTextField txtBoxRow;
	private JTextField txtBoxColumn;

	private JButton btnTurn;

	private boolean turnPressed;

	private Coordinate coordinate;

	public SwingView() {
		super("TicTacToe");

		init();

	}

	private void init() {
		turnPressed = false;
		coordinate = new Coordinate();

		JPanel pane = new JPanel();
		pane.setLayout(new BoxLayout(pane, BoxLayout.Y_AXIS));

		lblHeading = new JLabel();
		pane.add(lblHeading);

		board = new JTextArea();
		pane.add(board);

		lblTurn = new JLabel();
		pane.add(lblTurn);

		JLabel lblRow = new JLabel("Zeile:");
		pane.add(lblRow);

		txtBoxRow = new JTextField();
		pane.add(txtBoxRow);

		JLabel lblColumn = new JLabel("Spalte:");
		pane.add(lblColumn);

		txtBoxColumn = new JTextField();
		pane.add(txtBoxColumn);

		lblInvalidTurn = new JLabel();
		pane.add(lblInvalidTurn);

		btnTurn = new JButton("Ziehen");
		btnTurn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				char row = txtBoxRow.getText().charAt(0);
				coordinate.setRow(charToInt(row));

				char column = txtBoxColumn.getText().charAt(0);

				coordinate.setColumn(charToInt(column));
				turnPressed = true;
			}
		});
		pane.add(btnTurn);

		lblResult = new JLabel();
		pane.add(lblResult);

		lblEnd = new JLabel();
		pane.add(lblEnd);

		this.getContentPane().add(pane);

		this.setSize(300, 300);
	}

	private int charToInt(char inputChar) {
		return inputChar - '0' - 1;
	}

	@Override
	public void gameStartedNotification() {
		lblHeading.setText("TicTacToe gestartet");
		this.setVisible(true);
	}

	@Override
	public void isWinnerNotification(char stone) {
		lblResult.setText(stone + " hat gewonnen.");
	}

	@Override
	public void noWinnerNotification() {
		lblResult.setText("Unentschieden. Niemand hat gewonnen.");
	}

	@Override
	public void gameEndedNotification() {
		lblEnd.setText("Spiel beendet");
	}

	@Override
	public void turnNotification(char stone) {
		lblTurn.setText(stone + " am Zug");
	}

	@Override
	public Coordinate getCoordinate() {
		while (!turnPressed) {
			System.out.println("wait");
		}
		turnPressed = false;
		return coordinate;
	}

	@Override
	public void invalidTurnNotification(char stone) {
		lblInvalidTurn.setText("Ungültiger Zug. Bitte erneut eingeben.");
	}

	@Override
	public void drawBoard(TicTacToeModel ticTacToeModel) {
		board.setText("");
		board.setText(ticTacToeModel.toString());
	}

	@Override
	public void validTurnNotification(char stone) {
		lblInvalidTurn.setText("");
	}

}
