package mz.co.sisgf.view;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.animation.FadeTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;
import mz.co.sisgf.report.CamposUtil;

public class MainController implements Initializable {

	@FXML
	private Label labelRegisto;
	@FXML
	private Label labelTransacao;
	@FXML
	private Label labelBanco;
	@FXML
	private Label labelHome;
	@FXML
	private Label userName;
	@FXML
	private Label labelLogout;
	@FXML
	private Pane content;
	@FXML
	private Pane messagePane;
	@FXML
	private ImageView userIcon;

	@FXML
	private void hideMessage() {
		this.messagePane.setVisible(false);
	}

	@FXML
	private void showMessage() {
		this.messagePane.setVisible(true);
	}

	@FXML
	private void callContent(MouseEvent event) {

		content.getChildren().clear();
		try {
			Node node;
			if (event.getSource().equals(labelHome)) {
				node = FXMLLoader.load(getClass().getResource("Home.fxml"));
				nodeEffect(node);
				content.getChildren().add(node);
			} else if (event.getSource().equals(labelRegisto)) {
				node = FXMLLoader.load(getClass().getResource("Form.fxml"));
				nodeEffect(node);
				content.getChildren().add(node);
			} else if (event.getSource().equals(labelTransacao)) {
				node = FXMLLoader.load(getClass().getResource("TableView.fxml"));
				nodeEffect(node);
				content.getChildren().add(node);
			} else if (event.getSource().equals(labelBanco)) {
				node = FXMLLoader.load(getClass().getResource("Banco.fxml"));
				nodeEffect(node);
				content.getChildren().add(node);
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void nodeEffect(Node node) {
		FadeTransition ft = new FadeTransition(Duration.millis(1000), node);
		ft.setFromValue(0);
		ft.setToValue(1);
		ft.play();
	}

	private void initLabelsIcons() {
		Image transacoes = new Image(getClass().getResourceAsStream("img/book.png"));
		Image todasTransacoes = new Image(getClass().getResourceAsStream("img/cash-usd.png"));
		Image bancos = new Image(getClass().getResourceAsStream("img/bank.png"));
		Image home = new Image(getClass().getResourceAsStream("img/home.png"));
		Image logout = new Image(getClass().getResourceAsStream("img/logout.png"));
		
		Image userHome = new Image(getClass().getResourceAsStream("img/pic.png"));
		
		userIcon.setImage(userHome);

		labelLogout.setGraphic(new ImageView(logout));
		labelBanco.setGraphic(new ImageView(bancos));
		labelRegisto.setGraphic(new ImageView(transacoes));
		labelTransacao.setGraphic(new ImageView(todasTransacoes));
		labelHome.setGraphic(new ImageView(home));
	}
	
	@FXML
	private void logout(MouseEvent mouseEvent) {
		try {
			Node source = (Node) mouseEvent.getSource();
			Stage stageOld = (Stage) source.getScene().getWindow();
			stageOld.close();
			
			AnchorPane root = (AnchorPane) FXMLLoader.load(getClass().getResource("Login.fxml"));
			double width = root.getPrefWidth();
			double height = root.getPrefHeight();
			Stage stage = new Stage();
			Scene scene = new Scene(root, width, height);
			stage.initStyle(StageStyle.UNDECORATED);
			stage.setScene(scene);
			stage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		initLabelsIcons();
		userName.setText(CamposUtil.userName);
	}
}
