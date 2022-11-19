package controller;

import controller.Main;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Main extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		AnchorPane root = FXMLLoader.load(Main.class.getResource("/Views/MainMenu.fxml"));
		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.setMaximized(true);
		primaryStage.setTitle("MainScreen");
		primaryStage.show();
		
	}
	public static void main(String[] args) {
		launch(args);
		
		
	}

}
