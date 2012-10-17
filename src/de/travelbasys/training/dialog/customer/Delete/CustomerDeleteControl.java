package de.travelbasys.training.dialog.customer.Delete;

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

public class CustomerDeleteControl {

	private CustomerDeleteModel model;

	public CustomerDeleteControl(CustomerDeleteModel model) {
		this.model = model;
	}

	public void check(String customeridtemp) throws Exception {

		int customerid = 0;

		// User suchen.
		try {
			model.getCustomeridtemp();
			customerid = Integer.parseInt(customeridtemp);
			model.setCustomerid(customerid);
			List<Customer> user = CustomerDAO.findUserByID(customerid);
			model.setUserlist(user);
			return;
		} catch (Exception e) {
			throw new Exception(AppContext.getErrString("NumberErr"));
		}
	}

	public void checkdelete() {
		boolean delete = false;

		String s = model.getDecisiontemp();
		int decision = Integer.parseInt(s);
		switch (decision) {
		case 1:
			delete = true;
			break;
		case 2:
			delete = false;
			break;
		default:
			delete = false;
			AppContext.printErrString("ChooseErr");
			break;
		}
		model.setDeleteFlag(delete);
	}
}
