package de.travelbasys.training.dialog.customer.show;

import de.travelbasys.training.business.Customer;
import de.travelbasys.training.dialog.customer.common.find.CustomerFindDialog;
import de.travelbasys.training.dialog.customer.common.print.CustomerPrintDialog;
import de.travelbasys.training.framework.Dialog;

/**
 * hat die Aufgabe ein Customer Objekt anhand der Eingabe des Benutzers ({@link
 * CustomerFindDialog}) zu suchen und es, falls vorhanden, anzuzeigen..
 */
public class CustomerShowDialog implements Dialog {
	@Override
	public void run() {

		CustomerFindDialog d1 = new CustomerFindDialog();
		d1.run();

		Customer customer = d1.getCustomer();

		CustomerPrintDialog d2 = new CustomerPrintDialog(customer);
		d2.run();
	}

}
