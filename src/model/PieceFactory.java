package model;

public class PieceFactory {
	
//	 * A design pattern class, used in game play to producer instances of the given piece name

	public Piece makePiece(String piece,Square square) {
		
		if (piece == null || square == null)
			 return null;
		 
	     switch (piece) {
	        case "King":
	            return new King(square);
	        case "Knight":
	            return new Knight(square);
	        case "Queen":
	            return new Queen(square);
	        default:
	        		return null;
	  
	        }
	}
}
