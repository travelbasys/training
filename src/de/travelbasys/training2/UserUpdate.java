package de.travelbasys.training2;

import java.util.ResourceBundle;
import java.util.Scanner;

public class UserUpdate {

	private static String baseName = "resources.HelloWorld";
	static ResourceBundle bundle = ResourceBundle.getBundle(baseName);
	
	public static void run() {
		do {
			System.out.println(bundle.getString("UsernameShowPrompt"));
			Scanner in = new Scanner(System.in);
			String username = in.nextLine();
			if (username.isEmpty()) {
				return;
			}

			// Wir müssen diesen Namen in der 'Datenbank' suchen.
			// Ergebnis: Ein User-Objekt.
			User user = new User(username);
			System.out.println(user);
			
			// Jetzt nach den neuen Werten fragen und diese in der Datenbank speichern.
		} while (true);
	}

}
