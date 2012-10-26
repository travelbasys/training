package de.travelbasys.training.dialog.customer.delete.action;

import de.travelbasys.training.framework.Model;
import de.travelbasys.training.framework.View;
import de.travelbasys.training.util.AppContext;

/**
 * stellt einen View innerhalb des Customer Delete Dialoges dar.
 * 
 */
public class CustomerDeleteMenuView implements View {
	private CustomerDeleteMenuModel model;

	/**
	 * Initialisiert das Model.
	 */
	public CustomerDeleteMenuView(Model model) {
		this.model = (CustomerDeleteMenuModel) model;
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