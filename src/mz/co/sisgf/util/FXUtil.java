package mz.co.sisgf.util;

import javafx.animation.FadeTransition;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.util.Duration;

public class FXUtil {

	public static void transitionEffect(Node node, double duration) {
		FadeTransition ft = new FadeTransition(Duration.millis(duration), node);
		ft.setFromValue(1.0);
		ft.setToValue(0.0);
		ft.play();
	}
	
	public static void transitionEffectIn(Node node, double duration) {
		FadeTransition ft = new FadeTransition(Duration.millis(duration), node);
		ft.setFromValue(0.0);
		ft.setToValue(1.0);
		ft.play();
	}
	
	public static void showMessageText(String message, Label label) {
		label.setText(message);
		label.setVisible(true);
		transitionEffect(label, 7000);
	}
}
