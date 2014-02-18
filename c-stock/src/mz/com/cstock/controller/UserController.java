package mz.com.cstock.controller;

import java.net.URL;
import java.util.Calendar;
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
	private TableColumn<User, Calendar> columnDate;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		populateTable();
	}

	@SuppressWarnings("unchecked")
	private void populateTable() {
		UserDAO dao = new UserDAO();
		tableView.setItems(FXCollections.observableList(dao.findAll()));
		
		columnId.setCellValueFactory(new PropertyValueFactory<User, String>("id"));
		columnName.setCellValueFactory(new PropertyValueFactory<User, String>("name"));
		columnEmail.setCellValueFactory(new PropertyValueFactory<User, String>("email"));
		columnDate.setCellValueFactory(new PropertyValueFactory<User, Calendar>("dateRegistered"));
		
		tableView.getColumns().setAll(columnId, columnName, columnEmail, columnDate);
	}
}
