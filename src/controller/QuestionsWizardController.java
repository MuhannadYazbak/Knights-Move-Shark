package controller;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class QuestionsWizardController {
	@FXML Button backBtn, AddNewQuestionBtn;
	
	@FXML
	private void back(ActionEvent event) throws IOException {
		Parent pane = FXMLLoader.load(getClass().getResource("/View/MainMenu.fxml"));
		Scene scene = new Scene(pane);
		Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
		stage.setScene(scene);
		stage.setMaximized(true);
		stage.setTitle("Main Menu");
		stage.show();
	}
	
	@FXML
	private void addQuestion(ActionEvent event) throws IOException {
		Parent pane = FXMLLoader.load(getClass().getResource("/View/AddQuestion.fxml"));
		Scene scene = new Scene(pane);
		Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
		stage.setScene(scene);
		stage.setTitle("Add New Question");
		stage.setMaximized(true);
		stage.show();
	}

}
