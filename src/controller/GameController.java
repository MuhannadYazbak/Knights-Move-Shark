package controller;

import java.awt.event.MouseEvent;
import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class GameController {
	
	 @FXML
	    private Button CI00;
	@FXML
    private ImageView S00,S01,S02,S03,S04,S05,S06,S07,S10,S11,S12,S13,S14,S15,S16,S17,S20,S21,S22,S23,S24,S25,S26,S27,S30,S31,S32,S33,S34,S35,S36,S37,S40,S41,S42,S43,S44,S45,S46,S47,S50,S51,S52,S53,S54,S55,S56,S57,S60,S61,S62,S63,S64,S65,S66,S67,S70,S71,S72,S73,S74,S75,S76,S77;

	@FXML
    private ImageView I00,I01,I02,I03,I04,I05,I06,I07,I10,I11,I12,I13,I14,I15,I16,I17,I20,I21,I22,I23,I24,I25,I26,I27,I30,I31,I32,I33,I34,I35,I36,I37,I40,I41,I42,I43,I44,I45,I46,I47,I50,I51,I52,I53,I54,I55,I56,I57,I60,I61,I62,I63,I64,I65,I66,I67,I70,I71,I72,I73,I74,I75,I76,I77;
    @FXML
    private Button backBtn;

    @FXML
    private Label level;

    @FXML
    private Label playerName;

    @FXML
    private Label remainingTime;

    @FXML
    private Label score;

    @FXML
    private AnchorPane screen;
	
    @FXML
    void MoveTo(ActionEvent event) {
    	Image image = new Image("/lib/king.png");
    	if(CI00.isPressed()) {
    		I00.setImage(image);
    	}
    }
    
	@FXML
	private void back(ActionEvent event) throws IOException {
		
		Parent pane = FXMLLoader.load(getClass().getResource("/views/MainMenu.fxml"));
		Scene scene = new Scene(pane);
		Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
		stage.setScene(scene);
		stage.setTitle("Main Menu");
		stage.show();
	}

}
