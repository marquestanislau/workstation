package mz.co.sisgf.view;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.net.URL;
import java.util.Iterator;
import java.util.List;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import mz.co.sisgf.model.Utilizador;
import mz.co.sisgf.model.dao.SimpleEntityManager;
import mz.co.sisgf.report.CamposUtil;
import mz.co.sisgf.service.UtilizadorService;
import mz.co.sisgf.util.FXUtil;

public class LoginController implements Initializable {

	@FXML
	private Button close;
	@FXML
	private Label labelMessage;
	@FXML
	private TextField fieldSenha;
	@FXML
	private TextField fieldNome;
	@FXML
	private Button btnLogin;

	private List<Utilizador> utilizadores;

	@Override
	public void initialize(URL url, ResourceBundle resourceBundle) {
		Image image = new Image(getClass().getResourceAsStream("img/window-close.png"));
		close.setGraphic(new ImageView(image));

		labelMessage.setVisible(false);
	}

	@FXML
	private void close(ActionEvent event) {
		Node source = (Node) event.getSource();
		Stage stage = (Stage) source.getScene().getWindow();
		stage.close();
	}

	@FXML
	private void login(ActionEvent actionEvent) {
		if (!fieldNome.getText().trim().isEmpty() || !fieldSenha.getText().trim().isEmpty()) {
			if (fieldNome.getText().trim().equals("Admin") && fieldSenha.getText().trim().equals("admin")
					|| verificarExistencia(fieldNome.getText().trim(), fieldSenha.getText().trim())) {
				CamposUtil.userName = fieldNome.getText();
				callWindow("Main.fxml");
				closeWindow(actionEvent);
			} else {
				labelMessage.setText("Nome/Senha Invalidos!");
				FXUtil.transitionEffect(labelMessage, 4000);
				labelMessage.setVisible(true);
			}
		} else {
			labelMessage.setText("Preencha todos campos!");
			FXUtil.transitionEffect(labelMessage, 4000);
			labelMessage.setVisible(true);
		}
	}

	private boolean verificarExistencia(String nome, String passwd) {
		iniciarLista();
		Utilizador u = null;
		Iterator<Utilizador> it = utilizadores.iterator();

		while (it.hasNext()) {
			u = it.next();
			if (u.getNome().equals(nome) && u.getPassword().equals(passwd))
				return true;
		}
		return false;
	}

	private void iniciarLista() {

		try {
			SimpleEntityManager simpleEntityManager = new SimpleEntityManager("gestaoPU");
			UtilizadorService utilizadorService = new UtilizadorService(simpleEntityManager);

			simpleEntityManager.beginTransaction();

			this.utilizadores = utilizadorService.todos();

			simpleEntityManager.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void callWindow(String fxml) {
		try {
			Stage primaryStage = new Stage();
			AnchorPane root = (AnchorPane) FXMLLoader.load(getClass().getResource(fxml));
			Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
			double width = screenSize.getWidth();
			double heiht = screenSize.getHeight();
			Scene scene = new Scene(root, (width * 0.8), (heiht * 0.7));
			primaryStage.getIcons().add(new Image(getClass().getResourceAsStream("img/frameIcon.png")));
			primaryStage.setScene(scene);
			FXUtil.transitionEffectIn(root, 1000);
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void closeWindow(ActionEvent actionEvent) {
		Node source = (Node) actionEvent.getSource();
		Stage stage = (Stage) source.getScene().getWindow();
		stage.close();
	}
}