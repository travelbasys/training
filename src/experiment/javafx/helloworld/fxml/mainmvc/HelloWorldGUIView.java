package experiment.javafx.helloworld.fxml.mainmvc;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import de.travelbasys.training.framework.Model;
import de.travelbasys.training.framework.View;

/*
 * Ist dafür verantwortlich dem Benutzer ein Hauptmenü (Hauptfenster) zur Verfügung zu stellen,
 * welches weitere Komponenten aufrufen kann.
 * Die aktuelle Implementierung liest eine .fxml Datei ein und generiert mithilfe dieser ein Layout, wessen eindeutige fx:id's in der Scene gespeichert werden.
 * Wir lesen diese Elemente anhand von Scene.lookup() aus & erstellen eine Referenz. 
 */

public class HelloWorldGUIView implements View {
	private Stage stage;
	private Scene scene;
	private HelloWorldGUIModel model;
	private String PATH = "/experiment/javafx/helloworld/fxml/main/";
	private String FXML = "Sample.fxml";
	private TextField textField;
	private MenuBar menuBar;
	private MenuItem closeItem;

	public HelloWorldGUIView(Model model, Stage stage) {
		this.model = (HelloWorldGUIModel) model;
		this.stage = stage;
	}

	@Override
	public void run() {
		stage.show();
	}

	public void init() {
		try {
			AnchorPane root = FXMLLoader.load(getClass().getResource(
					PATH + FXML));
			scene = new Scene(root);
			((Button) getNode("#changeButton")).setDisable(true);
			((Button) getNode("#changeButton")).setDefaultButton(true);
			stage.setScene(scene);
			textField = (TextField) getNode("#textField");
			menuBar = (MenuBar) getNode("#menuBar");
			closeItem = getMenuItem("closeItem");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public Node getNode(String cssRef) {
		return scene.lookup(cssRef);
	}

	public MenuItem getMenuItem(String id) {
		for (Menu m : menuBar.getMenus()) {
			for (MenuItem item : m.getItems()) {
				if (item.getId().equals(id)) {
					return item;
				}
			}
		}
		return null;
	}

	public TextField getTextField() {
		return textField;
	}

	public void update() {
		((Button) getNode("#changeButton")).setDisable(model.isInvalid());
	}

	public MenuItem getCloseItem() {
		return closeItem;
	}

}
