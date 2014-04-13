package mz.com.cstock.controller;

import java.net.URL;
import java.util.Calendar;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.util.Callback;
import mz.com.cstock.dao.UserDAO;
import mz.com.cstock.messages.FieldVerify;
import mz.com.cstock.model.Permission;
import mz.com.cstock.model.User;
import mz.com.cstock.report.UserReport;

public class UserController implements Initializable {

	private static final String PATH = "/resources/images/";

	@FXML
	private TableView<User> tableView;
	@FXML
	private TableColumn<User, String> columnId;
	@FXML
	private TableColumn<User, String> columnName;
	@FXML
	private TableColumn<User, String> columnEmail;
	@FXML
	private TableColumn<User, String> columnDate;
	@FXML
	private TableColumn<User, User> tableColumnAction;

	// ------------------------------------------------------------------------------

	@FXML
	private TextField fieldNome;
	@FXML
	private TextField fieldEmail;
	@FXML
	private PasswordField fieldCodigo;
	@FXML
	private PasswordField fieldCodigo_;

	@FXML
	private TextField fieldNomeDelete;
	@FXML
	private TextField fieldEmailDelete;

	// ------------------------------------------------------------------------------

	@FXML
	private Button buttonSalvar;
	@FXML
	private Button buttonUpdate;
	@FXML
	private Button buttonDelete;
	@FXML
	private Button buttonNew;
	// ------------------------------------------------------------------------------

	@FXML
	private ComboBox<String> boxPrevilegios;

	// ------------------------------------------------------------------------------

	@FXML
	private Label labelError;
	@FXML
	private Label labelErrorPassword;
	@FXML
	private Label labelRemoved;
	@FXML
	private Menu menuReport;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		populateTable();
		initComboBox();
		initButtons();
		initMenu();
	}

	@SuppressWarnings("unchecked")
	private void populateTable() {
		UserDAO dao = new UserDAO();

		tableView.setItems(FXCollections.observableList(dao.findAll()));
		tableView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

		columnId.setCellValueFactory(new PropertyValueFactory<User, String>(
				"id"));
		columnId.setPrefWidth(100.0);
		columnName.setCellValueFactory(new PropertyValueFactory<User, String>(
				"name"));
		columnName.setPrefWidth(100.0);
		columnEmail.setCellValueFactory(new PropertyValueFactory<User, String>(
				"email"));
		columnEmail.setPrefWidth(255.0);
		columnDate.setCellValueFactory(new PropertyValueFactory<User, String>(
				"data"));
		columnDate.setPrefWidth(190.0);

		tableColumnAction
				.setCellValueFactory(new PropertyValueFactory<User, User>(""));
		tableColumnAction
				.setCellFactory(new Callback<TableColumn<User, User>, TableCell<User, User>>() {

					@Override
					public TableCell<User, User> call(
							TableColumn<User, User> param) {
						TableCell<User, User> cell = new TableCell<User, User>() {
							@Override
							protected void updateItem(final User item, boolean empty) {
								super.updateItem(item, empty);
								if (item != null || !empty) {
									Button button = new Button("Remover");
									setGraphic(button);
									setPrefWidth(100);
								}
							}
						};
						return cell;
					}
				});

		tableView.getColumns().setAll(columnId, columnName, columnEmail,
				columnDate, tableColumnAction);
	}
	
	private void initMenu() {
		menuReport.setGraphic(new ImageView(new Image(this.getClass().getResourceAsStream(PATH + "print.png"))));
	}

	private void initComboBox() {
		boxPrevilegios.getItems().setAll("", "ADMIN", "USER");
	}

	private void initButtons() {
		buttonDelete.setGraphic(new ImageView(new Image(getClass()
				.getResourceAsStream(PATH + "New.png"))));
		buttonSalvar.setGraphic(new ImageView(new Image(getClass().getResourceAsStream(PATH + "add.png"))));
		buttonNew.setGraphic(new ImageView(new Image(getClass().getResourceAsStream(PATH + "New.png"))));
		buttonUpdate.setGraphic(new ImageView(new Image(getClass().getResourceAsStream(PATH + "refresh.png"))));
		buttonDelete.setGraphic(new ImageView(new Image(getClass().getResourceAsStream(PATH + "delete.png"))));
	}

	public void save() {

		if (FieldVerify.checkFields(fieldNome, fieldEmail, fieldCodigo,
				fieldCodigo_)) {
			labelError.setText("Preencha os campos.");
			return;
		}

		User user = new User();
		try {

			UserDAO dao = new UserDAO();

			user.setDateRegistered(Calendar.getInstance());
			user.setEmail(fieldEmail.getText().trim());
			user.setName(fieldNome.getText().trim());
			user.setPassword(fieldCodigo.getText().trim());

			if (boxPrevilegios.getSelectionModel().getSelectedItem()
					.equals("ADMIN"))
				user.setPermission(Permission.ADMIN);
			else if (boxPrevilegios.getSelectionModel().getSelectedItem()
					.equals("USER"))
				user.setPermission(Permission.USER);
			else
				labelErrorPassword.setText("Seleccione o nivel de acesso!");

			dao.save(user);
			dao.commitAndCloseTransaction();

			populateTable();
			labelError.setText("Sucesso!");

		} catch (Exception e) {
			labelError.setText("Ocorreu um erro!");
		}
	}

	public void verifyPassword(KeyEvent event) {
		if (fieldCodigo.getText().length() != event.getCharacter().length()
				&& !fieldCodigo.getText().contains(event.getCharacter())) {
			labelErrorPassword.setText("Codigos diferentes!");
			buttonSalvar.setDisable(true);
			buttonUpdate.setDisable(true);
		} else {
			labelErrorPassword.setText("");
			buttonSalvar.setDisable(false);
			buttonUpdate.setDisable(false);
		}
	}

	public void clearFields() {
		fieldCodigo.setText("");
		fieldCodigo_.setText("");
		fieldEmail.setText("");
		fieldNome.setText("");

		labelError.setText("");
		labelErrorPassword.setText("");
		initComboBox();
		fieldNome.requestFocus();
	}

	public void selectItem() {
		User user = (User) tableView.getSelectionModel().getSelectedItem();
		labelRemoved.setText("");
		fieldNomeDelete.setText(user.getName());
		fieldEmailDelete.setText(user.getEmail());
	}

	public void delete() {

		if (FieldVerify.checkFields(fieldEmailDelete, fieldNomeDelete)) {
			labelRemoved.setText("Preencha o Nome/Email");
			return;
		}

		UserDAO dao = new UserDAO();

		User user = (User) tableView.getSelectionModel().getSelectedItem();
		dao.delete(user.getId(), User.class);

		dao.commitAndCloseTransaction();
		labelRemoved.setText("Removido!");
		populateTable();
	}
	@FXML
	private void callReport() {
		UserReport report = new UserReport();
		report.showReport("report_user.jasper");
	}
}
