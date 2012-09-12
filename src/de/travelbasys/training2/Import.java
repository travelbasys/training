package de.travelbasys.training2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ResourceBundle;

public class Import {

	private static final String FILE = "HelloWorld.txt";
	private static final String CSV = "HelloWorld.csv";

	private static String baseName = "resources.HelloWorld";
	static ResourceBundle bundle = ResourceBundle.getBundle(baseName);

	public static void run(String[] args) {
		try {
			// Wird zum lesen aus der csv Datei benötigt.
			FileReader fr = new FileReader(CSV);
			BufferedReader br = new BufferedReader(fr);
			// wird zum schreiben in die txt Datei benötigt.
			FileWriter fw = new FileWriter(FILE);
			PrintWriter pw = new PrintWriter(fw);

			String s;
			User tempUser;
			// gibt die vorhandenen Daten aus und formatiert sie für die txt Datei
			while ((s = br.readLine()) != null) {
				System.out.println(s);
				tempUser = User.parseCSV(s);
				pw.println(tempUser.toString());
			}
			// Gibt bei erfolgreichem Import eine bestätigung aus
			System.out.println(bundle.getString("ImportOK"));
			fr.close();
			pw.close();
		} catch (Exception e) {

		}
	}
}
