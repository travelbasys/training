package experiment.javafx.fxml.main;

import java.util.Date;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import de.travelbasys.training.framework.Control;
import de.travelbasys.training.framework.Model;
import de.travelbasys.training.framework.View;
import de.travelbasys.training.util.widgets.DatePicker;
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
	@FXML
	private static TextField dateField;
	private Date birthdate;
 
	public SimpleCalendar simple;
	
	public RBSTestGUIControl() {
	}

	public void init() {

		RBSTestGUIView.getButton().setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				System.out.println("Test");
				SimpleCalendar simple = new SimpleCalendar();
				simple.setPrefHeight(200);
				simple.setPrefWidth(200);
				simple.requestFocus();

				RBSTestGUIView.getCalbp().setCenter(simple);
				simple.dateProperty().addListener(new ChangeListener<String>() {

					@Override
					public void changed(ObservableValue<? extends String> observable,
							String oldValue, String newValue) {
						System.out.println(newValue);
						
						RBSTestGUIView.getDateField().setText(newValue);
					}
				});

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
