package de.travelbasys.training.dialog.customer.Show;

import java.util.List;

import de.travelbasys.training.business.Customer;
import de.travelbasys.training.db.CustomerDAO;
import de.travelbasys.training.util.AppContext;
import de.travelbasys.training.util.Console;

/**
 * Diese Klasse wird für das anzeigen eines einzelnen Benutzers und dessen Alter
 * verwendet.
 * 
 * @author tba
 * 
 */
public class CustomerShow {

	public static void run() {
		do {
			AppContext.println("LastNamePrompt");

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
	}

	public static void run2() {
		AppContext.println("AttentionPrompt");
		do {
			AppContext.println("IDPrompt");

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
				AppContext.getErrString("IDNotFoundErr");
			}
		} while (true);
	}
}
