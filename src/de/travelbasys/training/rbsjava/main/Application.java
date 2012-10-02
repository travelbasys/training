package de.travelbasys.training.rbsjava.main;

import java.util.Scanner;

import de.travelbasys.training.db.CustomerDAO;
import de.travelbasys.training.dialog.customer.CustomerCreate;
import de.travelbasys.training.dialog.customer.CustomerList;
import de.travelbasys.training.dialog.menu.MainMenu;
import de.travelbasys.training.util.CommandLine;
import de.travelbasys.training.util.Configuration;
import de.travelbasys.training.util.Date;

/**
 * Diese Klasse lädt alle Einstellungen für die gesamte Applikation.
 * 
 * @author tba....
 * 
 */
public class Application {

	/**
	 * Legt defaults fest.
	 */

	/**
	 * Bindet den Resourcen Ordner ein, in dem die Properties der verschiedenen
	 * Sprachen liegen.
	 */
	static Scanner in;

	public static void main(String[] args) {
		
		CommandLine.parse(args);
		Configuration.init(CommandLine.getOptions());

		/**
		 * 
		 * HelloWorldUI (Schreiber) wird mit einer Message aus der Klasse
		 * HelloWorldBusiness initialisiert. UserList (Leser) wird initalisiert.
		 * Gibt aus ob der Schreiber oder Leser gestartet werden soll. Nach
		 * erfolgreicher Auswahl, wird das entsprechende Programm gestartet.
		 * Sonst: Fehler.
		 */
		CustomerCreate ui = new CustomerCreate();
		ui.init(new Date());
		CustomerList ul = new CustomerList();
		ul.init();

		// Initialisiere den Datenbankzugriff.
		CustomerDAO.init((String)Configuration.get("db"));
		MainMenu.show(args, ui, ul);
	}

}
