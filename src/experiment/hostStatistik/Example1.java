package experiment.hostStatistik;

import java.io.IOException;
import java.net.URL;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Example1 extends Application {

	private static AnchorPane root;

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) {
		try {
			URL url = FXMLLoader.getDefaultClassLoader().getResource(
					"experiment/hostStatistik/MainFrame.fxml");
			root = FXMLLoader.load(url);
		} catch (IOException e) {
			e.printStackTrace();
		}
		primaryStage.setScene(new Scene(root, 1200, 800));
		primaryStage.show();
	}

	@Override
	public void stop() throws Exception {
		System.out.println("Stopped");
		super.stop();
	}
}
