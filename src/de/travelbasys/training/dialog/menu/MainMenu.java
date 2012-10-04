package de.travelbasys.training.dialog.menu;

import java.util.Scanner;

import de.travelbasys.training.db.ChangeDB;
import de.travelbasys.training.dialog.customer.CustomerCreateDialog;
import de.travelbasys.training.dialog.customer.CustomerCreateView;
import de.travelbasys.training.dialog.customer.CustomerDelete;
import de.travelbasys.training.dialog.customer.CustomerList;
import de.travelbasys.training.dialog.customer.CustomerShow;
import de.travelbasys.training.dialog.customer.CustomerUpdate;
import de.travelbasys.training.dialog.other.ChangeParam;
import de.travelbasys.training.dialog.other.Export;
import de.travelbasys.training.dialog.other.Import;
import de.travelbasys.training.util.AppContext;

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
			AppContext.printMessage("Choose");
			AppContext.printMessage("ExitApp");
			AppContext.printMessage("App1");
			AppContext.printMessage("App2a");
			AppContext.printMessage("App2b");
			AppContext.printMessage("App3");
			AppContext.printMessage("App4");
			AppContext.printMessage("App5");
			AppContext.printMessage("App6");
			AppContext.printMessage("App7");
			AppContext.printMessage("App8");
			AppContext.printMessage("App9");
			// Liest die vom Benutzer getroffene Auswahl ein und führt die
			// entsprechende Applikation aus
			try {
				in = new Scanner(System.in);
				int choice_str = in.nextInt();
				switch (choice_str) {
				case 0:
					return;
				case 1:
					CustomerCreateDialog customer = new CustomerCreateDialog();
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
				case 10:
					MainMenuDialog menu = new MainMenuDialog();
					menu.run();
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
