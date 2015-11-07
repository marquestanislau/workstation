package mz.co.sisgf.controller;

import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.ResourceBundle;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import mz.co.sisgf.model.Accao;
import mz.co.sisgf.model.Banco;
import mz.co.sisgf.model.Tipo;
import mz.co.sisgf.model.dao.SimpleEntityManager;
import mz.co.sisgf.service.BancoService;
import mz.co.sisgf.util.FXUtil;

public class FormController implements Initializable {

	@FXML
	private ComboBox<Banco> comboBanco;
	@FXML
	private ComboBox<Tipo> comboOptions;
	@FXML
	private TextField fieldValor;
	@FXML
	private DatePicker fieldData;
	@FXML
	private TextArea areaDesc;
	@FXML
	private Label labelMensagemForm;
	
	@FXML
	private Button btnSalvar;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		fillComboBox();
		fillComboOptions();
		initIcons();
		labelMensagemForm.setVisible(false);
	}

	private void fillComboBox() {
		try {
			SimpleEntityManager simpleEntityManager = new SimpleEntityManager("gestaoPU");
			BancoService bs = new BancoService(simpleEntityManager);
			simpleEntityManager.beginTransaction();

			comboBanco.getItems().addAll(FXCollections.observableArrayList(bs.todos()));

			simpleEntityManager.close();

		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	private void fillComboOptions() {
		try {
			comboOptions.getItems().addAll(Tipo.values());
		} catch (Exception e) {
			labelMensagemForm.setText("Erro ao carregar dados da base de dados!");
		}
	}

	@FXML
	private void registoTransacao() {
		if (isAllGood()) {
			Banco banco;
			try {
				LocalDate ld = fieldData.getValue();
				Calendar day = Calendar.getInstance();
				day.set(ld.getYear(), ld.getMonthValue() - 1, ld.getDayOfMonth());
				banco = comboBanco.getSelectionModel().getSelectedItem();
				Accao accao = newAccao(Double.parseDouble(fieldValor.getText().trim()), areaDesc.getText().toString(),
						comboOptions.getSelectionModel().getSelectedItem(), day);
				accao.setBanco(banco);
				EntityManagerFactory emf = Persistence.createEntityManagerFactory("gestaoPU");
				EntityManager em = emf.createEntityManager();
				em.getTransaction().begin();

				em.persist(accao);
				em.merge(banco);

				em.getTransaction().commit();
				em.close();
				emf.close();

				clearFieds();
				
				labelMensagemForm.setText("Dados guardados com exito!");
				labelMensagemForm.setVisible(true);
				FXUtil.transitionEffect(labelMensagemForm, 7000.0);

			} catch (NumberFormatException e) {
				labelMensagemForm.setVisible(true);
				labelMensagemForm.setText("***Digite um valor valido!");
				FXUtil.transitionEffect(labelMensagemForm, 7000);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	private boolean isAllGood() {
		labelMensagemForm.setVisible(true);
		if (fieldValor.getText().trim().isEmpty()) {
			labelMensagemForm.setText("**Preencha o campo valor\n");
			FXUtil.transitionEffect(labelMensagemForm, 7000);
			return false;
		} else if (areaDesc.getText().trim().isEmpty()) {
			labelMensagemForm.setText("**Preencha a descricao da transacao\n");
			FXUtil.transitionEffect(labelMensagemForm, 7000);
			return false;
		} else if (comboBanco.getSelectionModel().getSelectedIndex() < 0) {
			labelMensagemForm.setText("**Selecione um banco\n");
			FXUtil.transitionEffect(labelMensagemForm, 7000);
			return false;
		} else if (comboOptions.getSelectionModel().getSelectedItem() == null) {
			labelMensagemForm.setText("**Selecione o tipo de transação\n");
			FXUtil.transitionEffect(labelMensagemForm, 7000);
			return false;
		}
		return true;
	}

	private Accao newAccao(Double valor, String desc, Tipo tipo, Calendar data) {
		Accao accao;
		accao = new Accao();
		accao.setDescricao(desc);
		accao.setReferencia("lalau");
		if (valor.isNaN() || valor < 1) {
			throw new NumberFormatException();
		} else {
			accao.setSaldo(valor);
		}
		accao.setTipo(tipo);
		accao.setData_accao(data);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		accao.setDataformatada(sdf.format(data.getTime()));
		return accao;
	}
		
	private void clearFieds() {
		fieldValor.setText("");
		areaDesc.setText("");
		comboBanco.getSelectionModel().clearSelection();
		comboOptions.getSelectionModel().clearSelection();
	}
	
	private void initIcons() {
		Image salvar = new Image(getClass().getResourceAsStream("../view/img/check.png"));
		btnSalvar.setGraphic(new ImageView(salvar));
	}
}