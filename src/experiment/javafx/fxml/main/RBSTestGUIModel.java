package experiment.javafx.fxml.main;

import de.travelbasys.training.framework.Model;

/*
 * 
 * Stellt ein Model f�r den HelloWorldGUIDialog zur Vef�gung.
 * Die aktuelle Implementierung enth�lt alle Textfelder, die unsere Anwendung anzeigt.
 */
public class RBSTestGUIModel implements Model {

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
