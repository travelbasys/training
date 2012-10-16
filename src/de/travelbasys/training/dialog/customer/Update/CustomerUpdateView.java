package de.travelbasys.training.dialog.customer.Update;

import java.util.ArrayList;

import de.travelbasys.training.dialog.VTextField;
import de.travelbasys.training.dialog.customer.Update.CustomerUpdateControl;
import de.travelbasys.training.dialog.customer.Update.CustomerUpdateModel;
import de.travelbasys.training.util.AppContext;
import de.travelbasys.training.util.Console;

/**
 * ist verantwortlich für den Dialog mit dem Benutzer, um alle Daten für das
 * ändern eins Customer Objekts abzufragen
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
		do {
			AppContext.printMessage("IDPrompt");
			customeridtemp = Console.nextLine();
			control.check(customeridtemp);
		} while (control.checkend(customeridtemp));
	}
	public String getfirstname(){
		AppContext.printMessage("FirstNamePrompt");
		String firstname = Console.nextLine();
		return firstname;
	}
	
	
	
	
}