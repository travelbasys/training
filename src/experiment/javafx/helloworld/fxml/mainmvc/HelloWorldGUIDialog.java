package experiment.javafx.helloworld.fxml.mainmvc;

import javafx.stage.Stage;
import de.travelbasys.training.framework.Dialog;

public class HelloWorldGUIDialog implements Dialog {

	private HelloWorldGUIModel model;
	private HelloWorldGUIView view;
	private HelloWorldGUIControl control;

	public HelloWorldGUIDialog(Stage stage) {
		model = new HelloWorldGUIModel();
		view = new HelloWorldGUIView(model, stage);
		control = new HelloWorldGUIControl();
	}

	@Override
	public void run() {
		view.init();
		control.init(model, view);
		view.run();
	}
}
