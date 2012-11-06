package de.travelbasys.training.dialog.customer.delete.manager;

import de.travelbasys.training.business.Customer;
import de.travelbasys.training.dao.CustomerDAO;
import de.travelbasys.training.dialog.customer.common.find.CustomerFindDialog;
import de.travelbasys.training.dialog.customer.common.print.CustomerPrintDialog;
import de.travelbasys.training.dialog.customer.common.yesno.YesNoDialog;
import de.travelbasys.training.framework.Dialog;
import de.travelbasys.training.util.AppContext;

/**
 * hat die Aufgabe ein vorhandenes Customer Objekt aus der Datenbank zu
 * entfernen. Der Dialog kann optional auch ohne Änderung beendet werden.
 */
public class CustomerDeleteDialog implements Dialog {
	/**
	 * führt den Dialog aus.
	 */
	@Override
	public void run() {
		final String KEY = "DelUserQ";

		CustomerFindDialog d1 = new CustomerFindDialog();
		d1.run();

		Customer customer = d1.getCustomer();
		if (customer == null) {
			return;
		}
		CustomerPrintDialog d2 = new CustomerPrintDialog(customer);

		d2.run();

		YesNoDialog d3 = new YesNoDialog(KEY);
		d3.run();

		if (d3.isYes()) {
			// Löscht den gesuchten Customer.
			// Anmerkung: Es wird keine Exception erzeugt, da der Customer an
			// dieser Stelle 100% feststeht.
			CustomerDAO.delete(customer);
			AppContext.printMessage("DelOK");
		} else {
			AppContext.printMessage("Abort");
		}

	}
}
