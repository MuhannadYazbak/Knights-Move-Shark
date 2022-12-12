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
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import model.Question;
import model.SysData;
import utils.Difficulty;

public class AddQuestionController implements Initializable {
	private Question selected;                    // The question instance that we will fit the values from the view into.
	private Question onScreen;
	
	//private ObservableList<Integer> rightAnswer;
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
		if (SysData.getInstance().getSelectedQ() != null) {
			selected = SysData.getInstance().getSelectedQ();
			qText.setText(selected.getQuestionText());
			a1Text.setText(selected.getAnswer1());
			a2Text.setText(selected.getAnswer2());
			a3Text.setText(selected.getAnswer3());
			a4Text.setText(selected.getAnswer4());
			diffBox.setValue(selected.getLevel());
			rightAnswerBox.setValue(selected.getRightAnswer());
		}
		ObservableList<Difficulty> levels = FXCollections.observableArrayList();
		levels.addAll(Difficulty.EASY, Difficulty.MEDIUM, Difficulty.HARD);
		diffBox.setItems(levels);
		ObservableList<Integer> positions = FXCollections.observableArrayList();
		positions.addAll(1, 2, 3, 4);
		rightAnswerBox.setItems(positions);
		addQuestionBtn.setDisable(true);
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
		String original = selected.getQuestionText();
		// check if it is adding new question
		if (original.isBlank()) {
			SysData.getInstance().addQuestion(onScreen);
			Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
			alert.setContentText(onScreen.toString());
			alert.setTitle("Adding new question");
			alert.setHeaderText("About to add a new question");
			alert.showAndWait();
		}
		// updating an existing question
		else {
			SysData.getInstance().updateQuestion(SysData.getInstance().getQuestions().get(original), onScreen);
			Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
			alert.setContentText(onScreen.toString());
			alert.setTitle("Updating question");
			alert.setHeaderText("About to update an existing question");
			alert.showAndWait();
			
		}
	 Parent pane = FXMLLoader.load(getClass().getResource("/application/QuestionsWizard.fxml"));
		Scene scene = new Scene(pane);
		Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
		stage.setScene(scene);
		stage.setTitle("Questions Wizard");
		stage.show();
		
	}
	
	@FXML
	private void checkQuestion(KeyEvent event) throws IOException {
		// Verify that the user supplied all needed fields in order to add/update question
		onScreen = new Question(qText.getText(), diffBox.getValue(), a1Text.getText(), a2Text.getText(), a3Text.getText(), a4Text.getText(),rightAnswerBox.getValue(), "Shark" );
				if (!onScreen.getQuestionText().isBlank() && onScreen.getLevel() != null && !onScreen.getAnswer1().isBlank()
						&& !onScreen.getAnswer2().isBlank() && !onScreen.getAnswer3().isBlank() && !onScreen.getAnswer4().isBlank()
						&& onScreen.getRightAnswer() != 0)
						addQuestionBtn.setDisable(false);
	}

}