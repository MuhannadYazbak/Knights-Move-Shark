package controller;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class PlayerNameController {
	@FXML TextField playerName;
	@FXML Button enterBtn, backBtn;
	
	@FXML
	private void back(ActionEvent event) throws IOException {
		Parent pane = FXMLLoader.load(getClass().getResource("/View/MainMenu.fxml"));
		Scene scene = new Scene(pane);
		Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
		stage.setScene(scene);
		stage.setTitle("Main Menu");
		stage.setMaximized(true);
		stage.show();
	}
	
	@FXML
	private void goPlay(ActionEvent event) throws IOException {
		Parent pane = FXMLLoader.load(getClass().getResource("/View/Game.fxml"));
		Scene scene = new Scene(pane);
		Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
		stage.setScene(scene);
		stage.setTitle("Game Board");
		stage.setMaximized(true);
		stage.show();
	}

}
