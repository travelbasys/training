package de.travelbasys.training.dialog.other;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;

import de.travelbasys.training.business.Customer;
import de.travelbasys.training.db.CustomerDAO;
import de.travelbasys.training.util.Config;
import de.travelbasys.training.util.Console;

/**
 * Diese Klasse wird für den Export der Daten aus der HelloWorld.txt Datei in
 * die HelloWorld.csv Datei verwendet.
 * 
 * @author tba
 * */
public class Export {

	private static String CSV = null;

	public static void run(String[] args) {

		Console.println(Config.BUNDLE.getString("ExportName"));
		Scanner in = new Scanner(System.in);
		CSV = in.nextLine();
		if (CSV.isEmpty()) {
			return;
		}
		try {
			// wird zum schreiben in die csv Datei benötigt.
			FileWriter fwcsv = new FileWriter(CSV + ".csv");
			PrintWriter pwcsv = new PrintWriter(fwcsv);

			// gibt die vorhandenen Daten aus und formatiert sie für die csv
			// Datei
			pwcsv.println("UserID;LastName;FirstName;Age;Adress;Postalcode;eMail");
			for (Customer user : CustomerDAO.getUsers()) {
				System.out.println(user);
				pwcsv.println(user.toCSV());
			}
			// Gibt bei erfolgreichem Import eine bestätigung aus
			Console.println(Config.BUNDLE.getString("ExportOK"));
			pwcsv.close();
		} catch (Exception e) {

		}
	}
}
