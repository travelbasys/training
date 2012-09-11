package de.travelbasys.training2;

import java.util.ResourceBundle;
import java.util.Scanner;

public class UserDelete {

	private static String baseName = "resources.HelloWorld";
	static ResourceBundle bundle = ResourceBundle.getBundle(baseName);

	// Usernamen einlesen, durch UserDB pr�fen, ob der Name in der Datenbank liegt.
	// User Objekt aus Datenbank l�schen.
	
	public static void run() {
		do {
			System.out.println(bundle.getString("UsernameShowPrompt"));

			// Usernamen einlesen.
			Scanner in = new Scanner(System.in);
			String username = in.nextLine();
			if (username.isEmpty()) {
				return;

			}
			User user = UserDB.deleteUserByName(username);
			//Hier musst gel�scht werden bzw. L�schfunktion aufgerufen / gebaut werden, ma gucken.
			if (user == null) {
				// Errormeldung
				System.err.println(bundle.getString("NameNotFoundErr"));
				// Schleife fortsetzen.
				continue;
			}

		} while (true);
	}
}
