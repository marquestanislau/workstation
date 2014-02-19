package mz.com.cstock.messages;

import javafx.scene.control.TextField;

public class FieldVerify {
	
	public static boolean checkFields(TextField ... fields) {
		for(TextField t: fields) {
			if(t.getText().trim().equals(""))
				return true;
		}
		return false;
	}
}
