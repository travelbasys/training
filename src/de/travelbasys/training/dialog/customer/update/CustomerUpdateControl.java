package de.travelbasys.training.dialog.customer.update;

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

public class CustomerUpdateControl {
	private CustomerUpdateModel model;

	public CustomerUpdateControl(CustomerUpdateModel model) {
		this.model = model;

	}

	// throw (numberformatexception)
	public void check() {
		try {
			String s = model.getCustomeridtemp();
			int customerid = Integer.parseInt(s);
			if (customerid == 0) {
				model.setCustomerid(customerid);
				CustomerUpdateDialog.end();
				model.setend(false);
				return;
			}
			model.setCustomerid(customerid);
		} catch (NumberFormatException e) {
			AppContext.printErrString("NumberErr");
			return;
		}
		int customerid = model.getCustomerid();
		
		List<Customer> user = CustomerDAO.findUserByID(customerid);
		if (user.isEmpty()) { // Errormeldung
			AppContext.printErrString("IDNotFoundErr");
			return;
		}
		model.setUser(user);
		model.setCont(true);
		model.setend(false);
		return;
	}

	public int checkmenu() {

		do {

			try {
				String s = model.getChoice_str();
				int choice_int = Integer.parseInt(s);
				model.setChoice_int(choice_int);

				switch (choice_int) {
				case 0:
					CustomerUpdateDialog.end();
					return 0;
				case 1:
					CustomerUpdateDialog.setFirstname();
					break;
				case 2:
					CustomerUpdateDialog.setLastname();
					break;
				case 3:
					CustomerUpdateDialog.setAge();
					break;
				case 4:
					CustomerUpdateDialog.setAdress();
					break;
				case 5:
					CustomerUpdateDialog.setPostalcode();
					break;
				case 6:
					CustomerUpdateDialog.setEmail();
					break;
				default:
					AppContext.printErrString("ChooseErr");
					return 1;
				}
			} catch (NumberFormatException e) {
				AppContext.printErrString("NumberErr");
			}
				return 1;
			

		} while (true);

	}

	public boolean checkend() {
		return false;
	}

}