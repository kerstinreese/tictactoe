package de.kerstinreese.tictactoe.model;

public class Coordinate {

	private int row;
	private int column;

	public Coordinate() {

	}

	public Coordinate(int row, int column) {
		this.row = row;
		this.column = column;
	}

	public void setRow(int row) {
		this.row = row;
	}

	public void setColumn(int column) {
		this.column = column;
	}

	public int getRow() {
		return row;
	}

	public int getColumn() {
		return column;
	}

}
