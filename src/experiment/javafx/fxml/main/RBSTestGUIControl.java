package experiment.javafx.fxml.main;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import de.travelbasys.training.framework.Control;
import de.travelbasys.training.framework.Model;
import de.travelbasys.training.framework.View;

/*
 * Hat die Aufgabe den View unserer HelloWorld-Applikation zu verwalten & EventListener/Handler dieser zur Verfügung zu stellen.
 * 
 */
public class RBSTestGUIControl implements Control {

	@SuppressWarnings("unused")
	private RBSTestGUIModel model;
	@SuppressWarnings("unused")
	private RBSTestGUIView view;
	@FXML
	private static TextField dateField;

	public RBSTestGUIControl() {
	}

	public void init() {
	}

	@Override
	public void handleInput(Object value) throws Exception {
	}

	@Override
	public void init(Model model, View view) {
		// TODO Auto-generated method stub

	}

}
