package experiment.javafx.helloworld;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class HelloWorld extends Application {


	public static void main(String[] args) {
		launch(args);

	}

	@Override
	public void start(final Stage primaryStage) {
		
		primaryStage.setTitle("Hello World!");
		
		Button btn = new Button();
		btn.setText("Say 'Hello World'");
		btn.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				System.out.println("Hello World!");
				start2();
			}
		});

		StackPane root = new StackPane();
		root.getChildren().add(btn);
		primaryStage.setScene(new Scene(root, 640, 480));
		primaryStage.show();
	}

	public void start2() {

		final Stage secondaryStage = new Stage();
		secondaryStage.setTitle("Window 2");
		final Button btn = new Button();
		final Button btn2 = new Button();
		btn.setText("Fullscreen");
		btn2.setText("Change Window Title!");
		btn.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				if (secondaryStage.isFullScreen()) {
					btn.setText("Fullscreen");
					secondaryStage.setFullScreen(false);
				} else {
					secondaryStage.setFullScreen(true);
					btn.setText("Windowed");
				}
			}
		});

		btn2.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				secondaryStage.setTitle("Window <New Title>");
				btn2.setDisable(true);
			}

		});
		
		Pane root = new Pane();
		btn.setLayoutX(0);
		btn.setLayoutY(0);
		btn2.setLayoutX(100);
		btn2.setLayoutY(0);
		root.getChildren().add(btn);
		root.getChildren().add(btn2);
		secondaryStage.setScene(new Scene(root, 320, 240));
		secondaryStage.show();
	}
}