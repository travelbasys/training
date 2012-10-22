package de.travelbasys.training.dialog.customer.delete;

import de.travelbasys.training.business.Customer;
import de.travelbasys.training.dialog.customer.delete1.CustomerDelete1Dialog;
import de.travelbasys.training.dialog.customer.find.CustomerFindDialog;
import de.travelbasys.training.dialog.customer.show1.CustomerShow1Dialog;
import de.travelbasys.training.dialog.customer.yesno.YesNoDialog;
import de.travelbasys.training.framework.Dialog;

/**
 * ist verantwortlich für das löschen eines Benutzers aus der Datenbank
 * 
 * @author tba
 * 
 */
public class CustomerDeleteDialog implements Dialog {

	@Override
	public void run() {
		{

			CustomerFindDialog d1 = new CustomerFindDialog();
			d1.init();
			d1.run();

			Customer customer = d1.getCustomer();
			int customerid = d1.getCustomerID();
			if (customer == null) {
				return;
			}
			CustomerShow1Dialog d2 = new CustomerShow1Dialog();
			d2.setCustomer(customer);
			d2.init();
			d2.run();

			YesNoDialog d3 = new YesNoDialog();
			d3.run();

			if (d3.getFlag()) {
				CustomerDelete1Dialog d4 = new CustomerDelete1Dialog();
				d4.setCustomerID(customerid);
				d4.init();
				d4.run();
			}
		}
	}
}