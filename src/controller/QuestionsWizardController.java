package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.stage.Stage;
import model.Question;
import model.SysData;

public class QuestionsWizardController implements Initializable {
	@FXML Button backBtn, AddNewQuestionBtn;
	@FXML
	private TableView<Question> questionsTable = new TableView<>();
	
	
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
	private void addQuestion(ActionEvent event) throws IOException {
		Parent pane = FXMLLoader.load(getClass().getResource("/views/AddQuestion.fxml"));
		Scene scene = new Scene(pane);
		Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
		stage.setScene(scene);
		stage.setTitle("Add New Question");
		stage.show();
	}
	

    @FXML
    void updaetQuestion(ActionEvent event) throws IOException {
    	Parent pane = FXMLLoader.load(getClass().getResource("/views/AddQuestion.fxml"));
		Scene scene = new Scene(pane);
		Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
		stage.setScene(scene);
		stage.setTitle("Add New Question");
		stage.show();
    }
	/*
	 * Initializes the view, reading the questions from the Json file and loading it into the tableview.
	 */

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
//		@SuppressWarnings("unused")
//		ObservableList<Question> questions = SysData.getInstance().getQuestions();
//		questionsTable.getColumns().add((TableColumn<Question, ?>) questions);
	}

}
