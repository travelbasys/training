package de.travelbasys.training2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ResourceBundle;
import java.util.Scanner;
/**
 * Diese Klasse wird für den Import der Daten aus der HelloWorld.csv
 * Datei in die HelloWorld.txt Datei verwendet.
 * @author tba
 * */
public class Import {

	private static final String FILE = "HelloWorld.txt";
	private static String CSV = null;

	private static String baseName = "resources.HelloWorld";
	static ResourceBundle bundle = ResourceBundle.getBundle(baseName);

	public static void run(String[] args) {
		
		System.out.println(bundle.getString("ImportName"));
		Scanner in = new Scanner(System.in);
		CSV = in.nextLine();
		if (CSV.isEmpty()) {
			return;
		}
		
		try {
			// Wird zum lesen aus der csv Datei benötigt.
			FileReader fr = new FileReader(CSV +".csv");
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
