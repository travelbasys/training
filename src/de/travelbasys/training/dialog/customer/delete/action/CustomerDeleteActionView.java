package de.travelbasys.training.dialog.customer.delete.action;

import de.travelbasys.training.framework.Model;
import de.travelbasys.training.framework.View;
import de.travelbasys.training.util.AppContext;

/**
 * stellt einen View innerhalb des Customer Delete Dialoges dar.
 * 
 */
public class CustomerDeleteActionView implements View {
	private CustomerDeleteActionModel model;

	/**
	 * Initialisiert das Model.
	 */
	public CustomerDeleteActionView(Model model) {
		this.model = (CustomerDeleteActionModel) model;
	}

	/**
	 * Gibt eine Meldung zur�ck, ob der L�schvorgang erfolgreich oder fehlerhaft
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