package mz.co.sisgf.controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import mz.co.sisgf.model.Utilizador;
import mz.co.sisgf.model.dao.SimpleEntityManager;
import mz.co.sisgf.report.CamposUtil;
import mz.co.sisgf.service.UtilizadorService;
import mz.co.sisgf.util.FXUtil;
import mz.co.sisgf.view.LoginController;

public class UtilizadorController implements Initializable {

	@FXML
	private Label labelMensagem;
	@FXML
	private Label icon;
	
	@FXML
	private TextField fieldNome;
	@FXML
	private TextField fieldEmail;
	@FXML
	private TextField fieldSenha;
	@FXML
	private TextField fieldSenha_;
	
	@FXML
	private Button btnSalvar;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		labelMensagem.setVisible(false);
		initIcons();
	}
	
	private boolean validate(TextField... fields) {
		for(TextField tf: fields) {
			if(!tf.getText().trim().isEmpty()){
				return true;
			}
		}
		return false;
	}
	
	private boolean comparePasswords() {
		if(fieldSenha.getText().trim().equals(fieldSenha_.getText().trim()))
			return true;
		return false;
	}
	
	@FXML
	private void salvarUtilizador(ActionEvent event) {
		if (validate(fieldEmail, fieldNome, fieldSenha, fieldSenha_)) {
			if(comparePasswords()) {
				SimpleEntityManager simpleEntityManager = new SimpleEntityManager("gestaoPU");
				UtilizadorService utilizadorService = new UtilizadorService(simpleEntityManager);
				
				Utilizador utilizador = new Utilizador();
				utilizador.setEmail(fieldEmail.getText().trim());
				utilizador.setNome(fieldNome.getText().trim());
				utilizador.setPassword(fieldSenha.getText().trim());
				
				utilizadorService.salvar(utilizador);
				
				simpleEntityManager.close();
				
				CamposUtil.userName = fieldNome.getText().trim();
				
				try {
					LoginController loginController = new LoginController();
					loginController.callWindow("Main.fxml");
					loginController.closeWindow(event);
				} catch (Exception e) {
					e.printStackTrace();
				}
				
			} else {
				showMessage("Senhas são diferentes!");
			}
		} else {
			showMessage("Preencha todos campos!");
		}
	}
	
	private void showMessage(String message) {
		labelMensagem.setText(message);
		labelMensagem.setVisible(true);
		FXUtil.transitionEffect(labelMensagem, 7000);
	}

	private void initIcons() {
		Image imageIcon = new Image(getClass().getResourceAsStream("../view/img/account.png"));
		icon.setGraphic(new ImageView(imageIcon));
	}
}
