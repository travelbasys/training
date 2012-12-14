package experiment.javafx.helloworld.fxml.mainmvc;

import de.travelbasys.training.framework.Model;

/*
 * 
 * Stellt ein Model für den HelloWorldGUIDialog zur Vefügung.
 * Die aktuelle Implementierung enthält alle Textfelder, die unsere Anwendung anzeigt.
 */
public class HelloWorldGUIModel implements Model {

	private String text;

	public void setTextField(String text) {
		this.text = text;
	}

	public String getText() {
		return text;
	}

	public boolean isInvalid() {
		return text.isEmpty();
	}

}
