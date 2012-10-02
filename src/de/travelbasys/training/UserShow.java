package de.travelbasys.training;

import java.util.ResourceBundle;
import java.util.Scanner;

import de.travelbasys.training.business.Customer;
import de.travelbasys.training.db.CustomerDAO;
/**
 * Diese Klasse wird für das anzeigen eines einzelnen Benutzers
 * und dessen Alter verwendet.
 * @author tba
 *
 */
public class UserShow {

	private static String baseName = "resources.HelloWorld";
	static ResourceBundle bundle = ResourceBundle.getBundle(baseName);

	public static void run() {

		do {
			Output.println(bundle.getString("UsernameShowPrompt"));

			// Usernamen einlesen.
			Scanner in = new Scanner(System.in);
			String username = in.nextLine();
			if (username.isEmpty()) {
				return;

			}

			Customer user = CustomerDAO.findUserByName(username);
			if (user == null) {
				// Errormeldung
				System.err.println(bundle.getString("NameNotFoundErr"));
				// Schleife fortsetzen.
				continue;
			}
			System.out.println(user);

		} while (true);
	}
}
