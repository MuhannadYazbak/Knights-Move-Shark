package controller;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Platform;
//import Model.SysData;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;
import javafx.util.Duration;


public class MainMenuController implements Initializable{
	
	
	@FXML
	private Parent parent;
	@FXML
    private Button exitBtn;

    @FXML
    private Button historyBtn;

    @FXML
    private MediaView mediaView;

    @FXML
    private Button questionsWizardBtn;

    @FXML
    private AnchorPane screen;

    @FXML
    private Button startNewGameBtn;

    @FXML
    private VBox vbox;
	  
	    
    private Media media;
	 	private MediaPlayer backgroundvideo;
		
		@Override
		public void initialize(URL arg0, ResourceBundle arg1) {
			
			if (backgroundvideo == null) {//starts the background video
				media = new Media(getClass().getResource("/lib/B1.mp4").toExternalForm());

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
		}
	
	@FXML
	private void history(ActionEvent event) throws IOException {
		Parent pane = FXMLLoader.load(getClass().getResource("/views/History.fxml"));
		Scene scene = new Scene(pane);
		Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
		stage.setScene(scene);
		stage.setTitle("History");
		stage.show();
	}
	@FXML
	private void enterPlayerName(ActionEvent event) throws IOException {
		Parent pane = FXMLLoader.load(getClass().getResource("/views/PlayerName.fxml"));
		Scene scene = new Scene(pane);
		Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
		stage.setScene(scene);
		stage.setTitle("Start New Game");
		stage.show();
	
	}
	@FXML
	private void showQuestionsWizard(ActionEvent event) throws IOException {
		Parent pane = FXMLLoader.load(getClass().getResource("/views/QuestionsWizard.fxml"));
		Scene scene = new Scene(pane);
		Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
		stage.setScene(scene);
		stage.setTitle("Questions Wizard");
		stage.show();
	}
	
	@FXML
	private void exit(ActionEvent event) {
		Platform.exit();
	}


	
}
