package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class SplashController implements Initializable{

	
    @FXML
    private AnchorPane screen;
    
    @FXML
	private Parent parent;
    
    @Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
    	new Thread() {
			@Override
			public void run() {
				try {
					Thread.sleep(1000);
				}
				catch(Exception e){
					System.out.print(e);
				}
				
				Platform.runLater(new Runnable() {
					@Override
					public void run() {
						try {
							parent = FXMLLoader.load(getClass().getResource("/views/MainMenu.fxml"));
							Stage stage = new Stage();
							Scene scene = new Scene(parent);
							stage.setScene(scene);
							stage.show();
							screen.getScene().getWindow().hide();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				});
			}
		}.start();
	}
}

