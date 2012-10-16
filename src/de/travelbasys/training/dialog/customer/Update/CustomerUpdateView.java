package de.travelbasys.training.dialog.customer.Update;

import java.util.ArrayList;

import de.travelbasys.training.dialog.VTextField;
import de.travelbasys.training.util.AppContext;
import de.travelbasys.training.util.Console;

/**
 * ist verantwortlich für den Dialog mit dem Benutzer, um alle Daten für das
 * ändern eins Customer Objekts abzufragen
 * 
 * @autor tba
 */

public class CustomerUpdateView extends ArrayList<VTextField> {
	private CustomerUpdateModel model;
	private CustomerUpdateControl control;

	private static final long serialVersionUID = 1L;

	public CustomerUpdateView(CustomerUpdateModel model,
			CustomerUpdateControl control) {
		super();
		this.model = model;
		this.control = control;
	}

	public void run() {
		String customeridtemp = "";
		AppContext.printMessage("AttentionIntPrompt");
			AppContext.printMessage("IDPrompt");
			customeridtemp = Console.nextLine();
			control.check(customeridtemp);
			do {
				AppContext.printMessage("Choose");
				AppContext.printMessage("Cancel");
				AppContext.printMessage("Update1");
				AppContext.printMessage("Update2");
				AppContext.printMessage("Update3");
				AppContext.printMessage("Update4");
				AppContext.printMessage("Update5");
				AppContext.printMessage("Update6");
			} while (control.checkmenu() == 1);

	}

}
