package mz.com.cstock.controller;

import java.net.URL;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.effect.Glow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import mz.com.cstock.dao.CompraDAO;
import mz.com.cstock.dao.ProductDAO;
import mz.com.cstock.model.Compra;
import mz.com.cstock.model.Product;

public class VendasController implements Initializable {

	private static final String imagesPath = "/resources/images/";
	@FXML
	private TableView<Compra> tableCompra;
	@FXML
	private TableColumn<Compra, String> colCompraNome;
	@FXML
	private TableColumn<Compra, String> colCompraQdt;

	@FXML
	private ListView<Product> list;

	@FXML
	private Label labelErrorSell;
	@FXML
	private Label labelHeader;
	@FXML
	private Button buttonVendaAdd;
	@FXML
	private Button buttonVender;
	@FXML
	private Button buttonCompraRemove;
	@FXML
	private Button buttonClose;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		populateTableCompra();
		initLIst();
		initLabels();
		initButtons();
	}

	private void initLabels() {
		labelHeader.setEffect(new Glow(0.5));
		labelErrorSell.setText("");
	}

	@SuppressWarnings("unchecked")
	private void populateTableCompra() {
		CompraDAO dao = new CompraDAO();
		List<Compra> compras = dao.findAll();
		List<Compra> comprasActual = new ArrayList<Compra>();

		for (Compra compra : compras) {

			if (compra.getDate().compareTo(Calendar.getInstance()) != 0) {
				comprasActual.add(compra);
			}

		}
		tableCompra.setItems(FXCollections.observableList(comprasActual));
		colCompraNome
				.setCellValueFactory(new PropertyValueFactory<Compra, String>(
						"name"));
		colCompraQdt
				.setCellValueFactory(new PropertyValueFactory<Compra, String>(
						"qtd"));
		tableCompra.getColumns().setAll(colCompraNome, colCompraQdt);
	}

	public void fromListToTable(ActionEvent event) {

		Product product = (Product) list.getSelectionModel().getSelectedItem();
		if (product != null) {
			Compra compra = new Compra();
			CompraDAO dao = new CompraDAO();
			compra.setDate(Calendar.getInstance());
			compra.setName(product.getName());
			compra.setQtd(product.getQuantity());

			dao.save(compra);
			dao.commitAndCloseTransaction();

			populateTableCompra();
			labelErrorSell.setText("");
		} else {
			labelErrorSell.setText("Selecione da lista para a tabela.");
		}

	}

	public void deleteFromTableCompra(ActionEvent event) {
		Compra compra = tableCompra.getSelectionModel().getSelectedItem();
		CompraDAO dao = new CompraDAO();
		dao.delete(compra.getId(), Compra.class);
		dao.commitAndCloseTransaction();
		populateTableCompra();
	}

	private void initButtons() {
		buttonVendaAdd.setGraphic(new ImageView(new Image(getClass()
				.getResourceAsStream(imagesPath + "Forward.png"))));
		buttonCompraRemove.setGraphic(new ImageView(new Image(getClass()
				.getResourceAsStream(imagesPath + "Backward.png"))));
		buttonVender.setGraphic(new ImageView(new Image(getClass()
				.getResourceAsStream(imagesPath + "Go.png"))));
	}

	private void initLIst() {
		ProductDAO dao = new ProductDAO();
		list.getItems().setAll(FXCollections.observableList(dao.findAll()));
	}

	@FXML
	private void closeWindow(ActionEvent event) {
		Node source = (Node) event.getSource();
		Stage stage = (Stage) source.getScene().getWindow();
		stage.close();
	}

	@FXML
	private void sell(ActionEvent event) {
		ObservableList<Compra> compras = tableCompra.getItems();
		int totalQuantity = 0;
		DecimalFormat df = new DecimalFormat();
		if (compras.isEmpty()) {
			labelErrorSell.setText("Adicione itens para venda...");
			return;
		}
		for (Compra compra : compras) {
			totalQuantity += compra.getQtd();
		}
		labelErrorSell.setText(df.format(totalQuantity) + "");
	}
}
