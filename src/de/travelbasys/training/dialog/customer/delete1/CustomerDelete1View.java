package de.travelbasys.training.dialog.customer.delete1;

import de.travelbasys.training.framework.Model;
import de.travelbasys.training.framework.View;
import de.travelbasys.training.util.AppContext;

/**
 * stellt einen View innerhalb des Customer Delete Dialoges dar.
 * 
 */
public class CustomerDelete1View implements View {
	private CustomerDelete1Model model;

	/**
	 * Initialisiert das Model.
	 */
	public CustomerDelete1View(Model model) {
		this.model = (CustomerDelete1Model) model;
	}

	/**
	 * Gibt eine Meldung zurück, ob der Löschvorgang erfolgreich oder fehlerhaft
	 * war.
	 */
	public void run() {
		if (model.isSuccess()) {
			AppContext.printMessage("DelOK");
		} else {
			AppContext.printErrString("DelERR");
		}
	}
}