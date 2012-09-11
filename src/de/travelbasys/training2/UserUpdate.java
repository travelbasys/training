package de.travelbasys.training2;

import java.util.ResourceBundle;
import java.util.Scanner;

public class UserUpdate {

	private static String baseName = "resources.HelloWorld";
	static ResourceBundle bundle = ResourceBundle.getBundle(baseName);

	/**
	 * 
	 */
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

			// Alten Wert zur Kontrolle ausgeben.
			System.out.println("Alter Wert: " + user.getAge());

			// Nach neuem Wert fragen.
			System.out.println("Geben Sie ein neues Alter ein: ");
			int age = in.nextInt();

			user.setAge(age);

			// Datenbank wird mit neuem User upgedated.
			UserDB.update(user);

		} while (true);
	}

}
