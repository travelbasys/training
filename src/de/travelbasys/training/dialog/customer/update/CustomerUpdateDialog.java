package de.travelbasys.training.dialog.customer.update;

import de.travelbasys.training.business.Customer;
import de.travelbasys.training.db.CustomerDAO;
import de.travelbasys.training.dialog.customer.find.CustomerFindDialog;
import de.travelbasys.training.dialog.customer.showandchange.ShowAndChangeDialog;
import de.travelbasys.training.dialog.customer.showandchange.ShowAndChangeModel;
import de.travelbasys.training.dialog.customer.yesno.YesNoDialog;
import de.travelbasys.training.framework.Dialog;

/**
 * 
 */
public class CustomerUpdateDialog implements Dialog {
	private ShowAndChangeModel model;

	@Override
	public void run() {
		final String key = "SaveQ";

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
		d3.init(key);
		d3.run();

		if (d3.getFlag() == true) {
			this.model=ShowAndChangeDialog.getModel();
			int customerid = customer.getUserID();
			customer = model.getCustomer();
			CustomerDAO.replaceUser(customerid, customer);
		}
	}
}
