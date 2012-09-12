package de.travelbasys.training2;

import java.util.ResourceBundle;
import java.util.Scanner;
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
			System.out.println(bundle.getString("UsernameShowPrompt"));

			// Usernamen einlesen.
			Scanner in = new Scanner(System.in);
			String username = in.nextLine();
			if (username.isEmpty()) {
				return;

			}

			User user = UserDB.findUserByName(username);
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
