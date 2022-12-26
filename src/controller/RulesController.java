package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class RulesController implements Initializable{

    @FXML
    private Button backBtn;

    @FXML
    private TextArea rulesArea;

    @FXML
    private AnchorPane screen;

    @FXML
    void back(ActionEvent event) throws IOException {
    	Parent pane = FXMLLoader.load(getClass().getResource("/views/MainMenu.fxml"));
		Scene scene = new Scene(pane);
		Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
		stage.setScene(scene);
		stage.setResizable(false);
		stage.setTitle("Main Menu");
		stage.show();
    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}

}
