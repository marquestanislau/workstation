package mz.com.cstock.views;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class LoginLoader extends Application {

	public static void main(String[] args) {
		Application.launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		stage.setTitle("cstock:Login");
//		Dimension width = Toolkit.getDefaultToolkit().getScreenSize();
//		Dimension height = Toolkit.getDefaultToolkit().getScreenSize();
//		stage.setWidth(width.getWidth()/6 + width.getWidth()/2);
//		stage.setHeight(height.getHeight()/6 + (height.getHeight() /2));
//		Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));
		Parent root = FXMLLoader.load(getClass().getResource("Main.fxml"));
//		Parent root = FXMLLoader.load(getClass().getResource("Usuarios.fxml"));
//		Parent root = FXMLLoader.load(getClass().getResource("Fornecedores.fxml"));
//		Parent root = FXMLLoader.load(getClass().getResource("Relatorios.fxml"));
//		Parent root = FXMLLoader.load(getClass().getResource("Vendas.fxml"));
		stage.setScene(new Scene(root));
		stage.getIcons().add(new Image(getClass().getResourceAsStream("/resources/images/basecircle.png")));
		stage.show();		
	}
}
