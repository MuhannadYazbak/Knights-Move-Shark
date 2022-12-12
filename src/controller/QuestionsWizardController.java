package controller;

import java.io.IOException;
import java.net.URL;
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
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import model.Question;
import model.SysData;
import utils.Difficulty;

public class QuestionsWizardController implements Initializable {

	private ObservableList<Question> questions = FXCollections.observableArrayList();

	@FXML
	private Button backBtn, AddNewQuestionBtn, editQuestionBtn, deleteQuestionBtn;
	@FXML
	private TableView<Question> qTable;
	@FXML
	public TableColumn<Question, String> questionText;
	@FXML
	public TableColumn<Question, Difficulty> level;

	@FXML
	private void back(ActionEvent event) throws IOException {
		Parent pane = FXMLLoader.load(getClass().getResource("/application/MainMenu.fxml"));
		Scene scene = new Scene(pane);
		Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		stage.setScene(scene);
		stage.setTitle("Main Menu");
		stage.show();
	}

	@FXML
	private void addQuestion(ActionEvent event) throws IOException {
		SysData.getInstance().setSelectedQ(new Question("",null,"","","","",0,""));
		Parent pane = FXMLLoader.load(getClass().getResource("/application/AddQuestion.fxml"));
		Scene scene = new Scene(pane);
		Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		stage.setScene(scene);
		stage.setTitle("Add New Question");
		stage.show();
	}

	@FXML
	void updateQuestion(ActionEvent event) throws IOException {
		Parent pane = FXMLLoader.load(getClass().getResource("/views/AddQuestion.fxml"));
		Scene scene = new Scene(pane);
		Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		stage.setScene(scene);
		stage.setTitle("Add New Question");
		stage.show();
	}
	/*
	 * Initializes the view, reading the questions from the Json file and loading it
	 * into the tableview.
	 */

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		questions.addAll(SysData.getInstance().getQuestions().values());
		questionText.setCellValueFactory(new PropertyValueFactory<>("QuestionText"));
		level.setCellValueFactory(new PropertyValueFactory<>("Level"));
		qTable.setItems(questions);

	}
	
	@FXML
	private void selectQuestion(MouseEvent event) throws IOException {
		SysData.getInstance().setSelectedQ(qTable.getSelectionModel().getSelectedItem());
	}
	

	@FXML
	private void deleteQuestion(ActionEvent event)throws IOException {
		SysData.getInstance().removeQuestion(SysData.getInstance().getSelectedQ());
		questions.removeAll();
		Parent pane = FXMLLoader.load(getClass().getResource("/views/QuestionsWizard.fxml"));
		Scene scene = new Scene(pane);
		Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		stage.setScene(scene);
		stage.setTitle("Questions Wizard");
		stage.show();
	}

}