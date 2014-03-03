package mz.com.cstock.controller;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import mz.com.cstock.facade.UserFacade;

public class LoginController implements Initializable {

	@FXML
	private Label labelMessage;
	@FXML
	private Label h1;
	@FXML
	private TextField fieldName;
	@FXML
	private PasswordField fieldPassword;

	@Override
	public void initialize(URL url, ResourceBundle resource) {
		initComponents();
	}

	public void loginUser() {

		if (fieldName.getText().trim().equals("")
				|| fieldPassword.getText().trim().equals("")) {
			labelMessage.setText("Preencha o nome e codigo ");
			return;
		}
		Image image = new Image(getClass().getResourceAsStream(
				"/resources/images/KEY_16x16-32.png"));
		try {

			labelMessage.setGraphic(new ImageView(image));
			UserFacade facade = new UserFacade();
			boolean what = facade.validateUser(fieldName.getText(),
					fieldPassword.getText());
			if (what) {
				Dimension size = Toolkit.getDefaultToolkit().getScreenSize();
				final Stage stage = new Stage();
				stage.setWidth(size.getWidth());
				stage.setTitle("cstock");
				Parent root;
				try {
					root = FXMLLoader.load(getClass().getResource(
							"../views/Main.fxml"));
					stage.setScene(new Scene(root));
					stage.show();
				} catch (IOException e) {

					e.printStackTrace();
				}
			} else {
				labelMessage.setText("Codigo ou nome errado!");
			}
		} catch (Exception e) {
			labelMessage.setText("Ocorreu um erro,contatar adm...");
		}

	}

	private void initComponents() {
		Image image = new Image(getClass().getResourceAsStream(
				"/resources/images/login.png"));
		h1.setText("");
		h1.setGraphic(new ImageView(image));
		h1.setContentDisplay(ContentDisplay.CENTER);

		fieldName.setTooltip(new Tooltip("O nome do usuário."));
		fieldPassword.setTooltip(new Tooltip("O código do usuário."));
	}

	public void cleanOnkeyEvent(KeyEvent event) {
		if (event.getCode().equals(KeyCode.ENTER)) {
			loginUser();
		}
	}

}
