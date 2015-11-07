package mz.co.sisgf.controller;

import java.net.URL;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.ResourceBundle;

import javax.persistence.Query;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.Tooltip;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.util.Callback;
import mz.co.sisgf.model.Accao;
import mz.co.sisgf.model.Banco;
import mz.co.sisgf.model.Tipo;
import mz.co.sisgf.model.dao.SimpleEntityManager;
import mz.co.sisgf.report.ReportUtil;
import mz.co.sisgf.service.AccaoService;
import mz.co.sisgf.service.BancoService;
import mz.co.sisgf.util.FXUtil;

public class TableViewController implements Initializable {

	@FXML
	private TableView<Accao> tableView;
	@FXML
	private TableColumn<Accao, Calendar> data;
	@FXML
	private TableColumn<Accao, Tipo> debito;
	@FXML
	private TableColumn<Accao, Double> saldo;
	@FXML
	private TableColumn<Accao, String> descricao;
	@FXML
	private ComboBox<Banco> comboBancos;

	private List<Accao> accoes;

	@FXML
	private Label labelSaldoInicial;
	@FXML
	private Label labelSaldoContabilistico;
	@FXML
	private Label labelMensagem;
	@FXML
	private GridPane gridPane;

	@FXML
	private Button btnImprimir;
	@FXML
	private Button btnRemover;

	@FXML
	private DatePicker dataInicioPicker;
	@FXML
	private DatePicker dataFimPicker;

	@SuppressWarnings("unchecked")
	@FXML
	private void initTable() {
		SimpleEntityManager simpleEntityManager = new SimpleEntityManager("gestaoPU");
		simpleEntityManager.beginTransaction();
		// AccaoService accaoService = new AccaoService(simpleEntityManager);
		tableView.setVisible(false);

		if (comboBancos.getSelectionModel().getSelectedItem() != null) {

			Query query = simpleEntityManager.getEntityManager().createNamedQuery("Accao.findByBank");
			query.setParameter("banco_id", comboBancos.getSelectionModel().getSelectedItem().getId());
			accoes = query.getResultList();
			// accoes = accaoService.todos();

			displayDetailData(accoes, comboBancos.getSelectionModel().getSelectedItem());

			tableView.setItems(FXCollections.observableArrayList(accoes));

			saldo.setCellValueFactory(new PropertyValueFactory<Accao, Double>("saldo"));
			saldo.setCellFactory(new Callback<TableColumn<Accao, Double>, TableCell<Accao, Double>>() {

				@Override
				public TableCell<Accao, Double> call(TableColumn<Accao, Double> param) {
					return new TableCell<Accao, Double>() {
						@Override
						protected void updateItem(Double item, boolean empty) {
							super.updateItem(item, empty);
							if (!empty) {
								DecimalFormat df = new DecimalFormat("#,##0.00");
								setText(df.format(item));
							}
						}
					};
				}

			});
			descricao.setCellValueFactory(new PropertyValueFactory<Accao, String>("descricao"));
			data.setCellValueFactory(new PropertyValueFactory<Accao, Calendar>("data_accao"));
			data.setCellFactory(new Callback<TableColumn<Accao, Calendar>, TableCell<Accao, Calendar>>() {

				@Override
				public TableCell<Accao, Calendar> call(TableColumn<Accao, Calendar> value) {
					return new TableCell<Accao, Calendar>() {
						@Override
						protected void updateItem(Calendar item, boolean empty) {
							super.updateItem(item, empty);
							if (!empty) {
								SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-YYYY");
								setText(sdf.format(item.getTime()));
								setTextFill(Color.BLUE);
							}
						}
					};
				}
			});
			debito.setCellValueFactory(new PropertyValueFactory<Accao, Tipo>("tipo"));
			debito.setCellFactory(new Callback<TableColumn<Accao, Tipo>, TableCell<Accao, Tipo>>() {

				@Override
				public TableCell<Accao, Tipo> call(TableColumn<Accao, Tipo> arg0) {
					return new TableCell<Accao, Tipo>() {
						@Override
						protected void updateItem(Tipo tipo, boolean empty) {
							super.updateItem(tipo, empty);
							if (!empty) {
								setText(tipo.getLabel());
								switch (tipo) {
								case LEVANTAMENTO:
									setTextFill(Color.GREEN);
									break;
								case TRANSFERENCIA_EFECTUADA:
									setTextFill(Color.GREEN);
									break;
								case DEPOSITO:
									setTextFill(Color.BLUE);
									break;
								case TRANSFERENCIA_RECEBIDA:
									setTextFill(Color.BLUE);
									break;

								default:
									break;
								}
							}
						}
					};
				}
			});
			tableView.getColumns().setAll(data, descricao, debito, saldo);
		}
		simpleEntityManager.close();
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		populateCombo();
		initTable();
		initImageButtons();
		labelMensagem.setVisible(false);
		gridPane.setVisible(false);
	}

	private void populateCombo() {
		SimpleEntityManager simpleEntityManager = new SimpleEntityManager("gestaoPU");
		simpleEntityManager.beginTransaction();
		BancoService bancoService = new BancoService(simpleEntityManager);

		comboBancos.getItems().addAll(FXCollections.observableArrayList(bancoService.todos()));
		simpleEntityManager.close();
	}

	@FXML
	private void selecionarBanco() {
		initTable();
		tableView.setVisible(true);
		FXUtil.transitionEffectIn(tableView, 300);
	}

	private void displayDetailData(List<Accao> accoes, Banco b) {
		DecimalFormat df = new DecimalFormat("#,##0.00");
		String myNumber = df.format(b.getSaldoInicial());
		labelSaldoInicial.setText(myNumber + " Meticais");
		labelSaldoInicial.setStyle(" -fx-font-weight: bold;");
		Double total = new Double(b.getSaldoInicial());
		for (Accao a : accoes) {

			switch (a.getTipo()) {
			case TRANSFERENCIA_EFECTUADA:
				total -= a.getSaldo();
				break;
			case DEPOSITO:
				total += a.getSaldo();
				break;
			case LEVANTAMENTO:
				total -= a.getSaldo();
				break;
			case TRANSFERENCIA_RECEBIDA:
				total += a.getSaldo();
				break;
			default:
				break;
			}
		}
		labelSaldoContabilistico.setStyle(" -fx-font-weight: bold;");
		labelSaldoContabilistico.setText(df.format(total) + " Meticais");
		gridPane.setVisible(true);
		FXUtil.transitionEffectIn(gridPane, 2000);
	}

	private void initImageButtons() {
		Image printer = new Image(getClass().getResourceAsStream("../view/img/printer.png"));
		Image delete = new Image(getClass().getResourceAsStream("../view/img/delete.png"));
		btnImprimir.setGraphic(new ImageView(printer));
		btnImprimir.setTooltip(new Tooltip("Imprimir relatorios do banco."));
		btnRemover.setGraphic(new ImageView(delete));
	}

	@FXML
	private void apagar() {
		SimpleEntityManager simpleEntityManager = new SimpleEntityManager("gestaoPU");
		AccaoService accaoService = new AccaoService(simpleEntityManager);
		Accao accao = tableView.getSelectionModel().getSelectedItem();

		if (accao != null) {
			System.out.println("Deu para passar: " + accao.getSaldo());
			accaoService.apagar(accao);
			accoes.remove(accao);
			initTable();
			tableView.setVisible(true);
			labelMensagem.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("../view/img/check.png"))));
			FXUtil.showMessageText("Dados removidos", labelMensagem);
		} else {
			labelMensagem.setGraphic(
					new ImageView(new Image(getClass().getResourceAsStream("../view/img/window-close.png"))));
			FXUtil.showMessageText("Seleccione dados na tabela.", labelMensagem);
		}
		simpleEntityManager.close();
	}

	@FXML
	private void printReport(ActionEvent actionEvent) {
		ReportUtil reportUtil = new ReportUtil();
		Banco b = comboBancos.getSelectionModel().getSelectedItem();

		if (b != null) {
			if (dataInicioPicker.getValue() != null && dataFimPicker.getValue() != null) {
				reportUtil.createReport("extracto_param.jasper", b, dataInicioPicker, dataFimPicker);
			} else {
				reportUtil.createReport("extracto.jasper", b);
			}
		} else {
			FXUtil.showMessageText("Selecione um banco primeiro!", labelMensagem);

		}
	}
}