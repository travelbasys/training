package de.travelbasys.training2;

import java.util.ResourceBundle;
import java.util.Scanner;
/**
 * Diese Klasse gibt Das Hauptmen� aus und startet die Jeweiligen Funktionen.
 * @author tba
 *
 */
public class HelloWorldMenu {

	private static String baseName = "resources.HelloWorld";
	static ResourceBundle bundle = ResourceBundle.getBundle(baseName);
	private static Scanner in;

	static void show(String[] args, UserCreate UserCreate, UserList ul) {

		// Zeigt die verf�gbaren Funktionen an und fordert zur Auswahl auf.
		Output.println(bundle.getString("Welcome"));
		do {
			Output.println(bundle.getString("Choose"));
			Output.println("0: " + bundle.getString("ExitApp"));
			Output.println("1: " + bundle.getString("App1"));
			Output.println("2: " + bundle.getString("App2"));
			Output.println("3: " + bundle.getString("App3"));
			Output.println("4: " + bundle.getString("App4"));
			Output.println("5: " + bundle.getString("App5"));
			Output.println("6: " + bundle.getString("App6"));
			Output.println("7: " + bundle.getString("App7"));
			Output.println("8: " + bundle.getString("App8"));
			// Liest die vom Benutzer getroffene Auswahl ein und f�hrt die 
			// entsprechende Applikation aus
			in = new Scanner(System.in);
			int choice_str = in.nextInt();

			try {
				switch (choice_str) {
				case 0:
					Output.println(bundle.getString("End"));
					UserDB.terminate();
					System.exit(0);
				case 1:
					UserCreate.run();
					break;
				case 2:
					UserShow.run();
					break;
				case 3:
					UserUpdate.run();
					break;
				case 4:
					UserDelete.run();
					break;
				case 5:
					UserList.run(args);
					break;
				case 6:
					Export.run(args);
					break;
				case 7:
					Import.run(args);
					break;
				case 8:
					ChangeDB.run();
					break;
				default:
					Output.err.println(bundle.getString("ChooseErr"));
				}
			} catch (NumberFormatException e) {
				Output.err.println(bundle.getString("NumberErr"));
			}
		} while (true);
	}

}
