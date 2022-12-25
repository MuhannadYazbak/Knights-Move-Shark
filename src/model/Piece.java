package model;

import java.util.Set;

public abstract class Piece{
	
	private Square currentPlace;

	public Piece(Square currentPlace) {
		this.currentPlace = currentPlace;
	}
	
	abstract public Set<Square> allPossibleMoves();
	abstract public Set<Square> EmptyPossibleMoves();
	abstract public void moveThePiece(Set<Square> possibleMoves);
	
	//	Template Design Pattern
	// A template method to be used as is in the class which extends Piece with modification to moveThePiece according to movements rules.
	public final void move() {
		
		moveThePiece(allPossibleMoves());
	}
	
	public Square getCurrentPlace() {
		return currentPlace;
	}

	public void setCurrentPlace(Square currentPlace) {
		this.currentPlace = currentPlace;
	}

	

	
}