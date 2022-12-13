package model;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

import utils.Type;

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
	public void moveThePiece(Set<Square> possibleMoves) {
		// TODO Auto-generated method stub
		ArrayList<Square> toRemove = new ArrayList<Square>();
		TreeSet<Square> toReturn = new TreeSet<Square>(new Comparator<Square>() {
			public int compare(Square o1, Square o2) {
				Double o1d=Math.sqrt((o1.getCol() - Game.getQueen().getCurrentPlace().getCol()) * (o1.getCol() - Game.getQueen().getCurrentPlace().getCol())
						+ (o1.getRow() - Game.getQueen().getCurrentPlace().getRow()) * (o1.getRow() - Game.getQueen().getCurrentPlace().getRow()));
				Double o2d=Math.sqrt((o2.getCol() - Game.getQueen().getCurrentPlace().getCol()) * (o2.getCol() - Game.getQueen().getCurrentPlace().getCol())
						+ (o2.getRow() - Game.getQueen().getCurrentPlace().getRow()) * (o2.getRow() - Game.getQueen().getCurrentPlace().getRow()));
				return Double.compare(o1d, o2d);
			}
		});
		for(Square s : possibleMoves) {
			if(Game.squareByIndx(s.getRow(), s.getCol()).squareType==Type.Blocked) {
				toRemove.add(s);
			}
		}
		possibleMoves.removeAll(toRemove);
		for(Square square : possibleMoves) {
			toReturn.add(square);
		}
		Game.getQueen().setCurrentPlace(toReturn.first()); 
		
	}
	
}