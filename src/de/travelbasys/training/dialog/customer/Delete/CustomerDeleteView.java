package de.travelbasys.training.dialog.customer.Delete;

import java.util.ArrayList;

import de.travelbasys.training.dialog.VTextField;
import de.travelbasys.training.util.AppContext;
import de.travelbasys.training.util.Console;

/**
 * Diese Klasse ist verantwortlich für den Dialog mit dem Benutzer um die für
 * das löschen eines Customers aus der Datenbank
 * 
 * @author tba
 * 
 */
public class CustomerDeleteView extends ArrayList<VTextField> {
	private CustomerDeleteModel model;
	private CustomerDeleteControl control;

	private static final long serialVersionUID = 1L;

	public CustomerDeleteView(CustomerDeleteModel model,
			CustomerDeleteControl control) {
		super();
		this.model = model;
		this.control = control;
	}

	public void run() {
		String customerid = "";
		AppContext.printMessage("AttentionIntPrompt");
		do {
			AppContext.printMessage("IDPrompt");
			customerid = Console.nextLine();
			control.check(customerid);
		} while (control.checkend(customerid));
	}



	}
