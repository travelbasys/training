package de.travelbasys.training.dialog.customer.Delete;

import java.util.List;

import de.travelbasys.training.business.Customer;
import de.travelbasys.training.db.CustomerDAO;
import de.travelbasys.training.dialog.Model;
import de.travelbasys.training.util.AppContext;
import de.travelbasys.training.util.Console;

/**
 * Diese Klasse Kontrolliert Benutzereingaben.
 * 
 * @author tba
 * 
 */

public class CustomerDeleteControl {

	private CustomerDeleteModel model;
	private CustomerDeleteView view;

	

	public CustomerDeleteControl(CustomerDeleteModel model,
			CustomerDeleteView view) {
		this.model = model;
		this.view = view;
	}

	public void check(String customeridtemp) {
		List<Customer> user = null;
		boolean delete = false;
		int customerid = 0;

		// User suchen.
		try {
			customerid = Integer.parseInt(customeridtemp);
			user = CustomerDAO.findUserByID(customerid);
			if (customerid == 0) {
				return;
			}
			if (!user.isEmpty()) {
				AppContext.printMessage("UserFound");
				AppContext.println(user);
				AppContext.printMessage("DelUserQ");
				AppContext.printMessage("Yes");
				AppContext.printMessage("No");
				int decision = Console.nextInt();
				switch (decision) {
				case 1:
					delete = true;
					break;
				case 2:
					delete = false;
					break;
				default:
					delete = false;
					AppContext.getErrString("ChooseErr");
					break;
				}
			}

			if (delete) {
				CustomerDAO.delUser(customerid);
				AppContext.printMessage("DelOK");

			}
		} catch (Exception e) {
			AppContext.getErrString("NumberErr");
		}
	}

	public boolean checkend(String customeridtemp) {
		try {
			if (Integer.parseInt(customeridtemp) == 0) {
				return false;
			}
		} catch (Exception e) {
		}

		return true;
	}
}
