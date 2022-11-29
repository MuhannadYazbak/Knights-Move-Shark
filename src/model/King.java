package model;

import java.util.HashSet;
import java.util.Set;

public class King extends Piece{

	public King(Square currentPlace) {
		super(currentPlace);
	}

	@Override
	public Set<Square> allPossibleMoves() {
		
		if(getCurrentPlace() == null)
			return null;
		
		HashSet<Square> possibleMoves = new HashSet<Square>();
		
		if(getCurrentPlace().getCol() == 0 && getCurrentPlace().getRow() == 0) {
			possibleMoves.add(new Square(0, 1));
			possibleMoves.add(new Square(1,0));
			possibleMoves.add(new Square(7, 0));
			possibleMoves.add(new Square(0,7));
			possibleMoves.add(new Square(7, 7));
			possibleMoves.add(new Square(1,1));
			possibleMoves.add(new Square(7, 1));
			possibleMoves.add(new Square(1,7));
		}
		else if(getCurrentPlace().getCol() == 0 && getCurrentPlace().getRow() == 7) {
			possibleMoves.add(new Square(7, 1));
			possibleMoves.add(new Square(6,0));
			possibleMoves.add(new Square(7, 7));
			possibleMoves.add(new Square(0,0));
			possibleMoves.add(new Square(6, 6));
			possibleMoves.add(new Square(0,7));
			possibleMoves.add(new Square(0, 1));
			possibleMoves.add(new Square(6,7));
		}
		else if(getCurrentPlace().getCol() == 7 && getCurrentPlace().getRow() == 0) {
			possibleMoves.add(new Square(6, 0));
			possibleMoves.add(new Square(0,0));
			possibleMoves.add(new Square(7, 7));
			possibleMoves.add(new Square(1,7));
			possibleMoves.add(new Square(7, 7));
			possibleMoves.add(new Square(1,6));
			possibleMoves.add(new Square(7, 6));
			possibleMoves.add(new Square(1,0));
		}
		else if(getCurrentPlace().getCol() == 7 && getCurrentPlace().getRow() == 7) {
			possibleMoves.add(new Square(6, 7));
			possibleMoves.add(new Square(7,6));
			possibleMoves.add(new Square(0, 7));
			possibleMoves.add(new Square(7,0));
			possibleMoves.add(new Square(0, 0));
			possibleMoves.add(new Square(6,6));
			possibleMoves.add(new Square(0, 6));
			possibleMoves.add(new Square(6,0));
		}
		else if(getCurrentPlace().getCol() == 0) {
				possibleMoves.add(new Square(getCurrentPlace().getRow()+1, 0));
				possibleMoves.add(new Square(getCurrentPlace().getRow()-1, 0));
				possibleMoves.add(new Square(getCurrentPlace().getRow(), 1));
				possibleMoves.add(new Square(getCurrentPlace().getRow(), 7));
				possibleMoves.add(new Square(getCurrentPlace().getRow()-1, getCurrentPlace().getCol()-1));
				possibleMoves.add(new Square(getCurrentPlace().getRow()+1, getCurrentPlace().getCol()+1));
				possibleMoves.add(new Square(getCurrentPlace().getRow()-1, 7));
				possibleMoves.add(new Square(getCurrentPlace().getRow()+1, 7));

		}
		else if(getCurrentPlace().getRow() == 0) {
			possibleMoves.add(new Square(0, getCurrentPlace().getCol()+1));
			possibleMoves.add(new Square(0, getCurrentPlace().getCol()-1));
			possibleMoves.add(new Square(getCurrentPlace().getRow()+1, getCurrentPlace().getCol()));
			possibleMoves.add(new Square(7, getCurrentPlace().getCol()));
			possibleMoves.add(new Square(getCurrentPlace().getRow()+1, getCurrentPlace().getCol()+1));
			possibleMoves.add(new Square(getCurrentPlace().getRow()+1, getCurrentPlace().getCol()-1));
			possibleMoves.add(new Square(7, getCurrentPlace().getCol()-1));
			possibleMoves.add(new Square(7, getCurrentPlace().getCol()+1));
		}
		else if(getCurrentPlace().getCol() == 7) {
			possibleMoves.add(new Square(getCurrentPlace().getRow(), getCurrentPlace().getCol()-1));
			possibleMoves.add(new Square(getCurrentPlace().getRow()-1, getCurrentPlace().getCol()));
			possibleMoves.add(new Square(getCurrentPlace().getRow()+1, getCurrentPlace().getCol()));
			possibleMoves.add(new Square(getCurrentPlace().getRow(), 0));
			possibleMoves.add(new Square(getCurrentPlace().getRow()-1, getCurrentPlace().getCol()-1));
			possibleMoves.add(new Square(getCurrentPlace().getRow()+1, getCurrentPlace().getCol()-1));
			possibleMoves.add(new Square(getCurrentPlace().getRow()-1, 0));
			possibleMoves.add(new Square(getCurrentPlace().getRow()+1, 0));
		}
		else if(getCurrentPlace().getRow() == 7) {
			possibleMoves.add(new Square(0, getCurrentPlace().getCol()));
			possibleMoves.add(new Square(getCurrentPlace().getRow()-1, getCurrentPlace().getCol()));
			possibleMoves.add(new Square(getCurrentPlace().getRow(), getCurrentPlace().getCol()+1));
			possibleMoves.add(new Square(getCurrentPlace().getRow(), getCurrentPlace().getCol()-1));
			possibleMoves.add(new Square(0, getCurrentPlace().getCol()-1));
			possibleMoves.add(new Square(getCurrentPlace().getRow()-1, getCurrentPlace().getCol()-1));
			possibleMoves.add(new Square(getCurrentPlace().getRow()-1, getCurrentPlace().getCol()+1));
			possibleMoves.add(new Square(0, getCurrentPlace().getCol()+1));

		}
		else {
			possibleMoves.add(new Square(getCurrentPlace().getRow()-1, getCurrentPlace().getCol()));
			possibleMoves.add(new Square(getCurrentPlace().getRow()+1, getCurrentPlace().getCol()));
			possibleMoves.add(new Square(getCurrentPlace().getRow(), getCurrentPlace().getCol()-1));
			possibleMoves.add(new Square(getCurrentPlace().getRow(), getCurrentPlace().getCol()+1));
			possibleMoves.add(new Square(getCurrentPlace().getRow()-1, getCurrentPlace().getCol()-1));
			possibleMoves.add(new Square(getCurrentPlace().getRow()-1, getCurrentPlace().getCol()+1));
			possibleMoves.add(new Square(getCurrentPlace().getRow()+1, getCurrentPlace().getCol()-1));
			possibleMoves.add(new Square(getCurrentPlace().getRow()+1, getCurrentPlace().getCol()+1));

		}
		return possibleMoves;
	}

	@Override
	public void moveThePiec(Set<Square> possibleMoves) {
		// TODO Auto-generated method stub
		
	}
	
	
}