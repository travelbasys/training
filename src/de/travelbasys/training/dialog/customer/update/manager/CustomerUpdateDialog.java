package de.travelbasys.training.dialog.customer.update.manager;

import de.travelbasys.training.business.Customer;
import de.travelbasys.training.db.CustomerDAO;
import de.travelbasys.training.dialog.customer.find.CustomerFindDialog;
import de.travelbasys.training.dialog.customer.update.attributes.CustomerAttributesUpdateDialog;
import de.travelbasys.training.dialog.customer.yesno.YesNoDialog;
import de.travelbasys.training.framework.Dialog;

/**
 * hat die Aufgabe ein vorhandenes Customer Objekt aus der Datenbank zu ändern.
 * Der Dialog kann optional auch ohne Änderung beendet werden.
 * 
 * <ol>
 * 	<li>{@see CustomerFindDialog} findet ein {@see Customer} Objekt.
 * 	<li>{@see ShowAndChangeDialog} gibt {@see Customer} Objekt aus und lässt seine Attribute ändern.
 * 	<li>{@see YesNoDialog} fragt ob {@see Customer} in die Datenbank geschrieben werden soll.
 * </ol>
 */
public class CustomerUpdateDialog implements Dialog {

	private static final String KEY = "SaveQ";

	/**
	 * führt den Dialog aus.
	 */
	@Override
	public void run() {
		//Find
		CustomerFindDialog d1 = new CustomerFindDialog();
		d1.run();

		Customer customer = d1.getCustomer();
		if (customer == null) {
			return;
		}
		
		// Show and Change
		CustomerAttributesUpdateDialog d2 = new CustomerAttributesUpdateDialog(customer);
		d2.run();

		// Yes or No
		YesNoDialog d3 = new YesNoDialog(KEY);
		d3.run();

		if (d3.isYes() == true) {
			// Replace customer
			int customerid = customer.getId();
			CustomerDAO.replaceUser(customerid, customer);
		}

	}
}
