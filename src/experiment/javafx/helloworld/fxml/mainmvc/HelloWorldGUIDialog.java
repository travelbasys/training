package experiment.javafx.helloworld.fxml.mainmvc;

import javafx.stage.Stage;
import de.travelbasys.training.framework.Dialog;

/*
 * Ist verantwortlich f�r das Anzeigen des Hauptmen�s (Hauptfenster mit Men�leiste).
 * (Zeigt dem Benutzer alle verf�gbaren Funktionen).
 * 
 */

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
