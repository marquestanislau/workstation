package mz.com.cstock.controller;

import java.io.IOException;
import java.io.Serializable;
import java.net.URL;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;
import mz.com.cstock.dao.ProductDAO;
import mz.com.cstock.model.Compra;
import mz.com.cstock.model.Product;

public class MainController implements Serializable, Initializable {

	private static final long serialVersionUID = 1L;

	/* Botões do menu bar */
	@FXML
	private Button btnUser;
	@FXML
	private Button btnFornecedores;
	@FXML
	private Button btnRelatorio;
	@FXML
	private Button btnLogOut;
	@FXML
	private Button btnNovo;
	@FXML
	private Button btnSalvar;
	@FXML
	private Button btnActualizar;
	@FXML
	private Button Apagar;
	@FXML
	private Button buttonVendas;

	/* Label com finalidade de mostar os erros no sistema ao usuario */
	@FXML
	private Label labelSaveMessage;
	@FXML
	private Label deleteMessage;
	@FXML
	private Label labelMessageActualizar;

	/* Text fields do accordion "titled panel Salvar" */
	@FXML
	private TextField fieldNome;
	@FXML
	private TextField fieldQuantidade;
	@FXML
	private TextField fieldPrice;
	@FXML
	private TextField fieldPriceB;

	/* TextField que recebe o nome do produto para operacao "delete" */
	@FXML
	private TextField fieldApagar;

	/* Fields para opreracao actualizar */
	@FXML
	private TextField updateFieldName;
	@FXML
	private TextField updateFieldQuantity;
	@FXML
	private TextField updateFieldPrice;
	@FXML
	private TextField updateFieldPriceBuy;

	/* Colunas que compoem a tabela */
	@FXML
	private TableColumn<Product, String> columnName;
	@FXML
	private TableColumn<Product, String> columnId;
	@FXML
	private TableColumn<Product, String> columnQuantity;
	@FXML
	private TableColumn<Product, String> columnBuyPrice;
	@FXML
	private TableColumn<Product, String> columnSellPrice;

	/* Tabela que recebe colunas */
	@FXML
	private TableView<Product> tableView;

	@FXML
	private TableView<Compra> tableCompra;
	@FXML
	private TableColumn<Compra, String> colCompraNome;
	@FXML
	private TableColumn<Compra, String> colCompraQdt;

	@FXML
	private Label labelInfo;

	@FXML
	private Label imageFrame;
	@FXML
	private Label labelTimeLoged;

	private static final String imagesPath = "/resources/images/";

	@Override
	public void initialize(URL url, ResourceBundle bundle) {
		populateTable();
		initButtons();
		initTime();
	}

	public void openSellDialog(ActionEvent ev) {
		createModalWindow("Vendas", "C-Stock: Vendas", ev);
	}

	public void openReportDialog(ActionEvent ev) {
		createModalWindow("Relatorios", "C-Stock: Reatorios", ev);
	}

	public void openUserDialog(ActionEvent event) {
		createModalWindow("Usuarios", "C-Stock: Usuarios", event);
	}

	public void openFornecedoresDialog(ActionEvent event) {
		createModalWindow("Fornecedores", "C-Stock: Fornecedores", event);
	}

	private void createModalWindow(String fileName, String title,
			ActionEvent event) {
		System.out.println("Button clicked!");
		Stage stage = new Stage();
		try {
			Parent root = FXMLLoader.load(getClass().getResource(
					"../views/" + fileName + ".fxml"));
			Scene scene = new Scene(root);
			stage.setScene(scene);
			stage.setTitle(title);
			stage.initModality(Modality.WINDOW_MODAL);
			stage.initOwner(((Node) event.getSource()).getScene().getWindow());
			stage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void initLabels(ProductDAO dao) {
		int allQuantity = 0;
		for (Product p : dao.findAll()) {
			allQuantity += p.getQuantity();
		}
		DecimalFormat df = (DecimalFormat) DecimalFormat.getIntegerInstance();
		labelInfo.setText("Tem " + df.format(allQuantity)
				+ " produto(s) disponiveis");
//		imageFrame.setGraphic(new ImageView(new Image(getClass()
//				.getResourceAsStream(imagesPath + "User.png"))));
//		imageFrame.setContentDisplay(ContentDisplay.BOTTOM);
	}

	@SuppressWarnings("unchecked")
	private void populateTable() {
		ProductDAO dao = new ProductDAO();
		tableView.setItems(FXCollections.observableList(dao.findAll()));
		tableView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

		columnName
				.setCellValueFactory(new PropertyValueFactory<Product, String>(
						"name"));
		columnName.setPrefWidth(155);

		columnQuantity
				.setCellValueFactory(new PropertyValueFactory<Product, String>(
						"quantity"));

		columnBuyPrice
				.setCellValueFactory(new PropertyValueFactory<Product, String>(
						"buyPrice"));

		columnSellPrice
				.setCellValueFactory(new PropertyValueFactory<Product, String>(
						"sellPrice"));

		columnId.setCellValueFactory(new PropertyValueFactory<Product, String>(
				"id"));

		tableView.getColumns().setAll(columnId, columnName, columnQuantity,
				columnSellPrice, columnBuyPrice);
		initLabels(dao);
	}

	private void initButtons() {
		Image img1, img2, img3;
		img1 = new Image(getClass().getResourceAsStream(
				imagesPath + "Alien.png"));
		img2 = new Image(getClass().getResourceAsStream(
				imagesPath + "Industry.png"));
		img3 = new Image(getClass().getResourceAsStream(
				imagesPath + "notes.png"));
		btnUser.setGraphic(new ImageView(img1));
		btnUser.setContentDisplay(ContentDisplay.TOP);
		btnFornecedores.setGraphic(new ImageView(img2));
		btnFornecedores.setContentDisplay(ContentDisplay.TOP);
		btnRelatorio.setGraphic(new ImageView(img3));
		btnRelatorio.setContentDisplay(ContentDisplay.TOP);
		buttonVendas.setContentDisplay(ContentDisplay.TOP);
		btnLogOut.setGraphic(new ImageView(new Image(getClass()
				.getResourceAsStream(imagesPath + "power.png"))));
		btnLogOut.setContentDisplay(ContentDisplay.TOP);
		btnSalvar.setGraphic(new ImageView(new Image(getClass()
				.getResourceAsStream(imagesPath + "add.png"))));
		btnNovo.setGraphic(new ImageView(new Image(getClass()
				.getResourceAsStream(imagesPath + "New.png"))));
		btnActualizar.setGraphic(new ImageView(new Image(getClass()
				.getResourceAsStream(imagesPath + "refresh.png"))));
		Apagar.setGraphic(new ImageView(new Image(getClass()
				.getResourceAsStream(imagesPath + "delete.png"))));
		buttonVendas.setGraphic(new ImageView(new Image(getClass()
				.getResourceAsStream(imagesPath + "share.png"))));
		// buttonSell.setGraphic(new ImageView(new
		// Image(getClass().getResourceAsStream(imagesPath +
		// "Ecommerce.png"))));
	}

	private void cleanFields(TextField... fields) {
		for (TextField t : fields) {
			t.setText("");
		}
	}

	private boolean check(TextField... fields) {
		for (TextField t : fields) {
			if (t.getText().trim().equals("")) {
				return true;
			}
		}
		return false;
	}

	public void resetSaveFields() {
		cleanFields(fieldNome, fieldPrice, fieldQuantidade, fieldPriceB);
		fieldNome.requestFocus();
		labelSaveMessage.setText("");
	}

	public void save() {
		if (check(fieldNome, fieldPrice, fieldPriceB, fieldQuantidade)) {
			labelSaveMessage.setText("Preencha os campos.");
			return;
		}
		ProductDAO dao = new ProductDAO();
		Product product = new Product();
		product.setName(fieldNome.getText());
		product.setDateRegistered(Calendar.getInstance());

		try {
			
			double buy = Double.parseDouble(fieldPrice.getText());
			double sell = Double.parseDouble(fieldPriceB.getText());
			int qtd = Integer.parseInt(fieldQuantidade.getText());
			
			product.setBuyPrice(buy);
			product.setSellPrice(sell);
			product.setQuantity(qtd);
	
			if((product.getSellPrice() <= 0) || (product.getBuyPrice() <= 0) || (product.getQuantity() <= 0)) {
				labelSaveMessage.setText("Remova numero(s) negativo(s)");
				return;
			} else {
				dao.save(product);
				dao.commitAndCloseTransaction();
				populateTable();
				labelSaveMessage.setText("Produto guardado!");
			}
			
		} catch (Exception e) {
			labelSaveMessage.setText("Numero(s) invalidos!");
			e.printStackTrace();
		}

	}

	public void selectRowFromTable(MouseEvent event) {
		Product product = (Product) tableView.getSelectionModel()
				.getSelectedItem();
		fieldApagar.setText(product.getName());

		updateFieldName.setText(product.getName());
		updateFieldPrice.setText(String.valueOf(product.getSellPrice()));
		updateFieldPriceBuy.setText(String.valueOf(product.getBuyPrice()));
		updateFieldQuantity.setText(String.valueOf(product.getQuantity()));

	}

	public void delete() {
		if (check(fieldApagar)) {
			deleteMessage.setText("Seleccione na tabela!");
			return;
		}
		try {
			ProductDAO dao = new ProductDAO();
			for (Product p : dao.findAll()) {
				if (p.getName().equals(fieldApagar.getText())) {
					dao.delete(p.getId(), Product.class);
					dao.commitAndCloseTransaction();
					populateTable();
					deleteMessage.setText(p.getName() + " removido!");
					return;
				}
			}
			deleteMessage.setText("Producto nao existe.");
		} catch (Exception e) {
			deleteMessage.setText("Operação falhou!");
		}
	}

	public void update() {
		if (check(updateFieldName, updateFieldPrice, updateFieldPriceBuy,
				updateFieldQuantity)) {
			labelMessageActualizar.setText("Campos vazios!!");
			return;
		}
		boolean real = false;
		try {
			ProductDAO dao = new ProductDAO();
			for (Product p : dao.findAll()) {
				if (p.getName().equals(updateFieldName.getText())) {
					real = true;
					
					try {
						p.setName(updateFieldName.getText());
						p.setBuyPrice(Double.parseDouble(updateFieldPriceBuy
								.getText()));
						p.setDateRegistered(Calendar.getInstance());
						p.setSellPrice(Double.parseDouble(updateFieldPrice
								.getText()));
						p.setQuantity(Integer.parseInt(updateFieldQuantity
								.getText()));
						if((p.getBuyPrice() <= 0) || (p.getSellPrice() <= 0) || (p.getQuantity() <= 0)) {
							labelMessageActualizar.setText("Remova os numeros negativos");
							return;
						} else {
							dao.update(p);
							dao.commitAndCloseTransaction();
							populateTable();
							labelMessageActualizar.setText("Actualizado: "
									+ p.getName());
						}
					} catch (Exception e) {
						labelMessageActualizar.setText("Numero(s) Invalido(s)!");
						e.printStackTrace();
					}

				}
			}

			if (!real) {
				labelMessageActualizar.setText("Não existe!");
			}

		} catch (Exception e) {
			labelMessageActualizar.setText("Erro ao actualizar!");
		}
	}

	@FXML
	public void characterOrNumber(KeyEvent event) {
		if (!"0123456789".contains(event.getCharacter()))
			labelSaveMessage.setText("Digite apenas numeros");
		else
			labelSaveMessage.setText("");
	}
	private void initTime() {
		Calendar time = Calendar.getInstance();
		
		DateFormat df = new SimpleDateFormat();
		labelTimeLoged.setText("Dia e Hora de entrada no sistema: " + String.valueOf(df.format(time.getTime())));
	}

}