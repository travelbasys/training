package de.travelbasys.training.dialog.customer.Delete;

import java.util.List;

import de.travelbasys.training.business.Customer;
import de.travelbasys.training.db.CustomerDAO;
import de.travelbasys.training.util.AppContext;
import de.travelbasys.training.util.Console;

/**
 * Diese Klasse ist für das löschen eines einzelnen Benutzers aus der
 * HelloWorld.txt Datei zuständig.
 * 
 * @author tba
 * 
 */
public class CustomerDelete {

	// Usernamen einlesen, durch UserDB prüfen, ob der Name in der Datenbank
	// liegt.
	// User Objekt aus Datenbank löschen.

	public static void run() {
		AppContext.println("AttentionPrompt");
		do {
			List<Customer> user = null;
			boolean delete = false;
			AppContext.println("IDPrompt");

			// Usernamen einlesen.
			try {
				int customerid = Console.nextInt();
				if (customerid == 0) {
					return;
				}
				user = CustomerDAO.findUserByID(customerid);
				if (!user.isEmpty()) {
					AppContext.println("UserFound");
					AppContext.println(user);
					AppContext.println("DelUserQ");
					AppContext.println("Yes");
					AppContext.println("No");
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
					AppContext.println("DelOK");
				} else if (user.isEmpty()) {
					AppContext.getErrString("IDNotFoundErr");
					AppContext.println("DelUserAbort");
				} else {
					AppContext.println("DelUserAbort");

				}
			} catch (Exception e) {
				AppContext.getErrString("NumberErr");
			}

		} while (true);
	}
}
