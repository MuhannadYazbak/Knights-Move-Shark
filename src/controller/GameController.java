package controller;

import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.event.*;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;
import model.Game;
import model.Player;

public class GameController implements Initializable{
	
	
	@FXML
    private ImageView S00,S01,S02,S03,S04,S05,S06,S07,S10,S11,S12,S13,S14,S15,S16,S17,S20,S21,S22,S23,S24,S25,S26,S27,S30,S31,S32,S33,S34,S35,S36,S37,S40,S41,S42,S43,S44,S45,S46,S47,S50,S51,S52,S53,S54,S55,S56,S57,S60,S61,S62,S63,S64,S65,S66,S67,S70,S71,S72,S73,S74,S75,S76,S77;

	@FXML
    private ImageView I00,I01,I02,I03,I04,I05,I06,I07,I10,I11,I12,I13,I14,I15,I16,I17,I20,I21,I22,I23,I24,I25,I26,I27,I30,I31,I32,I33,I34,I35,I36,I37,I40,I41,I42,I43,I44,I45,I46,I47,I50,I51,I52,I53,I54,I55,I56,I57,I60,I61,I62,I63,I64,I65,I66,I67,I70,I71,I72,I73,I74,I75,I76,I77;
    
	@FXML
    private Button CI00,CI01,CI02,CI03,CI04,CI05,CI06,CI07,CI10,CI11,CI12,CI13,CI14,CI15,CI16,CI17,CI20,CI21,CI22,CI23,CI24,CI25,CI26,CI27,CI30,CI31,CI32,CI33,CI34,CI35,CI36,CI37,CI40,CI41,CI42,CI43,CI44,CI45,CI46,CI47,CI50,CI51,CI52,CI53,CI54,CI55,CI56,CI57,CI60,CI61,CI62,CI63,CI64,CI65,CI66,CI67,CI70,CI71,CI72,CI73,CI74,CI75,CI76,CI77;
	
	@FXML
    private Button backBtn;

    @FXML
    private Label level,playerName,remainingTime,score;

    @FXML
    private AnchorPane screen;
    
    private static final Integer STARTTIME = 60;
    private Timeline timeline;
    private IntegerProperty timeSeconds = new SimpleIntegerProperty(STARTTIME);
    
    
    
    @FXML
    void MoveTo() {
    	Image KING = new Image(getClass().getResourceAsStream("/lib/king.png"));
    	Image QUEEN = new Image(getClass().getResourceAsStream("/lib/queen.png"));
    	Image KNIGHT = new Image(getClass().getResourceAsStream("/lib/knight.png"));
    	
    	if(CI00.isPressed()) {
    		I00.setImage(KNIGHT);
    	}
    		
    	
    	if(CI01.isPressed())
    		I01.setImage(KNIGHT);
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

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
        remainingTime.textProperty().bind(timeSeconds.asString());
        if (timeline != null) 
        	timeline.stop();
                
        timeSeconds.set(STARTTIME);
        timeline = new Timeline();
        timeline.getKeyFrames().add(new KeyFrame(Duration.seconds(STARTTIME+1),new KeyValue(timeSeconds, 0)));
        timeline.playFromStart();
        
     // playerName.setText(g);
        
            
         

	}

}
