package model;

import java.util.Set;

public abstract class Piece{
	
	private Square currentPlace;
	private Square prev_Place;

	public Piece(Square currentPlace) {
		this.currentPlace = currentPlace;
		this.prev_Place=currentPlace;
	}
	
	abstract public Set<Square> allPossibleMoves();
	abstract public Set<Square> EmptyPossibleMoves();
	abstract public void moveThePiece(Set<Square> possibleMoves);
	
	//	Template Design Pattern
	// A template method to be used as is in the class which extends Piece with modification to moveThePiece according to movements rules.
	public final void move() {
		this.setPrev_Place(this.getCurrentPlace());
		moveThePiece(allPossibleMoves());
	}
	
	public Square getPrev_Place() {
		return prev_Place;
	}

	public void setPrev_Place(Square prev_Place) {
		this.prev_Place = prev_Place;
	}

	public Square getCurrentPlace() {
		return currentPlace;
	}

	public void setCurrentPlace(Square currentPlace) {
		this.currentPlace = currentPlace;
	}

	

	
}