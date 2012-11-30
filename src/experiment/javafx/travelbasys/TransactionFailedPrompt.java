package experiment.javafx.travelbasys;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class TransactionFailedPrompt {
//TODO: Der TransactionSuccessfull Klasse nachbauen.
	public TransactionFailedPrompt() {
		final Stage stage = new Stage();
		StackPane stackpane = new StackPane();
		Label label = new Label("Transaction Failed");
		label.setTextFill(Color.web("#880000"));
		Button btn = new Button("OK");
		btn.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent e) {
				stage.close();
			}
		});
		stackpane.getChildren().addAll(label, btn);
		stage.setScene(new Scene(stackpane, 320, 240));
		stage.show();
	}
}
