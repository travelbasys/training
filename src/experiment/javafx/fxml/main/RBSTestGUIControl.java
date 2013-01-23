package experiment.javafx.fxml.main;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
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

	public RBSTestGUIControl() {
	}

	public void init() {

		RBSTestGUIView.getButton().setOnAction(
				new EventHandler<ActionEvent>() {

					@Override
					public void handle(ActionEvent event) {
						System.out.println("Test");
					}
				});

	}

	@Override
	public void handleInput(Object value) throws Exception {
	}

	@Override
	public void init(Model model, View view) {
		// TODO Auto-generated method stub

	}

}
