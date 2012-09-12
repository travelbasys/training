package de.travelbasys.training2;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ResourceBundle;
import java.util.Scanner;

/**
 * Diese Klasse wird f�r den Export der Daten aus der HelloWorld.txt Datei in
 * die HelloWorld.csv Datei verwendet.
 * 
 * @author tba
 * */
public class Export {

	private static String CSV = null;

	private static String baseName = "resources.HelloWorld";
	static ResourceBundle bundle = ResourceBundle.getBundle(baseName);

	public static void run(String[] args) {

		System.out.println(bundle.getString("ExportName"));
		Scanner in = new Scanner(System.in);
		CSV = in.nextLine();
		if (CSV.isEmpty()) {
			return;
		}
		try {
			// wird zum schreiben in die csv Datei ben�tigt.
			FileWriter fwcsv = new FileWriter(CSV + ".csv");
			PrintWriter pwcsv = new PrintWriter(fwcsv);

			// gibt die vorhandenen Daten aus und formatiert sie f�r die csv
			// Datei
			pwcsv.println("Name;Age");
			for (User user : UserDB.getUsers()) {
				System.out.println(user);
				pwcsv.println(user.toCSV());
			}
			// Gibt bei erfolgreichem Import eine best�tigung aus
			System.out.println(bundle.getString("ExportOK"));
			pwcsv.close();
		} catch (Exception e) {

		}
	}
}
