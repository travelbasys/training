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
public class CustomerShowControl extends Controller {

	private CustomerShowModel model;

	public CustomerShowControl(CustomerShowModel model) {
		this.model = model;
	}

	public void checkCustomerId() {

		// User suchen.
		System.out.println("***** " + model.getCustomerId());
		List<Customer> customers = CustomerDAO.findUserByID(model.getCustomerId());
		System.out.println("***** " + customers);
		
		if (!customers.isEmpty()) {
			model.setCustomer(customers.get(0));
		} else {
			AppContext.printErrString("IDNotFoundErr");
		}

	}
}
