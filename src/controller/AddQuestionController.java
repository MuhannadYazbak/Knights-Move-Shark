package controller;

import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.Question;
import model.SysData;
import utils.Difficulty;

public class AddQuestionController implements Initializable {
	Question selected = new Question(null, null, null, null, null, null, 0, null);                       // The question instance that we will fit the values from the view into.
	ObservableList<HashMap<String, Question>> questions;                      
	ObservableList<Integer> rightAnswer;
	@FXML
	Button backBtn, addQuestionBtn;
	
	@FXML
	private TextField qText, a1Text, a2Text, a3Text, a4Text;
	
	@FXML
	private ComboBox<Difficulty> diffBox;
	@FXML
	private ComboBox<Integer> rightAnswerBox;
	
	/**
	 * prepare the data of the view, fills the combo boxes with the possible choices.
	 */
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		questions = FXCollections.observableArrayList(SysData.getInstance().getQuestions());
		//answers = FXCollections.observableArrayList();
		ObservableList<Difficulty> levels = FXCollections.observableArrayList();
		levels.addAll(Difficulty.Easy, Difficulty.Medium, Difficulty.Hard);
		diffBox.setItems(levels);
		ObservableList<Integer> positions = FXCollections.observableArrayList();
		positions.addAll(1, 2, 3, 4);
		rightAnswerBox.setItems(positions);
	}

	
	
	@FXML
	private void back(ActionEvent event) throws IOException {
		Parent pane = FXMLLoader.load(getClass().getResource("/views/QuestionsWizard.fxml"));
		Scene scene = new Scene(pane);
		Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
		stage.setScene(scene);
		stage.setTitle("Questions Wizard");
		stage.show();
	}
	/*
	 * committing to add a new question, shows confirmation alert telling the user which question is going to be added.
	 */
	
	@FXML
	private void submitQuestion(ActionEvent event) throws IOException {
		Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
		selected.setText(qText.getText());
		selected.setDiff(diffBox.getValue());
//		selected.addAnswer(a1Text.getText());
//		selected.addAnswer(a2Text.getText());
//		selected.addAnswer(a3Text.getText());
//		selected.addAnswer(a4Text.getText());
		selected.setRightAnswer(rightAnswerBox.getValue());
		SysData.getInstance().addQuestion(selected);
		alert.setContentText(selected.toString());
		alert.setTitle("Adding new question");
		alert.setHeaderText("About to add a new question");
		alert.showAndWait();
		Parent pane = FXMLLoader.load(getClass().getResource("/views/QuestionsWizard.fxml"));
		Scene scene = new Scene(pane);
		Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
		stage.setScene(scene);
		stage.setTitle("Questions Wizard");
		stage.show();
		
	}

}
