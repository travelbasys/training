package de.travelbasys.training;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ResourceBundle;
import java.util.Scanner;

import de.travelbasys.training.business.Customer;
import de.travelbasys.training.db.CustomerDAO;

/**
 * Diese Klasse wird f�r den Import der Daten aus der HelloWorld.csv Datei in
 * die HelloWorld.txt Datei verwendet.
 * 
 * @author tba
 * */
public class Import {

	private static String CSV = null;

	private static String baseName = "resources.HelloWorld";
	static ResourceBundle bundle = ResourceBundle.getBundle(baseName);

	public static void run(String[] args) {

		Output.println(bundle.getString("ImportName"));
		Scanner in = new Scanner(System.in);
		CSV = in.nextLine();
		if (CSV.isEmpty()) {
			return;
		}

		try {
			// Wird zum lesen aus der csv Datei ben�tigt.
			FileReader fr = new FileReader(CSV + ".csv");
			BufferedReader br = new BufferedReader(fr);
			// wird zum schreiben in die txt Datei ben�tigt.
			CustomerDAO.terminate();
			String s;
			Customer user = null;
			CustomerDAO.getUsers().clear();
			// gibt die vorhandenen Daten aus und formatiert sie f�r die txt
			// Datei
			br.readLine();
			while ((s = br.readLine()) != null) {
				Output.println(s);
				user = Customer.parseCSV(s);
				CustomerDAO.getUsers().add(user);
			}

			// Gibt bei erfolgreichem Import eine best�tigung aus
			Output.println(bundle.getString("ImportOK"));
			fr.close();
		} catch (Exception e) {

		}
	}
}
