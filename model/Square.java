package model;

import utils.Type;

public class Square {
	public int row;
	public int col;
	public boolean isVisisted = false;
	public Type squareType;
	
	public Square(int row, int col) {
		super();
		this.row = row;
		this.col = col;
	}

	public int getRow() {
		return row;
	}

	public void setRow(int row) {
		this.row = row;
	}

	public int getCol() {
		return col;
	}

	public void setCol(int col) {
		this.col = col;
	}

	public boolean isVisisted() {
		return isVisisted;
	}

	public void setVisisted(boolean isVisisted) {
		this.isVisisted = isVisisted;
	}

	public Type getSquareType() {
		return squareType;
	}

	public void setSquareType(Type squareType) {
		this.squareType = squareType;
	}
	
	
}