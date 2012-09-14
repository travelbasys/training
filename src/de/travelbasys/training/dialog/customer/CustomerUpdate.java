package de.travelbasys.training.dialog.customer;

import java.util.List;
import java.util.Scanner;

import de.travelbasys.training.business.Customer;
import de.travelbasys.training.db.CustomerDAO;
import de.travelbasys.training.util.Config;
import de.travelbasys.training.util.Console;

/**
 * 
 * Diese Klasse ändert das Alter eines anhand des Namens gesuchten User
 * Objektes.
 * 
 * @author tba
 * 
 */
public class CustomerUpdate {

	/**
	 * 
	 */
	public static void run() {

		do {
			Console.println(Config.BUNDLE.getString("UsernameShowPrompt"));

			// Usernamen einlesen.
			Scanner in = new Scanner(System.in);
			String username = in.nextLine();
			if (username.isEmpty()) {
				return;
			}

			List<Customer> user = CustomerDAO.findUserByLastName(username);
			if (user == null) {
				// Errormeldung
				System.err.println(Config.BUNDLE.getString("NameNotFoundErr"));
				// Schleife fortsetzen.
				continue;
			}

			// Alten Wert zur Kontrolle ausgeben.
			// Console.println("Alter Wert: " + user.getAge());

			// Nach neuem Wert fragen.
			Console.println("Geben Sie ein neues Alter ein: ");
			int age = in.nextInt();

			// user.setAge(age);

		} while (true);
	}

}
