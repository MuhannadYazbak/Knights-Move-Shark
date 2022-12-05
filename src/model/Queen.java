package model;

import java.util.HashSet;
import java.util.Set;

public class Queen extends Piece{

	public Queen(Square currentPlace) {
		super(currentPlace);
	}

	@Override
	public Set<Square> allPossibleMoves() {
		
		if(getCurrentPlace() == null)
			return null;
		
		int col = getCurrentPlace().getCol();
		int row = getCurrentPlace().getRow();
		HashSet<Square> possibleMoves = new HashSet<Square>();
		
		for(int i=0 ; i<8 ; i++) {
			possibleMoves.add(new Square(i, getCurrentPlace().getCol()));
			possibleMoves.add(new Square(getCurrentPlace().getRow(), i));
		}
		while(col != 8 && row != 8) {
			possibleMoves.add(new Square(row, col));
			row++;
			col++;
		}
		row = getCurrentPlace().getRow();
		col = getCurrentPlace().getCol();
		while(col != -1 && row != -1) {
			possibleMoves.add(new Square(row, col));
			col--;
			row--;
		}
		row = getCurrentPlace().getRow();
		col = getCurrentPlace().getCol();
		while(row != -1 && col != 8) {
			possibleMoves.add(new Square(row, col));
			row--;
			col++;
		}
		row = getCurrentPlace().getRow();
		col = getCurrentPlace().getCol();
		while(row != 8 && col != -1) {
			possibleMoves.add(new Square(row, col));
			row++;
			col--;
		}
		
		
		return possibleMoves;
	}

	@Override
	public void moveThePiec(Set<Square> possibleMoves) {
		// TODO Auto-generated method stub
		
	}
	
}