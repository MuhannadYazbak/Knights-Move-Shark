package controller;

import java.io.IOException;
import java.net.URL;
import java.util.HashSet;
import java.util.ResourceBundle;
import java.util.Timer;
import java.util.concurrent.TimeUnit;

import javafx.event.ActionEvent;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;
import model.Game;
import model.Player;
import model.Square;
import model.SquareFactory;
import model.SysData;
import utils.Type;

public class GameController implements Initializable{
	
	/*
	 * ImageView for each square to build the board.
	 */
	@FXML
    private ImageView S00,S01,S02,S03,S04,S05,S06,S07,S10,S11,S12,S13,S14,S15,S16,S17,S20,S21,S22,S23,S24,S25,S26,S27,S30,S31,S32,S33,S34,S35,S36,S37,S40,S41,S42,S43,S44,S45,S46,S47,S50,S51,S52,S53,S54,S55,S56,S57,S60,S61,S62,S63,S64,S65,S66,S67,S70,S71,S72,S73,S74,S75,S76,S77;
	
	/*
	 * HashSet to use all the board images.
	 */
	private HashSet<ImageView> BoardImages = new HashSet<ImageView>();
	
	/*
	 * ImageView for each image to move the pieces.
	 */
	@FXML
    private ImageView I00,I01,I02,I03,I04,I05,I06,I07,I10,I11,I12,I13,I14,I15,I16,I17,I20,I21,I22,I23,I24,I25,I26,I27,I30,I31,I32,I33,I34,I35,I36,I37,I40,I41,I42,I43,I44,I45,I46,I47,I50,I51,I52,I53,I54,I55,I56,I57,I60,I61,I62,I63,I64,I65,I66,I67,I70,I71,I72,I73,I74,I75,I76,I77;
	
	/*
	 * HashSet to use all the null (show the piece when it is on specific image.
	 */
	private static HashSet<ImageView> allImages = new HashSet<ImageView>();
	
	/*
	 * Button for each square.
	 */
	@FXML
    private Button CI00,CI01,CI02,CI03,CI04,CI05,CI06,CI07,CI10,CI11,CI12,CI13,CI14,CI15,CI16,CI17,CI20,CI21,CI22,CI23,CI24,CI25,CI26,CI27,CI30,CI31,CI32,CI33,CI34,CI35,CI36,CI37,CI40,CI41,CI42,CI43,CI44,CI45,CI46,CI47,CI50,CI51,CI52,CI53,CI54,CI55,CI56,CI57,CI60,CI61,CI62,CI63,CI64,CI65,CI66,CI67,CI70,CI71,CI72,CI73,CI74,CI75,CI76,CI77;
	
	/*
	 * HashSet for Buttons
	 */
	private HashSet<Button> allButtons = new HashSet<Button>();
	
	/*
	 * HashSet for the possible buttons to know where the player should press.
	 */
	private HashSet<Button> PossibleButtons = new HashSet<Button>();
	
	private Square[][] Board = new Square[8][8];
	@FXML
    private Button backBtn;

    @FXML
    private Label level,playerName,remainingTime,score;

    @FXML
    private AnchorPane screen;
    
    private static final Integer STARTTIME = 60;
    private Timeline timeline;
    private IntegerProperty timeSeconds = new SimpleIntegerProperty(STARTTIME);
    static Timer timer = new Timer();
    
    public static Timer getTimer() {
		return timer;
	}

	public void setTimer(Timer timer) {
		GameController.timer = timer;
	}
	/*
     * images to use on board
     */
	private Image KING = new Image(getClass().getResourceAsStream("/lib/king.png"));
	private Image QUEEN = new Image(getClass().getResourceAsStream("/lib/queen.png"));
	private Image KNIGHT = new Image(getClass().getResourceAsStream("/lib/knight.png"));
	private Image Possible = new Image(getClass().getResourceAsStream("/lib/whitebg.png"));
	private Image Visited = new Image(getClass().getResourceAsStream("/lib/yellow.png"));
	private Image Question = new Image(getClass().getResourceAsStream("/lib/Qm.png"));
	private Image QuestionWhite = new Image(getClass().getResourceAsStream("/lib/Qw.png"));
	private Image Blocked = new Image(getClass().getResourceAsStream("/lib/blocked.png"));


    //private HashSet<ImageView> PossibleMovesKnight = new HashSet<ImageView>();
	
    private HashSet<ImageView> PossibleMovesQueen = new HashSet<ImageView>();
    private static HashSet<ImageView> PossibleMovesKing = new HashSet<ImageView>();
    private static Type selectedQuestionType;
    private static Boolean level4Started = false;
    
    
    public static Type getSelectedQuestionType() {
		return selectedQuestionType;
	}

	public static void setSelectedQuestionType(Type selectedQuestionType) {
		GameController.selectedQuestionType = selectedQuestionType;
	}

	public static HashSet<ImageView> getPossibleMovesKing() {
		return PossibleMovesKing;
	}

	public void setPossibleMovesKing(HashSet<ImageView> possibleMovesKing) {
		PossibleMovesKing = possibleMovesKing;
	}
	private boolean levelUp=false;
    private Alert alert = new Alert(Alert.AlertType.INFORMATION);
	

	@FXML
    void MoveTo() {
		
		//checking if this is the first move in level 4 to start king movement
		if(!level4Started && Game.getInstance().getLevel() == 4) {
			level4Started = true;
			I07.setImage(null);
			System.out.println("first Move");
			
			// the king will change speed move every 10 seconds
			timer.schedule(new kingSpeed(), 0, 10000);
		}
    	
    	while(!remainingTime.getText().equals("0")) {
	    		switch(level.getText()) {
	    		
		    		case"1":{		    			
		    			Boolean movedFlag = false, buttonFlag=true;
		    		
		    			for(Square s : Game.getInstance().getKnight().allPossibleMoves()) {
		    				PossibleButtons.add(getButtonByString("CI"+s.getRow()+s.getCol()));
		    				
		    			}
					
		    			for(Button b: PossibleButtons) {
		    				if(buttonFlag) {
		    					if(b.isPressed())
									{	    							
		    							PressedButton(b.getId());
		    							buttonFlag=false;
		    							movedFlag = true;
									}
		    				}
		    				
		    			}
		    			
		    			PossibleButtons.clear();
		    			//buttonFlag=true;
		    			if(buttonFlag) {
		    				try {
		    					alert.setTitle("Wrong Square Pressed!");
		    					alert.setContentText("Press ok to continue.");
		    					alert.setHeaderText("Please press only on the white squares.");
		    					alert.showAndWait();
		    				} catch (Error e) {
		    					e.printStackTrace();
		    				} catch (Exception e) {
		    					e.printStackTrace();
		    				}
		    			}
		    			
		    			/*
		    			 * If statment to check if the player can move on to the next level 
		    			 */
		    			if(SysData.getInstance().getHistoryGamesForShow().contains(Game.getInstance().getPlayer())) {
		    				for(Player p: SysData.getInstance().getHistoryGamesForShow()) {
		    					if(p.getName().equals(Game.getInstance().getPlayer().getName()) && p.getScore()>=15 )
		    						{
		    							Game.getInstance().setLevel(Game.getInstance().getLevel()+1);
		    							levelUp=true;
		    							ResetSquareType(); // to set all the square as regular squares and be ready for the next level
		    							GenerateSquareType();
		    							try {
		    								alert.setTitle("Congrats!");
		    								alert.setContentText("Press ok to continue.");
		    								alert.setHeaderText("Congratulations, "+ Game.getInstance().getPlayer().getName() +".\n" + "You have now reached to the next level!");
		    								alert.showAndWait();
		    							} catch (Error e) {
		    								e.printStackTrace();
		    							} catch (Exception e) {
		    								e.printStackTrace();
		    							}
		    							countDown();
		    					        
		    					        break;
		    						}
								
		    				}
		    			}
					
		    			
		    			if(movedFlag == true) {
						for(Square s: 	Game.getInstance().getQueen().allPossibleMoves()) {
							PossibleMovesQueen.add(getImageByString("I"+s.getRow()+s.getCol()));
						}
						Game.getInstance().getQueen().setPrev_Place(Game.getInstance().getQueen().getCurrentPlace());
						//Square queen_prev = Game.getInstance().getQueen().getCurrentPlace();
						Game.getInstance().getQueen().moveThePiece(	Game.getInstance().getQueen().allPossibleMoves());
						ImageView temp = null;
						String s = "I" +Integer.toString(Game.getInstance().getQueen().getCurrentPlace().getRow())
								+Integer.toString(Game.getInstance().getQueen().getCurrentPlace().getCol());
						for(ImageView i : allImages ) {
							if(i.getId().equals(s)) {
								i.setImage(QUEEN);
								
								
							}
							
						}
						
						
						String prev = "I" +Integer.toString(Game.getInstance().getQueen().getPrev_Place().getRow())
						+Integer.toString(Game.getInstance().getQueen().getPrev_Place().getCol());
						for(ImageView i : allImages ) {
							if(i.getId().equals(prev)) {
								i.setImage(null);
								
							}
							
						}
						}
		    			movedFlag= false;
		    

		    			if(Game.getInstance().getQueen().getCurrentPlace().getCol()==Game.getInstance().getKnight().getCurrentPlace().getCol() && 
		    					Game.getInstance().getQueen().getCurrentPlace().getRow() == Game.getInstance().getKnight().getCurrentPlace().getRow()) {
		    				try {
		    					alert.setTitle("Game Over!");
		    					alert.setContentText("Good Luck Next Time.");
		    					alert.setHeaderText("Thank You For Playing.");
		    					alert.showAndWait();
		    					SysData.getInstance().addHistory(Game.getInstance().getPlayer());
		    					backToMain();
		    				

		    					
		    				} catch (Error e) {
		    					e.printStackTrace();
		    				} catch (Exception e) {
		    					e.printStackTrace();
		    				}
		    				
		    				
		    			}
				    
		    			break;
		    			
		    		}
		    	
		    		case "2":{
		    			Boolean movedFlag = false, buttonFlag=true;
			    		
		    			for(Square s : Game.getInstance().getKnight().allPossibleMovesLevel2()) {
		    				PossibleButtons.add(getButtonByString("CI"+s.getRow()+s.getCol()));
//		    				String pos = "I"+s.getRow()+s.getCol();
//		    				for(ImageView i : allImages ) {
//								if(i.getId().equals(pos)) {
//									i.setImage(Possible);
//									
//								}
//								
//							}
		    				//SetPossible();
		    				
		    			}
					
		    			for(Button b: PossibleButtons) {
		    				if(buttonFlag) {
		    					if(b.isPressed())
									{	    							
		    							PressedButton(b.getId());
		    							buttonFlag=false;
		    							movedFlag = true;
									}
		    				}
		    				
		    			}
		    			
		    			PossibleButtons.clear();
		    			//buttonFlag=true;
		    			if(buttonFlag) {
		    				try {
		    					alert.setTitle("Wrong Square Pressed!");
		    					alert.setContentText("Press ok to continue.");
		    					alert.setHeaderText("Please press only on the white squares.");
		    					alert.showAndWait();
		    				} catch (Error e) {
		    					e.printStackTrace();
		    				} catch (Exception e) {
		    					e.printStackTrace();
		    				}
		    			}
		    			
		    			/*
		    			 * If statment to check if the player can move on to the next level 
		    			 */
		    			if(SysData.getInstance().getHistoryGamesForShow().contains(Game.getInstance().getPlayer())) {
		    				for(Player p: SysData.getInstance().getHistoryGamesForShow()) {
		    					if(p.getName().equals(Game.getInstance().getPlayer().getName()) && p.getScore()>=15 )
		    						{
		    							Game.getInstance().setLevel(Game.getInstance().getLevel()+1);
		    							levelUp=true;
		    							ResetSquareType(); // to set all the square as regular squares and be ready for the next level
		    							GenerateSquareType();
		    							try {
		    								alert.setTitle("Congrats!");
		    								alert.setContentText("Press ok to continue.");
		    								alert.setHeaderText("Congratulations, "+ Game.getInstance().getPlayer().getName() +".\n" + "You have now reached to the next level!");
		    								alert.showAndWait();
		    							} catch (Error e) {
		    								e.printStackTrace();
		    							} catch (Exception e) {
		    								e.printStackTrace();
		    							}
		    							countDown();
		    					        
		    					        break;
		    						}
								
		    				}
		    			}
					
		    			try {
		    				
		    				 Thread.sleep(2000);
		    			} catch (InterruptedException e) {
		    				 // TODO Auto-generated catch block
		    				 e.printStackTrace();
		    			}
		    			
		    			if(movedFlag == true) {
						for(Square s: 	Game.getInstance().getQueen().allPossibleMoves()) {
							PossibleMovesQueen.add(getImageByString("I"+s.getRow()+s.getCol()));
						}
						Game.getInstance().getQueen().setPrev_Place(Game.getInstance().getQueen().getCurrentPlace());
						//Square queen_prev = Game.getInstance().getQueen().getCurrentPlace();
						Game.getInstance().getQueen().moveThePiece(	Game.getInstance().getQueen().allPossibleMoves());
						ImageView temp = null;
						String s = "I" +Integer.toString(Game.getInstance().getQueen().getCurrentPlace().getRow())
								+Integer.toString(Game.getInstance().getQueen().getCurrentPlace().getCol());
						for(ImageView i : allImages ) {
							if(i.getId().equals(s)) {
								i.setImage(QUEEN);
								
								
							}
							
						}
						
						
						String prev = "I" +Integer.toString(Game.getInstance().getQueen().getPrev_Place().getRow())
						+Integer.toString(Game.getInstance().getQueen().getPrev_Place().getCol());
						for(ImageView i : allImages ) {
							if(i.getId().equals(prev)) {
								i.setImage(null);
								
							}
							
						}
						}
		    			movedFlag= false;
		    

		    			if(Game.getInstance().getQueen().getCurrentPlace().getCol()==Game.getInstance().getKnight().getCurrentPlace().getCol() && 
		    					Game.getInstance().getQueen().getCurrentPlace().getRow() == Game.getInstance().getKnight().getCurrentPlace().getRow()) {
		    				try {
		    					alert.setTitle("Game Over!");
		    					alert.setContentText("Good Luck Next Time.");
		    					alert.setHeaderText("Thank You For Playing.");
		    					alert.showAndWait();
		    					SysData.getInstance().addHistory(Game.getInstance().getPlayer());
		    					backToMain();
		    				

		    					
		    				} catch (Error e) {
		    					e.printStackTrace();
		    				} catch (Exception e) {
		    					e.printStackTrace();
		    				}
		    				
		    				
		    			}
		    			break;
		    		}
		    		
		    		case "3":{
		    			Boolean buttonFlag=true, gameStillGoing = true;
		    			Timer timer = new Timer();
		    			// the king will move every 10 seconds
//		    			timer.schedule(new kingMovement(), 0, 10000);
//		    			// the king will move every 8 seconds
//		    			timer.schedule(new kingMovement(), 10000, 8000);
//		    			// the king will move every 7 seconds
//		    			timer.schedule(new kingMovement(), 20000, 70000);
//		    			// the king will move every 6 seconds
//		    			timer.schedule(new kingMovement(), 30000, 6000);
//		    			// the king will move every 5 seconds
//		    			timer.schedule(new kingMovement(), 40000, 5000);
//		    			// the king will move every 1 seconds
//		    			timer.schedule(new kingMovement(), 50000, 1000);
		    			
		    			while(gameStillGoing) {
		    				
		    				for(Square s : Game.getInstance().getKnight().allPossibleMoves()) {
		    				PossibleButtons.add(getButtonByString("CI"+s.getRow()+s.getCol()));
		    				}
		    				
		    				for(Button b: PossibleButtons) {
			    				if(buttonFlag) {
			    					if(b.isPressed())
										{	    							
			    							PressedButton(b.getId());
			    							buttonFlag=false;
			    							
										}
			    				}
			    				
			    			}
		    				
			    			PossibleButtons.clear();
			    			//buttonFlag=true;
			    			if(buttonFlag) {
			    				try {
			    					alert.setTitle("Wrong Square Pressed!");
			    					alert.setContentText("Press ok to continue.");
			    					alert.setHeaderText("Please press only on the white squares.");
			    					alert.showAndWait();
			    				} catch (Error e) {
			    					e.printStackTrace();
			    				} catch (Exception e) {
			    					e.printStackTrace();
			    				}
			    			}
			    			
			    			// checking if the player finished the game
			    			
			    			if(SysData.getInstance().getHistoryGamesForShow().contains(Game.getInstance().getPlayer())) {
			    				for(Player p: SysData.getInstance().getHistoryGamesForShow()) {
			    					if(p.getName().equals(Game.getInstance().getPlayer().getName()) && p.getScore()>=15 )
			    						{
			    							Game.getInstance().setLevel(Game.getInstance().getLevel()+1);
			    							levelUp=true;
			    							ResetSquareType(); // to set all the square as regular squares and be ready for the next level
			    							GenerateSquareType();
			    							try {
			    								alert.setTitle("Congrats!");
			    								alert.setContentText("Press ok to continue.");
			    								alert.setHeaderText("Congratulations, "+ Game.getInstance().getPlayer().getName() +".\n" + "You have now reached to the next level!");
			    								alert.showAndWait();
			    							} catch (Error e) {
			    								e.printStackTrace();
			    							} catch (Exception e) {
			    								e.printStackTrace();
			    							}
			    							countDown();
			    					        
			    					        break;
			    						}
									
			    				}
			    			}
			    			if(Game.getInstance().getKing().getCurrentPlace().getCol()==Game.getInstance().getKnight().getCurrentPlace().getCol() && 
			    					Game.getInstance().getKing().getCurrentPlace().getRow() == Game.getInstance().getKnight().getCurrentPlace().getRow()) {
			    				try {
			    					alert.setTitle("Game Over!");
			    					alert.setContentText("Good Luck Next Time.");
			    					alert.setHeaderText("Thank You For Playing.");
			    					alert.showAndWait();
			    					SysData.getInstance().addHistory(Game.getInstance().getPlayer());
			    					backToMain();
			    				

			    					
			    				} catch (Error e) {
			    					e.printStackTrace();
			    				} catch (Exception e) {
			    					e.printStackTrace();
			    				}
			    				
			    				
			    			}
			    			
			    			
			    			
		    				
		    			}
		    			break;
		    		}
		    		
		    		case "4":{
		    			
		    			Boolean buttonFlag=true;
		    			
	    				if(Game.getInstance().getKing().getCurrentPlace().getCol()==Game.getInstance().getKnight().getCurrentPlace().getCol() && 
		    					Game.getInstance().getKing().getCurrentPlace().getRow() == Game.getInstance().getKnight().getCurrentPlace().getRow()) {
		    				try {
		    					
		    					timer.cancel();
		    					timer.purge();
		    					alert.setTitle("Game Over!");
		    					alert.setContentText("Good Luck Next Time.");
		    					alert.setHeaderText("Thank You For Playing.");
		    					alert.showAndWait();
		    					backToMain();
		    				

		    					
		    				} catch (Error e) {
		    					e.printStackTrace();
		    				} catch (Exception e) {
		    					e.printStackTrace();
		    				}
		    				
		    				
		    			}
	    				
	    				if(remainingTime.getText().equals("0")){
		    				timer.cancel();
	    					timer.purge();
		    		    	
		    		    	}
	    				
	    				
		    			if(Game.getInstance().getPlayer().getScore() >=15) {
		    				

		    				try {
		    					
		    					
		    					timer.cancel();
		    		    		timer.purge();
		    					alert.setTitle("Congrats!");
		    					alert.setContentText("Press ok to continue.");
		    					alert.setHeaderText("Congratulations, "+ Game.getInstance().getPlayer().getName() +".\n" + "You have won the game!");
		    					alert.showAndWait();
		    					backToMain();
		    					} catch (Error e) {
		    							e.printStackTrace();
		    						} catch (Exception e) {
		    							
		    							e.printStackTrace();
		    						}
		    							countDown();
		    					        
		    					        break;
		    						}
		    			

		    				
		    				for(Square s : Game.getInstance().getKnight().allPossibleMovesLevel2()) {
		    					PossibleButtons.add(getButtonByString("CI"+s.getRow()+s.getCol()));
		    					}
		    				
		    				for(Button b: PossibleButtons) {
			    				if(buttonFlag) {
			    					if(b.isPressed())
										{	    							
			    							PressedButton(b.getId());
			    							buttonFlag=false;
			    							
										}
			    				}
			    				
			    			}
		    				

		    				
			    			PossibleButtons.clear();
			    			//buttonFlag=true;
			    			if(buttonFlag) {
			    				try {
			    					alert.setTitle("Wrong Square Pressed!");
			    					alert.setContentText("Press ok to continue.");
			    					alert.setHeaderText("Please press only on the white squares.");
			    					alert.showAndWait();
			    				} catch (Error e) {
			    					e.printStackTrace();
			    				} catch (Exception e) {
			    					e.printStackTrace();
			    				}
			    			}
			    			
			    			// checking if the player finished the game
			    			

								
//		    				}
//		    			}
			    			
			    			// checking timer because in case 4 there is a while loop
			    			
			    			if(remainingTime.getText().equals("0")){
			    				timer.cancel();
		    					timer.purge();
			    		    	
			    		    	}
			    			
			    			
			    			
		    				
		    			
		    			break;
		    		}
	    	}
    		break;	
    	}
    	if(remainingTime.getText().equals("0")){
    	try {
    		timer.cancel();
			timer.purge();
			alert.setTitle("game Over!");
			alert.setContentText("Time Out.");
			alert.setHeaderText("Thank You For Playing.");
			alert.showAndWait();
			SysData.getInstance().addHistory(Game.getInstance().getPlayer());
			backToMain();
		} catch (Error e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
    	}
    }
    
    private ImageView getImageByStringBoard(String s) { //by sending string (rowNum, colNum) to the function we will get ImageView that starts with the letter S+rowNum+colNum
    	for(ImageView i : getBoardImages()) {
    		if(s.equals(i.getId())) {
    			return i;
    		}
    	}
    	return null;
    }
    
    static ImageView getImageByString(String s) { //by sending string (rowNum, colNum) to the function we will get ImageView that starts with the letter I+rowNum+colNum
    	for(ImageView i : getAllImages()) {
    		if(s.equals(i.getId())) {
    			return i;
    		}
    	}
    	return null;
    }
    
	private Button getButtonByString(String s) { //by sending string (rowNum, colNum) to the function we will get Button that starts with the letter CI+rowNum+colNum
    	for(Button i : getAllButtons()) {
    		if(s.equals(i.getId())) {
    			return i;
    		}
    	}
    	return null;
    }
    
    private void SetPossible() { // function to show the possible moves by setting white color on the square
    	
    	for(Square s : 	Game.getInstance().getKnight().allPossibleMoves()) {
    		
    		if(Board[s.getRow()][s.getCol()].getSquareType().equals(Type.Regular) || Board[s.getRow()][s.getCol()].getSquareType().equals(Type.RandomJump))
    			getImageByString("I"+s.getRow()+s.getCol()).setImage(Possible); // set image with name Possible (White color) to show the possible moves
    			
	    	if(Board[s.getRow()][s.getCol()].getSquareType().equals(Type.EasyQuestion) || Board[s.getRow()][s.getCol()].getSquareType().equals(Type.HardQuestion) || 
	    			Board[s.getRow()][s.getCol()].getSquareType().equals(Type.MediumQuestion)) {
		    	getImageByString("I"+s.getRow()+s.getCol()).setImage(QuestionWhite); 
	    	}
		}
    }
    
    private void SetPossibleLEVEL2() { // function to show the possible moves by setting white color on the square
    	
    	for(Square s : 	Game.getInstance().getKnight().allPossibleMovesLevel2()) {
    		if(Board[s.getRow()][s.getCol()].getSquareType().equals(Type.Regular) || Board[s.getRow()][s.getCol()].getSquareType().equals(Type.RandomJump))
    			getImageByString("I"+s.getRow()+s.getCol()).setImage(Possible);// set image with name Possible (White color) to show the possible moves
	    	if(Board[s.getRow()][s.getCol()].getSquareType().equals(Type.EasyQuestion) || Board[s.getRow()][s.getCol()].getSquareType().equals(Type.HardQuestion) || 
	    			Board[s.getRow()][s.getCol()].getSquareType().equals(Type.MediumQuestion)) {
		    	getImageByString("I"+s.getRow()+s.getCol()).setImage(QuestionWhite); 
	    	}
		}
    }
    
    private void RemovePossible() { // function to remove the possible moves
    	for(Square s : 	Game.getInstance().getKnight().allPossibleMoves()) {
    		if(Board[s.getRow()][s.getCol()].getSquareType().equals(Type.Regular) || Board[s.getRow()][s.getCol()].getSquareType().equals(Type.RandomJump))
    			getImageByString("I"+s.getRow()+s.getCol()).setImage(null); // set image null to remove the possible moves
    		if(Board[s.getRow()][s.getCol()].getSquareType().equals(Type.EasyQuestion) || (Board[s.getRow()][s.getCol()].getSquareType().equals(Type.MediumQuestion) || (Board[s.getRow()][s.getCol()].getSquareType().equals(Type.HardQuestion))))
    			getImageByString("I"+s.getRow()+s.getCol()).setImage(Question);
    		if(Board[s.getRow()][s.getCol()].getSquareType().equals(Type.Blocked))
    			getImageByString("I"+s.getRow()+s.getCol()).setImage(Blocked);
		}
    }
    
    private void RemovePossibleLEVEL2() { // function to remove the possible moves
    	for(Square s : 	Game.getInstance().getKnight().allPossibleMovesLevel2()) {
    		
    		if(Board[s.getRow()][s.getCol()].getSquareType().equals(Type.Regular) || Board[s.getRow()][s.getCol()].getSquareType().equals(Type.RandomJump))
    			getImageByString("I"+s.getRow()+s.getCol()).setImage(null); // set image null to remove the possible moves
    		if(Board[s.getRow()][s.getCol()].getSquareType().equals(Type.EasyQuestion) || (Board[s.getRow()][s.getCol()].getSquareType().equals(Type.MediumQuestion) || (Board[s.getRow()][s.getCol()].getSquareType().equals(Type.HardQuestion))))
    			getImageByString("I"+s.getRow()+s.getCol()).setImage(Question);
    		if(Board[s.getRow()][s.getCol()].getSquareType().equals(Type.Blocked))
    			getImageByString("I"+s.getRow()+s.getCol()).setImage(Blocked);
    		
		}
    }
    
    private Square[][] BuildSquares(){ // function to build 64 squares with Regular type
    	
    	for(int i=0 ; i<8 ; i++) {
			for(int j=0; j<8 ; j++) {
				Board[i][j] = SquareFactory.makeSquare(i,j,Type.Regular);
			}
			
		}
    return Board;
    }
    
    private void ResetSquareType() { // when the level is up, all the squares will get Regular type to avoid square types more than required to each level.
    	for(int i=0 ; i<8 ; i++) {
			for(int j=0; j<8 ; j++) {
				Board[i][j].setSquareType(Type.Regular);
			}
			
		}
    }
    private void GenerateSquareType() {// generate square types for each level

    	switch(Game.getInstance().getLevel()) {
    	
    	case 1:{ // when the level is 1 the game builds 3 RandomJump squares.
    		
    		for(int k=0;k<3;k++) {
    			Square s= randomRegularSquare();
        		s.setSquareType(Type.RandomJump);
        		System.out.println("Random -> "+s.getRow() + " "+ s.getCol());
    		}
    		break;
    	}
    	
    	case 2:{ // when the level is 2 the game builds 3 Forget squares.
    		
    		for(int k=0;k<3;k++) {
    			Square s= randomRegularSquare();
        		s.setSquareType(Type.Forget);
    		}
    		
    		break;
    	}
    	
    	case 3:{ // when the level is 3 the game builds 2 Forget squares and 2 RandomJump Squares.
    		
    		for(int k=0;k<2;k++) {
    			Square s1= randomRegularSquare();
        		s1.setSquareType(Type.Forget);
        		Square s2= randomRegularSquare();
        		s2.setSquareType(Type.RandomJump);
    		}
    		
    		break;
    	}
    	
    	case 4:{ // when the level is 4 the game builds 8 Blocked squares.
    		
    		for(int k=0;k<8;k++) {
    			Square s= randomRegularSquare();
        		s.setSquareType(Type.Blocked);
    		}
    		break;
    	}
    	}
    	

		Square s1= randomRegularSquare(); // build one square with easy question.
		s1.setSquareType(Type.EasyQuestion);
		getImageByString("I"+s1.getRow()+s1.getCol()).setImage(Question);
		
		
		Square s2= randomRegularSquare(); // build one square with medium question.
		s2.setSquareType(Type.MediumQuestion);
		getImageByString("I"+s2.getRow()+s2.getCol()).setImage(Question);

		
		Square s3= randomRegularSquare(); // build one square with hard question.
		s3.setSquareType(Type.HardQuestion);
		getImageByString("I"+s3.getRow()+s3.getCol()).setImage(Question);

    }
    
    private void GetNewSquareByType(int r, int c, Type t) { // when the player press on a button with one of these types the game create square with the same type
    	
    	boolean flag=true;
    	
    	
    	while(flag) {
    		Square s = randomRegularSquare();
    		if(!(s.getRow()==r&&s.getCol()==c)) {
    			switch(t.toString()) {
    			
    			case "RandomJump":{ // set new square with RandomJump type.
    				s.setSquareType(Type.RandomJump);
    				System.out.println("New RANDOM" +s.getCol() + " " +s.getRow());
    				break;
    			}
    			
    			case "Forget":{ // set new square with Forget type.
    				s.setSquareType(Type.Forget);
    				break;
    			}
    			
    			case "Blocked":{ // set new square with Blocked type.
    				s.setSquareType(Type.Blocked);
    				break;
    			}
    		
    			case "EasyQuestion":{ // set new square with EasyQuestion type.
    				s.setSquareType(Type.EasyQuestion);
    				getImageByString("I"+r+c).setImage(Question);
    				
    				/*
    				 * to add question when the player press on it
    				 */
    				break;
    			}
    			
    			case "MediumQuestion":{ // set new square with MediumQuestion type.
    				s.setSquareType(Type.MediumQuestion);
    				System.err.println();
    				getImageByString("I"+r+c).setImage(Question);

    				/*
    				 * to add question when the player press on it
    				 */
    				break;
    			}
    			
    			case "HardQuestion":{ // set new square with HardQuestion type.
    				s.setSquareType(Type.HardQuestion);
    				getImageByString("I"+r+c).setImage(Question);

    				/*
    				 * to add question when the player press on it
    				 */
    				break;
    			}
    		}
    			
    		flag=false; // set flag=false to end the random searching for RegularSquare.
    		}
    	}
    }
    
    // method to handle player pressing any button based on button type
    private void PressedButton(String s) {
    	
    	int i = Character.getNumericValue(s.charAt(2)); // Row number for the pressed square
    	int j = Character.getNumericValue(s.charAt(3)); // Column number for the pressed square

    	//Nothing happens if a player presses on a blocked square
    	if(!Board[i][j].getSquareType().equals(Type.Blocked)) {
    		
    		if(SysData.getInstance().getGame().getLevel()==1)
    			RemovePossible();
    		else RemovePossibleLEVEL2();
    		Square prevPlace=Game.getInstance().getKnight().getCurrentPlace();
			Game.getInstance().getKnight().setCurrentPlace(Board[i][j]);
    		getImageByStringBoard("S"+prevPlace.getRow()+prevPlace.getCol()).setImage(Visited);
    		getImageByString("I"+prevPlace.getRow()+prevPlace.getCol()).setImage(null);
		
		// if player pressed a regular square
    		if((Board[i][j].getSquareType().equals(Type.Regular))) {
    			getImageByString("I"+i+j).setImage(KNIGHT);
    			if(Board[i][j].isVisisted()) {
    				Game.getInstance().getPlayer().setScore(Game.getInstance().getPlayer().getScore()-1);
    			}
    			else {
    				Board[i][j].setVisisted(true);
    				Game.getInstance().getPlayer().setScore(Game.getInstance().getPlayer().getScore()+1);
					}
    		}
		// if the square is anything but a regular square
    		else {
    			handleSquare(i, j, Board[i][j].getSquareType());
    		}
		
    	}
    	
    	else if(Board[i][j].getSquareType().equals(Type.Blocked))
    			getImageByString("I"+i+j).setImage(Blocked);
    	
    	if(SysData.getInstance().getGame().getLevel()==1)
    		SetPossible();
    	else if(SysData.getInstance().getGame().getLevel()==2||SysData.getInstance().getGame().getLevel()==3|| SysData.getInstance().getGame().getLevel()==4)
    		SetPossibleLEVEL2();
        score.setText(Integer.toString(Game.getInstance().getPlayer().getScore()));

        if(Game.getInstance().Winner(Game.getInstance().getScore()))
			{
        		try {
			
				popWinner();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			}
//		try {
//			Thread.sleep(1000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}



    }
		/*
		 * to check if we need to set new type for another square
		 */
//		if((Board[i][j].getSquareType().equals(Type.Forget)) || (Board[i][j].getSquareType().equals(Type.RandomJump)) || (Board[i][j].getSquareType().equals(Type.Blocked)))
//		for(int r=0;r<8;r++) {
//			for(int c=0;c<8;c++) {
//				if(r==i&&c==j)
//					GetNewSquareByType(i,j,Board[i][j].getSquareType());
//			}
//		}
		
    
    // a function to handle RandomJump ,Forget, Question squares.
    public void handleSquare(int i, int j, Type squareType) {
    	switch(squareType) {
    	
    	// moving knight to random square and creating a new random jump square
    	case RandomJump: {
    		try {
				alert.setTitle("OOPs!");
				alert.setContentText("random jump.");
				alert.setHeaderText("Get Ready, "+ Game.getInstance().getPlayer().getName());
				alert.showAndWait();
			} catch (Error e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
			countDown();
	        
	        
    		Board[i][j].setSquareType(Type.Regular);
    		GetNewSquareByType(i,j,Type.RandomJump);
    		Square jumpTo1 = randomSquare();
    		getImageByString("I"+jumpTo1.getRow() + jumpTo1.getCol()).setImage(KNIGHT);
    		Game.getInstance().getKnight().setCurrentPlace(Board[jumpTo1.getRow()][jumpTo1.getCol()]);
    		
    		if(Board[jumpTo1.getRow()][jumpTo1.getCol()].isVisisted()) {
				Game.getInstance().getPlayer().setScore(Game.getInstance().getPlayer().getScore()-1);
		    }
			else {
				Board[i][j].setVisisted(true);
				Game.getInstance().getPlayer().setScore(Game.getInstance().getPlayer().getScore()+1);
				}
    		
    		break;
    	}
    	case Forget:{
    		Board[i][j].setSquareType(Type.Regular);
    		GetNewSquareByType(i,j,Type.Forget);
    		getImageByString("I"+i+j).setImage(KNIGHT);
    		Game.getInstance().getKnight().setCurrentPlace(Board[i][j]);
    		
    		if(Board[i][j].isVisisted()) {
				Game.getInstance().getPlayer().setScore(Game.getInstance().getPlayer().getScore()-1);
		    }
			else {
				Board[i][j].setVisisted(true);
				Game.getInstance().getPlayer().setScore(Game.getInstance().getPlayer().getScore()+1);
				}
    		break;
    	}
        case EasyQuestion:{
        	setSelectedQuestionType(Type.EasyQuestion);
        	Board[i][j].setSquareType(Type.Regular);
    		GetNewSquareByType(i,j,Type.EasyQuestion);

    		getImageByString("I"+i+j).setImage(KNIGHT);
    		Game.getInstance().getKnight().setCurrentPlace(Board[i][j]);
    		
    		if(Board[i][j].isVisisted()) {
				Game.getInstance().getPlayer().setScore(Game.getInstance().getPlayer().getScore()-1);
		    }
			else {
				Board[i][j].setVisisted(true);
				Game.getInstance().getPlayer().setScore(Game.getInstance().getPlayer().getScore()+1);
				}
    		try {
				popQuestion();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    		Square s1= randomRegularSquare(); // build one square with easy question.
    		s1.setSquareType(Type.EasyQuestion);
    		getImageByString("I"+s1.getRow()+s1.getCol()).setImage(Question);
    		break;
        }
    	case MediumQuestion:{
    		setSelectedQuestionType(Type.MediumQuestion);
    		Board[i][j].setSquareType(Type.Regular);
    		GetNewSquareByType(i,j,Type.MediumQuestion);

    		getImageByString("I"+i+j).setImage(KNIGHT);
    		Game.getInstance().getKnight().setCurrentPlace(Board[i][j]);
    		
    		if(Board[i][j].isVisisted()) {
				Game.getInstance().getPlayer().setScore(Game.getInstance().getPlayer().getScore()-1);
		    }
			else {
				Board[i][j].setVisisted(true);
				Game.getInstance().getPlayer().setScore(Game.getInstance().getPlayer().getScore()+1);
				}
    		try {
				popQuestion();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    		Square s1= randomRegularSquare(); // build one square with easy question.
    		s1.setSquareType(Type.MediumQuestion);
    		getImageByString("I"+s1.getRow()+s1.getCol()).setImage(Question);
    		break;
        }
    	case HardQuestion:{
    		setSelectedQuestionType(Type.HardQuestion);
    		Board[i][j].setSquareType(Type.Regular);
    		GetNewSquareByType(i,j,Type.HardQuestion);
    		getImageByString("I"+i+j).setImage(KNIGHT);
    		Game.getInstance().getKnight().setCurrentPlace(Board[i][j]);
    		
    		if(Board[i][j].isVisisted()) {
				Game.getInstance().getPlayer().setScore(Game.getInstance().getPlayer().getScore()-1);
		    }
			else {
				Board[i][j].setVisisted(true);
				Game.getInstance().getPlayer().setScore(Game.getInstance().getPlayer().getScore()+1);
				}
    		try {
				popQuestion();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    		Square s1= randomRegularSquare(); // build one square with easy question.
    		s1.setSquareType(Type.HardQuestion);
    		getImageByString("I"+s1.getRow()+s1.getCol()).setImage(Question);
    		break;
        }
		default:
			break;
    	
    	}
    }
    
    private void popQuestion() throws IOException {
		timeline.pause();
    	Parent pane = FXMLLoader.load(getClass().getResource("/views/QuestionWindow.fxml"));
		Scene scene = new Scene(pane);
		Stage newstage = new Stage();
		newstage.setScene(scene);
		newstage.setTitle("Question PopUp");
		newstage.showAndWait();
		timeline.play();

    }
    
    private void popWinner() throws IOException {
		timeline.pause();
    	Parent pane = FXMLLoader.load(getClass().getResource("/views/WinnerWindow.fxml"));
		Scene scene = new Scene(pane);
		Stage newstage = new Stage();
		newstage.setScene(scene);
		newstage.setTitle("You are the winner! Congrats.");
		newstage.showAndWait();
		timeline.play();

    }
    
    // a method that returns a random regular square 
    public Square randomRegularSquare() {
    	
    	boolean flag = true;
    	int randomNumber1, randomNumber2;
    	do {
    		 randomNumber1 = (int) (Math.random() * 8);
        	 randomNumber2 = (int) (Math.random() * 8);
        	if(Board[randomNumber1][randomNumber2].getSquareType().equals(Type.Regular)) // checking if the type is regular to continue
        		flag = false;
    		
    	}while(flag);
    	
    	return Board[randomNumber1][randomNumber2];


    }
    
 public Square randomSquare() {
    	
    	int randomNumber1, randomNumber2;
    		 randomNumber1 = (int) (Math.random() * 8);
        	 randomNumber2 = (int) (Math.random() * 8);
    	return Board[randomNumber1][randomNumber2];


    }

	private void PressedButtonNotUsed() {	
//		if(SysData.getInstance().getHistoryGamesForShow().contains(Game.getInstance().getPlayer())) {
//		for(Player p: SysData.getInstance().getHistoryGamesForShow()) {
//			if(p.getName().equals(Game.getInstance().getPlayer().getName()) && p.getScore()>=15 )
//				Game.getInstance().setLevel(Game.getInstance().getLevel()+1);
//	
//		}
//	}
    	
    	
//    	switch(s) {
//    	
//    	case "CI00":{
//    		//Type squareType = Game.getInstance().getKnight().getCurrentPlace().getSquareType();
//    		//Game.getInstance().handleSquare(i, j, squareType);
//    		I00.setImage(KNIGHT);
//    		RemovePossible();
//    		Square prevPlace=Game.getInstance().getKnight().getCurrentPlace();
//    		getImageByStringBoard("S"+prevPlace.getRow()+prevPlace.getCol()).setImage(Visited);
//    		getImageByString("I"+prevPlace.getRow()+prevPlace.getCol()).setImage(null);
//    		if(Board[0][0].isVisisted())
//    			Game.getInstance().getPlayer().setScore(Game.getInstance().getPlayer().getScore()-1);
//    		else {
//    			Board[0][0].setVisisted(true);
//    			Game.getInstance().getKnight().setCurrentPlace(Board[0][0]);
//        		Game.getInstance().getPlayer().setScore(Game.getInstance().getPlayer().getScore()+1);
//    		}
//    		for(Button b: PossibleButtons)
//				PossibleButtons.remove(b);
//    		if(Game.getInstance().getKnight().getCurrentPlace().getSquareType()==utils.Type.RandomJump) {
//    			for(Square sq : Game.getInstance().getKnight().EmptyPossibleMoves())
//    				PossibleButtons.add(getButtonByString("CI"+sq.getRow()+sq.getCol()));
//			
//    			for(Button b: PossibleButtons) {
//    				if(b.isPressed())
//						PressedButton(b.getId());
//    				}
//    			}
//    			
////    				if(SysData.getInstance().getHistoryGamesForShow().contains(Game.getInstance().getPlayer())) {
////    					for(Player p: SysData.getInstance().getHistoryGamesForShow()) {
////    						if(p.getName().equals(Game.getInstance().getPlayer().getName()) && p.getScore()>=15 )
////    							Game.getInstance().setLevel(Game.getInstance().getLevel()+1);
////					
////    					}
////    				}
//    			
//    		break;
//    		}
//    	
//    	case "CI01":{
//    		I01.setImage(KNIGHT);
//    		RemovePossible();
//    		Square prevPlace=	Game.getInstance().getKnight().getCurrentPlace();
//    		getImageByStringBoard("S"+prevPlace.getRow()+prevPlace.getCol()).setImage(Visited);
//    		getImageByString("I"+prevPlace.getRow()+prevPlace.getCol()).setImage(null);
//    		Board[0][1].setVisisted(true);
//    			Game.getInstance().getKnight().setCurrentPlace(Board[0][1]);
//    		break;
//    		}
//    	
//    	case "CI02":{
//    		I02.setImage(KNIGHT);
//    		RemovePossible();
//    		Square prevPlace=	Game.getInstance().getKnight().getCurrentPlace();
//    		getImageByStringBoard("S"+prevPlace.getRow()+prevPlace.getCol()).setImage(Visited);
//    		getImageByString("I"+prevPlace.getRow()+prevPlace.getCol()).setImage(null);
//    		Board[0][2].setVisisted(true);
//    			Game.getInstance().getKnight().setCurrentPlace(Board[0][2]);
//    		break;
//    		}
//    	
//    	case "CI03":{
//    		I03.setImage(KNIGHT);
//    		RemovePossible();
//    		Square prevPlace=	Game.getInstance().getKnight().getCurrentPlace();
//    		getImageByStringBoard("S"+prevPlace.getRow()+prevPlace.getCol()).setImage(Visited);
//    		getImageByString("I"+prevPlace.getRow()+prevPlace.getCol()).setImage(null);
//    		Board[0][3].setVisisted(true);
//    			Game.getInstance().getKnight().setCurrentPlace(Board[0][3]);
//    		break;
//    		}
//    	
//    	case "CI04":{
//    		I04.setImage(KNIGHT);
//    		RemovePossible();
//    		Square prevPlace=	Game.getInstance().getKnight().getCurrentPlace();
//    		getImageByStringBoard("S"+prevPlace.getRow()+prevPlace.getCol()).setImage(Visited);
//    		getImageByString("I"+prevPlace.getRow()+prevPlace.getCol()).setImage(null);
//    		Board[0][4].setVisisted(true);
//    			Game.getInstance().getKnight().setCurrentPlace(Board[0][4]);
//    		break;
//    		}
//    	
//    	case "CI05":{
//    		I05.setImage(KNIGHT);
//    		RemovePossible();
//    		Square prevPlace=	Game.getInstance().getKnight().getCurrentPlace();
//    		getImageByStringBoard("S"+prevPlace.getRow()+prevPlace.getCol()).setImage(Visited);
//    		getImageByString("I"+prevPlace.getRow()+prevPlace.getCol()).setImage(null);
//    		Board[0][5].setVisisted(true);
//    			Game.getInstance().getKnight().setCurrentPlace(Board[0][5]);
//    		break;
//    		}
//    	
//    	case "CI06":{
//    		I06.setImage(KNIGHT);
//    		RemovePossible();
//    		Square prevPlace=	Game.getInstance().getKnight().getCurrentPlace();
//    		getImageByStringBoard("S"+prevPlace.getRow()+prevPlace.getCol()).setImage(Visited);
//    		getImageByString("I"+prevPlace.getRow()+prevPlace.getCol()).setImage(null);
//    		Board[0][6].setVisisted(true);
//    			Game.getInstance().getKnight().setCurrentPlace(Board[0][6]);
//    		break;
//    		}
//    	
//    	case "CI07":{
//    		I07.setImage(KNIGHT);
//    		RemovePossible();
//    		Square prevPlace=	Game.getInstance().getKnight().getCurrentPlace();
//    		getImageByStringBoard("S"+prevPlace.getRow()+prevPlace.getCol()).setImage(Visited);
//    		getImageByString("I"+prevPlace.getRow()+prevPlace.getCol()).setImage(null);
//    		Board[0][7].setVisisted(true);
//    			Game.getInstance().getKnight().setCurrentPlace(Board[0][7]);
//    		break;
//    		}
//    	
//    	case "CI10":{
//    		I10.setImage(KNIGHT);
//    		RemovePossible();
//    		Square prevPlace=	Game.getInstance().getKnight().getCurrentPlace();
//    		getImageByStringBoard("S"+prevPlace.getRow()+prevPlace.getCol()).setImage(Visited);
//    		getImageByString("I"+prevPlace.getRow()+prevPlace.getCol()).setImage(null);
//    		Board[1][0].setVisisted(true);
//    		Game.getInstance().getKnight().setCurrentPlace(Board[1][0]);
//    		break;
//    		}
//    
//    	case "CI11":{
//    		RemovePossible();
//    		I11.setImage(KNIGHT);
//    		Square prevPlace=	Game.getInstance().getKnight().getCurrentPlace();
//    		getImageByStringBoard("S"+prevPlace.getRow()+prevPlace.getCol()).setImage(Visited);
//    		getImageByString("I"+prevPlace.getRow()+prevPlace.getCol()).setImage(null);
//    		Board[1][1].setVisisted(true);
//    		Game.getInstance().getKnight().setCurrentPlace(Board[1][1]);
//    		break;
//    		}
//    	
//    	case "CI12":{
//    		RemovePossible();
//    		I12.setImage(KNIGHT);
//    		Square prevPlace=	Game.getInstance().getKnight().getCurrentPlace();
//    		getImageByStringBoard("S"+prevPlace.getRow()+prevPlace.getCol()).setImage(Visited);
//    		getImageByString("I"+prevPlace.getRow()+prevPlace.getCol()).setImage(null);
//    		Board[1][2].setVisisted(true);
//    		Game.getInstance().getKnight().setCurrentPlace(Board[1][2]);
//    		break;
//    		}
//    	
//    	case "CI13":{
//    		I13.setImage(KNIGHT);
//    		RemovePossible();
//    		Square prevPlace=	Game.getInstance().getKnight().getCurrentPlace();
//    		getImageByStringBoard("S"+prevPlace.getRow()+prevPlace.getCol()).setImage(Visited);
//    		getImageByString("I"+prevPlace.getRow()+prevPlace.getCol()).setImage(null);
//    		Board[1][3].setVisisted(true);
//    		Game.getInstance().getKnight().setCurrentPlace(Board[1][3]);
//    		break;
//    		}
//    	
//    	case "CI14":{
//    		I14.setImage(KNIGHT);
//    		RemovePossible();
//    		Square prevPlace=	Game.getInstance().getKnight().getCurrentPlace();
//    		getImageByStringBoard("S"+prevPlace.getRow()+prevPlace.getCol()).setImage(Visited);
//    		getImageByString("I"+prevPlace.getRow()+prevPlace.getCol()).setImage(null);
//    		Board[1][4].setVisisted(true);
//    		Game.getInstance().getKnight().setCurrentPlace(Board[1][4]);
//    		break;
//    		}
//    	
//    	case "CI15":{
//    		I15.setImage(KNIGHT);
//    		RemovePossible();
//    		Square prevPlace=	Game.getInstance().getKnight().getCurrentPlace();
//    		getImageByStringBoard("S"+prevPlace.getRow()+prevPlace.getCol()).setImage(Visited);
//    		getImageByString("I"+prevPlace.getRow()+prevPlace.getCol()).setImage(null);
//    		Board[1][5].setVisisted(true);
//    		Game.getInstance().getKnight().setCurrentPlace(Board[1][5]);
//    		break;
//    		}
//    	
//    	case "CI16":{
//    		I16.setImage(KNIGHT);
//    		RemovePossible();
//    		Square prevPlace=	Game.getInstance().getKnight().getCurrentPlace();
//    		getImageByStringBoard("S"+prevPlace.getRow()+prevPlace.getCol()).setImage(Visited);
//    		getImageByString("I"+prevPlace.getRow()+prevPlace.getCol()).setImage(null);
//    		Board[1][6].setVisisted(true);
//    			Game.getInstance().getKnight().setCurrentPlace(Board[1][6]);
//    		break;
//    		}
//    	
//    	case "CI17":{
//    		I17.setImage(KNIGHT);
//    		RemovePossible();
//    		Square prevPlace=	Game.getInstance().getKnight().getCurrentPlace();
//    		getImageByStringBoard("S"+prevPlace.getRow()+prevPlace.getCol()).setImage(Visited);
//    		getImageByString("I"+prevPlace.getRow()+prevPlace.getCol()).setImage(null);
//    		Board[1][7].setVisisted(true);
//    			Game.getInstance().getKnight().setCurrentPlace(Board[1][7]);
//    		break;
//    		}
//    	
//    	case "CI20":{
//    		I20.setImage(KNIGHT);
//    		RemovePossible();
//    		Square prevPlace=	Game.getInstance().getKnight().getCurrentPlace();
//    		getImageByStringBoard("S"+prevPlace.getRow()+prevPlace.getCol()).setImage(Visited);
//    		getImageByString("I"+prevPlace.getRow()+prevPlace.getCol()).setImage(null);
//    		Board[2][0].setVisisted(true);
//    			Game.getInstance().getKnight().setCurrentPlace(Board[2][0]);
//    		break;
//    		}
//    	
//    	case "CI21":{
//    		I21.setImage(KNIGHT);
//    		RemovePossible();
//    		Square prevPlace=Game.getInstance().getKnight().getCurrentPlace();
//    		getImageByStringBoard("S"+prevPlace.getRow()+prevPlace.getCol()).setImage(Visited);
//    		getImageByString("I"+prevPlace.getRow()+prevPlace.getCol()).setImage(null);
//    		Board[2][1].setVisisted(true);
//    			Game.getInstance().getKnight().setCurrentPlace(Board[2][1]);
//    		break;
//    		}
//    	
//    	case "CI22":{
//    		I22.setImage(KNIGHT);
//    		RemovePossible();
//    		Square prevPlace=Game.getInstance().getKnight().getCurrentPlace();
//    		getImageByStringBoard("S"+prevPlace.getRow()+prevPlace.getCol()).setImage(Visited);
//    		getImageByString("I"+prevPlace.getRow()+prevPlace.getCol()).setImage(null);
//    		Board[2][2].setVisisted(true);
//    			Game.getInstance().getKnight().setCurrentPlace(Board[2][2]);
//    		break;
//    		}
//    	
//    	case "CI23":{
//    		I23.setImage(KNIGHT);
//    		RemovePossible();
//    		Square prevPlace=	Game.getInstance().getKnight().getCurrentPlace();
//    		getImageByStringBoard("S"+prevPlace.getRow()+prevPlace.getCol()).setImage(Visited);
//    		getImageByString("I"+prevPlace.getRow()+prevPlace.getCol()).setImage(null);
//    		Board[2][3].setVisisted(true);
//    			Game.getInstance().getKnight().setCurrentPlace(Board[2][3]);
//    		break;
//    		}
//    	
//    	case "CI24":{
//    		I24.setImage(KNIGHT);
//    		RemovePossible();
//    		Square prevPlace=	Game.getInstance().getKnight().getCurrentPlace();
//    		getImageByStringBoard("S"+prevPlace.getRow()+prevPlace.getCol()).setImage(Visited);
//    		getImageByString("I"+prevPlace.getRow()+prevPlace.getCol()).setImage(null);
//    		Board[2][4].setVisisted(true);
//    			Game.getInstance().getKnight().setCurrentPlace(Board[2][4]);
//    		break;
//    		
//    		}
//    	
//    	case "CI25":{
//    		I25.setImage(KNIGHT);
//    		RemovePossible();
//    		Square prevPlace=	Game.getInstance().getKnight().getCurrentPlace();
//    		getImageByStringBoard("S"+prevPlace.getRow()+prevPlace.getCol()).setImage(Visited);
//    		getImageByString("I"+prevPlace.getRow()+prevPlace.getCol()).setImage(null);
//    		Board[2][5].setVisisted(true);
//    			Game.getInstance().getKnight().setCurrentPlace(Board[2][5]);
//    		break;
//    		}
//    	
//    	case "CI26":{
//    		I26.setImage(KNIGHT);
//    		RemovePossible();
//    		Square prevPlace=	Game.getInstance().getKnight().getCurrentPlace();
//    		getImageByStringBoard("S"+prevPlace.getRow()+prevPlace.getCol()).setImage(Visited);
//    		getImageByString("I"+prevPlace.getRow()+prevPlace.getCol()).setImage(null);
//    		Board[2][6].setVisisted(true);
//    			Game.getInstance().getKnight().setCurrentPlace(Board[2][6]);
//    		break;
//    		}
//    	
//    	case "CI27":{
//    		I27.setImage(KNIGHT);
//    		RemovePossible();
//    		Square prevPlace=	Game.getInstance().getKnight().getCurrentPlace();
//    		getImageByStringBoard("S"+prevPlace.getRow()+prevPlace.getCol()).setImage(Visited);
//    		getImageByString("I"+prevPlace.getRow()+prevPlace.getCol()).setImage(null);
//    		Board[2][7].setVisisted(true);
//    			Game.getInstance().getKnight().setCurrentPlace(Board[2][7]);
//    		break;
//    		}
//    	
//    	case "CI30":{
//    		I30.setImage(KNIGHT);
//    		RemovePossible();
//    		Square prevPlace=	Game.getInstance().getKnight().getCurrentPlace();
//    		getImageByStringBoard("S"+prevPlace.getRow()+prevPlace.getCol()).setImage(Visited);
//    		getImageByString("I"+prevPlace.getRow()+prevPlace.getCol()).setImage(null);
//    		Board[3][0].setVisisted(true);
//    			Game.getInstance().getKnight().setCurrentPlace(Board[3][0]);
//    		break;
//    		}
//    	
//    	case "CI31":{
//    		I31.setImage(KNIGHT);
//    		RemovePossible();
//    		Square prevPlace=	Game.getInstance().getKnight().getCurrentPlace();
//    		getImageByStringBoard("S"+prevPlace.getRow()+prevPlace.getCol()).setImage(Visited);
//    		getImageByString("I"+prevPlace.getRow()+prevPlace.getCol()).setImage(null);
//    		Board[3][1].setVisisted(true);
//    			Game.getInstance().getKnight().setCurrentPlace(Board[3][1]);
//    		break;
//    		}
//    	
//    	case "CI32":{
//    		I32.setImage(KNIGHT);
//    		RemovePossible();
//    		Square prevPlace=	Game.getInstance().getKnight().getCurrentPlace();
//    		getImageByStringBoard("S"+prevPlace.getRow()+prevPlace.getCol()).setImage(Visited);
//    		getImageByString("I"+prevPlace.getRow()+prevPlace.getCol()).setImage(null);
//    		Board[3][2].setVisisted(true);
//    			Game.getInstance().getKnight().setCurrentPlace(Board[3][2]);
//    		break;
//    		}
//    	
//    	case "CI33":{
//    		I33.setImage(KNIGHT);
//    		RemovePossible();
//    		Square prevPlace=	Game.getInstance().getKnight().getCurrentPlace();
//    		getImageByStringBoard("S"+prevPlace.getRow()+prevPlace.getCol()).setImage(Visited);
//    		getImageByString("I"+prevPlace.getRow()+prevPlace.getCol()).setImage(null);
//    		Board[3][3].setVisisted(true);
//    			Game.getInstance().getKnight().setCurrentPlace(Board[3][3]);
//    		break;
//    		}
//    	
//    	case "CI34":{
//    		I34.setImage(KNIGHT);
//    		RemovePossible();
//    		Square prevPlace=	Game.getInstance().getKnight().getCurrentPlace();
//    		getImageByStringBoard("S"+prevPlace.getRow()+prevPlace.getCol()).setImage(Visited);
//    		getImageByString("I"+prevPlace.getRow()+prevPlace.getCol()).setImage(null);
//    		Board[3][4].setVisisted(true);
//    			Game.getInstance().getKnight().setCurrentPlace(Board[3][4]);
//    		break;
//    		}
//    	
//    	case "CI35":{
//    		I35.setImage(KNIGHT);
//    		RemovePossible();
//    		Square prevPlace=	Game.getInstance().getKnight().getCurrentPlace();
//    		getImageByStringBoard("S"+prevPlace.getRow()+prevPlace.getCol()).setImage(Visited);
//    		getImageByString("I"+prevPlace.getRow()+prevPlace.getCol()).setImage(null);
//    		Board[3][5].setVisisted(true);
//    			Game.getInstance().getKnight().setCurrentPlace(Board[3][5]);
//    		break;
//    		}
//    	
//    	case "CI36":{
//    		I36.setImage(KNIGHT);
//    		RemovePossible();
//    		Square prevPlace=	Game.getInstance().getKnight().getCurrentPlace();
//    		getImageByStringBoard("S"+prevPlace.getRow()+prevPlace.getCol()).setImage(Visited);
//    		getImageByString("I"+prevPlace.getRow()+prevPlace.getCol()).setImage(null);
//    		Board[3][6].setVisisted(true);
//    			Game.getInstance().getKnight().setCurrentPlace(Board[3][6]);
//    		break;
//    		}
//    	
//    	case "CI37":{
//    		I37.setImage(KNIGHT);
//    		RemovePossible();
//    		Square prevPlace=	Game.getInstance().getKnight().getCurrentPlace();
//    		getImageByStringBoard("S"+prevPlace.getRow()+prevPlace.getCol()).setImage(Visited);
//    		getImageByString("I"+prevPlace.getRow()+prevPlace.getCol()).setImage(null);
//    		Board[3][7].setVisisted(true);
//    			Game.getInstance().getKnight().setCurrentPlace(Board[3][7]);
//    		break;
//    		}
//    	
//    	case "CI40":{
//    		I40.setImage(KNIGHT);
//    		RemovePossible();
//    		Square prevPlace=	Game.getInstance().getKnight().getCurrentPlace();
//    		getImageByStringBoard("S"+prevPlace.getRow()+prevPlace.getCol()).setImage(Visited);
//    		getImageByString("I"+prevPlace.getRow()+prevPlace.getCol()).setImage(null);
//    		Board[4][0].setVisisted(true);
//    			Game.getInstance().getKnight().setCurrentPlace(Board[4][0]);
//    		break;
//    		}
//    	
//    	case "CI41":{
//    		I41.setImage(KNIGHT);
//    		RemovePossible();
//    		Square prevPlace=	Game.getInstance().getKnight().getCurrentPlace();
//    		getImageByStringBoard("S"+prevPlace.getRow()+prevPlace.getCol()).setImage(Visited);
//    		getImageByString("I"+prevPlace.getRow()+prevPlace.getCol()).setImage(null);
//    		Board[4][1].setVisisted(true);
//    			Game.getInstance().getKnight().setCurrentPlace(Board[4][1]);
//    		break;
//    		}
//    	
//    	case "CI42":{
//    		I42.setImage(KNIGHT);
//    		RemovePossible();
//    		Square prevPlace=	Game.getInstance().getKnight().getCurrentPlace();
//    		getImageByStringBoard("S"+prevPlace.getRow()+prevPlace.getCol()).setImage(Visited);
//    		getImageByString("I"+prevPlace.getRow()+prevPlace.getCol()).setImage(null);
//    		Board[4][2].setVisisted(true);
//    			Game.getInstance().getKnight().setCurrentPlace(Board[4][2]);
//    		break;
//    		}
//    	
//    	case "CI43":{
//    		I43.setImage(KNIGHT);
//    		RemovePossible();
//    		Square prevPlace=	Game.getInstance().getKnight().getCurrentPlace();
//    		getImageByStringBoard("S"+prevPlace.getRow()+prevPlace.getCol()).setImage(Visited);
//    		getImageByString("I"+prevPlace.getRow()+prevPlace.getCol()).setImage(null);
//    		Board[4][3].setVisisted(true);
//    			Game.getInstance().getKnight().setCurrentPlace(Board[4][3]);
//    		break;
//    		}
//    	
//    	case "CI44":{
//    		I44.setImage(KNIGHT);
//    		RemovePossible();
//    		Square prevPlace=	Game.getInstance().getKnight().getCurrentPlace();
//    		getImageByStringBoard("S"+prevPlace.getRow()+prevPlace.getCol()).setImage(Visited);
//    		getImageByString("I"+prevPlace.getRow()+prevPlace.getCol()).setImage(null);
//    		Board[4][4].setVisisted(true);
//    			Game.getInstance().getKnight().setCurrentPlace(Board[4][4]);
//    		break;
//    		}
//    	
//    	case "CI45":{
//    		I45.setImage(KNIGHT);
//    		RemovePossible();
//    		Square prevPlace=	Game.getInstance().getKnight().getCurrentPlace();
//    		getImageByStringBoard("S"+prevPlace.getRow()+prevPlace.getCol()).setImage(Visited);
//    		getImageByString("I"+prevPlace.getRow()+prevPlace.getCol()).setImage(null);
//    		Board[4][5].setVisisted(true);
//    			Game.getInstance().getKnight().setCurrentPlace(Board[4][5]);
//    		break;
//    		}
//    	
//    	case "CI46":{
//    		I46.setImage(KNIGHT);
//    		RemovePossible();
//    		Square prevPlace=	Game.getInstance().getKnight().getCurrentPlace();
//    		getImageByStringBoard("S"+prevPlace.getRow()+prevPlace.getCol()).setImage(Visited);
//    		getImageByString("I"+prevPlace.getRow()+prevPlace.getCol()).setImage(null);
//    		Board[4][6].setVisisted(true);
//    			Game.getInstance().getKnight().setCurrentPlace(Board[4][6]);
//    		break;
//    		}
//    	
//    	case "CI47":{
//    		I47.setImage(KNIGHT);
//    		RemovePossible();
//    		Square prevPlace=	Game.getInstance().getKnight().getCurrentPlace();
//    		getImageByStringBoard("S"+prevPlace.getRow()+prevPlace.getCol()).setImage(Visited);
//    		getImageByString("I"+prevPlace.getRow()+prevPlace.getCol()).setImage(null);
//    		Board[4][7].setVisisted(true);
//    			Game.getInstance().getKnight().setCurrentPlace(Board[4][7]);
//    		break;
//    		}
//    	
//    	case "CI50":{
//    		I50.setImage(KNIGHT);
//    		RemovePossible();
//    		Square prevPlace=	Game.getInstance().getKnight().getCurrentPlace();
//    		getImageByStringBoard("S"+prevPlace.getRow()+prevPlace.getCol()).setImage(Visited);
//    		getImageByString("I"+prevPlace.getRow()+prevPlace.getCol()).setImage(null);
//    		Board[5][0].setVisisted(true);
//    			Game.getInstance().getKnight().setCurrentPlace(Board[5][0]);
//    		break;
//    		}
//    	
//    	case "CI51":{
//    		I51.setImage(KNIGHT);
//    		RemovePossible();
//    		Square prevPlace=	Game.getInstance().getKnight().getCurrentPlace();
//    		getImageByStringBoard("S"+prevPlace.getRow()+prevPlace.getCol()).setImage(Visited);
//    		getImageByString("I"+prevPlace.getRow()+prevPlace.getCol()).setImage(null);
//    		Board[5][1].setVisisted(true);
//    			Game.getInstance().getKnight().setCurrentPlace(Board[5][1]);
//    		break;
//    		}
//    	
//    	case "CI52":{
//    		I52.setImage(KNIGHT);
//    		RemovePossible();
//    		Square prevPlace=	Game.getInstance().getKnight().getCurrentPlace();
//    		getImageByStringBoard("S"+prevPlace.getRow()+prevPlace.getCol()).setImage(Visited);
//    		getImageByString("I"+prevPlace.getRow()+prevPlace.getCol()).setImage(null);
//    		Board[5][2].setVisisted(true);
//    			Game.getInstance().getKnight().setCurrentPlace(Board[5][2]);
//    		break;
//    		}
//    	
//    	case "CI53":{
//    		I53.setImage(KNIGHT);
//    		RemovePossible();
//    		Square prevPlace=	Game.getInstance().getKnight().getCurrentPlace();
//    		getImageByStringBoard("S"+prevPlace.getRow()+prevPlace.getCol()).setImage(Visited);
//    		getImageByString("I"+prevPlace.getRow()+prevPlace.getCol()).setImage(null);
//    		Board[5][3].setVisisted(true);
//    			Game.getInstance().getKnight().setCurrentPlace(Board[5][3]);
//    		break;
//    		}
//    	
//    	case "CI54":{
//    		I54.setImage(KNIGHT);
//    		RemovePossible();
//    		Square prevPlace=	Game.getInstance().getKnight().getCurrentPlace();
//    		getImageByStringBoard("S"+prevPlace.getRow()+prevPlace.getCol()).setImage(Visited);
//    		getImageByString("I"+prevPlace.getRow()+prevPlace.getCol()).setImage(null);
//    		Board[5][4].setVisisted(true);
//    			Game.getInstance().getKnight().setCurrentPlace(Board[5][4]);
//    		break;
//    		}
//    	
//    	case "CI55":{
//    		I55.setImage(KNIGHT);
//    		RemovePossible();
//    		Square prevPlace=	Game.getInstance().getKnight().getCurrentPlace();
//    		getImageByStringBoard("S"+prevPlace.getRow()+prevPlace.getCol()).setImage(Visited);
//    		getImageByString("I"+prevPlace.getRow()+prevPlace.getCol()).setImage(null);
//    		Board[5][5].setVisisted(true);
//    			Game.getInstance().getKnight().setCurrentPlace(Board[5][5]);
//    		break;
//    		}
//    	
//    	case "CI56":{
//    		I56.setImage(KNIGHT);
//    		RemovePossible();
//    		Square prevPlace=	Game.getInstance().getKnight().getCurrentPlace();
//    		getImageByStringBoard("S"+prevPlace.getRow()+prevPlace.getCol()).setImage(Visited);
//    		getImageByString("I"+prevPlace.getRow()+prevPlace.getCol()).setImage(null);
//    		Board[5][6].setVisisted(true);
//    			Game.getInstance().getKnight().setCurrentPlace(Board[5][6]);
//    		break;
//    		}
//    	
//    	case "CI57":{
//    		I57.setImage(KNIGHT);
//    		RemovePossible();
//    		Square prevPlace=	Game.getInstance().getKnight().getCurrentPlace();
//    		getImageByStringBoard("S"+prevPlace.getRow()+prevPlace.getCol()).setImage(Visited);
//    		getImageByString("I"+prevPlace.getRow()+prevPlace.getCol()).setImage(null);
//    		Board[5][7].setVisisted(true);
//    			Game.getInstance().getKnight().setCurrentPlace(Board[5][7]);
//    		break;
//    		}
//    	
//    	case "CI60":{
//    		I60.setImage(KNIGHT);
//    		RemovePossible();
//    		Square prevPlace=	Game.getInstance().getKnight().getCurrentPlace();
//    		getImageByStringBoard("S"+prevPlace.getRow()+prevPlace.getCol()).setImage(Visited);
//    		getImageByString("I"+prevPlace.getRow()+prevPlace.getCol()).setImage(null);
//    		Board[6][0].setVisisted(true);
//    			Game.getInstance().getKnight().setCurrentPlace(Board[6][0]);
//    		break;
//    		}
//    	
//    	case "CI61":{
//    		I61.setImage(KNIGHT);
//    		RemovePossible();
//    		Square prevPlace=	Game.getInstance().getKnight().getCurrentPlace();
//    		getImageByStringBoard("S"+prevPlace.getRow()+prevPlace.getCol()).setImage(Visited);
//    		getImageByString("I"+prevPlace.getRow()+prevPlace.getCol()).setImage(null);
//    		Board[6][1].setVisisted(true);
//    			Game.getInstance().getKnight().setCurrentPlace(Board[6][1]);
//    		break;
//    		}
//    	
//    	case "CI62":{
//    		I62.setImage(KNIGHT);
//    		RemovePossible();
//    		Square prevPlace=	Game.getInstance().getKnight().getCurrentPlace();
//    		getImageByStringBoard("S"+prevPlace.getRow()+prevPlace.getCol()).setImage(Visited);
//    		getImageByString("I"+prevPlace.getRow()+prevPlace.getCol()).setImage(null);
//    		Board[6][2].setVisisted(true);
//    			Game.getInstance().getKnight().setCurrentPlace(Board[6][2]);
//    		break;
//    		}
//    	
//    	case "CI63":{
//    		I63.setImage(KNIGHT);
//    		RemovePossible();
//    		Square prevPlace=	Game.getInstance().getKnight().getCurrentPlace();
//    		getImageByStringBoard("S"+prevPlace.getRow()+prevPlace.getCol()).setImage(Visited);
//    		getImageByString("I"+prevPlace.getRow()+prevPlace.getCol()).setImage(null);
//    		Board[6][3].setVisisted(true);
//    			Game.getInstance().getKnight().setCurrentPlace(Board[6][3]);
//    		break;
//    		}
//    	
//    	case "CI64":{
//    		I64.setImage(KNIGHT);
//    		RemovePossible();
//    		Square prevPlace=	Game.getInstance().getKnight().getCurrentPlace();
//    		getImageByStringBoard("S"+prevPlace.getRow()+prevPlace.getCol()).setImage(Visited);
//    		getImageByString("I"+prevPlace.getRow()+prevPlace.getCol()).setImage(null);
//    		Board[6][4].setVisisted(true);
//    			Game.getInstance().getKnight().setCurrentPlace(Board[6][4]);
//    		break;
//    		}
//    	
//    	case "CI65":{
//    		I65.setImage(KNIGHT);
//    		RemovePossible();
//    		Square prevPlace=	Game.getInstance().getKnight().getCurrentPlace();
//    		getImageByStringBoard("S"+prevPlace.getRow()+prevPlace.getCol()).setImage(Visited);
//    		getImageByString("I"+prevPlace.getRow()+prevPlace.getCol()).setImage(null);
//    		Board[6][5].setVisisted(true);
//    			Game.getInstance().getKnight().setCurrentPlace(Board[6][5]);
//    		break;
//    		}
//    	
//    	case "CI66":{
//    		I66.setImage(KNIGHT);
//    		RemovePossible();
//    		Square prevPlace=	Game.getInstance().getKnight().getCurrentPlace();
//    		getImageByStringBoard("S"+prevPlace.getRow()+prevPlace.getCol()).setImage(Visited);
//    		getImageByString("I"+prevPlace.getRow()+prevPlace.getCol()).setImage(null);
//    		Board[6][6].setVisisted(true);
//    			Game.getInstance().getKnight().setCurrentPlace(Board[6][6]);
//    		break;
//    		}
//    	
//    	case "CI67":{
//    		I67.setImage(KNIGHT);
//    		RemovePossible();
//    		Square prevPlace=	Game.getInstance().getKnight().getCurrentPlace();
//    		getImageByStringBoard("S"+prevPlace.getRow()+prevPlace.getCol()).setImage(Visited);
//    		getImageByString("I"+prevPlace.getRow()+prevPlace.getCol()).setImage(null);
//    		Board[6][7].setVisisted(true);
//    			Game.getInstance().getKnight().setCurrentPlace(Board[6][7]);
//    		break;
//    		}
//    	
//    	case "CI70":{
//    		I70.setImage(KNIGHT);
//    		RemovePossible();
//    		Square prevPlace=	Game.getInstance().getKnight().getCurrentPlace();
//    		getImageByStringBoard("S"+prevPlace.getRow()+prevPlace.getCol()).setImage(Visited);
//    		getImageByString("I"+prevPlace.getRow()+prevPlace.getCol()).setImage(null);
//    		Board[7][0].setVisisted(true);
//    			Game.getInstance().getKnight().setCurrentPlace(Board[7][0]);
//    		break;
//    		}
//    	
//    	case "CI71":{
//    		I71.setImage(KNIGHT);
//    		RemovePossible();
//    		Square prevPlace=	Game.getInstance().getKnight().getCurrentPlace();
//    		getImageByStringBoard("S"+prevPlace.getRow()+prevPlace.getCol()).setImage(Visited);
//    		getImageByString("I"+prevPlace.getRow()+prevPlace.getCol()).setImage(null);
//    		Board[7][1].setVisisted(true);
//    			Game.getInstance().getKnight().setCurrentPlace(Board[7][1]);
//    		break;
//    		}
//    	
//    	case "CI72":{
//    		I72.setImage(KNIGHT);
//    		RemovePossible();
//    		Square prevPlace=	Game.getInstance().getKnight().getCurrentPlace();
//    		getImageByStringBoard("S"+prevPlace.getRow()+prevPlace.getCol()).setImage(Visited);
//    		getImageByString("I"+prevPlace.getRow()+prevPlace.getCol()).setImage(null);
//    		Board[7][2].setVisisted(true);
//    			Game.getInstance().getKnight().setCurrentPlace(Board[7][2]);
//    		break;
//    		}
//    	
//    	case "CI73":{
//    		I73.setImage(KNIGHT);
//    		RemovePossible();
//    		Square prevPlace=	Game.getInstance().getKnight().getCurrentPlace();
//    		getImageByStringBoard("S"+prevPlace.getRow()+prevPlace.getCol()).setImage(Visited);
//    		getImageByString("I"+prevPlace.getRow()+prevPlace.getCol()).setImage(null);
//    		Board[7][3].setVisisted(true);
//    			Game.getInstance().getKnight().setCurrentPlace(Board[7][3]);
//    		break;
//    		}
//    	
//    	case "CI74":{
//    		I74.setImage(KNIGHT);
//    		RemovePossible();
//    		Square prevPlace=	Game.getInstance().getKnight().getCurrentPlace();
//    		getImageByStringBoard("S"+prevPlace.getRow()+prevPlace.getCol()).setImage(Visited);
//    		getImageByString("I"+prevPlace.getRow()+prevPlace.getCol()).setImage(null);
//    		Board[7][4].setVisisted(true);
//    			Game.getInstance().getKnight().setCurrentPlace(Board[7][4]);
//    		break;
//    		}
//    	
//    	case "CI75":{
//    		I75.setImage(KNIGHT);
//    		RemovePossible();
//    		Square prevPlace=	Game.getInstance().getKnight().getCurrentPlace();
//    		getImageByStringBoard("S"+prevPlace.getRow()+prevPlace.getCol()).setImage(Visited);
//    		getImageByString("I"+prevPlace.getRow()+prevPlace.getCol()).setImage(null);
//    		Board[7][5].setVisisted(true);
//    			Game.getInstance().getKnight().setCurrentPlace(Board[7][5]);
//    		break;
//    		}
//    	
//    	case "CI76":{
//    		I76.setImage(KNIGHT);
//    		RemovePossible();
//    		Square prevPlace=	Game.getInstance().getKnight().getCurrentPlace();
//    		getImageByStringBoard("S"+prevPlace.getRow()+prevPlace.getCol()).setImage(Visited);
//    		getImageByString("I"+prevPlace.getRow()+prevPlace.getCol()).setImage(null);
//    		Board[7][6].setVisisted(true);
//    			Game.getInstance().getKnight().setCurrentPlace(Board[7][6]);
//    		break;
//    		}
//    	
//    	
//    	case "CI77":{
//    		I77.setImage(KNIGHT);
//    		RemovePossible();
//    		Square prevPlace=	Game.getInstance().getKnight().getCurrentPlace();
//    		getImageByStringBoard("S"+prevPlace.getRow()+prevPlace.getCol()).setImage(Visited);
//    		getImageByString("I"+prevPlace.getRow()+prevPlace.getCol()).setImage(null);
//    		Board[7][7].setVisisted(true);
//    			Game.getInstance().getKnight().setCurrentPlace(Board[7][7]);
//    		break;
//    		}
//    	
//    	
//    	}
//    
	}

	
    private void countDown() {
    	remainingTime.textProperty().bind(timeSeconds.asString());
        if (timeline != null) 
        	timeline.stop();
                
        timeSeconds.set(STARTTIME);
        timeline = new Timeline();
        timeline.getKeyFrames().add(new KeyFrame(Duration.seconds(STARTTIME+1),new KeyValue(timeSeconds, 0)));
        timeline.playFromStart();
    }
    
	@FXML
	 private void back(ActionEvent event) throws IOException {
		
		Parent pane = FXMLLoader.load(getClass().getResource("/views/MainMenu.fxml"));
		Scene scene = new Scene(pane);
		Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
		stage.setScene(scene);
		stage.setResizable(false);
		stage.setTitle("Main Menu");
		stage.show();
	}
	static void backToMain()throws IOException{
		Game.getInstance().getKnight().setCurrentPlace(new Square(0, 0));
		Game.getInstance().getKnight().setPrev_Place(new Square(0, 0));
		Game.getInstance().getQueen().setPrev_Place(new Square(0, 7));
		Game.getInstance().getQueen().setCurrentPlace(new Square(0, 7));
//		Parent pane = FXMLLoader.load(getClass().getResource("/views/MainMenu.fxml"));
//		Scene scene = new Scene(pane);
//		Stage stage = new Stage();
//		stage.setScene(scene);
//		stage.setResizable(false);
//		stage.setTitle("Main Menu");
//		stage.show();
		Platform.exit();
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
		BoardImages.add(S00);BoardImages.add(S01);BoardImages.add(S02);BoardImages.add(S03);BoardImages.add(S04);BoardImages.add(S05);
		BoardImages.add(S06);BoardImages.add(S07);BoardImages.add(S10);BoardImages.add(S11);BoardImages.add(S12);BoardImages.add(S13);
		BoardImages.add(S14);BoardImages.add(S15);BoardImages.add(S16);BoardImages.add(S17);BoardImages.add(S20);BoardImages.add(S21);
		BoardImages.add(S22);BoardImages.add(S23);BoardImages.add(S24);BoardImages.add(S25);BoardImages.add(S26);BoardImages.add(S27);
		BoardImages.add(S30);BoardImages.add(S31);BoardImages.add(S32);BoardImages.add(S33);BoardImages.add(S34);BoardImages.add(S35);
		BoardImages.add(S36);BoardImages.add(S37);BoardImages.add(S40);BoardImages.add(S41);BoardImages.add(S42);BoardImages.add(S43);
		BoardImages.add(S44);BoardImages.add(S45);BoardImages.add(S46);BoardImages.add(S47);BoardImages.add(S50);BoardImages.add(S51);
		BoardImages.add(S52);BoardImages.add(S53);BoardImages.add(S54);BoardImages.add(S55);BoardImages.add(S56);BoardImages.add(S57);
		BoardImages.add(S60);BoardImages.add(S61);BoardImages.add(S62);BoardImages.add(S63);BoardImages.add(S64);BoardImages.add(S65);
		BoardImages.add(S66);BoardImages.add(S67);BoardImages.add(S70);BoardImages.add(S71);BoardImages.add(S72);BoardImages.add(S73);
		BoardImages.add(S74);BoardImages.add(S75);BoardImages.add(S76);BoardImages.add(S77);
		
		allImages.add(I00);allImages.add(I01);allImages.add(I02);allImages.add(I03);allImages.add(I04);allImages.add(I05);
		allImages.add(I06);allImages.add(I07);allImages.add(I10);allImages.add(I11);allImages.add(I12);allImages.add(I13);
		allImages.add(I14);allImages.add(I15);allImages.add(I16);allImages.add(I17);allImages.add(I20);allImages.add(I21);
		allImages.add(I22);allImages.add(I23);allImages.add(I24);allImages.add(I25);allImages.add(I26);allImages.add(I27);
		allImages.add(I30);allImages.add(I31);allImages.add(I32);allImages.add(I33);allImages.add(I34);allImages.add(I35);
		allImages.add(I36);allImages.add(I37);allImages.add(I40);allImages.add(I41);allImages.add(I42);allImages.add(I43);
		allImages.add(I44);allImages.add(I45);allImages.add(I46);allImages.add(I47);allImages.add(I50);allImages.add(I51);
		allImages.add(I52);allImages.add(I53);allImages.add(I54);allImages.add(I55);allImages.add(I56);allImages.add(I57);
		allImages.add(I60);allImages.add(I61);allImages.add(I62);allImages.add(I63);allImages.add(I64);allImages.add(I65);
		allImages.add(I66);allImages.add(I67);allImages.add(I70);allImages.add(I71);allImages.add(I72);allImages.add(I73);
		allImages.add(I74);allImages.add(I75);allImages.add(I76);allImages.add(I77);
		
		allButtons.add(CI00);allButtons.add(CI13);allButtons.add(CI26);allButtons.add(CI41);allButtons.add(CI54);allButtons.add(CI66);
		allButtons.add(CI01);allButtons.add(CI14);allButtons.add(CI27);allButtons.add(CI42);allButtons.add(CI55);allButtons.add(CI67);
		allButtons.add(CI02);allButtons.add(CI15);allButtons.add(CI30);allButtons.add(CI43);allButtons.add(CI56);allButtons.add(CI70);
		allButtons.add(CI03);allButtons.add(CI16);allButtons.add(CI31);allButtons.add(CI44);allButtons.add(CI57);allButtons.add(CI71);
		allButtons.add(CI04);allButtons.add(CI17);allButtons.add(CI32);allButtons.add(CI45);allButtons.add(CI60);allButtons.add(CI72);
		allButtons.add(CI05);allButtons.add(CI20);allButtons.add(CI33);allButtons.add(CI46);allButtons.add(CI61);allButtons.add(CI73);
		allButtons.add(CI06);allButtons.add(CI21);allButtons.add(CI34);allButtons.add(CI47);allButtons.add(CI62);allButtons.add(CI74);
		allButtons.add(CI07);allButtons.add(CI22);allButtons.add(CI35);allButtons.add(CI50);allButtons.add(CI63);allButtons.add(CI75);
		allButtons.add(CI10);allButtons.add(CI23);allButtons.add(CI36);allButtons.add(CI51);allButtons.add(CI64);allButtons.add(CI76);
		allButtons.add(CI11);allButtons.add(CI24);allButtons.add(CI37);allButtons.add(CI52);allButtons.add(CI65);allButtons.add(CI77);
		allButtons.add(CI12);allButtons.add(CI25);allButtons.add(CI40);allButtons.add(CI53);
		
		countDown();
        
        level.setText(Integer.toString(SysData.getInstance().getGame().getLevel()));
        score.setText(Integer.toString(SysData.getInstance().getGame().getScore()));
        playerName.setText(Game.getInstance().getPlayer().getName());

        Game.getInstance().setBoard(BuildSquares());
        GenerateSquareType();
        
    	I00.setImage(KNIGHT);
    	Board[0][0].setVisisted(true);
    	S00.setImage(Visited);
    	I07.setImage(QUEEN);
    	Game.getInstance().getPlayer().setScore(1);
    	
    	if(SysData.getInstance().getGame().getLevel()==1)
    		SetPossible();
    	else	SetPossibleLEVEL2();


	}
	
	public static void gameOverMessage() {
		try {
			final Alert alert = new Alert(Alert.AlertType.INFORMATION);
			alert.setTitle("Game Over!");
			alert.setContentText("Good Luck Next Time.");
			alert.setHeaderText("Thank You For Playing.");
			alert.showAndWait();
//			GameController.backToMain();
		

			
		} catch (Error e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static HashSet<ImageView> getAllImages() {
		return allImages;
	}
	public HashSet<Button> getAllButtons() {
		return allButtons;
	}
	public void setAllButtons(HashSet<Button> allButtons) {
		this.allButtons = allButtons;
	}
	public void setAllImages(HashSet<ImageView> allImages) {
		this.allImages = allImages;
	}
	
	public HashSet<ImageView> getBoardImages() {
		return BoardImages;
	}
	public void setBoardImages(HashSet<ImageView> boardImages) {
		BoardImages = boardImages;
	}
	
	public Square[][] getBoard() {
		return Board;
	}
	public void setBoard(Square[][] board) {
		Board = board;
	}
}
