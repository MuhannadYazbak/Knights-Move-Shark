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

public class AddQuestionController {
	@FXML
	Button backBtn, addQuestionBtn;
	
	
	@FXML
	private void back(ActionEvent event) throws IOException {
		Parent pane = FXMLLoader.load(getClass().getResource("/View/QuestionsWizard.fxml"));
		Scene scene = new Scene(pane);
		Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
		stage.setScene(scene);
		stage.setTitle("Questions Wizard");
		stage.setMaximized(true);
		stage.show();
	}

}
