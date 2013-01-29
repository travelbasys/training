package experiment.javafx.fxml.main;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import de.travelbasys.training.framework.Control;
import de.travelbasys.training.framework.Model;
import de.travelbasys.training.framework.View;
import de.travelbasys.training.util.widgets.SimpleCalendar;

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

		RBSTestGUIView.getButton().setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				System.out.println("Test");
				SimpleCalendar simple = new SimpleCalendar();
				simple.setPrefHeight(100);
				simple.setPrefWidth(100);
				simple.requestFocus();
				RBSTestGUIView.getBP().setCenter(simple);
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
