package model;


public class Square implements Cloneable {
	private static final long SerialVersionUID = 1L;
	public int row;
	public int col;
	public boolean isVisisted;
	public Color squareColor;
	public Piece piece;
	public boolean isVisisted() {
		return isVisisted;
	}
	public void setVisisted(boolean isVisisted) {
		this.isVisisted = isVisisted;
	}
	public Color getSquareColor() {
		return squareColor;
	}
	public void setSquareColor(Color squareColor) {
		this.squareColor = squareColor;
	}
	public int getRow() {
		return row;
	}
	public int getCol() {
		return col;
	}
	public Square(int row, int col, Color squareColor) {
		super();
		this.row = row;
		this.col = col;
		this.squareColor = squareColor;
		this.isVisisted = false;
		this.squareColor = Color.WHITE;
	}
	public Object getpiece() {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
