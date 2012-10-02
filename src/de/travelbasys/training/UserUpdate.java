package de.travelbasys.training;

import java.util.ResourceBundle;
import java.util.Scanner;

import de.travelbasys.training.business.Customer;
import de.travelbasys.training.db.CustomerDAO;
/**
 * 
 * Diese Klasse ändert das Alter eines anhand des Namens gesuchten User Objektes.
 * 
 * @author tba
 *
 */
public class UserUpdate {

	private static String baseName = "resources.HelloWorld";
	static ResourceBundle bundle = ResourceBundle.getBundle(baseName);

	/**
	 * 
	 */
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

			// Alten Wert zur Kontrolle ausgeben.
			Output.println("Alter Wert: " + user.getAge());

			// Nach neuem Wert fragen.
			Output.println("Geben Sie ein neues Alter ein: ");
			int age = in.nextInt();

			user.setAge(age);

		} while (true);
	}

}
