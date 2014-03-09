package mz.com.cstock.controller;

import java.net.URL;
import java.util.Calendar;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import mz.com.cstock.dao.ProductDAO;
import mz.com.cstock.dao.SupplierDAO;
import mz.com.cstock.messages.FieldVerify;
import mz.com.cstock.model.Product;
import mz.com.cstock.model.Supplier;

public class FornecedoresController implements Initializable {

	private static final String path = "/resources/images/";

	@FXML
	private Button buttonFw;
	@FXML
	private Button buttonRw;
	@FXML
	private Button buttonAdd;
	@FXML
	private Button buttonNew;
	@FXML
	private Button buttonUpdate;
	@FXML
	private Button buttonRemove;

	@FXML
	private TableColumn<Supplier, String> colId;
	@FXML
	private TableColumn<Supplier, String> colName;
	@FXML
	private TableColumn<Supplier, String> colContact;
	@FXML
	private TableColumn<Supplier, String> colAddress;
	@FXML
	private TableColumn<Supplier, String> colProduct;
	@FXML
	private TableColumn<Supplier, String> colEmail;
	@FXML
	private TableView<Supplier> tableView;

	@FXML
	private ListView<Product> listL;
	@FXML
	private ListView<Product> listR;

	@FXML
	private TextField fieldEmail;
	@FXML
	private TextField fieldCell;
	@FXML
	private TextField fieldAddress;
	@FXML
	private TextField fieldName;
	@FXML
	private TextField fieldEmailDel;
	@FXML
	private TextField fieldNameDel;

	@FXML
	private Label labelErrorDel;
	@FXML
	private Label labelErrorLists;
	@FXML
	private Label labelErrorName;
	@FXML
	private Label labelErrorCell;
	@FXML
	private Label labelErrorAddress;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		initButtons();
		populateTable();
	}

	private void initButtons() {
		buttonFw.setGraphic(new ImageView(new Image(getClass()
				.getResourceAsStream(path + "Forward.png"))));
		buttonRw.setGraphic(new ImageView(new Image(getClass()
				.getResourceAsStream(path + "Backward.png"))));
		buttonAdd.setGraphic(new ImageView(new Image(getClass()
				.getResourceAsStream(path + "add.png"))));
		buttonNew.setGraphic(new ImageView(new Image(getClass()
				.getResourceAsStream(path + "New.png"))));
		buttonUpdate.setGraphic(new ImageView(new Image(getClass()
				.getResourceAsStream(path + "refresh.png"))));
		buttonRemove.setGraphic(new ImageView(new Image(getClass()
				.getResourceAsStream(path + "delete.png"))));
	}

	@SuppressWarnings("unchecked")
	private void populateTable() {
		SupplierDAO dao = new SupplierDAO();
		startListL();
		tableView.setItems(FXCollections.observableList(dao.findAll()));
		tableView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
		colId.setCellValueFactory(new PropertyValueFactory<Supplier, String>(
				"id"));
		colName.setCellValueFactory(new PropertyValueFactory<Supplier, String>(
				"name"));
		colName.setPrefWidth(100);
		colAddress
				.setCellValueFactory(new PropertyValueFactory<Supplier, String>(
						"address"));
		colAddress.setPrefWidth(300);
		colEmail.setCellValueFactory(new PropertyValueFactory<Supplier, String>(
				"email"));
		colEmail.setPrefWidth(190);
		colContact
				.setCellValueFactory(new PropertyValueFactory<Supplier, String>(
						"contact"));
		colContact.setPrefWidth(100);

		tableView.getColumns().setAll(colId, colName, colContact, colAddress,
				colEmail);
	}

	private void startListL() {
		ProductDAO dao = new ProductDAO();
		listL.getItems().addAll(dao.findAll());
	}

	@FXML
	public void addToListR() {
		Product product = listL.getSelectionModel().getSelectedItem();
		if (product != null)
			listR.getItems().add(product);
		labelErrorLists.setText("");
		labelErrorAddress.setText("");
		labelErrorCell.setText("");
		labelErrorName.setText("");

	}

	@FXML
	public void removeFromListR() {
		Product product = listR.getSelectionModel().getSelectedItem();
		if (product != null) {
			listR.getItems().remove(product);
			labelErrorLists.setText("");
			labelErrorAddress.setText("");
			labelErrorCell.setText("");
			labelErrorName.setText("");

			return;
		} else {
			labelErrorLists.setText("Selecione na lista");
		}
		if (listR.getItems().isEmpty()) {
			labelErrorLists.setText("Lista vazia!");
			return;
		}
	}

	@FXML
	public void newObject() {
		listR.getItems().clear();
		fieldAddress.setText("");
		fieldCell.setText("");
		fieldEmail.setText("");
		fieldName.setText("");

		labelErrorAddress.setText("");
		labelErrorCell.setText("");
		labelErrorName.setText("");
		labelErrorLists.setText("");

		fieldName.requestFocus();
	}

	@FXML
	public void delete() {
		if (fieldEmailDel.getText().trim().isEmpty()
				&& fieldNameDel.getText().trim().isEmpty()) {
			labelErrorDel.setText("Preencha o nome/email");
		} else {
			SupplierDAO dao = new SupplierDAO();
			dao.delete(selectOnTableView().getId(), Supplier.class);
			dao.commitAndCloseTransaction();
			populateTable();
			labelErrorDel.setText("Apagado!");
		}
	}

	@FXML
	public Supplier selectOnTableView() {
		Supplier supp = tableView.getSelectionModel().getSelectedItem();
		fieldEmailDel.setText(supp.getEmail());
		fieldNameDel.setText(supp.getName());

		fieldName.setText(supp.getName());
		fieldEmail.setText(supp.getEmail());
		fieldAddress.setText(supp.getAddress());
		fieldCell.setText(supp.getContact());
		listR.getItems().setAll(supp.getProducts());
		return supp;
	}

	@FXML
	public void save() {
		if (FieldVerify.checkFields(fieldAddress))
			labelErrorAddress.setText("Preencha o endereco");
		else
			labelErrorAddress.setText("");
		if (FieldVerify.checkFields(fieldCell))
			labelErrorCell.setText("Preencha o numero");
		else
			labelErrorCell.setText("");
		if (FieldVerify.checkFields(fieldName))
			labelErrorName.setText("Preencha o nome");
		else
			labelErrorName.setText("");
		if (listR.getItems().isEmpty())
			labelErrorLists.setText("Adicione pelomenos um producto");
		else
			labelErrorLists.setText("");

		if (!FieldVerify.checkFields(fieldAddress, fieldCell, fieldName) && !listR.getItems().isEmpty()) {
			SupplierDAO dao = new SupplierDAO();
			Supplier supp = new Supplier();
			supp.setAddress(fieldAddress.getText());
			supp.setName(fieldName.getText());
			supp.setContact(fieldCell.getText());
			supp.setDateRegistered(Calendar.getInstance());
			supp.setEmail(fieldEmail.getText());
			supp.setProducts(listR.getItems());
			dao.save(supp);
			dao.commitAndCloseTransaction();
			populateTable();
			labelErrorLists.setText("Adicionado!");
		} else
			labelErrorLists.setText("Ocorreu um erro");
	}
	
	@FXML
	public void update() {
		if (!FieldVerify.checkFields(fieldAddress, fieldCell, fieldName) && !listR.getItems().isEmpty()) {
			SupplierDAO dao = new SupplierDAO();
			Supplier supp = tableView.getSelectionModel().getSelectedItem();
			supp.setAddress(fieldAddress.getText());
			supp.setName(fieldName.getText());
			supp.setContact(fieldCell.getText());
			supp.setDateRegistered(Calendar.getInstance());
			supp.setEmail(fieldEmail.getText());
			supp.setProducts(listR.getItems());
			dao.update(supp);
			dao.commitAndCloseTransaction();
			populateTable();
			newObject();
			labelErrorLists.setText("Actualizado!");
		} else {
			labelErrorLists.setText("Escolha um producto na tabela!");
			labelErrorAddress.setText("");
			labelErrorCell.setText("");
			labelErrorName.setText("");
		}
	}
}
