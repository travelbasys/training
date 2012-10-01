package de.travelbasys.training.dialog.customer;

import java.util.List;

import de.travelbasys.training.business.Customer;
import de.travelbasys.training.db.CustomerDAO;
import de.travelbasys.training.util.Config;
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
		Console.println(Config.BUNDLE.getString("AttentionPrompt"));
		do {
			List<Customer> user = null;
			boolean delete = false;
			int decision = 0;
			Console.println(Config.BUNDLE.getString("IDPrompt"));

			// Usernamen einlesen.
			int customerid = Console.nextInt();
			if (customerid == 0) {
				return;
			}
			user = CustomerDAO.findUserByID(customerid);
			if (!user.isEmpty()) {
				Console.println(Config.BUNDLE.getString("UserFound") + user);
				Console.println(Config.BUNDLE.getString("DelUserQ"));
				Console.println("1: " + Config.BUNDLE.getString("Yes"));
				Console.println("2: " + Config.BUNDLE.getString("No"));
				decision = Console.nextInt();
				switch (decision) {
				case 1:
					delete = true;
					break;
				case 2:
					delete = false;
					break;
				default:
					delete = false;
					System.err.println(Config.BUNDLE.getString("ChooseErr"));
					break;
				}
			}
			if (delete) {
				CustomerDAO.delUser(customerid);
			}
			else if(user.isEmpty()){
				Console.printerr(Config.BUNDLE.getString("IDNotFoundErr"));
				Console.println(Config.BUNDLE.getString("DelUserAbort"));
				}
			else {
				Console.println(Config.BUNDLE.getString("DelUserAbort"));

			}

		} while (true);
	}
}
