package experiment.javafx.travelbasys;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class TransactionSuccessfullPrompt {
//TODO: Verschieben des Buttons/der Schrift in die Mitte
	public TransactionSuccessfullPrompt() {
		final Stage stage = new Stage();
		GridPane grid = new GridPane();
		BorderPane borderpane = new BorderPane();
		Label label = new Label("Transaction Successfull");
		Button btn = new Button("OK");
		grid.setVgap(5);
		grid.setHgap(5);
		GridPane.setConstraints(btn, 30, 34);
		GridPane.setConstraints(label, 16, 18);
//		GridPane.setValignment(btn, VPos.BOTTOM);
//		GridPane.setValignment(label, VPos.BOTTOM);
		grid.getChildren().addAll(label, btn);

		btn.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent e) {
				stage.close();
			}
		});
		borderpane.setCenter(grid);
		stage.setScene(new Scene(borderpane, 320, 240));
		stage.show();
	}
}
