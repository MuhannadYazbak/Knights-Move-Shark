package controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.util.Duration;
import model.Game;
import model.Question;
import model.SysData;
import utils.Difficulty;
import utils.Type;

public class QuestionWindowController implements Initializable {
	
	@FXML
	private Label questionLbl;
	
	@FXML
	private RadioButton option1, option2, option3, option4;
	
	@FXML
	private Button submitBtn;
	
	   @FXML
	    private MediaView mediaView;
	   
	 private Question question;
	 
	 private Media media;
	 	private MediaPlayer backgroundvideo=null;

	private ArrayList<Question> questions = new ArrayList<>();
	 
	 private Collection<Question> questionsColl = new ArrayList<>();
	 
	 /*
	  * Creates Array List of Questions of the needed level of difficulty and pick a random question.
	  */
	 private ArrayList<Question> qArray (Type level){
		 if (level == Type.EasyQuestion) {
			  questionsColl = SysData.getInstance().getEasyQuestions().values();
		 	questions.addAll(questionsColl);
		 	question = questions.get((int)(Math.random() *questionsColl.size()));
		 } else if (level == Type.MediumQuestion) {
			 questionsColl = SysData.getInstance().getMediumQuestions().values();
			 questions.addAll(questionsColl);
			 question = questions.get((int)(Math.random() *questionsColl.size()));
		 }else if(level == Type.HardQuestion) {
			 questionsColl = SysData.getInstance().getHardQuestions().values();
			 questions.addAll(questionsColl);
			 question = questions.get((int)(Math.random() *questionsColl.size()));
		 }
		 return questions;
	 }
	 
	
	/*
	 * When submit is clicked, it check whether the player answered correctly or not.
	 *  Updates the score accordingly and shows suitable alert. 
	 *  Finally, it closes the question window and back to game.
	 */
	 @FXML
		private void Answer(ActionEvent event) {
		Alert right = new Alert(Alert.AlertType.INFORMATION);
		right.setContentText("Good job, you answered correctly");
		right.setTitle("Right Answer");
		Alert wrong = new Alert(Alert.AlertType.INFORMATION);
		wrong.setContentText("Hard luck, you answered wrong");
		wrong.setTitle("Wrong Answer");
		 switch (question.getLevel()) {
		 case EASY:
			 switch(question.getRightAnswer()) {
				case 1:
				if (option1.isSelected()) {
					Game.getInstance().getPlayer().setScore(Game.getInstance().getPlayer().getScore()+1);
					right.showAndWait();
				} else if(Game.getInstance().getScore()>=3) {
					Game.getInstance().getPlayer().setScore(Game.getInstance().getPlayer().getScore()-2);
					wrong.showAndWait();
					
				}else {
					Game.getInstance().setScore(0);
					wrong.showAndWait();
				}
				break;
				case 2:
					if (option2.isSelected()) {
						Game.getInstance().getPlayer().setScore(Game.getInstance().getPlayer().getScore()+1);
						right.showAndWait();
					} else if(Game.getInstance().getScore()>=3) {
						Game.getInstance().getPlayer().setScore(Game.getInstance().getPlayer().getScore()-2);
						wrong.showAndWait();
						
					}else {
						Game.getInstance().setScore(0);
						wrong.showAndWait();
					}
					break;
				case 3:
					if (option3.isSelected()) {
						Game.getInstance().getPlayer().setScore(Game.getInstance().getPlayer().getScore()+1);
						right.showAndWait();
					} else if(Game.getInstance().getScore()>=3) {
						Game.getInstance().getPlayer().setScore(Game.getInstance().getPlayer().getScore()-2);
						wrong.showAndWait();
						
					}else {
						Game.getInstance().setScore(0);
						wrong.showAndWait();
					}
					break;
				case 4:
					if (option4.isSelected()) {
						Game.getInstance().getPlayer().setScore(Game.getInstance().getPlayer().getScore()+1);
						right.showAndWait();
					} else if(Game.getInstance().getScore()>=3) {
						Game.getInstance().getPlayer().setScore(Game.getInstance().getPlayer().getScore()-2);
						wrong.showAndWait();
						
					}else {
						Game.getInstance().setScore(0);
						wrong.showAndWait();
					}
				break;
			}
			 break;
		 case MEDIUM:
			 switch(question.getRightAnswer()) {
				case 1:
				if (option1.isSelected()) {
					Game.getInstance().getPlayer().setScore(Game.getInstance().getPlayer().getScore()+2);
					right.showAndWait();
				} else if(Game.getInstance().getScore()>=3) {
					Game.getInstance().getPlayer().setScore(Game.getInstance().getPlayer().getScore()-3);
					wrong.showAndWait();
					
				}else {
					Game.getInstance().setScore(0);
					wrong.showAndWait();
				}
				break;
				case 2:
					if (option2.isSelected()) {
						Game.getInstance().getPlayer().setScore(Game.getInstance().getPlayer().getScore()+2);
						right.showAndWait();
					} else if(Game.getInstance().getScore()>=3) {
						Game.getInstance().getPlayer().setScore(Game.getInstance().getPlayer().getScore()-3);
						wrong.showAndWait();
						
					}else {
						Game.getInstance().setScore(0);
						wrong.showAndWait();
					}
					break;
				case 3:
					if (option3.isSelected()) {
						Game.getInstance().getPlayer().setScore(Game.getInstance().getPlayer().getScore()+2);
						right.showAndWait();
					} else if(Game.getInstance().getScore()>=3) {
						Game.getInstance().getPlayer().setScore(Game.getInstance().getPlayer().getScore()-3);
						wrong.showAndWait();
						
					}else {
						Game.getInstance().setScore(0);
						wrong.showAndWait();
					}
					break;
				case 4:
					if (option4.isSelected()) {
						Game.getInstance().getPlayer().setScore(Game.getInstance().getPlayer().getScore()+2);
						right.showAndWait();
					} else if(Game.getInstance().getScore()>=3) {
						Game.getInstance().getPlayer().setScore(Game.getInstance().getPlayer().getScore()-3);
						wrong.showAndWait();
						
					}else {
						Game.getInstance().setScore(0);
						wrong.showAndWait();
					}
				break;
			}
			 break;
		 case HARD:
			 switch(question.getRightAnswer()) {
				case 1:
				if (option1.isSelected()) {
					Game.getInstance().getPlayer().setScore(Game.getInstance().getPlayer().getScore()+3);
					right.showAndWait();
				} else if(Game.getInstance().getScore()>=3) {
					Game.getInstance().getPlayer().setScore(Game.getInstance().getPlayer().getScore()-4);
					wrong.showAndWait();
					
				}else {
					Game.getInstance().setScore(0);
					wrong.showAndWait();
				}
				break;
				case 2:
					if (option2.isSelected()) {
						Game.getInstance().getPlayer().setScore(Game.getInstance().getPlayer().getScore()+3);
						right.showAndWait();
					} else if(Game.getInstance().getScore()>=3) {
						Game.getInstance().getPlayer().setScore(Game.getInstance().getPlayer().getScore()-4);
						wrong.showAndWait();
						
					}else {
						Game.getInstance().setScore(0);
						wrong.showAndWait();
					}
					break;
				case 3:
					if (option3.isSelected()) {
						Game.getInstance().getPlayer().setScore(Game.getInstance().getPlayer().getScore()+3);
						right.showAndWait();
					} else if(Game.getInstance().getScore()>=3) {
						Game.getInstance().getPlayer().setScore(Game.getInstance().getPlayer().getScore()-4);
						wrong.showAndWait();
						
					}else {
						Game.getInstance().setScore(0);
						wrong.showAndWait();
					}
					break;
				case 4:
					if (option4.isSelected()) {
						Game.getInstance().getPlayer().setScore(Game.getInstance().getPlayer().getScore()+3);
						right.showAndWait();
					} else if(Game.getInstance().getScore()>=3) {
						Game.getInstance().getPlayer().setScore(Game.getInstance().getPlayer().getScore()-4);
						wrong.showAndWait();
						
					}else {
						Game.getInstance().setScore(0);
						wrong.showAndWait();
					}
				break;
			}
		 }
			((Node) event.getSource()).getScene().getWindow().hide();
			
		}

	 

	/*
	 * Prepares the needed components to set their values
	 */
	 @Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		 if (backgroundvideo == null) {//starts the background video
				media = new Media(getClass().getResource("/lib/QB.mp4").toExternalForm());

				backgroundvideo = new MediaPlayer(media);
				mediaView.setMediaPlayer(backgroundvideo);

				backgroundvideo.setOnEndOfMedia(new Runnable() {
					@Override
					public void run() {
						backgroundvideo.seek(Duration.ZERO);
						backgroundvideo.play();
					}
				});
				backgroundvideo.play();
			}
			mediaView.toBack();
			
		questions = qArray(GameController.getSelectedQuestionType());
		System.out.println("Question: "+question);
		questionLbl.setText(question.getQuestionText());
		ToggleGroup group = new ToggleGroup();
		option1.setText(question.getAnswer1());
		option1.setToggleGroup(group);
		option2.setText(question.getAnswer2());
		option2.setToggleGroup(group);
		option3.setText(question.getAnswer3());
		option3.setToggleGroup(group);
		option4.setText(question.getAnswer4());
		option4.setToggleGroup(group);
	}

}
