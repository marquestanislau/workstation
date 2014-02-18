package mz.com.cstock.messages;

import javafx.scene.control.Label;

public class ShowLabelMessages {

	private static Label label = null;
	
	public static Label showErrorMessage(String errorMessage, String id) {
		label = new Label(errorMessage);
		label.setId(id);
		return label;
	}
	
	public static Label showSuccessMessage(String successMessage, String id) {
		label = new Label(successMessage);
		label.setId(id);
		return label;
	}
	
	public static Label showWarnigMessage(String warnigMessage, String id) {
		label = new Label(warnigMessage);
		label.setId(id);
		return label;
	}
}
