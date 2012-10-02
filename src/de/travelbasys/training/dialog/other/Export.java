package de.travelbasys.training.dialog.other;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.InputMismatchException;
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

	public static void run() {
		Console.println(Config.BUNDLE.getString("Choose"));
		Console.println("0: " + Config.BUNDLE.getString("Back"));
		Console.println("1: " + Config.BUNDLE.getString("Export1"));
		Console.println("2: " + Config.BUNDLE.getString("Export2"));
		int choice_str = Console.nextInt();
		try {
			switch (choice_str) {
			case 0:
				return;
			case 1:
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

					// gibt die vorhandenen Daten aus und formatiert sie für die
					// csv
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
				return;
			case 2:
				return;
			default:
				Console.printerr(Config.BUNDLE.getString("ChooseErr"));
				break;
			}
		} catch (NumberFormatException e) {
			Console.printerr(Config.BUNDLE.getString("NumberErr"));
		} catch (InputMismatchException e) {
			Console.printerr(Config.BUNDLE.getString("NumberErr"));
		}

	}
}
