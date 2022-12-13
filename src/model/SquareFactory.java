package model;

import utils.Type;
/*
 * A design pattern class, used in game play to producre instances of squares and setting the correct type of square to return.
 */

public class SquareFactory {
	public Square makeSquare(int x, int y,Type type) {
		Square square = new Square(x,y);
		square.setSquareType(type);
		return square;
		
	}
	
		

}
