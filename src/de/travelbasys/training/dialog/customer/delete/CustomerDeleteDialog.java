package de.travelbasys.training.dialog.customer.delete;

import de.travelbasys.training.business.Customer;
import de.travelbasys.training.dialog.customer.delete1.CustomerDelete1Dialog;
import de.travelbasys.training.dialog.customer.find.CustomerFindDialog;
import de.travelbasys.training.dialog.customer.show1.CustomerShow1Dialog;
import de.travelbasys.training.dialog.customer.yesno.YesNoDialog;
import de.travelbasys.training.framework.Dialog;

/**
 * hat die Aufgabe ein vorhandenes Customer Objekt aus der Datenbank zu entfernen.
 * Der Dialog kann optional auch ohne Änderung beendet werden.
 */
public class CustomerDeleteDialog implements Dialog {
	/**
	 * führt den Dialog aus.
	 */
	@Override
	public void run() {
		final String key = "DelUserQ";

		CustomerFindDialog d1 = new CustomerFindDialog();
		d1.run();

		Customer customer = d1.getCustomer();
		int customerid = d1.getCustomerID();
		if (customer == null) {
			return;
		}
		CustomerShow1Dialog d2 = new CustomerShow1Dialog(customer);

		d2.run();

		YesNoDialog d3 = new YesNoDialog(key);
		d3.run();

		if (d3.isYes()) {
			CustomerDelete1Dialog d4 = new CustomerDelete1Dialog();
			d4.setCustomerID(customerid);
			d4.init();
			d4.run();
		}
	}
}
