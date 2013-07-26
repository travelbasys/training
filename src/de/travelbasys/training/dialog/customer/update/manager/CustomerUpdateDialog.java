package de.travelbasys.training.dialog.customer.update.manager;

import de.travelbasys.training.business.Customer;
import de.travelbasys.training.dao.CustomerDaoException;
import de.travelbasys.training.dao.Dao;
import de.travelbasys.training.dialog.customer.common.find.CustomerFindDialog;
import de.travelbasys.training.dialog.customer.common.yesno.YesNoDialog;
import de.travelbasys.training.dialog.customer.update.attributes.CustomerAttributesUpdateDialog;
import de.travelbasys.training.framework.Dialog;

/**
 * hat die Aufgabe ein vorhandenes Customer Objekt aus der Datenbank zu �ndern.
 * Der Dialog kann optional auch ohne �nderung beendet werden.
 * 
 * <ol>
 * <li>{@link CustomerFindDialog} findet ein {@link Customer} Objekt.
 * <li>{@link CustomerAttributesUpdateDialog} gibt {@link Customer} Objekt aus und l�sst
 * seine Attribute �ndern.
 * <li>{@link YesNoDialog} fragt ob {@link Customer} in die Datenbank geschrieben
 * werden soll.
 * </ol>
 */
public class CustomerUpdateDialog implements Dialog {

	private static String KEY;

	/**
	 * f�hrt den Dialog aus.
	 */
	@Override
	public void run() {
		YesNoDialog d3;
		// Find
		CustomerFindDialog d1 = new CustomerFindDialog();
		d1.run();

		Customer customer = d1.getCustomer();
		if (customer == null) {
			return;
		}

		// Show and Change
		CustomerAttributesUpdateDialog d2 = new CustomerAttributesUpdateDialog(
				customer);
		d2.run();

		if (d2.getDirtyFlag()) {
			try {
				Dao.getDAO().getExisting(customer);
			} catch (CustomerDaoException e) {
				e.printcustomererr();
				return;
			}
		}

		// Yes or No
		KEY = "SaveQ";
		d3 = new YesNoDialog(KEY);
		d3.run();
		if (d3.isYes()) {
			try {
				Dao.getDAO().update(customer);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}
}
