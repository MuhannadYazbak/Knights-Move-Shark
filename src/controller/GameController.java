package controller;

import java.io.IOException;
import java.net.URL;
import java.util.HashSet;
import java.util.ResourceBundle;
import java.util.Timer;
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
import model.Square;
import model.SquareFactory;
import model.SysData;
import model.lastObj;
import utils.Type;

public class GameController implements Initializable {

	/*
	 * ImageView for each square to build the board.
	 */
	@FXML
	private ImageView S00, S01, S02, S03, S04, S05, S06, S07, S10, S11, S12, S13, S14, S15, S16, S17, S20, S21, S22,
			S23, S24, S25, S26, S27, S30, S31, S32, S33, S34, S35, S36, S37, S40, S41, S42, S43, S44, S45, S46, S47,
			S50, S51, S52, S53, S54, S55, S56, S57, S60, S61, S62, S63, S64, S65, S66, S67, S70, S71, S72, S73, S74,
			S75, S76, S77;

	/*
	 * HashSet to use all the board images.
	 */
	private HashSet<ImageView> BoardImages = new HashSet<ImageView>();

	/*
	 * ImageView for each image to move the pieces.
	 */
	@FXML
	private ImageView I00, I01, I02, I03, I04, I05, I06, I07, I10, I11, I12, I13, I14, I15, I16, I17, I20, I21, I22,
			I23, I24, I25, I26, I27, I30, I31, I32, I33, I34, I35, I36, I37, I40, I41, I42, I43, I44, I45, I46, I47,
			I50, I51, I52, I53, I54, I55, I56, I57, I60, I61, I62, I63, I64, I65, I66, I67, I70, I71, I72, I73, I74,
			I75, I76, I77;

	/*
	 * HashSet to use all the null (show the piece when it is on specific image.
	 */
	private static HashSet<ImageView> allImages = new HashSet<ImageView>();

	/*
	 * Button for each square.
	 */
	@FXML
	private Button CI00, CI01, CI02, CI03, CI04, CI05, CI06, CI07, CI10, CI11, CI12, CI13, CI14, CI15, CI16, CI17, CI20,
			CI21, CI22, CI23, CI24, CI25, CI26, CI27, CI30, CI31, CI32, CI33, CI34, CI35, CI36, CI37, CI40, CI41, CI42,
			CI43, CI44, CI45, CI46, CI47, CI50, CI51, CI52, CI53, CI54, CI55, CI56, CI57, CI60, CI61, CI62, CI63, CI64,
			CI65, CI66, CI67, CI70, CI71, CI72, CI73, CI74, CI75, CI76, CI77;

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
	    private Label remainingTime,level,score,playerName;
	 
	@FXML
	private ImageView countdownimage,levelImage,playernameImage,scoreImage;

	@FXML
	private AnchorPane screen;

	private static final Integer STARTTIME = 60;
	private Timeline timeline;
	public static Boolean pauseKing = false;
	private IntegerProperty timeSeconds = new SimpleIntegerProperty(STARTTIME);
	static Timer timer = new Timer();
	static Timer timer2 = new Timer();

	public static Timer getTimer2() {
		return timer2;
	}

	public static void setTimer2(Timer timer2) {
		GameController.timer2 = timer2;
	}

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
	private Image Possible = new Image(getClass().getResourceAsStream("/lib/test12.gif"));
	private Image QuestionRed = new Image(getClass().getResourceAsStream("/lib/qRed.png"));
	private Image QuestionYellow = new Image(getClass().getResourceAsStream("/lib/Qyellow.png"));
	private Image QuestionGreen = new Image(getClass().getResourceAsStream("/lib/Qgreen.png"));
	private Image QuestionRedPos = new Image(getClass().getResourceAsStream("/lib/qRed1.gif"));
	private Image QuestionYellowPos = new Image(getClass().getResourceAsStream("/lib/Qyellow1.gif"));
	private Image QuestionGreenPos = new Image(getClass().getResourceAsStream("/lib/Qgreen1.gif"));

	private Image Blocked = new Image(getClass().getResourceAsStream("/lib/blocked.png"));
	private Image GREEN = new Image(getClass().getResourceAsStream("/lib/gb.png"));
	private Image BROWN = new Image(getClass().getResourceAsStream("/lib/sb.png"));
	private Image StepB = new Image(getClass().getResourceAsStream("/lib/sbNew.jpeg"));
	private Image StepG = new Image(getClass().getResourceAsStream("/lib/gbNew.jpeg"));
	private Image Step = new Image(getClass().getResourceAsStream("/lib/step.png"));
	
	private Image Level1 = new Image(getClass().getResourceAsStream("/lib/level1.png"));
	private Image Level2 = new Image(getClass().getResourceAsStream("/lib/level2.png"));
	private Image Level3 = new Image(getClass().getResourceAsStream("/lib/level3.png"));
	private Image Level4 = new Image(getClass().getResourceAsStream("/lib/level4.png"));
	
	private HashSet<ImageView> PossibleMovesQueen = new HashSet<ImageView>();
	private static HashSet<ImageView> PossibleMovesKing = new HashSet<ImageView>();
	private static Type selectedQuestionType;
	private static Boolean level4Started = false, level3Started =false;

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

	private boolean levelUp = false;
	private Alert alert = new Alert(Alert.AlertType.INFORMATION);

	@FXML
	void MoveTo() {
		
		// checking if this is the first move in level 3 or 4 to start king movement
		if (!level3Started && Game.getInstance().getLevel() == 3) {
			level3Started = true;
			I07.setImage(KING);

			// the king will change speed move every 10 seconds
			 timer.schedule(new kingSpeed(), 0, 10000);
		}
		if (!level4Started && Game.getInstance().getLevel() == 4) {
			level4Started = true;
			I07.setImage(KING);

			// the king will change speed move every 10 seconds
			 timer.schedule(new kingSpeed(), 0, 10000);
		}
		while (!remainingTime.getText().equals("0")) {
			switch (level.getText()) {

			case "1": {
				Boolean movedFlag = false, buttonFlag = true;

				for (Square s : Game.getInstance().getKnight().allPossibleMoves()) {
					PossibleButtons.add(getButtonByString("CI" + s.getRow() + s.getCol()));
				}

				for (Button b : PossibleButtons) {
					if (buttonFlag) {
						if (b.isPressed()) {
							PressedButton(b.getId());
							buttonFlag = false;
							movedFlag = true;
						}
					}

				}
				System.out.println(PossibleButtons);
				PossibleButtons.clear();
				
				if (buttonFlag) {
					try {
						final Alert alert = new Alert(Alert.AlertType.INFORMATION);
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
				buttonFlag=true;

				if (movedFlag == true) {
					for (Square s : Game.getInstance().getQueen().allPossibleMoves()) {
						PossibleMovesQueen.add(getImageByString("I" + s.getRow() + s.getCol()));
					}
					Game.getInstance().getQueen().setPrev_Place(Game.getInstance().getQueen().getCurrentPlace());
					Game.getInstance().getQueen().moveThePiece(Game.getInstance().getQueen().allPossibleMoves());
					String s = "I" + Integer.toString(Game.getInstance().getQueen().getCurrentPlace().getRow())
							+ Integer.toString(Game.getInstance().getQueen().getCurrentPlace().getCol());
					for (ImageView i : allImages) {
						if (i.getId().equals(s)) {
							i.setImage(QUEEN);

						}

					}

					String prev = "I" + Integer.toString(Game.getInstance().getQueen().getPrev_Place().getRow())
							+ Integer.toString(Game.getInstance().getQueen().getPrev_Place().getCol());
					for (ImageView i : allImages) {
						if (i.getId().equals(prev)) {
							if (Board[Game.getInstance().getQueen().getPrev_Place().getRow()][Game.getInstance()
									.getQueen().getPrev_Place().getCol()].getSquareType() == Type.Regular
									|| Board[Game.getInstance().getQueen().getPrev_Place().getRow()][Game.getInstance()
											.getQueen().getPrev_Place().getCol()].getSquareType() == Type.RandomJump) {
								i.setImage(null);
							} else if (Board[Game.getInstance().getQueen().getPrev_Place().getRow()][Game.getInstance()
									.getQueen().getPrev_Place().getCol()].getSquareType() == Type.EasyQuestion
									|| Board[Game.getInstance().getQueen().getPrev_Place().getRow()][Game.getInstance()
											.getQueen().getPrev_Place().getCol()].getSquareType() == Type.HardQuestion
									|| Board[Game.getInstance().getQueen().getPrev_Place().getRow()][Game.getInstance()
											.getQueen().getPrev_Place().getCol()]
											.getSquareType() == Type.MediumQuestion) {
								i.setImage(null);
							}

						}
					}
					movedFlag = false;

					if (Game.getInstance().getQueen().getCurrentPlace().getCol() == Game.getInstance().getKnight()
							.getCurrentPlace().getCol()
							&& Game.getInstance().getQueen().getCurrentPlace().getRow() == Game.getInstance()
									.getKnight().getCurrentPlace().getRow()) {
						try {
							final Alert alert = new Alert(Alert.AlertType.INFORMATION);
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

			case "2": {
				Boolean movedFlag = false, buttonFlag = true;

				for (Square s : Game.getInstance().getKnight().allPossibleMovesLevel2()) {
					PossibleButtons.add(getButtonByString("CI" + s.getRow() + s.getCol()));

				}

				for (Button b : PossibleButtons) {
					if (buttonFlag) {
						if (b.isPressed()) {
							PressedButton(b.getId());
							buttonFlag = false;
							movedFlag = true;
						}
					}

				}

				PossibleButtons.clear();
				if (buttonFlag) {
					try {
						final Alert alert = new Alert(Alert.AlertType.INFORMATION);
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

				if (movedFlag == true) {
					for (Square s : Game.getInstance().getQueen().allPossibleMoves()) {
						PossibleMovesQueen.add(getImageByString("I" + s.getRow() + s.getCol()));
					}
					Game.getInstance().getQueen().setPrev_Place(Game.getInstance().getQueen().getCurrentPlace());
					Game.getInstance().getQueen().moveThePiece(Game.getInstance().getQueen().allPossibleMoves());
					String s = "I" + Integer.toString(Game.getInstance().getQueen().getCurrentPlace().getRow())
							+ Integer.toString(Game.getInstance().getQueen().getCurrentPlace().getCol());
					for (ImageView i : allImages) {
						if (i.getId().equals(s)) {
							i.setImage(QUEEN);

						}

					}
				}

				String prev = "I" + Integer.toString(Game.getInstance().getQueen().getPrev_Place().getRow())
						+ Integer.toString(Game.getInstance().getQueen().getPrev_Place().getCol());
				for (ImageView i : allImages) {
					if (i.getId().equals(prev)) {
						if (Board[Game.getInstance().getQueen().getPrev_Place().getRow()][Game.getInstance().getQueen()
								.getPrev_Place().getCol()].getSquareType() == Type.Regular
								|| Board[Game.getInstance().getQueen().getPrev_Place().getRow()][Game.getInstance()
										.getQueen().getPrev_Place().getCol()].getSquareType() == Type.Forget) {
							i.setImage(null);
						} else if (Board[Game.getInstance().getQueen().getPrev_Place().getRow()][Game.getInstance()
								.getQueen().getPrev_Place().getCol()].getSquareType() == Type.EasyQuestion
								|| Board[Game.getInstance().getQueen().getPrev_Place().getRow()][Game.getInstance()
										.getQueen().getPrev_Place().getCol()].getSquareType() == Type.HardQuestion
								|| Board[Game.getInstance().getQueen().getPrev_Place().getRow()][Game.getInstance()
										.getQueen().getPrev_Place().getCol()].getSquareType() == Type.MediumQuestion) {
							i.setImage(null);
						}

					}
				}
				movedFlag = false;

				if (Game.getInstance().getQueen().getCurrentPlace().getCol() == Game.getInstance().getKnight()
						.getCurrentPlace().getCol()
						&& Game.getInstance().getQueen().getCurrentPlace().getRow() == Game.getInstance().getKnight()
								.getCurrentPlace().getRow()) {
					try {
						final Alert alert = new Alert(Alert.AlertType.INFORMATION);
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
			
			case "3": {

				Boolean buttonFlag = true;

				if (Game.getInstance().getKing().getCurrentPlace().getCol() == Game.getInstance().getKnight()
						.getCurrentPlace().getCol()
						&& Game.getInstance().getKing().getCurrentPlace().getRow() == Game.getInstance().getKnight()
								.getCurrentPlace().getRow()) {
					try {
						final Alert alert = new Alert(Alert.AlertType.INFORMATION);
						timer2.cancel();
						timer2.purge();
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

				if (remainingTime.getText().equals("0")) {
					timer2.cancel();
					timer2.purge();
					timer.cancel();
					timer.purge();

				}



				for (Square s : Game.getInstance().getKnight().allPossibleMovesLevel2()) {
					PossibleButtons.add(getButtonByString("CI" + s.getRow() + s.getCol()));
				}

				for (Button b : PossibleButtons) {
					if (buttonFlag) {
						if (b.isPressed()) {
							PressedButton(b.getId());
							buttonFlag = false;

						}
					}

				}

				PossibleButtons.clear();
				// buttonFlag=true;
				if (buttonFlag) {
					try {
						final Alert alert = new Alert(Alert.AlertType.INFORMATION);
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

				// checking timer because in case 4 there is a while loop

				if (remainingTime.getText().equals("0")) {
					timer2.cancel();
					timer2.purge();
					timer.cancel();
					timer.purge();

				}

				break;
			}

			case "4": {

				Boolean buttonFlag = true;

				if (Game.getInstance().getKing().getCurrentPlace().getCol() == Game.getInstance().getKnight()
						.getCurrentPlace().getCol()
						&& Game.getInstance().getKing().getCurrentPlace().getRow() == Game.getInstance().getKnight()
								.getCurrentPlace().getRow()) {
					try {
						final Alert alert = new Alert(Alert.AlertType.INFORMATION);
						timer2.cancel();
						timer2.purge();
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

				if (remainingTime.getText().equals("0")) {
					timer2.cancel();
					timer2.purge();
					timer.cancel();
					timer.purge();

				}

				for (Square s : Game.getInstance().getKnight().allPossibleMovesLevel2()) {
					PossibleButtons.add(getButtonByString("CI" + s.getRow() + s.getCol()));
				}

				for (Button b : PossibleButtons) {
					if (buttonFlag) {
						if (b.isPressed()) {
							PressedButton(b.getId());
							buttonFlag = false;

						}
					}

				}

				PossibleButtons.clear();
				if (buttonFlag) {
					try {
						final Alert alert = new Alert(Alert.AlertType.INFORMATION);
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
				
				// checking timer because in case 4 there is a while loop

				if (remainingTime.getText().equals("0")) {
					timer2.cancel();
					timer2.purge();
					timer.cancel();
					timer.purge();

				}

				break;
			}
			}
			break;
		}
		if(remainingTime.getText().equals("0")){
    		if(Game.getInstance().getPlayer().getScore()>=15 && Game.getInstance().getLevel() == 1)
			{
				Game.getInstance().setLevel(Game.getInstance().getLevel()+1);
				level.setText(Integer.toString(Game.getInstance().getLevel()));
				levelImage.setImage(Level2);
				levelUp=true;
				SetImagesNULL();
				ResetSquareType(); // to set all the square as regular squares and be ready for the next level
				GenerateSquareType();
				Game.getInstance().getKnight().setCurrentPlace(Board[0][0]);
				getImageByString("I00").setImage(KNIGHT);
				Game.getInstance().getQueen().setCurrentPlace(Board[0][7]);
				getImageByString("I07").setImage(QUEEN);
				try {
					final Alert alert = new Alert(Alert.AlertType.INFORMATION);
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

				SetPossibleLEVEL2();
				
			}
    		else if(Game.getInstance().getPlayer().getScore()>=30 && Game.getInstance().getLevel() == 2)
    			{
    				Game.getInstance().setLevel(Game.getInstance().getLevel()+1);
    				level.setText(Integer.toString(Game.getInstance().getLevel()));
    				levelImage.setImage(Level3);
    				levelUp=true;
    				SetImagesNULL();
    				ResetSquareType(); // to set all the square as regular squares and be ready for the next level
    				GenerateSquareType();
    				Game.getInstance().getKnight().setCurrentPlace(Board[0][0]);
    				getImageByString("I00").setImage(KNIGHT);
    				Game.getInstance().getQueen().setCurrentPlace(Board[0][7]);
    				getImageByString("I07").setImage(QUEEN);
    				try {
    					final Alert alert = new Alert(Alert.AlertType.INFORMATION);
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

    				SetPossibleLEVEL2();
    		    
    			}
        		else if(Game.getInstance().getPlayer().getScore()>=45 && Game.getInstance().getLevel() == 3)
        			{
        				Game.getInstance().setLevel(Game.getInstance().getLevel()+1);
        				level.setText(Integer.toString(Game.getInstance().getLevel()));
        				levelImage.setImage(Level4);
        				levelUp=true;
        				SetImagesNULL();
        				ResetSquareType(); // to set all the square as regular squares and be ready for the next level
        				GenerateSquareType();
        				Game.getInstance().getKnight().setCurrentPlace(Board[0][0]);
        				getImageByString("I00").setImage(KNIGHT);
        				Game.getInstance().getQueen().setCurrentPlace(Board[0][7]);
        				getImageByString("I07").setImage(QUEEN);
        				try {
        					final Alert alert = new Alert(Alert.AlertType.INFORMATION);
        					timer2.cancel();
        					timer2.purge();
        					timer.cancel();
        		    		timer.purge();
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

        				SetPossibleLEVEL2();
        		    
        			}
    		else if(Game.getInstance().getPlayer().getScore() >=60 && Game.getInstance().getLevel() == 4) {

				try {
					final Alert alert = new Alert(Alert.AlertType.INFORMATION);
					timer2.cancel();
					timer2.purge();
					timer.cancel();
		    		timer.purge();
					alert.setTitle("Congrats!");
					alert.setContentText("Press ok to continue.");
					alert.setHeaderText("Congratulations, "+ Game.getInstance().getPlayer().getName() +".\n" + "You have won the game!");
					alert.showAndWait();
					if (Game.getInstance().getPlayer().getScore()>200) {
						Parent pane = FXMLLoader.load(getClass().getResource("/views/WinnerWindow.fxml"));
						Scene scene = new Scene(pane);
						//Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
						
						Stage stage = new Stage();
						stage.setScene(scene);
						stage.setTitle("Cup Winner");
						stage.show();
						Platform.exit();
					}
					backToMain();
					} catch (Error e) {
							e.printStackTrace();
						} catch (Exception e) {

							e.printStackTrace();
						}
							countDown();

						}
    		else {
    			try {
    				final Alert alert = new Alert(Alert.AlertType.INFORMATION);
    				timer2.cancel();
    			timer2.purge();
    			timer.cancel();
    			timer.purge();
    			alert.setTitle("Game Over!");
    			alert.setContentText("Good Luck Next Time.");
    			alert.setHeaderText("Thank You For Playing.");
    			alert.showAndWait();
    			backToMain();
    	
    			} catch(Exception e) {
    				e.printStackTrace();
    			}
    	
    		}
		}}

	private void SetImagesNULL() { // function to set all the board image to the original one and the piece image null
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				getImageByString("I" + i + j).setImage(null);
				if ((j - i) % 2 == 0 || (j - i) == 0)
					getImageByStringBoard("S" + i + j).setImage(GREEN);
				else
					getImageByStringBoard("S" + i + j).setImage(BROWN);
			}
		}
	}

	private ImageView getImageByStringBoard(String s) { // by sending string (rowNum, colNum) to the function we will
														// get ImageView that starts with the letter S+rowNum+colNum
		for (ImageView i : getBoardImages()) {
			if (s.equals(i.getId())) {
				return i;
			}
		}
		return null;
	}

	static ImageView getImageByString(String s) { // by sending string (rowNum, colNum) to the function we will get
													// ImageView that starts with the letter I+rowNum+colNum
		for (ImageView i : getAllImages()) {
			if (s.equals(i.getId())) {
				return i;
			}
		}
		return null;
	}

	private Button getButtonByString(String s) { // by sending string (rowNum, colNum) to the function we will get
													// Button that starts with the letter CI+rowNum+colNum
		for (Button i : getAllButtons()) {
			if (s.equals(i.getId())) {
				return i;
			}
		}
		return null;
	}

	private void SetPossible() { // function to show the possible moves by setting white color on the square

		for (Square s : Game.getInstance().getKnight().allPossibleMoves()) {

			if (Board[s.getRow()][s.getCol()].getSquareType().equals(Type.Regular)
					|| Board[s.getRow()][s.getCol()].getSquareType().equals(Type.RandomJump))
				getImageByString("I" + s.getRow() + s.getCol()).setImage(Possible); // set image with name Possible
																					// (White color) to show the
																					// possible moves
			if (Board[s.getRow()][s.getCol()].getSquareType().equals(Type.EasyQuestion)) {
				getImageByString("I" + s.getRow() + s.getCol()).setImage(QuestionGreenPos);
			}
			if(Board[s.getRow()][s.getCol()].getSquareType().equals(Type.HardQuestion)) {
				getImageByString("I" + s.getRow() + s.getCol()).setImage(QuestionRedPos);

			}
			if(Board[s.getRow()][s.getCol()].getSquareType().equals(Type.MediumQuestion)) {
				getImageByString("I" + s.getRow() + s.getCol()).setImage(QuestionYellowPos);

			}
		}
	}

	private void SetPossibleLEVEL2() { // function to show the possible moves by setting white color on the square

		for (Square s : Game.getInstance().getKnight().allPossibleMovesLevel2()) {
			if (Board[s.getRow()][s.getCol()].getSquareType().equals(Type.Regular)
					|| Board[s.getRow()][s.getCol()].getSquareType().equals(Type.RandomJump))
				getImageByString("I" + s.getRow() + s.getCol()).setImage(Possible);// set image with name Possible
																					// (White color) to show the
																					// possible moves
			if (Board[s.getRow()][s.getCol()].getSquareType().equals(Type.Forget))
				getImageByString("I" + s.getRow() + s.getCol()).setImage(Possible);
			if (Board[s.getRow()][s.getCol()].getSquareType().equals(Type.EasyQuestion)) {
				getImageByString("I" + s.getRow() + s.getCol()).setImage(QuestionGreenPos);
			}
			if(Board[s.getRow()][s.getCol()].getSquareType().equals(Type.HardQuestion)) {
				getImageByString("I" + s.getRow() + s.getCol()).setImage(QuestionRedPos);

			}
			if(Board[s.getRow()][s.getCol()].getSquareType().equals(Type.MediumQuestion)) {
				getImageByString("I" + s.getRow() + s.getCol()).setImage(QuestionYellowPos);

			}
		}
	}

	private void RemovePossible() { // function to remove the possible moves
		for (Square s : Game.getInstance().getKnight().allPossibleMoves()) {
			if (Board[s.getRow()][s.getCol()].getSquareType().equals(Type.Regular)
					|| Board[s.getRow()][s.getCol()].getSquareType().equals(Type.RandomJump))
				getImageByString("I" + s.getRow() + s.getCol()).setImage(null); // set image null to remove the possible

			if(Board[s.getRow()][s.getCol()].getSquareType().equals(Type.EasyQuestion)) {
				getImageByString("I" + s.getRow() + s.getCol()).setImage(QuestionGreen);

			}
			if(Board[s.getRow()][s.getCol()].getSquareType().equals(Type.MediumQuestion)) {
				getImageByString("I" + s.getRow() + s.getCol()).setImage(QuestionYellow);

			}
			if(Board[s.getRow()][s.getCol()].getSquareType().equals(Type.HardQuestion)) {
				getImageByString("I" + s.getRow() + s.getCol()).setImage(QuestionRed);

			}
			if (Board[s.getRow()][s.getCol()].getSquareType().equals(Type.Blocked)) {
				getImageByString("I" + s.getRow() + s.getCol()).setImage(Blocked);
			}
		}
		
	}

	private void RemovePossibleLEVEL2() { // function to remove the possible moves
		for (Square s : Game.getInstance().getKnight().allPossibleMovesLevel2()) {

			if (Board[s.getRow()][s.getCol()].getSquareType().equals(Type.Regular)
					|| Board[s.getRow()][s.getCol()].getSquareType().equals(Type.RandomJump)
					|| Board[s.getRow()][s.getCol()].getSquareType().equals(Type.Forget))
				getImageByString("I" + s.getRow() + s.getCol()).setImage(null); // set image null to remove the possible
																				// moves
			if(Board[s.getRow()][s.getCol()].getSquareType().equals(Type.EasyQuestion)) {
				getImageByString("I" + s.getRow() + s.getCol()).setImage(QuestionGreen);

			}
			if(Board[s.getRow()][s.getCol()].getSquareType().equals(Type.MediumQuestion)) {
				getImageByString("I" + s.getRow() + s.getCol()).setImage(QuestionYellow);

			}
			if(Board[s.getRow()][s.getCol()].getSquareType().equals(Type.HardQuestion)) {
				getImageByString("I" + s.getRow() + s.getCol()).setImage(QuestionRed);

			}
			
			if (Board[s.getRow()][s.getCol()].getSquareType().equals(Type.Blocked))
				getImageByString("I" + s.getRow() + s.getCol()).setImage(Blocked);

		}
		
	}

	private Square[][] BuildSquares() { // function to build 64 squares with Regular type

		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				Board[i][j] = SquareFactory.makeSquare(i, j, Type.Regular);
			}

		}
		return Board;
	}

	private void ResetSquareType() { // when the level is up, all the squares will get Regular type to avoid square
										// types more than required to each level.
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				Board[i][j].setSquareType(Type.Regular);
				Board[i][j].setVisisted(false);
			}

		}
	}


	private void GenerateSquareType() {// generate square types for each level

		switch (Game.getInstance().getLevel()) {

		case 1: { // when the level is 1 the game builds 3 RandomJump squares.

			for (int k = 0; k < 3; k++) {
				Square s = randomRegularSquare();
				s.setSquareType(Type.RandomJump);
			}
			break;
		}

		case 2: { // when the level is 2 the game builds 3 Forget squares.

			for (int k = 0; k < 3; k++) {
				Square s = randomRegularSquare();
				s.setSquareType(Type.Forget);
			}
			
			break;
		}

		case 3: { // when the level is 3 the game builds 2 Forget squares and 2 RandomJump
					// Squares.

			for (int k = 0; k < 2; k++) {
				Square s1 = randomRegularSquare();
				s1.setSquareType(Type.Forget);
				Square s2 = randomRegularSquare();
				s2.setSquareType(Type.RandomJump);
			}

			break;
		}

		case 4: { // when the level is 4 the game builds 8 Blocked squares.

			for (int k = 0; k < 8; k++) {
				Square s = randomRegularSquare();
				s.setSquareType(Type.Blocked);
			}
			break;
		}
		}

		Square s1 = randomRegularSquare(); // build one square with easy question.
		s1.setSquareType(Type.EasyQuestion);
		getImageByString("I" + s1.getRow() + s1.getCol()).setImage(QuestionGreen);

		Square s2 = randomRegularSquare(); // build one square with medium question.
		s2.setSquareType(Type.MediumQuestion);
		getImageByString("I" + s2.getRow() + s2.getCol()).setImage(QuestionYellow);

		Square s3 = randomRegularSquare(); // build one square with hard question.
		s3.setSquareType(Type.HardQuestion);
		getImageByString("I" + s3.getRow() + s3.getCol()).setImage(QuestionRed);

	}

	private void GetNewSquareByType(int r, int c, Type t) { // when the player press on a button with one of these types
															// the game create square with the same type

		boolean flag = true;

		while (flag) {
			Square s = randomRegularSquare();
			if (!(s.getRow() == r && s.getCol() == c)) {
				switch (t.toString()) {

				case "RandomJump": { // set new square with RandomJump type.
					s.setSquareType(Type.RandomJump);
					break;
				}

				case "Forget": { // set new square with Forget type.
					s.setSquareType(Type.Forget);
					break;
				}

				case "Blocked": { // set new square with Blocked type.
					s.setSquareType(Type.Blocked);
					break;
				}

				case "EasyQuestion": { // set new square with EasyQuestion type.
					s.setSquareType(Type.EasyQuestion);
					getImageByString("I" + r + c).setImage(QuestionGreen);

					/*
					 * to add question when the player press on it
					 */
					break;
				}

				case "MediumQuestion": { // set new square with MediumQuestion type.
					s.setSquareType(Type.MediumQuestion);
					getImageByString("I" + r + c).setImage(QuestionYellow);

					/*
					 * to add question when the player press on it
					 */
					break;
				}

				case "HardQuestion": { // set new square with HardQuestion type.
					s.setSquareType(Type.HardQuestion);
					getImageByString("I" + r + c).setImage(QuestionRed);

					/*
					 * to add question when the player press on it
					 */
					break;
				}
				}

				flag = false; // set flag=false to end the random searching for RegularSquare.
			}
		}
	}

	// method to handle player pressing any button based on button type
	private void PressedButton(String s) {
		int i = Character.getNumericValue(s.charAt(2)); // Row number for the pressed square
		int j = Character.getNumericValue(s.charAt(3)); // Column number for the pressed square
		Game.getInstance().getKnight().setPrev_Place(Game.getInstance().getKnight().getCurrentPlace());
		// Nothing happens if a player presses on a blocked square
		if (!Board[i][j].getSquareType().equals(Type.Blocked)) {
			Game.getInstance().getLast().add(new lastObj(Board[i][j], Game.getInstance().getPlayer().getScore()));
			if (SysData.getInstance().getGame().getLevel() == 1)
				RemovePossible();
			else
				RemovePossibleLEVEL2();
			Square prevPlace = Game.getInstance().getKnight().getCurrentPlace();
			Game.getInstance().getKnight().setCurrentPlace(Board[i][j]);
				if ((prevPlace.getCol() - prevPlace.getRow()) % 2 == 0
						|| (prevPlace.getCol() - prevPlace.getRow()) == 0)
					getImageByStringBoard("S" + prevPlace.getRow() + prevPlace.getCol())
							.setImage(StepG);
				else
					getImageByStringBoard("S" + prevPlace.getRow() + prevPlace.getCol()).setImage(StepB);

			getImageByString("I" + prevPlace.getRow() + prevPlace.getCol()).setImage(null);

			// if player pressed a regular square
			if ((Board[i][j].getSquareType().equals(Type.Regular))) {
				getImageByString("I" + i + j).setImage(KNIGHT);
				if (Board[i][j].isVisisted()) {
					Game.getInstance().getPlayer().setScore(Game.getInstance().getPlayer().getScore() - 1);
				} else {
					Board[i][j].setVisisted(true);
					Game.getInstance().getPlayer().setScore(Game.getInstance().getPlayer().getScore() + 1);
				}
			}
			// if the square is anything but a regular square
			else {
				handleSquare(i, j, Board[i][j].getSquareType());
			}

		}

		else if (Board[i][j].getSquareType().equals(Type.Blocked))
			getImageByString("I" + i + j).setImage(Blocked);

		if (Game.getInstance().getLevel() == 1)
			SetPossible();
		else if (SysData.getInstance().getGame().getLevel() == 2 || SysData.getInstance().getGame().getLevel() == 3
				|| SysData.getInstance().getGame().getLevel() == 4)
			SetPossibleLEVEL2();

		score.setText(Integer.toString(Game.getInstance().getPlayer().getScore()));

		if (Game.getInstance().Winner(Game.getInstance().getPlayer().getScore())) {
			try {

				popWinner();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	// a function to handle RandomJump ,Forget, Question squares.
	public void handleSquare(int i, int j, Type squareType) {
		switch (squareType) {

		// moving knight to random square and creating a new random jump square
		case RandomJump: {
			try {
				final Alert alert = new Alert(Alert.AlertType.INFORMATION);
				alert.setTitle("OOPs!");
				alert.setContentText("random jump.");
				alert.setHeaderText("Get Ready, " + Game.getInstance().getPlayer().getName());
				alert.showAndWait();
			} catch (Error e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
			// countDown();
			if (Board[i][j].isVisisted()) {
				Game.getInstance().getPlayer().setScore(Game.getInstance().getPlayer().getScore() - 1);
			} else {
				Board[i][j].setVisisted(true);
				Game.getInstance().getPlayer().setScore(Game.getInstance().getPlayer().getScore() + 1);
			}

			Board[i][j].setSquareType(Type.Regular);
			GetNewSquareByType(i, j, Type.RandomJump);
			Square jumpTo1 = randomSquare();
			getImageByString("I" + jumpTo1.getRow() + jumpTo1.getCol()).setImage(KNIGHT);
			Game.getInstance().getKnight().setCurrentPlace(Board[jumpTo1.getRow()][jumpTo1.getCol()]);

			if (Board[jumpTo1.getRow()][jumpTo1.getCol()].isVisisted()) {
				Game.getInstance().getPlayer().setScore(Game.getInstance().getPlayer().getScore() - 1);
			} else {
				Board[i][j].setVisisted(true);
				Game.getInstance().getPlayer().setScore(Game.getInstance().getPlayer().getScore() + 1);
			}

			break;
		}
		case Forget: {
			try {
				final Alert alert = new Alert(Alert.AlertType.INFORMATION);
				alert.setTitle("OOPs!");
				alert.setContentText("you are on a forget square");
				alert.showAndWait();
			} catch (Error e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
			lastObj l = Game.getInstance().getLast().pop();
			if (Game.getInstance().getLast().size() < 3) {
				while (!Game.getInstance().getLast().isEmpty()) {
					lastObj lastObj = Game.getInstance().getLast().pop();
					Game.getInstance().getPlayer().setScore(lastObj.getScore());
					if (Board[lastObj.getSquare().getRow()][lastObj.getSquare().getCol()].isVisisted()) {
						if ((lastObj.getSquare().getCol() - lastObj.getSquare().getRow()) % 2 == 0
								|| (lastObj.getSquare().getCol() - lastObj.getSquare().getRow()) == 0)
							getImageByStringBoard("S" + lastObj.getSquare().getRow() + lastObj.getSquare().getCol())
									.setImage(GREEN);
						else
							getImageByStringBoard("S" + lastObj.getSquare().getRow() + lastObj.getSquare().getCol())
									.setImage(BROWN);
						Board[lastObj.getSquare().getRow()][lastObj.getSquare().getCol()].setVisisted(false);
					} else {
						Board[lastObj.getSquare().getRow()][lastObj.getSquare().getCol()].setVisisted(true);
						getImageByString("I" + lastObj.getSquare().getRow() + lastObj.getSquare().getCol())
								.setImage(Step);
						;

					}
				}
			} else {
				for (int index = 0; index < 3; index++) {
					lastObj lastObj = Game.getInstance().getLast().pop();
					Game.getInstance().getPlayer().setScore(lastObj.getScore());
					if (Board[lastObj.getSquare().getRow()][lastObj.getSquare().getCol()].isVisisted()) {
						if ((lastObj.getSquare().getCol() - lastObj.getSquare().getRow()) % 2 == 0
								|| (lastObj.getSquare().getCol() - lastObj.getSquare().getRow()) == 0)
							getImageByStringBoard("S" + lastObj.getSquare().getRow() + lastObj.getSquare().getCol())
									.setImage(GREEN);
						else
							getImageByStringBoard("S" + lastObj.getSquare().getRow() + lastObj.getSquare().getCol())
									.setImage(BROWN);
						Board[lastObj.getSquare().getRow()][lastObj.getSquare().getCol()].setVisisted(false);
					} else {
						Board[lastObj.getSquare().getRow()][lastObj.getSquare().getCol()].setVisisted(true);
						getImageByString("I" + lastObj.getSquare().getRow() + lastObj.getSquare().getCol())
								.setImage(Step);
						;

					}

				}
			}
			getImageByString("I" + l.getSquare().getRow() + l.getSquare().getCol()).setImage(KNIGHT);

			break;
		}
		case EasyQuestion: {
			setSelectedQuestionType(Type.EasyQuestion);
			Board[i][j].setSquareType(Type.Regular);
			GetNewSquareByType(i, j, Type.EasyQuestion);

			getImageByString("I" + i + j).setImage(KNIGHT);
			Game.getInstance().getKnight().setCurrentPlace(Board[i][j]);

			if (Board[i][j].isVisisted()) {
				Game.getInstance().getPlayer().setScore(Game.getInstance().getPlayer().getScore() - 1);
			} else {
				Board[i][j].setVisisted(true);
				Game.getInstance().getPlayer().setScore(Game.getInstance().getPlayer().getScore() + 1);
			}
			try {
				popQuestion();
			} catch (IOException e) {
				e.printStackTrace();
			}
			Square s1 = randomRegularSquare(); // build one square with easy question.
			s1.setSquareType(Type.EasyQuestion);
			getImageByString("I" + s1.getRow() + s1.getCol()).setImage(QuestionGreen);
			break;
		}
		case MediumQuestion: {
			setSelectedQuestionType(Type.MediumQuestion);
			Board[i][j].setSquareType(Type.Regular);
			GetNewSquareByType(i, j, Type.MediumQuestion);

			getImageByString("I" + i + j).setImage(KNIGHT);
			Game.getInstance().getKnight().setCurrentPlace(Board[i][j]);

			if (Board[i][j].isVisisted()) {
				Game.getInstance().getPlayer().setScore(Game.getInstance().getPlayer().getScore() - 1);
			} else {
				Board[i][j].setVisisted(true);
				Game.getInstance().getPlayer().setScore(Game.getInstance().getPlayer().getScore() + 1);
			}
			try {
				popQuestion();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Square s1 = randomRegularSquare(); // build one square with easy question.
			s1.setSquareType(Type.MediumQuestion);
			getImageByString("I" + s1.getRow() + s1.getCol()).setImage(QuestionYellow);
			break;
		}
		case HardQuestion: {
			setSelectedQuestionType(Type.HardQuestion);
			Board[i][j].setSquareType(Type.Regular);
			GetNewSquareByType(i, j, Type.HardQuestion);
			getImageByString("I" + i + j).setImage(KNIGHT);
			Game.getInstance().getKnight().setCurrentPlace(Board[i][j]);

			if (Board[i][j].isVisisted()) {
				Game.getInstance().getPlayer().setScore(Game.getInstance().getPlayer().getScore() - 1);
			} else {
				Board[i][j].setVisisted(true);
				Game.getInstance().getPlayer().setScore(Game.getInstance().getPlayer().getScore() + 1);
			}
			try {
				popQuestion();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Square s1 = randomRegularSquare(); // build one square with easy question.
			s1.setSquareType(Type.HardQuestion);
			getImageByString("I" + s1.getRow() + s1.getCol()).setImage(QuestionRed);
			break;
		}
		default:
			break;

		}
	}

	private void popQuestion() throws IOException {
		pauseKing = true;
		timeline.pause();
		Parent pane = FXMLLoader.load(getClass().getResource("/views/QuestionWindow.fxml"));
		Scene scene = new Scene(pane);
		Stage newstage = new Stage();
		newstage.setScene(scene);
		newstage.setTitle("Question PopUp");
		newstage.showAndWait();
		timeline.play();
		pauseKing = false;

	}

	private void popWinner() throws IOException {
		pauseKing = true;
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
			if (Board[randomNumber1][randomNumber2].getSquareType().equals(Type.Regular)) // checking if the type is
																							// regular to continue
				flag = false;

		} while (flag);

		return Board[randomNumber1][randomNumber2];

	}

	// a method that returns a random square
	public Square randomSquare() {

		int randomNumber1, randomNumber2;
		randomNumber1 = (int) (Math.random() * 8);
		randomNumber2 = (int) (Math.random() * 8);
		return Board[randomNumber1][randomNumber2];

	}

	// a method to start the countdown from the start
	private void countDown() {
		remainingTime.textProperty().bind(timeSeconds.asString());
		if (timeline != null)
			timeline.stop();

		timeSeconds.set(STARTTIME);
		timeline = new Timeline();
		timeline.getKeyFrames().add(new KeyFrame(Duration.seconds(STARTTIME + 1), new KeyValue(timeSeconds, 0)));
		timeline.playFromStart();
	}

	@FXML
	private void back(ActionEvent event) throws IOException {

		Parent pane = FXMLLoader.load(getClass().getResource("/views/MainMenu.fxml"));
		Scene scene = new Scene(pane);
		Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		stage.setScene(scene);
		stage.setResizable(false);
		stage.setTitle("Main Menu");
		stage.show();
	}

	static void backToMain() throws IOException {
		Game.getInstance().getKnight().setCurrentPlace(new Square(0, 0));
		Game.getInstance().getKnight().setPrev_Place(new Square(0, 0));
		Game.getInstance().getQueen().setPrev_Place(new Square(0, 7));
		Game.getInstance().getQueen().setCurrentPlace(new Square(0, 7));
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

		allImages.add(I00);allImages.add(I01);allImages.add(I02);allImages.add(I03);allImages.add(I04);allImages.add(I05);allImages.add(I06);
		allImages.add(I07);allImages.add(I10);allImages.add(I11);allImages.add(I12);allImages.add(I13);allImages.add(I14);allImages.add(I15);
		allImages.add(I16);allImages.add(I17);allImages.add(I20);allImages.add(I21);allImages.add(I22);allImages.add(I23);allImages.add(I24);
		allImages.add(I25);allImages.add(I26);allImages.add(I27);allImages.add(I30);allImages.add(I31);allImages.add(I32);allImages.add(I33);
		allImages.add(I34);allImages.add(I35);allImages.add(I36);allImages.add(I37);allImages.add(I40);allImages.add(I41);allImages.add(I42);
		allImages.add(I43);allImages.add(I44);allImages.add(I45);allImages.add(I46);allImages.add(I47);allImages.add(I50);allImages.add(I51);
		allImages.add(I52);allImages.add(I53);allImages.add(I54);allImages.add(I55);allImages.add(I56);allImages.add(I57);allImages.add(I60);
		allImages.add(I61);allImages.add(I62);allImages.add(I63);allImages.add(I64);allImages.add(I65);allImages.add(I66);allImages.add(I67);
		allImages.add(I70);allImages.add(I71);allImages.add(I72);allImages.add(I73);allImages.add(I74);allImages.add(I75);allImages.add(I76);
		allImages.add(I77);

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
		S00.setImage(GREEN);
		I07.setImage(QUEEN);
		Game.getInstance().getPlayer().setScore(1);

		if (SysData.getInstance().getGame().getLevel() == 1)
			SetPossible();
		else
			SetPossibleLEVEL2();

	}

	public static void gameOverMessage() {
		try {
			final Alert alert = new Alert(Alert.AlertType.INFORMATION);
			alert.setTitle("Game Over!");
			alert.setContentText("Good Luck Next Time.");
			alert.setHeaderText("Thank You For Playing.");
			alert.showAndWait();

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


	public HashSet<ImageView> getBoardImages() {
		return BoardImages;
	}
	

	public ImageView getS00() {
		return S00;
	}

	public void setS00(ImageView s00) {
		S00 = s00;
	}

	public ImageView getS01() {
		return S01;
	}

	public void setS01(ImageView s01) {
		S01 = s01;
	}

	public ImageView getS02() {
		return S02;
	}

	public void setS02(ImageView s02) {
		S02 = s02;
	}

	public ImageView getS03() {
		return S03;
	}

	public void setS03(ImageView s03) {
		S03 = s03;
	}

	public ImageView getS04() {
		return S04;
	}

	public void setS04(ImageView s04) {
		S04 = s04;
	}

	public ImageView getS05() {
		return S05;
	}

	public void setS05(ImageView s05) {
		S05 = s05;
	}

	public ImageView getS06() {
		return S06;
	}

	public void setS06(ImageView s06) {
		S06 = s06;
	}

	public ImageView getS07() {
		return S07;
	}

	public void setS07(ImageView s07) {
		S07 = s07;
	}

	public ImageView getS10() {
		return S10;
	}

	public void setS10(ImageView s10) {
		S10 = s10;
	}

	public ImageView getS11() {
		return S11;
	}

	public void setS11(ImageView s11) {
		S11 = s11;
	}

	public ImageView getS12() {
		return S12;
	}

	public void setS12(ImageView s12) {
		S12 = s12;
	}

	public ImageView getS13() {
		return S13;
	}

	public void setS13(ImageView s13) {
		S13 = s13;
	}

	public ImageView getS14() {
		return S14;
	}

	public void setS14(ImageView s14) {
		S14 = s14;
	}

	public ImageView getS15() {
		return S15;
	}

	public void setS15(ImageView s15) {
		S15 = s15;
	}

	public ImageView getS16() {
		return S16;
	}

	public void setS16(ImageView s16) {
		S16 = s16;
	}

	public ImageView getS17() {
		return S17;
	}

	public void setS17(ImageView s17) {
		S17 = s17;
	}

	public ImageView getS20() {
		return S20;
	}

	public void setS20(ImageView s20) {
		S20 = s20;
	}

	public ImageView getS21() {
		return S21;
	}

	public void setS21(ImageView s21) {
		S21 = s21;
	}

	public ImageView getS22() {
		return S22;
	}

	public void setS22(ImageView s22) {
		S22 = s22;
	}

	public ImageView getS23() {
		return S23;
	}

	public void setS23(ImageView s23) {
		S23 = s23;
	}

	public ImageView getS24() {
		return S24;
	}

	public void setS24(ImageView s24) {
		S24 = s24;
	}

	public ImageView getS25() {
		return S25;
	}

	public void setS25(ImageView s25) {
		S25 = s25;
	}

	public ImageView getS26() {
		return S26;
	}

	public void setS26(ImageView s26) {
		S26 = s26;
	}

	public ImageView getS27() {
		return S27;
	}

	public void setS27(ImageView s27) {
		S27 = s27;
	}

	public ImageView getS30() {
		return S30;
	}

	public void setS30(ImageView s30) {
		S30 = s30;
	}

	public ImageView getS31() {
		return S31;
	}

	public void setS31(ImageView s31) {
		S31 = s31;
	}

	public ImageView getS32() {
		return S32;
	}

	public void setS32(ImageView s32) {
		S32 = s32;
	}

	public ImageView getS33() {
		return S33;
	}

	public void setS33(ImageView s33) {
		S33 = s33;
	}

	public ImageView getS34() {
		return S34;
	}

	public void setS34(ImageView s34) {
		S34 = s34;
	}

	public ImageView getS35() {
		return S35;
	}

	public void setS35(ImageView s35) {
		S35 = s35;
	}

	public ImageView getS36() {
		return S36;
	}

	public void setS36(ImageView s36) {
		S36 = s36;
	}

	public ImageView getS37() {
		return S37;
	}

	public void setS37(ImageView s37) {
		S37 = s37;
	}

	public ImageView getS40() {
		return S40;
	}

	public void setS40(ImageView s40) {
		S40 = s40;
	}

	public ImageView getS41() {
		return S41;
	}

	public void setS41(ImageView s41) {
		S41 = s41;
	}

	public ImageView getS42() {
		return S42;
	}

	public void setS42(ImageView s42) {
		S42 = s42;
	}

	public ImageView getS43() {
		return S43;
	}

	public void setS43(ImageView s43) {
		S43 = s43;
	}

	public ImageView getS44() {
		return S44;
	}

	public void setS44(ImageView s44) {
		S44 = s44;
	}

	public ImageView getS45() {
		return S45;
	}

	public void setS45(ImageView s45) {
		S45 = s45;
	}

	public ImageView getS46() {
		return S46;
	}

	public void setS46(ImageView s46) {
		S46 = s46;
	}

	public ImageView getS47() {
		return S47;
	}

	public void setS47(ImageView s47) {
		S47 = s47;
	}

	public ImageView getS50() {
		return S50;
	}

	public void setS50(ImageView s50) {
		S50 = s50;
	}

	public ImageView getS51() {
		return S51;
	}

	public void setS51(ImageView s51) {
		S51 = s51;
	}

	public ImageView getS52() {
		return S52;
	}

	public void setS52(ImageView s52) {
		S52 = s52;
	}

	public ImageView getS53() {
		return S53;
	}

	public void setS53(ImageView s53) {
		S53 = s53;
	}

	public ImageView getS54() {
		return S54;
	}

	public void setS54(ImageView s54) {
		S54 = s54;
	}

	public ImageView getS55() {
		return S55;
	}

	public void setS55(ImageView s55) {
		S55 = s55;
	}

	public ImageView getS56() {
		return S56;
	}

	public void setS56(ImageView s56) {
		S56 = s56;
	}

	public ImageView getS57() {
		return S57;
	}

	public void setS57(ImageView s57) {
		S57 = s57;
	}

	public ImageView getS60() {
		return S60;
	}

	public void setS60(ImageView s60) {
		S60 = s60;
	}

	public ImageView getS61() {
		return S61;
	}

	public void setS61(ImageView s61) {
		S61 = s61;
	}

	public ImageView getS62() {
		return S62;
	}

	public void setS62(ImageView s62) {
		S62 = s62;
	}

	public ImageView getS63() {
		return S63;
	}

	public void setS63(ImageView s63) {
		S63 = s63;
	}

	public ImageView getS64() {
		return S64;
	}

	public void setS64(ImageView s64) {
		S64 = s64;
	}

	public ImageView getS65() {
		return S65;
	}

	public void setS65(ImageView s65) {
		S65 = s65;
	}

	public ImageView getS66() {
		return S66;
	}

	public void setS66(ImageView s66) {
		S66 = s66;
	}

	public ImageView getS67() {
		return S67;
	}

	public void setS67(ImageView s67) {
		S67 = s67;
	}

	public ImageView getS70() {
		return S70;
	}

	public void setS70(ImageView s70) {
		S70 = s70;
	}

	public ImageView getS71() {
		return S71;
	}

	public void setS71(ImageView s71) {
		S71 = s71;
	}

	public ImageView getS72() {
		return S72;
	}

	public void setS72(ImageView s72) {
		S72 = s72;
	}

	public ImageView getS73() {
		return S73;
	}

	public void setS73(ImageView s73) {
		S73 = s73;
	}

	public ImageView getS74() {
		return S74;
	}

	public void setS74(ImageView s74) {
		S74 = s74;
	}

	public ImageView getS75() {
		return S75;
	}

	public void setS75(ImageView s75) {
		S75 = s75;
	}

	public ImageView getS76() {
		return S76;
	}

	public void setS76(ImageView s76) {
		S76 = s76;
	}

	public ImageView getS77() {
		return S77;
	}

	public void setS77(ImageView s77) {
		S77 = s77;
	}

	public ImageView getI00() {
		return I00;
	}

	public void setI00(ImageView i00) {
		I00 = i00;
	}

	public ImageView getI01() {
		return I01;
	}

	public void setI01(ImageView i01) {
		I01 = i01;
	}

	public ImageView getI02() {
		return I02;
	}

	public void setI02(ImageView i02) {
		I02 = i02;
	}

	public ImageView getI03() {
		return I03;
	}

	public void setI03(ImageView i03) {
		I03 = i03;
	}

	public ImageView getI04() {
		return I04;
	}

	public void setI04(ImageView i04) {
		I04 = i04;
	}

	public ImageView getI05() {
		return I05;
	}

	public void setI05(ImageView i05) {
		I05 = i05;
	}

	public ImageView getI06() {
		return I06;
	}

	public void setI06(ImageView i06) {
		I06 = i06;
	}

	public ImageView getI07() {
		return I07;
	}

	public void setI07(ImageView i07) {
		I07 = i07;
	}

	public ImageView getI10() {
		return I10;
	}

	public void setI10(ImageView i10) {
		I10 = i10;
	}

	public ImageView getI11() {
		return I11;
	}

	public void setI11(ImageView i11) {
		I11 = i11;
	}

	public ImageView getI12() {
		return I12;
	}

	public void setI12(ImageView i12) {
		I12 = i12;
	}

	public ImageView getI13() {
		return I13;
	}

	public void setI13(ImageView i13) {
		I13 = i13;
	}

	public ImageView getI14() {
		return I14;
	}

	public void setI14(ImageView i14) {
		I14 = i14;
	}

	public ImageView getI15() {
		return I15;
	}

	public void setI15(ImageView i15) {
		I15 = i15;
	}

	public ImageView getI16() {
		return I16;
	}

	public void setI16(ImageView i16) {
		I16 = i16;
	}

	public ImageView getI17() {
		return I17;
	}

	public void setI17(ImageView i17) {
		I17 = i17;
	}

	public ImageView getI20() {
		return I20;
	}

	public void setI20(ImageView i20) {
		I20 = i20;
	}

	public ImageView getI21() {
		return I21;
	}

	public void setI21(ImageView i21) {
		I21 = i21;
	}

	public ImageView getI22() {
		return I22;
	}

	public void setI22(ImageView i22) {
		I22 = i22;
	}

	public ImageView getI23() {
		return I23;
	}

	public void setI23(ImageView i23) {
		I23 = i23;
	}

	public ImageView getI24() {
		return I24;
	}

	public void setI24(ImageView i24) {
		I24 = i24;
	}

	public ImageView getI25() {
		return I25;
	}

	public void setI25(ImageView i25) {
		I25 = i25;
	}

	public ImageView getI26() {
		return I26;
	}

	public void setI26(ImageView i26) {
		I26 = i26;
	}

	public ImageView getI27() {
		return I27;
	}

	public void setI27(ImageView i27) {
		I27 = i27;
	}

	public ImageView getI30() {
		return I30;
	}

	public void setI30(ImageView i30) {
		I30 = i30;
	}

	public ImageView getI31() {
		return I31;
	}

	public void setI31(ImageView i31) {
		I31 = i31;
	}

	public ImageView getI32() {
		return I32;
	}

	public void setI32(ImageView i32) {
		I32 = i32;
	}

	public ImageView getI33() {
		return I33;
	}

	public void setI33(ImageView i33) {
		I33 = i33;
	}

	public ImageView getI34() {
		return I34;
	}

	public void setI34(ImageView i34) {
		I34 = i34;
	}

	public ImageView getI35() {
		return I35;
	}

	public void setI35(ImageView i35) {
		I35 = i35;
	}

	public ImageView getI36() {
		return I36;
	}

	public void setI36(ImageView i36) {
		I36 = i36;
	}

	public ImageView getI37() {
		return I37;
	}

	public void setI37(ImageView i37) {
		I37 = i37;
	}

	public ImageView getI40() {
		return I40;
	}

	public void setI40(ImageView i40) {
		I40 = i40;
	}

	public ImageView getI41() {
		return I41;
	}

	public void setI41(ImageView i41) {
		I41 = i41;
	}

	public ImageView getI42() {
		return I42;
	}

	public void setI42(ImageView i42) {
		I42 = i42;
	}

	public ImageView getI43() {
		return I43;
	}

	public void setI43(ImageView i43) {
		I43 = i43;
	}

	public ImageView getI44() {
		return I44;
	}

	public void setI44(ImageView i44) {
		I44 = i44;
	}

	public ImageView getI45() {
		return I45;
	}

	public void setI45(ImageView i45) {
		I45 = i45;
	}

	public ImageView getI46() {
		return I46;
	}

	public void setI46(ImageView i46) {
		I46 = i46;
	}

	public ImageView getI47() {
		return I47;
	}

	public void setI47(ImageView i47) {
		I47 = i47;
	}

	public ImageView getI50() {
		return I50;
	}

	public void setI50(ImageView i50) {
		I50 = i50;
	}

	public ImageView getI51() {
		return I51;
	}

	public void setI51(ImageView i51) {
		I51 = i51;
	}

	public ImageView getI52() {
		return I52;
	}

	public void setI52(ImageView i52) {
		I52 = i52;
	}

	public ImageView getI53() {
		return I53;
	}

	public void setI53(ImageView i53) {
		I53 = i53;
	}

	public ImageView getI54() {
		return I54;
	}

	public void setI54(ImageView i54) {
		I54 = i54;
	}

	public ImageView getI55() {
		return I55;
	}

	public void setI55(ImageView i55) {
		I55 = i55;
	}

	public ImageView getI56() {
		return I56;
	}

	public void setI56(ImageView i56) {
		I56 = i56;
	}

	public ImageView getI57() {
		return I57;
	}

	public void setI57(ImageView i57) {
		I57 = i57;
	}

	public ImageView getI60() {
		return I60;
	}

	public void setI60(ImageView i60) {
		I60 = i60;
	}

	public ImageView getI61() {
		return I61;
	}

	public void setI61(ImageView i61) {
		I61 = i61;
	}

	public ImageView getI62() {
		return I62;
	}

	public void setI62(ImageView i62) {
		I62 = i62;
	}

	public ImageView getI63() {
		return I63;
	}

	public void setI63(ImageView i63) {
		I63 = i63;
	}

	public ImageView getI64() {
		return I64;
	}

	public void setI64(ImageView i64) {
		I64 = i64;
	}

	public ImageView getI65() {
		return I65;
	}

	public void setI65(ImageView i65) {
		I65 = i65;
	}

	public ImageView getI66() {
		return I66;
	}

	public void setI66(ImageView i66) {
		I66 = i66;
	}

	public ImageView getI67() {
		return I67;
	}

	public void setI67(ImageView i67) {
		I67 = i67;
	}

	public ImageView getI70() {
		return I70;
	}

	public void setI70(ImageView i70) {
		I70 = i70;
	}

	public ImageView getI71() {
		return I71;
	}

	public void setI71(ImageView i71) {
		I71 = i71;
	}

	public ImageView getI72() {
		return I72;
	}

	public void setI72(ImageView i72) {
		I72 = i72;
	}

	public ImageView getI73() {
		return I73;
	}

	public void setI73(ImageView i73) {
		I73 = i73;
	}

	public ImageView getI74() {
		return I74;
	}

	public void setI74(ImageView i74) {
		I74 = i74;
	}

	public ImageView getI75() {
		return I75;
	}

	public void setI75(ImageView i75) {
		I75 = i75;
	}

	public ImageView getI76() {
		return I76;
	}

	public void setI76(ImageView i76) {
		I76 = i76;
	}

	public ImageView getI77() {
		return I77;
	}

	public void setI77(ImageView i77) {
		I77 = i77;
	}

	public Button getCI00() {
		return CI00;
	}

	public void setCI00(Button cI00) {
		CI00 = cI00;
	}

	public Button getCI01() {
		return CI01;
	}

	public void setCI01(Button cI01) {
		CI01 = cI01;
	}

	public Button getCI02() {
		return CI02;
	}

	public void setCI02(Button cI02) {
		CI02 = cI02;
	}

	public Button getCI03() {
		return CI03;
	}

	public void setCI03(Button cI03) {
		CI03 = cI03;
	}

	public Button getCI04() {
		return CI04;
	}

	public void setCI04(Button cI04) {
		CI04 = cI04;
	}

	public Button getCI05() {
		return CI05;
	}

	public void setCI05(Button cI05) {
		CI05 = cI05;
	}

	public Button getCI06() {
		return CI06;
	}

	public void setCI06(Button cI06) {
		CI06 = cI06;
	}

	public Button getCI07() {
		return CI07;
	}

	public void setCI07(Button cI07) {
		CI07 = cI07;
	}

	public Button getCI10() {
		return CI10;
	}

	public void setCI10(Button cI10) {
		CI10 = cI10;
	}

	public Button getCI11() {
		return CI11;
	}

	public void setCI11(Button cI11) {
		CI11 = cI11;
	}

	public Button getCI12() {
		return CI12;
	}

	public void setCI12(Button cI12) {
		CI12 = cI12;
	}

	public Button getCI13() {
		return CI13;
	}

	public void setCI13(Button cI13) {
		CI13 = cI13;
	}

	public Button getCI14() {
		return CI14;
	}

	public void setCI14(Button cI14) {
		CI14 = cI14;
	}

	public Button getCI15() {
		return CI15;
	}

	public void setCI15(Button cI15) {
		CI15 = cI15;
	}

	public Button getCI16() {
		return CI16;
	}

	public void setCI16(Button cI16) {
		CI16 = cI16;
	}

	public Button getCI17() {
		return CI17;
	}

	public void setCI17(Button cI17) {
		CI17 = cI17;
	}

	public Button getCI20() {
		return CI20;
	}

	public void setCI20(Button cI20) {
		CI20 = cI20;
	}

	public Button getCI21() {
		return CI21;
	}

	public void setCI21(Button cI21) {
		CI21 = cI21;
	}

	public Button getCI22() {
		return CI22;
	}

	public void setCI22(Button cI22) {
		CI22 = cI22;
	}

	public Button getCI23() {
		return CI23;
	}

	public void setCI23(Button cI23) {
		CI23 = cI23;
	}

	public Button getCI24() {
		return CI24;
	}

	public void setCI24(Button cI24) {
		CI24 = cI24;
	}

	public Button getCI25() {
		return CI25;
	}

	public void setCI25(Button cI25) {
		CI25 = cI25;
	}

	public Button getCI26() {
		return CI26;
	}

	public void setCI26(Button cI26) {
		CI26 = cI26;
	}

	public Button getCI27() {
		return CI27;
	}

	public void setCI27(Button cI27) {
		CI27 = cI27;
	}

	public Button getCI30() {
		return CI30;
	}

	public void setCI30(Button cI30) {
		CI30 = cI30;
	}

	public Button getCI31() {
		return CI31;
	}

	public void setCI31(Button cI31) {
		CI31 = cI31;
	}

	public Button getCI32() {
		return CI32;
	}

	public void setCI32(Button cI32) {
		CI32 = cI32;
	}

	public Button getCI33() {
		return CI33;
	}

	public void setCI33(Button cI33) {
		CI33 = cI33;
	}

	public Button getCI34() {
		return CI34;
	}

	public void setCI34(Button cI34) {
		CI34 = cI34;
	}

	public Button getCI35() {
		return CI35;
	}

	public void setCI35(Button cI35) {
		CI35 = cI35;
	}

	public Button getCI36() {
		return CI36;
	}

	public void setCI36(Button cI36) {
		CI36 = cI36;
	}

	public Button getCI37() {
		return CI37;
	}

	public void setCI37(Button cI37) {
		CI37 = cI37;
	}

	public Button getCI40() {
		return CI40;
	}

	public void setCI40(Button cI40) {
		CI40 = cI40;
	}

	public Button getCI41() {
		return CI41;
	}

	public void setCI41(Button cI41) {
		CI41 = cI41;
	}

	public Button getCI42() {
		return CI42;
	}

	public void setCI42(Button cI42) {
		CI42 = cI42;
	}

	public Button getCI43() {
		return CI43;
	}

	public void setCI43(Button cI43) {
		CI43 = cI43;
	}

	public Button getCI44() {
		return CI44;
	}

	public void setCI44(Button cI44) {
		CI44 = cI44;
	}

	public Button getCI45() {
		return CI45;
	}

	public void setCI45(Button cI45) {
		CI45 = cI45;
	}

	public Button getCI46() {
		return CI46;
	}

	public void setCI46(Button cI46) {
		CI46 = cI46;
	}

	public Button getCI47() {
		return CI47;
	}

	public void setCI47(Button cI47) {
		CI47 = cI47;
	}

	public Button getCI50() {
		return CI50;
	}

	public void setCI50(Button cI50) {
		CI50 = cI50;
	}

	public Button getCI51() {
		return CI51;
	}

	public void setCI51(Button cI51) {
		CI51 = cI51;
	}

	public Button getCI52() {
		return CI52;
	}

	public void setCI52(Button cI52) {
		CI52 = cI52;
	}

	public Button getCI53() {
		return CI53;
	}

	public void setCI53(Button cI53) {
		CI53 = cI53;
	}

	public Button getCI54() {
		return CI54;
	}

	public void setCI54(Button cI54) {
		CI54 = cI54;
	}

	public Button getCI55() {
		return CI55;
	}

	public void setCI55(Button cI55) {
		CI55 = cI55;
	}

	public Button getCI56() {
		return CI56;
	}

	public void setCI56(Button cI56) {
		CI56 = cI56;
	}

	public Button getCI57() {
		return CI57;
	}

	public void setCI57(Button cI57) {
		CI57 = cI57;
	}

	public Button getCI60() {
		return CI60;
	}

	public void setCI60(Button cI60) {
		CI60 = cI60;
	}

	public Button getCI61() {
		return CI61;
	}

	public void setCI61(Button cI61) {
		CI61 = cI61;
	}

	public Button getCI62() {
		return CI62;
	}

	public void setCI62(Button cI62) {
		CI62 = cI62;
	}

	public Button getCI63() {
		return CI63;
	}

	public void setCI63(Button cI63) {
		CI63 = cI63;
	}

	public Button getCI64() {
		return CI64;
	}

	public void setCI64(Button cI64) {
		CI64 = cI64;
	}

	public Button getCI65() {
		return CI65;
	}

	public void setCI65(Button cI65) {
		CI65 = cI65;
	}

	public Button getCI66() {
		return CI66;
	}

	public void setCI66(Button cI66) {
		CI66 = cI66;
	}

	public Button getCI67() {
		return CI67;
	}

	public void setCI67(Button cI67) {
		CI67 = cI67;
	}

	public Button getCI70() {
		return CI70;
	}

	public void setCI70(Button cI70) {
		CI70 = cI70;
	}

	public Button getCI71() {
		return CI71;
	}

	public void setCI71(Button cI71) {
		CI71 = cI71;
	}

	public Button getCI72() {
		return CI72;
	}

	public void setCI72(Button cI72) {
		CI72 = cI72;
	}

	public Button getCI73() {
		return CI73;
	}

	public void setCI73(Button cI73) {
		CI73 = cI73;
	}

	public Button getCI74() {
		return CI74;
	}

	public void setCI74(Button cI74) {
		CI74 = cI74;
	}

	public Button getCI75() {
		return CI75;
	}

	public void setCI75(Button cI75) {
		CI75 = cI75;
	}

	public Button getCI76() {
		return CI76;
	}

	public void setCI76(Button cI76) {
		CI76 = cI76;
	}

	public Button getCI77() {
		return CI77;
	}

	public void setCI77(Button cI77) {
		CI77 = cI77;
	}

	public HashSet<Button> getPossibleButtons() {
		return PossibleButtons;
	}

	public void setPossibleButtons(HashSet<Button> possibleButtons) {
		PossibleButtons = possibleButtons;
	}

	public Button getBackBtn() {
		return backBtn;
	}

	public void setBackBtn(Button backBtn) {
		this.backBtn = backBtn;
	}

	public Label getLevel() {
		return level;
	}

	public void setLevel(Label level) {
		this.level = level;
	}

	public Label getPlayerName() {
		return playerName;
	}

	public void setPlayerName(Label playerName) {
		this.playerName = playerName;
	}

	public Label getRemainingTime() {
		return remainingTime;
	}

	public void setRemainingTime(Label remainingTime) {
		this.remainingTime = remainingTime;
	}

	public Label getScore() {
		return score;
	}

	public void setScore(Label score) {
		this.score = score;
	}

	public AnchorPane getScreen() {
		return screen;
	}

	public void setScreen(AnchorPane screen) {
		this.screen = screen;
	}

	public Timeline getTimeline() {
		return timeline;
	}

	public void setTimeline(Timeline timeline) {
		this.timeline = timeline;
	}

	public static Boolean getPauseKing() {
		return pauseKing;
	}

	public static void setPauseKing(Boolean pauseKing) {
		GameController.pauseKing = pauseKing;
	}

	public IntegerProperty getTimeSeconds() {
		return timeSeconds;
	}

	public void setTimeSeconds(IntegerProperty timeSeconds) {
		this.timeSeconds = timeSeconds;
	}

	public Image getKING() {
		return KING;
	}

	public void setKING(Image kING) {
		KING = kING;
	}

	public Image getQUEEN() {
		return QUEEN;
	}

	public void setQUEEN(Image qUEEN) {
		QUEEN = qUEEN;
	}

	public Image getKNIGHT() {
		return KNIGHT;
	}

	public void setKNIGHT(Image kNIGHT) {
		KNIGHT = kNIGHT;
	}

	public Image getPossible() {
		return Possible;
	}

	public void setPossible(Image possible) {
		Possible = possible;
	}





	public Image getBlocked() {
		return Blocked;
	}

	public void setBlocked(Image blocked) {
		Blocked = blocked;
	}

	public Image getGREEN() {
		return GREEN;
	}

	public void setGREEN(Image gREEN) {
		GREEN = gREEN;
	}

	public Image getBROWN() {
		return BROWN;
	}

	public void setBROWN(Image bROWN) {
		BROWN = bROWN;
	}

	public HashSet<ImageView> getPossibleMovesQueen() {
		return PossibleMovesQueen;
	}

	public void setPossibleMovesQueen(HashSet<ImageView> possibleMovesQueen) {
		PossibleMovesQueen = possibleMovesQueen;
	}

	public static Boolean getLevel4Started() {
		return level4Started;
	}

	public static void setLevel4Started(Boolean level4Started) {
		GameController.level4Started = level4Started;
	}

	public static Boolean getLevel3Started() {
		return level3Started;
	}

	public static void setLevel3Started(Boolean level3Started) {
		GameController.level3Started = level3Started;
	}

	public boolean isLevelUp() {
		return levelUp;
	}

	public void setLevelUp(boolean levelUp) {
		this.levelUp = levelUp;
	}

	public Alert getAlert() {
		return alert;
	}

	public void setAlert(Alert alert) {
		this.alert = alert;
	}

	public static Integer getStarttime() {
		return STARTTIME;
	}

	public static void setAllImages(HashSet<ImageView> allImages) {
		GameController.allImages = allImages;
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
