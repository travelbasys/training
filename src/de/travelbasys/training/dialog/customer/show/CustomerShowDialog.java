package de.travelbasys.training.dialog.customer.show;

import de.travelbasys.training.business.Customer;
import de.travelbasys.training.dialog.customer.find.CustomerFindDialog;
import de.travelbasys.training.dialog.customer.show1.CustomerShow1Dialog;
import de.travelbasys.training.framework.Dialog;

/**
 * hat die Aufgabe ein vorhandenes Customer Objekt aus der Datenbank zu finden
 * und anzuzeigen.
 */
public class CustomerShowDialog implements Dialog {
	@Override
	public void run() {

		CustomerFindDialog d1 = new CustomerFindDialog();
		d1.init();
		d1.run();

		Customer customer = d1.getCustomer();

		CustomerShow1Dialog d2 = new CustomerShow1Dialog();
		d2.setCustomer(customer);
		d2.init();
		d2.run();
	}

}
