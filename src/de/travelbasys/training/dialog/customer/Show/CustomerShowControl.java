package de.travelbasys.training.dialog.customer.Show;

import java.util.List;

import de.travelbasys.training.business.Customer;
import de.travelbasys.training.db.CustomerDAO;
import de.travelbasys.training.util.AppContext;
import de.travelbasys.training.util.Console;

public class CustomerShowControl {

	public CustomerShowControl(CustomerShowModel model, CustomerShowView view) {
	}

	public void checkchoice(String choice_str) {
		try {
			int choice_int = Integer.parseInt(choice_str);
			if (choice_int >= 0 && choice_int <= 2) {
				switch (choice_int) {
				case 0:
					return;
				case 1:
					AppContext.printErrString("AttentionStringPrompt");
					do {
						AppContext.printErrString("LastNamePrompt");

						// Usernamen einlesen.
						String lastname = Console.nextLine();
						if (lastname.isEmpty()) {
							return;
						}

						@SuppressWarnings("unused")
						List<Customer> user = CustomerDAO.findUserByLastName(lastname);
						for (Customer customer : CustomerDAO.getCustomers()) {
							AppContext.println(customer);
						}
					} while (true);
				case 2:
					AppContext.printMessage("AttentionIntPrompt");
					do {
						AppContext.printMessage("IDPrompt");

						// Usernamen einlesen.
						int customerid = Console.nextInt();
						if (customerid == 0) {
							return;
						}
						@SuppressWarnings("unused")
						List<Customer> user = CustomerDAO.findUserByID(customerid);
						for (Customer customer : CustomerDAO.getCustomers()) {
							AppContext.println(customer);
						}
						if (CustomerDAO.getCustomers().isEmpty()) {
							AppContext.printErrString("IDNotFoundErr");
						}
					} while (true);
				default:
					AppContext.printErrString("ChooseErr");
					break;
				}
			} else {
				AppContext.printErrString("ChooseErr");
			}
		} catch (Exception e) {
			AppContext.printErrString("NumberErr");
		}
	}

	public boolean checkend(String choice_str) {
		try {
			if (Integer.parseInt(choice_str) == 0) {
				return false;
			}
		} catch (Exception e) {
		}

		return true;
	}
}
