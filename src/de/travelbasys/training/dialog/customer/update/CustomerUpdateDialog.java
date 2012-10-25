package de.travelbasys.training.dialog.customer.update;

import de.travelbasys.training.business.Customer;
import de.travelbasys.training.db.CustomerDAO;
import de.travelbasys.training.dialog.customer.find.CustomerFindDialog;
import de.travelbasys.training.dialog.customer.showandchange.ShowAndChangeDialog;
import de.travelbasys.training.dialog.customer.yesno.YesNoDialog;
import de.travelbasys.training.framework.Dialog;

/**
 * hat die Aufgabe ein vorhandenes Customer Objekt aus der Datenbank zu ändern.
 * Der Dialog kann optional auch ohne Änderung beendet werden.
 */
public class CustomerUpdateDialog implements Dialog {

	private static final String KEY = "SaveQ";

	/**
	 * führt den Dialog aus.
	 */
	@Override
	public void run() {
		CustomerFindDialog d1 = new CustomerFindDialog();
		d1.init();
		d1.run();

		Customer customer = d1.getCustomer();
		if (customer == null) {
			return;
		}
		ShowAndChangeDialog d2 = new ShowAndChangeDialog();
		d2.setCustomer(customer);
		d2.init();
		d2.run();

		YesNoDialog d3 = new YesNoDialog();
		d3.init(KEY);
		d3.run();

		if (d3.isYes() == true) {
			int customerid = customer.getId();
			CustomerDAO.replaceUser(customerid, customer);
		}

	}
}
