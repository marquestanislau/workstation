package mz.com.cstock.controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import mz.com.cstock.dao.UserDAO;
import mz.com.cstock.model.User;

public class UserController implements Initializable {

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

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		populateTable();
	}

	@SuppressWarnings("unchecked")
	private void populateTable() {
		UserDAO dao = new UserDAO();
		tableView.setItems(FXCollections.observableList(dao.findAll()));
		
		columnId.setCellValueFactory(new PropertyValueFactory<User, String>("id"));
		columnId.setPrefWidth(100.0);
		columnName.setCellValueFactory(new PropertyValueFactory<User, String>("name"));
		columnName.setPrefWidth(100.0);
		columnEmail.setCellValueFactory(new PropertyValueFactory<User, String>("email"));
		columnEmail.setPrefWidth(255.0);
		columnDate.setCellValueFactory(new PropertyValueFactory<User, String>("data"));
		columnDate.setPrefWidth(190.0);
		
		tableView.getColumns().setAll(columnId, columnName, columnEmail, columnDate);
	}
}
