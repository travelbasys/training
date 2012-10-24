package de.travelbasys.training.dialog.customer.delete1;

import de.travelbasys.training.framework.Model;
import de.travelbasys.training.framework.View;
import de.travelbasys.training.util.AppContext;

/**
 * stellt einen View innerhalb des Customer Delete Dialoges dar.
 * 
 */
public class CustomerDelete1View implements View {
	@SuppressWarnings("unused")
	private CustomerDelete1Model model;

	/**
	 * Initialisiert das Model.
	 */
	public void init(Model model) {
		this.model = (CustomerDelete1Model) model;
	}

	/**
	 * Gibt eine Meldung zurück, wenn der Löschvorgang erfolgreich war.
	 */
	public void run() {
		AppContext.printMessage("DelOK");

	}

}