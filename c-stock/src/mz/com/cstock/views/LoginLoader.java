package mz.com.cstock.views;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class LoginLoader extends Application {

	public static void main(String[] args) {
		Application.launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		stage.setTitle("cstock:Login");
//		Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));
		Parent root = FXMLLoader.load(getClass().getResource("Main.fxml"));
		stage.setScene(new Scene(root));
		stage.show();		
	}
}
