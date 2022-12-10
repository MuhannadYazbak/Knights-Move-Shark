package model;

import java.util.HashSet;
import java.util.Set;

public class Knight extends Piece{

	public Knight(Square currentPlace) {
		super(currentPlace);
	}

	@Override
	public Set<Square> allPossibleMoves() {
		HashSet<Square> possibleMoves = new HashSet<Square>();
		if((getCurrentPlace().getCol()+2)<8) {
		possibleMoves.add(new Square(getCurrentPlace().getRow()+1,getCurrentPlace().getCol()+2));
		possibleMoves.add(new Square(getCurrentPlace().getRow()-1,getCurrentPlace().getCol()+2));
		}else if((getCurrentPlace().getCol()+2)>8){
		possibleMoves.add(new Square(getCurrentPlace().getRow()+1,getCurrentPlace().getCol()+2%8));
		possibleMoves.add(new Square(getCurrentPlace().getRow()-1,getCurrentPlace().getCol()+2%8));
		}
		if((getCurrentPlace().getCol()-2)>0) {
		possibleMoves.add(new Square(getCurrentPlace().getRow()+1,getCurrentPlace().getCol()-2));
		possibleMoves.add(new Square(getCurrentPlace().getRow()-1,getCurrentPlace().getCol()-2));
		}else if((getCurrentPlace().getCol()-2)<0) {
		possibleMoves.add(new Square(getCurrentPlace().getRow()+1,(getCurrentPlace().getCol()-2)+8));
		possibleMoves.add(new Square(getCurrentPlace().getRow()-1,(getCurrentPlace().getCol()-2)+8));
		}
		if((getCurrentPlace().getRow()+2)<8) {
		possibleMoves.add(new Square(getCurrentPlace().getRow()+2,getCurrentPlace().getCol()+1));
		possibleMoves.add(new Square(getCurrentPlace().getRow()+2,getCurrentPlace().getCol()-1));
		}else if((getCurrentPlace().getRow()+2)>8) {
		possibleMoves.add(new Square((getCurrentPlace().getRow()+2)%8,getCurrentPlace().getCol()+1));
		possibleMoves.add(new Square((getCurrentPlace().getRow()+2)%8,getCurrentPlace().getCol()-1));
		}if((getCurrentPlace().getRow()-2)>0) {
		possibleMoves.add(new Square(getCurrentPlace().getRow()-2,getCurrentPlace().getCol()+1));
		possibleMoves.add(new Square(getCurrentPlace().getRow()-2,getCurrentPlace().getCol()-1));
		}else if((getCurrentPlace().getRow()-2)<0) {
		possibleMoves.add(new Square(getCurrentPlace().getRow()-2+8,getCurrentPlace().getCol()+1));
		possibleMoves.add(new Square(getCurrentPlace().getRow()-2+8,getCurrentPlace().getCol()-1));
		}
		return possibleMoves;
	}

	@Override
	public void moveThePiec(Set<Square> possibleMoves) {
		// TODO Auto-generated method stub
		
		
	}
	public void moveThePiecK(Set<Square> possibleMoves, int i, int j) {
		for (Square S : possibleMoves) {
			if(S.getCol() ==i && S.getRow()== j) {
				this.setCurrentPlace(S);
			}
		}
	}
	}

	
}