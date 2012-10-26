package de.travelbasys.training.dialog.customer.delete.manager;

import de.travelbasys.training.business.Customer;
import de.travelbasys.training.db.CustomerDAO;
import de.travelbasys.training.dialog.customer.delete.action.CustomerDeleteActionDialog;
import de.travelbasys.training.dialog.customer.find.CustomerFindDialog;
import de.travelbasys.training.dialog.customer.show1.CustomerShow1Dialog;
import de.travelbasys.training.dialog.customer.yesno.YesNoDialog;
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
		CustomerShow1Dialog d2 = new CustomerShow1Dialog(customer);

		d2.run();

		YesNoDialog d3 = new YesNoDialog(KEY);
		d3.run();
		

		if (d3.isYes()) {
			int customerid = d1.getCustomerID();
			boolean success;
			try {
				CustomerDAO.delUser(customerid);
				success = true;
			} catch (Exception e) {
				success = false;
			}
			CustomerDeleteActionDialog d4 = new CustomerDeleteActionDialog(success);
			d4.run();
		}else{
			AppContext.printMessage("Abort");
		}
		
	}
}
