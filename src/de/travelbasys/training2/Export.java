package de.travelbasys.training2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ResourceBundle;
import java.util.Scanner;
/**
 * Diese Klasse wird f�r den Export der Daten aus der HelloWorld.txt
 * Datei in die HelloWorld.csv Datei verwendet.
 * @author tba
 * */
public class Export {

	private static final String FILE = "HelloWorld.txt";
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

			// Wird zum lesen aus der txt Datei ben�tigt.
			FileReader fr = new FileReader(FILE);
			BufferedReader br = new BufferedReader(fr);

			// wird zum schreiben in die csv Datei ben�tigt.
			FileWriter fwcsv = new FileWriter(CSV + ".csv");
			PrintWriter pwcsv = new PrintWriter(fwcsv);

			String s;
			User tempUser;
			// gibt die vorhandenen Daten aus und formatiert sie f�r die csv
			// Datei
			while ((s = br.readLine()) != null) {
				System.out.println(s);
				tempUser = User.parse(s);
				pwcsv.println(tempUser.toCSV());
			}
			// Gibt bei erfolgreichem Import eine best�tigung aus
			System.out.println(bundle.getString("ExportOK"));
			fr.close();
			pwcsv.close();
		} catch (Exception e) {

		}
	}
}
