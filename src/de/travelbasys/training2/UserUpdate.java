package de.travelbasys.training2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ResourceBundle;
import java.util.Scanner;

public class UserUpdate {

	private static final String FILE = "HelloWorld.txt";
	private static final String TEMP = "Temp.txt";
	private static final File file = new File("HelloWorld.txt");
	private static final File temp = new File("Temp.txt");


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
				FileWriter fwtmp = new FileWriter(TEMP, true);
				PrintWriter pw = new PrintWriter(fw);
				PrintWriter pwtmp = new PrintWriter(fwtmp);
				BufferedReader br = new BufferedReader(fr);
				String s;
				while ((s = br.readLine()) != null) {
					user = User.parse(s);
					if (user.getName().equals(usershow.getName())) {
						System.out.println("Geben Sie ein neues Alter ein: ");
						int age = in.nextInt();
						user.setAge(age);
						usershow = user;
						System.out.println(usershow);
					}
					pwtmp.println(user);
				}
				fr.close();
				pw.close();
				pwtmp.close();
				file.delete();
				if(!temp.renameTo(file)){
				    System.err.println("Fehler beim Umbenennen der Datei: " + file.getName());
				}
			} catch (Exception e) {
				e.printStackTrace();

			}
		} while (true);
	}

}
