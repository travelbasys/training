package de.travelbasys.training2;

import java.util.ResourceBundle;
import java.util.Scanner;

public class UserDelete {

	private static String baseName = "resources.HelloWorld";
	static ResourceBundle bundle = ResourceBundle.getBundle(baseName);

	// Usernamen einlesen, durch UserDB prüfen, ob der Name in der Datenbank
	// liegt.
	// User Objekt aus Datenbank löschen.

	public static void run() {
	
		do {
			User user = null;
			boolean delete = false;
			int decision = 0;
			System.out.println(bundle.getString("UsernameShowPrompt"));

			// Usernamen einlesen.
			Scanner in = new Scanner(System.in);
			String username = in.nextLine();
			if (username.isEmpty()) {
				return;

			}
			user = UserDB.findUserByName(username);
			if (user != null) {
				System.out.println(bundle.getString("UserFound") + user);
				System.out.println(bundle.getString("DelUserQ"));
				System.out.println("1: " + bundle.getString("Yes"));
				System.out.println("2: " + bundle.getString("No"));
				decision = in.nextInt();
				switch (decision) {
				case 1:
					delete = true;
					break;
				case 2:
					delete = false;
					break;
				default:
					delete = false;
					System.err.println(bundle.getString("ChooseErr"));
					break;
				}
			}
			if (delete) {
				user = UserDB.deleteUserByName(username);
			} else {
				System.out.println(bundle.getString("DelUserAbort"));

			}
			// Hier muss gelöscht werden bzw. Löschfunktion aufgerufen / gebaut
			// werden, ma gucken.
			if (user == null) {
				// Errormeldung
				System.err.println(bundle.getString("NameNotFoundErr"));
				// Schleife fortsetzen.
				continue;
			}

		} while (true);
	}
}
