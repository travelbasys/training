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
import de.travelbasys.training.util.AppContext;
import de.travelbasys.training.util.Datum;

/**
 * Diese Klasse gibt Das Hauptmenü aus und startet die Jeweiligen Funktionen.
 * 
 * @author tba
 * 
 */
public class MainMenu {

	private static Scanner in;

	public static void show() {
		// Zeigt die verfügbaren Funktionen an und fordert zur Auswahl auf.
		do {
			AppContext.getString("Choose");
			AppContext.getString("ExitApp");
			AppContext.getString("App1");
			AppContext.getString("App2a");
			AppContext.getString("App2b");
			AppContext.getString("App3");
			AppContext.getString("App4");
			AppContext.getString("App5");
			AppContext.getString("App6");
			AppContext.getString("App7");
			AppContext.getString("App8");
			AppContext.getString("App9");
			// Liest die vom Benutzer getroffene Auswahl ein und führt die
			// entsprechende Applikation aus
			try {
				in = new Scanner(System.in);
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
					AppContext.getErrString("ChooseErr");
					break;
				}
			} catch (Exception e) {
				AppContext.getErrString("NumberErr");
			}
		} while (true);
	}

}
