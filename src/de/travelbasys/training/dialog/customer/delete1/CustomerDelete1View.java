package de.travelbasys.training.dialog.customer.delete1;

import de.travelbasys.training.framework.Model;
import de.travelbasys.training.framework.View;
import de.travelbasys.training.util.AppContext;

/**
 */
public class CustomerDelete1View implements View {
	@SuppressWarnings("unused")
	private CustomerDelete1Model model;

	public void init(Model model) {
		this.model = (CustomerDelete1Model) model;
	}

	public void run() {
		AppContext.printMessage("DelOK");

	}

}