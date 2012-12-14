package experiment.javafx.helloworld.fxml.mainmvc;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import de.travelbasys.training.framework.Control;
import de.travelbasys.training.framework.Model;
import de.travelbasys.training.framework.View;

/*
 * Hat die Aufgabe den View unserer HelloWorld-Applikation zu verwalten & EventListener/Handler dieser zur Verfügung zu stellen.
 * 
 */

public class HelloWorldGUIControl implements Control {

	private HelloWorldGUIModel model;
	private HelloWorldGUIView view;

	public HelloWorldGUIControl() {
	}

	@Override
	public void init(Model model, View view) {
		this.view = (HelloWorldGUIView) view;
		this.model = (HelloWorldGUIModel) model;

		((Button) this.view.getNode("#changeButton"))
				.setOnAction(new EventHandler<ActionEvent>() {

					TextField textField = ((TextField) HelloWorldGUIControl.this.view
							.getNode("#textField"));

					@Override
					public void handle(ActionEvent arg0) {
						if (textField.getText().equalsIgnoreCase("exit")) {
							System.exit(0);
						}

						if (textField.isEditable()) {
							textField.setText("locked");
							textField.setEditable(false);
						} else {
							textField.setText("unlocked");
							textField.setEditable(true);
						}

					}
				});

		this.view.getTextField().textProperty()
				.addListener(new ChangeListener<String>() {

					@Override
					public void changed(
							ObservableValue<? extends String> observable,
							String oldValue, String newValue) {
						HelloWorldGUIControl.this.model.setTextField(newValue);
						HelloWorldGUIControl.this.view.update();
					}
				});

		this.view.getCloseItem().setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				System.exit(0);
			}
		});
	}

	@Override
	public void handleInput(Object value) throws Exception {
	}

}
