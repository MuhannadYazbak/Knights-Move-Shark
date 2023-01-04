package model;

public class lastObj {
	private Square square;
	private int score;
	public lastObj(Square square, int score) {
		super();
		this.square = square;
		this.score = score;
	}
	public Square getSquare() {
		return square;
	}
	public void setSquare(Square square) {
		this.square = square;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	@Override
	public String toString() {
		return "lastObj [square=" + square + ", score=" + score + "]";
	}
	
	

}
