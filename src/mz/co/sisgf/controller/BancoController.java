package mz.co.sisgf.controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import mz.co.sisgf.model.Banco;
import mz.co.sisgf.model.dao.SimpleEntityManager;
import mz.co.sisgf.service.BancoService;
import mz.co.sisgf.util.FXUtil;

public class BancoController implements Initializable {

	@FXML
	private Label labelMensagem;
	@FXML
	private TextField nome;
	@FXML
	private TextField numero_conta;
	@FXML
	private TextField fieldSaldoInicial;
	@FXML
	private TextArea descricao;
	@FXML
	private Button btnSalvar;

	@FXML
	private Button btnRemover;

	@FXML
	private ListView<Banco> listView;

	@FXML
	private void salvar(ActionEvent event) {

		String stringNome = nome.getText().trim();
		String desc = descricao.getText().trim();
		String numString = numero_conta.getText().trim();
		String saldoString = fieldSaldoInicial.getText().trim();

		if (stringNome.isEmpty()) {
			labelMensagem.setText("Preencha o campo nome");
			labelMensagem.setVisible(true);
			FXUtil.transitionEffect(labelMensagem, 7000.0);
			return;
		}
		if (saldoString.isEmpty()) {
			labelMensagem.setText("Preencha o campo saldo inicial");
			labelMensagem.setVisible(true);
			FXUtil.transitionEffect(labelMensagem, 7000.0);
			return;
		}
		if (!stringNome.isEmpty() || !saldoString.isEmpty()) {
			try {

				Long num = Long.parseLong(numString);
				Double saldoInicial = Double.parseDouble(saldoString);
				if (saldoInicial < 1) {
					labelMensagem.setText("Saldo inicial invalido.");
					labelMensagem.setVisible(true);
					FXUtil.transitionEffect(labelMensagem, 7000.0);
					return;
				}
				newBanco(stringNome, num, desc, saldoInicial);
				listView.getItems().clear();
				initListView();
				labelMensagem.setText("Salvou com exito!!");
				labelMensagem.setVisible(true);
				FXUtil.transitionEffect(labelMensagem, 7000.0);
				cleanFields();

			} catch (NumberFormatException e) {
				labelMensagem.setText("Digite apenas numeros nos campos Numero e Saldo. Ex: 123456");
				labelMensagem.setVisible(true);
				FXUtil.transitionEffect(labelMensagem, 7000.0);
			}
		}

	}

	private void newBanco(String nome, Long nc, String d, Double saldoInicial) {
		SimpleEntityManager simpleEntityManager = new SimpleEntityManager("gestaoPU");
		BancoService bs = new BancoService(simpleEntityManager);

		Banco b = new Banco();
		b.setDescricao(d);
		b.setNome(nome);
		b.setNumero_conta(nc);
		b.setSaldoInicial(saldoInicial);

		bs.salvar(b);

		simpleEntityManager.close();
	}

	private void cleanFields() {
		nome.setText("");
		numero_conta.setText("");
		descricao.setText("");
		fieldSaldoInicial.setText("");
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		labelMensagem.setVisible(false);
		initIcons();
		initListView();
	}

	private void initListView() {
		SimpleEntityManager simpleEntityManager = new SimpleEntityManager("gestaoPU");
		BancoService bs = new BancoService(simpleEntityManager);
		listView.getItems().addAll(FXCollections.observableArrayList(bs.todos()));
		simpleEntityManager.close();
	}

	private void initIcons() {
		Image salvar = new Image(getClass().getResourceAsStream("../view/img/check.png"));
		Image remover = new Image(getClass().getResourceAsStream("../view/img/delete.png"));
		btnSalvar.setGraphic(new ImageView(salvar));
		btnRemover.setGraphic(new ImageView(remover));
		btnRemover.setTooltip(new Tooltip("Selecione na lista um Banco para remover"));
	}

	@FXML
	private void apagar(ActionEvent actionEvent) {
		SimpleEntityManager simpleEntityManager = new SimpleEntityManager("gestaoPU");
		BancoService service = new BancoService(simpleEntityManager);
		
		Banco b = listView.getSelectionModel().getSelectedItem();

		if (b != null) {
			service.apagar(b);
			listView.getItems().clear();
			initListView();
			labelMensagem.setText("**Banco removido com exito!");
			labelMensagem.setVisible(true);
			FXUtil.transitionEffect(labelMensagem, 7000);
		} else {
			labelMensagem.setText("**Selecione um banco na lista!");
			labelMensagem.setVisible(true);
			FXUtil.transitionEffect(labelMensagem, 7000);
		}

		simpleEntityManager.close();
	}
}