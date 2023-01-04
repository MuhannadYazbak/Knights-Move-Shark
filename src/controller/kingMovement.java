package controller;

import java.util.Set;
import java.util.TimerTask;

import javafx.scene.control.Alert;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import model.Game;
import model.King;
import model.Square;
import utils.Type;

class kingMovement extends TimerTask  {
	Set<Square> possibleMoves;
	private Image KING = new Image(getClass().getResourceAsStream("/lib/king.png"));

    @Override
    public void run() {
    	if(!GameController.pauseKing) {
        	possibleMoves = Game.getInstance().getKing().allPossibleMoves();
        	System.out.println("king moved");
    	    
    	    for(Square s: possibleMoves) {
    			GameController.getPossibleMovesKing().add(GameController.getImageByString("I"+s.getRow()+s.getCol()));
    		}
    	    
    		Game.getInstance().getKing().setPrev_Place(Game.getInstance().getKing().getCurrentPlace());
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
    				GameController.getTimer2().cancel();
    				GameController.getTimer().cancel();
    			} catch (Error e) {
    				e.printStackTrace();
    			} catch (Exception e) {
    				e.printStackTrace();
    			}
    			
    			
    		}
    	}
    	

    }
}