package de.travelbasys.training.dialog.menu;

import java.util.Scanner;

import de.travelbasys.training.db.ChangeDB;
import de.travelbasys.training.dialog.customer.CustomerCreate;
import de.travelbasys.training.dialog.customer.CustomerDelete;
import de.travelbasys.training.dialog.customer.CustomerList;
import de.travelbasys.training.dialog.customer.CustomerShow;
import de.travelbasys.training.dialog.customer.CustomerUpdate;
import de.travelbasys.training.dialog.other.ChangeParam;
import de.travelbasys.training.dialog.other.Export;
import de.travelbasys.training.dialog.other.Import;
import de.travelbasys.training.util.Config;
import de.travelbasys.training.util.Console;
import de.travelbasys.training.util.Datum;

/**
 * Diese Klasse gibt Das Hauptmen� aus und startet die Jeweiligen Funktionen.
 * 
 * @author tba
 * 
 */
public class MainMenu {

	private static Scanner in;

	public static void show() {
		in = new Scanner(System.in);
		// Zeigt die verf�gbaren Funktionen an und fordert zur Auswahl auf.
		do {
			Console.println(Config.BUNDLE.getString("Choose"));
			Console.println("0: " + Config.BUNDLE.getString("ExitApp"));
			Console.println("1: " + Config.BUNDLE.getString("App1"));
			Console.println("21: " + Config.BUNDLE.getString("App2a"));
			Console.println("22: " + Config.BUNDLE.getString("App2b"));
			Console.println("3: " + Config.BUNDLE.getString("App3"));
			Console.println("4: " + Config.BUNDLE.getString("App4"));
			Console.println("5: " + Config.BUNDLE.getString("App5"));
			Console.println("6: " + Config.BUNDLE.getString("App6"));
			Console.println("7: " + Config.BUNDLE.getString("App7"));
			Console.println("8: " + Config.BUNDLE.getString("App8"));
			Console.println("9: " + Config.BUNDLE.getString("App9"));
			// Liest die vom Benutzer getroffene Auswahl ein und f�hrt die
			// entsprechende Applikation aus
			try {
				int choice_str = in.nextInt();
				switch (choice_str) {
				case 0:
					return;
				case 1:
					CustomerCreate customer = new CustomerCreate();
					customer.init(new Datum());
					customer.run();
					break;
				case 21:
					CustomerShow.run2();
					break;
				case 22:
					CustomerShow.run();
					break;
				case 3:
					CustomerUpdate.run();
					break;
				case 4:
					CustomerDelete.run();
					break;
				case 5:
					CustomerList.run();
					break;
				case 6:
					Export.run();
					break;
				case 7:
					Import.run();
					break;
				case 8:
					ChangeDB.run();
					break;
				case 9:
					ChangeParam.run();
					break;
				default:
					Console.printerr(Config.BUNDLE.getString("ChooseErr"));
					break;
				}
			} catch (Exception e) {
				Console.printerr(Config.BUNDLE.getString("NumberErr"));
				in.next();
			}
		} while (true);
	}

}
