package controller;

import java.util.Set;
import java.util.TimerTask;

import javafx.scene.control.Alert;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import model.Game;
import model.King;
import model.Square;

class kingMovement extends TimerTask  {
	Set<Square> possibleMoves;
	private Alert alert = new Alert(Alert.AlertType.INFORMATION);
	private Image KING = new Image(getClass().getResourceAsStream("/lib/king.png"));

    @Override
    public void run() {
    	possibleMoves = Game.getInstance().getKing().allPossibleMoves();
    	 
	    
	    for(Square s: possibleMoves) {
			GameController.getPossibleMovesKing().add(GameController.getImageByString("I"+s.getRow()+s.getCol()));
		}
	    
		Game.getInstance().getKing().setPrev_Place(Game.getInstance().getKing().getCurrentPlace());
		System.out.println(Game.getInstance().getKing().getCurrentPlace().getRow());
		System.out.println(Game.getInstance().getKing().getCurrentPlace().getCol());
		Game.getInstance().getKing().moveThePiece(Game.getInstance().getKing().allPossibleMoves());
		ImageView temp = null;
		String s = "I" +Integer.toString(Game.getInstance().getKing().getCurrentPlace().getRow())
				+Integer.toString(Game.getInstance().getKing().getCurrentPlace().getCol());
		for(ImageView i : GameController.getAllImages() ) {
			if(i.getId().equals(s)) {
				i.setImage(KING);		
				
			}
			
		}
		
		String prev = "I" +Integer.toString(Game.getInstance().getKing().getPrev_Place().getRow())
		+Integer.toString(Game.getInstance().getKing().getPrev_Place().getCol());
		for(ImageView i : GameController.getAllImages() ) {
			if(i.getId().equals(prev)) {
				
				i.setImage(null);
				
			}
			
		}
		
		if(Game.getInstance().getKing().getCurrentPlace().getCol()==Game.getInstance().getKnight().getCurrentPlace().getCol() && 
				Game.getInstance().getKing().getCurrentPlace().getRow() == Game.getInstance().getKnight().getCurrentPlace().getRow()) {
			try {
				GameController.getTimer().cancel();		
			} catch (Error e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			
		}
    }
}