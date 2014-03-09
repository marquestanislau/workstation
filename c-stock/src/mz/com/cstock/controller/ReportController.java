package mz.com.cstock.controller;

import java.net.URL;
import java.util.Calendar;
import java.util.List;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import mz.com.cstock.dao.ProductDAO;
import mz.com.cstock.model.Product;

public class ReportController implements Initializable {

	@FXML
	private BarChart<String, Number> barChart;
	@FXML
	private ChoiceBox<String> meses;
	@FXML
	private Button buttonExibir;
	@FXML
	private Label labelError;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		fullFillBarChart();
		initChoiceBox();
	}

	XYChart.Series<String, Number> serie1 = new XYChart.Series<String, Number>();

	@SuppressWarnings("unchecked")
	@FXML
	private void fullFillBarChart() {

		ProductDAO dao = new ProductDAO();
		for (Product product : dao.findAll()) {
			serie1.setName("Vendas totais");
			serie1.getData().add(
					new XYChart.Data<String, Number>(product.getName(), product
							.getQuantity()));
		}
		barChart.getData().addAll(serie1);
	}

	private void initChoiceBox() {
		meses.getItems().clear();
		meses.getItems().addAll("Janeiro", "Fevereiro", "Março", "Abril",
				"Junho", "Julho", "Agosto", "Setembro", "Outubro", "Novembro",
				"Dezembro");
		meses.setPrefHeight(0.99);
		meses.setMaxHeight(0.99);
	}

	@FXML
	private void selectMonth() {
		// TODO Auto-generated method stub
		String mes = meses.getSelectionModel().getSelectedItem();
		if (mes.isEmpty() || mes == null) {
			return;
		}
		if (mes.equals("Janeiro")) {
			fillOnlyMonth(Calendar.JANUARY, "Janeiro");
			return;
		}
		if (mes.equals("Fevereiro")) {
			fillOnlyMonth(Calendar.FEBRUARY, "Fevereiro");
			return;
		}
		if (mes.equals("Março")) {
			fillOnlyMonth(Calendar.MARCH, "Março");
			return;
		}
		if (mes.equals("Abril")) {
			fillOnlyMonth(Calendar.APRIL, "Abril");
			return;
		}
		if (mes.equals("Maio")) {
			fillOnlyMonth(Calendar.MAY, "Maio");
			return;
		}
		if (mes.equals("Junho")) {
			fillOnlyMonth(Calendar.JUNE, "Junho");
			return;
		}
		if (mes.equals("Julho")) {
			fillOnlyMonth(Calendar.JULY, "Julho");
			return;
		}
		if (mes.equals("Agosto")) {
			fillOnlyMonth(Calendar.AUGUST, "Agosto");
			return;
		}
		if (mes.equals("Setembro")) {
			fillOnlyMonth(Calendar.SEPTEMBER, "Setembro");
			return;
		}
		if (mes.equals("Outubro")) {
			fillOnlyMonth(Calendar.OCTOBER, "Outubro");
			return;
		}
		if (mes.equals("Novembro")) {
			fillOnlyMonth(Calendar.NOVEMBER, "Novembro");
			return;
		}
		if (mes.equals("Dezembro")) {
			fillOnlyMonth(Calendar.DECEMBER, "Dezembro");
			return;
		}
	}

	@SuppressWarnings("unchecked")
	private void fillOnlyMonth(int month, String mes) {
		// TODO Auto-generated method stub
		XYChart.Series<String, Number> serie1 = new XYChart.Series<String, Number>();
		serie1.setName(mes);
		barChart.getData().removeAll(this.serie1);
		ProductDAO dao = new ProductDAO();
		List<Product> products = dao.findAll();
		boolean exists = false;
		labelError.setText("");
		for (Product product : products) {
			if (product.getDateRegistered().get(Calendar.MONTH) == month) {
				serie1.getData().add(
						new XYChart.Data<String, Number>(product.getName(),
								product.getQuantity()));
				exists = true;
			}
		}
		if(!exists) {
			labelError.setText("Graficos nao disponiveis.");
		}
		barChart.getData().setAll(serie1);
	}
}
