package experiment.javafx.fxml.main;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import de.travelbasys.training.framework.Dialog;

/*
 * Ist verantwortlich für das Anzeigen des Hauptmenüs (Hauptfenster mit Menüleiste).
 * (Zeigt dem Benutzer alle verfügbaren Funktionen).
 * 
 */
public class RBSTestGUIDialog implements Dialog {

	@SuppressWarnings("unused")
	private RBSTestGUIModel model;
	private RBSTestGUIControl control;

	private Stage stage;
	private Scene scene;
	private String PATH = "/experiment/javafx/fxml/main/";
	private String FILE = "MainFrame.fxml";

	public RBSTestGUIDialog(Stage stage) {
		model = new RBSTestGUIModel();
		control = new RBSTestGUIControl();
		this.stage = stage;
	}

	@Override
	public void run() {
		try {
			AnchorPane root = FXMLLoader.load(getClass().getResource(
					PATH + FILE));
			scene = new Scene(root);
			stage.setScene(scene);
		} catch (IOException e) {
			e.printStackTrace();
		}
		stage.show();
		control.init();
	}
}
