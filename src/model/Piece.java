package model;

import java.util.Set;

public abstract class Piece{
	
	private Square currentPlace;

	public Piece(Square currentPlace) {
		this.currentPlace = currentPlace;
	}
	
	abstract public Set<Square> allPossibleMoves();
	abstract public void moveThePiec(Set<Square> possibleMoves);
	
	public final void movie() {
		
		moveThePiec(allPossibleMoves());
	}
	
	public Square getCurrentPlace() {
		return currentPlace;
	}

	public void setCurrentPlace(Square currentPlace) {
		this.currentPlace = currentPlace;
	}

	
}