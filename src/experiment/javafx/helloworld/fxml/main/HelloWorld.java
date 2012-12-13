package experiment.javafx.helloworld.fxml.main;

import javafx.application.Application;
import javafx.stage.Stage;
import de.travelbasys.training.framework.Dialog;
import experiment.javafx.helloworld.fxml.mainmvc.HelloWorldGUIDialog;

public class HelloWorld extends Application {

	@Override
	public void start(Stage stage) throws Exception {
		Dialog d = new HelloWorldGUIDialog(stage);
		d.run();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
