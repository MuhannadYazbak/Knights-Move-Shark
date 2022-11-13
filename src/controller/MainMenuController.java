package controller;



import java.io.IOException;

//import Model.SysData;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;


public class MainMenuController {
	
	@FXML
	Button startNewGameBtn, historyBtn, questionsWizardBtn, exitBtn;
	@FXML
	private void history(ActionEvent event) throws IOException {
		Parent pane = FXMLLoader.load(getClass().getResource("/View/History.fxml"));
		Scene scene = new Scene(pane);
		Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
		stage.setScene(scene);
		stage.setMaximized(true);
		stage.setTitle("History");
		stage.show();
	}
	@FXML
	private void enterPlayerName(ActionEvent event) throws IOException {
		Parent pane = FXMLLoader.load(getClass().getResource("/View/PlayerName.fxml"));
		Scene scene = new Scene(pane);
		Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
		stage.setScene(scene);
		stage.setMaximized(true);
		stage.setTitle("Start New Game");
		stage.show();
	
	}
	@FXML
	private void showQuestionsWizard(ActionEvent event) throws IOException {
		Parent pane = FXMLLoader.load(getClass().getResource("/View/QuestionsWizard.fxml"));
		Scene scene = new Scene(pane);
		Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
		stage.setScene(scene);
		stage.setMaximized(true);
		stage.setTitle("Questions Wizard");
		stage.show();
	}

}
