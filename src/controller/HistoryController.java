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
import javafx.stage.Stage;
import model.Player;
import model.SysData;

public class HistoryController implements Initializable {
	
	private ObservableList<Player> history = FXCollections.observableArrayList();
	@FXML
	private Button backBtn;
	
	@FXML
	private TableView<Player> hTable;
	
	@FXML
	public TableColumn<Player, String> name;
	
	@FXML
	public TableColumn<Player,Integer> score; 
	
	@FXML
	private void back(ActionEvent event) throws IOException {
		Parent pane = FXMLLoader.load(getClass().getResource("/views/MainMenu.fxml"));
		Scene scene = new Scene(pane);
		Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
		stage.setScene(scene);
		stage.setTitle("Main Menu");
		stage.show();
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		history.addAll(SysData.getInstance().getHistoryGamesForShow());
		name.setCellValueFactory(new PropertyValueFactory<>("Name"));
		score.setCellValueFactory(new PropertyValueFactory<>("Score"));
		hTable.setItems(history);
		
	}

}