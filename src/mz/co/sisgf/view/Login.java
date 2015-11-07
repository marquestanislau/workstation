package mz.co.sisgf.view;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import mz.co.sisgf.model.dao.SimpleEntityManager;
import mz.co.sisgf.service.UtilizadorService;

public class Login extends Application {

	@Override
	public void start(Stage stage) throws Exception {
		try {
			if (checkUsers()) {
				LoginController loginController = new LoginController();
				loginController.callWindow("Admin.fxml");
			} else {
				AnchorPane root = (AnchorPane) FXMLLoader.load(getClass().getResource("Login.fxml"));
				double width = root.getPrefWidth();
				double height = root.getPrefHeight();
				Scene scene = new Scene(root, width, height);
				stage.initStyle(StageStyle.UNDECORATED);
				stage.getIcons().add(new Image(getClass().getResourceAsStream("img/frameIcon.png")));
				stage.setScene(scene);
				stage.show();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private boolean checkUsers() {
		SimpleEntityManager simpleEntityManager = new SimpleEntityManager("gestaoPU");
		UtilizadorService utilizadorService = new UtilizadorService(simpleEntityManager);

		simpleEntityManager.beginTransaction();

		if (utilizadorService.todos().isEmpty()){
			simpleEntityManager.close();
			return true;
		}

		simpleEntityManager.close();
		return false;
	}

	public static void main(String[] args) {
		Application.launch(args);
	}

}