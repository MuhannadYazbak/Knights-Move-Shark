package controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.util.Duration;

public class WinnerController implements Initializable{

    @FXML
    private Button button;

    @FXML
    private MediaView mediaView,mediaView2;

    @FXML
    private AnchorPane screen;

    @FXML
    void continuee(ActionEvent event) {
    	Platform.exit();
    }
    
    private Media media,media2;
 	private MediaPlayer backgroundvideo=null,backgroundvideo2=null;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		if (backgroundvideo2 == null) {//starts the background video
			media2 = new Media(getClass().getResource("/lib/winner2.mp4").toExternalForm());

			backgroundvideo2 = new MediaPlayer(media2);
			mediaView2.setMediaPlayer(backgroundvideo2);

			backgroundvideo2.setOnEndOfMedia(new Runnable() {
				@Override
				public void run() {
					backgroundvideo2.seek(Duration.ZERO);
					backgroundvideo2.play();
				}
			});
			backgroundvideo2.play();
		}
		mediaView2.toBack();
		if (backgroundvideo == null) {//starts the background video
			media = new Media(getClass().getResource("/lib/winner3.mp4").toExternalForm());

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

}
