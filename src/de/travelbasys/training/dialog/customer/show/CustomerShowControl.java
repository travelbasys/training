package de.travelbasys.training.dialog.customer.show;

import java.util.List;

import de.travelbasys.training.business.Customer;
import de.travelbasys.training.db.CustomerDAO;
import de.travelbasys.training.util.AppContext;
/**
 * Diese Klasse Kontrolliert Benutzereingaben.
 * 
 * @author tba
 * 
 */
public class CustomerShowControl {

	private CustomerShowModel model;

	public CustomerShowControl(CustomerShowModel model) {
		this.model = model;
	}

	public void check() {

		int customerid = 0;

		// User suchen.
		try {

			customerid = Integer.parseInt(model.getCustomeridtemp());
		} catch (NumberFormatException e) {
			AppContext.printErrString("NumberErr");
			return;

		}
			if (customerid == 0) {
				model.setCustomerid(customerid);
				CustomerShowDialog.end();
				model.setEnd(false);
				model.setGotuser(false);
				return;
			}
			
			model.setCustomerid(customerid);
			List<Customer> user = CustomerDAO.findUserByID(customerid);
			if (!user.isEmpty()) {
				model.setUserlist(user);
				model.setGotuser(false);
				return;
			} else {
				AppContext.printErrString("IDNotFoundErr");
				return;
			}

		
	}
}
