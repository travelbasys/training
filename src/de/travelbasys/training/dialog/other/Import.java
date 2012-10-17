package de.travelbasys.training.dialog.other;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.InputMismatchException;
import java.util.Scanner;

import de.travelbasys.training.business.Customer;
import de.travelbasys.training.db.CustomerDAO;
import de.travelbasys.training.util.AppContext;
import de.travelbasys.training.util.Console;

/**
 * Diese Klasse wird für den Import der Daten aus der HelloWorld.csv Datei in
 * die HelloWorld.txt Datei verwendet.
 * 
 * @author tba
 * */
public class Import {

	private static String CSV = null;

	public static void run() {
		do {
			AppContext.println("Choose");
			AppContext.println("Back");
			AppContext.println("Import1");
			AppContext.println("Import2");
			try {
				int choice_str = Console.nextInt();
				switch (choice_str) {
				case 0:
					return;
				case 1:
					AppContext.println("ImportName");
					Scanner in = new Scanner(System.in);
					CSV = in.nextLine();
					if (CSV.isEmpty()) {
						return;
					}

					try {
						// Wird zum lesen aus der csv Datei benötigt.
						FileReader fr = new FileReader(CSV + ".csv");
						BufferedReader br = new BufferedReader(fr);
						// wird zum schreiben in die txt Datei benötigt.
						CustomerDAO.terminate();
						String s;
						Customer user = null;
						CustomerDAO.getUsers().clear();
						// gibt die vorhandenen Daten aus und formatiert sie für
						// die txt
						// Datei
						br.readLine();
						while ((s = br.readLine()) != null) {
							AppContext.println(s);
							user = Customer.parseCSV(s);
							CustomerDAO.getUsers().add(user);
						}

						// Gibt bei erfolgreichem Import eine bestätigung aus
						AppContext.println("ImportOK");
						fr.close();
					} catch (Exception e) {

					}
					return;
				case 2:
					return;
				default:
					AppContext.printErrString("ChooseErr");
					break;
				}
			} catch (NumberFormatException e) {
				AppContext.printErrString("NumberErr");
			} catch (InputMismatchException e) {
				AppContext.printErrString("NumberErr");
			}
		} while (true);

	}
}
