package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import model.Game;
import model.Player;
import model.SysData;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

//TODO throw exp name == null

public class PlayerNameController implements Initializable {
	private String name;
	@FXML 
	private TextField playerName;
	
	@FXML 
	private Button enterBtn, backBtn;
	
	@FXML
	private Label message;
	
	@FXML
	private void back(ActionEvent event) throws IOException {
		Parent pane = FXMLLoader.load(getClass().getResource("/views/MainMenu.fxml"));
		Scene scene = new Scene(pane);
		Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
		stage.setScene(scene);
		stage.setTitle("Main Menu");
		stage.show();
	}
	
	@FXML
	private void goPlay(ActionEvent event) throws IOException {
		Player p= new Player(playerName.getText(),0,"01/01/2022");
		//String s=playerName.getText();
		Game g= new Game(p);
		//g.setPlayer(p.getName());
		SysData.getInstance().setGame(g);
		Parent pane = FXMLLoader.load(getClass().getResource("/views/Game.fxml"));
		Scene scene = new Scene(pane);
		Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
		stage.setScene(scene);
		stage.setTitle("Game Board");
		stage.show();
	}
	
	@FXML
	private void checkName(KeyEvent event) throws IOException {
		name = playerName.getText();
		if (!name.isBlank()) {
			message.setVisible(false);
			enterBtn.setDisable(false);
		}
		if(name.isBlank()) {
			message.setVisible(true);
			enterBtn.setDisable(true);
		}
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		enterBtn.setDisable(true);
		message.setVisible(true);
		
	}

}