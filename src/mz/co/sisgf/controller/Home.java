package mz.co.sisgf.controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Home implements Initializable {

	@FXML
	private ImageView logo;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		initLabel();
	}
	
	private void initLabel() {
		Image image = new Image(getClass().getResourceAsStream("../view/img/dc_logo.jpg"));
		logo.setImage(image);
	}
}
