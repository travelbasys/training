package experiment.javafx.travelbasys;

import javafx.stage.Stage;
import de.travelbasys.training.framework.Dialog;

public class MainDialog implements Dialog {

	private MainModel model;
	private MainView view;
	@SuppressWarnings("unused")
	private MainControl control;

	public MainDialog(Stage stage) {
		model = new MainModel();
		view = new MainView(model, stage);
		control = new MainControl(model, view);
	}

	public void run() {
		view.run();
	}
}
