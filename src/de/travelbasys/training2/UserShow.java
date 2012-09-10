package de.travelbasys.training2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ResourceBundle;
import java.util.Scanner;

public class UserShow {

	private static final String FILE = "HelloWorld.txt";

	private static String baseName = "resources.HelloWorld";
	static ResourceBundle bundle = ResourceBundle.getBundle(baseName);

	public static void run() {
		User user = null;
		User usershow = null;

		// Wir müssen diesen Namen in der 'Datenbank' suchen.
		// Ergebnis: Ein User-Objekt.
		// Muss in Schleife eingebaut sein.

		do {
			try {
				System.out.println(bundle.getString("UsernameShowPrompt"));
				Scanner in = new Scanner(System.in);
				String username = in.nextLine();
				if (username.isEmpty()) {
					return;
				}
				usershow = new User(username);
				FileReader fr = new FileReader(FILE);
				BufferedReader br = new BufferedReader(fr);
				String s;
				while ((s = br.readLine()) != null) {
					user = User.parse(s);
					if (user.getName().equals(usershow.getName())) {
						usershow = user;
						System.out.println(usershow);
					}
				}
				fr.close();

			} catch (Exception e) {
				e.printStackTrace();

			}
			System.out.println(usershow);
		} while (true);
	}
}
