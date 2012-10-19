package de.travelbasys.training.dialog.customer.show;

import java.util.ArrayList;

import de.travelbasys.training.business.Customer;
import de.travelbasys.training.dialog.VTextField;
import de.travelbasys.training.util.AppContext;
import de.travelbasys.training.util.Console;
/**
 * Diese Klasse ist verantwortlich für den Dialog mit dem Benutzer um die für
 * das anzeigen eines Customers aus der Datenbank erforderlichen Daten zu erfragen.
 * 
 * @author tba
 * 
 */
public class CustomerShowView extends ArrayList<VTextField> {
	private CustomerShowModel model;
	private CustomerShowControl control;

	private static final long serialVersionUID = 1L;

	public CustomerShowView(CustomerShowModel model, CustomerShowControl control) {
		super();
		this.model = model;
		this.control = control;
	}

	public void run() {

		AppContext.printMessage("AttentionIntPrompt");
		String customeridtemp;
		do {
			AppContext.printMessage("IDPrompt");
			customeridtemp = Console.nextLine();
			model.setCustomeridtemp(customeridtemp);

			control.check();

		} while (model.isGotuser());
	}

	public void found() {
		AppContext.printMessage("UserFound");
		Customer customer = model.getUserlist().get(0);

		AppContext.println(customer);

		return;

	}

	public void abort() {
		AppContext.printMessage("Abort");
		return;

	}
}