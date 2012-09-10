package de.travelbasys.training2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ResourceBundle;
import java.util.Scanner;

public class UserUpdate {

	private static final String FILE = "HelloWorld.txt";

	private static String baseName = "resources.HelloWorld";
	static ResourceBundle bundle = ResourceBundle.getBundle(baseName);

	public static void run() {
		User user = null;
		User usershow = null;

		// Wir müssen diesen Namen in der 'Datenbank' suchen.
		// Ergebnis: Ein User-Objekt.
		// Muss in Schleife eingebaut sein.
		// Jetzt nach den neuen Werten fragen und diese in der Datenbank
		// speichern.

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
				FileWriter fw = new FileWriter(FILE, true);
				PrintWriter writer = new PrintWriter(fw);
				BufferedReader br = new BufferedReader(fr);
				String s;
				while ((s = br.readLine()) != null) {
					user = User.parse(s);
					if (user.getName().equals(usershow.getName())) {
						System.out.println("Geben Sie ein neues Alter ein: ");
						int age = in.nextInt();
						user.setAge(age);
					}
					// Hängt Daten an die Datei an.
					// Überschreibt die Datei jedoch nicht wie vorgesehen.
					// Es enstehen Redundanzen.
					writer.println(user);
				}
				fr.close();
				writer.close();

			} catch (Exception e) {
				e.printStackTrace();

			}
		} while (true);

	}

}
