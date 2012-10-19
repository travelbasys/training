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

	public void check() {

		int customerid = 0;

		// User suchen.
		try {

			customerid = Integer.parseInt(model.getCustomeridtemp());
			if (customerid == 0) {
				model.setCustomerid(customerid);
				CustomerDeleteDialog.end();
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

		} catch (NumberFormatException e) {
			AppContext.getErrString("NumberErr");

		}
	}

	public void checkdelete() {
		try {
			String s = model.getDecisiontemp();
			int decision = Integer.parseInt(s);
			model.setDecision(decision);

		} catch (NumberFormatException e) {
			AppContext.printErrString("NumberErr");
			return;
		}
		int decision = 0;
		decision = model.getDecision();
		if (decision >= 1 && decision <= 2) {
			model.setFlagCheck();
			switch (decision) {
			case 1:
				model.setDeleteFlag(true);
				break;
			case 2:
				model.setDeleteFlag(false);
				break;
			}
		} else {
			AppContext.printErrString("ChooseErr");
			return;
		}

	}

}
