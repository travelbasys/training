package de.travelbasys.training.dialog.menu;

import java.util.Scanner;

import de.travelbasys.training.db.ChangeDB;
import de.travelbasys.training.dialog.customer.CustomerCreateDialog;
import de.travelbasys.training.dialog.customer.CustomerDelete;
import de.travelbasys.training.dialog.customer.CustomerList;
import de.travelbasys.training.dialog.customer.CustomerShow;
import de.travelbasys.training.dialog.customer.CustomerUpdate;
import de.travelbasys.training.dialog.other.ChangeParam;
import de.travelbasys.training.dialog.other.Export;
import de.travelbasys.training.dialog.other.Import;
import de.travelbasys.training.util.AppContext;


/**
 * ist verantwortlich f�r den Dialog mit dem Benutzer, um alle Daten f�r ein
 * Customer Objekt abzufragen und das Objekt dann zu erzeugen.
 * 
 * @author tba
 */

public class MainMenuDialog {
	
	private MainMenuModel model;
	private MainMenuView view;
	private MainMenuControl control;
	private static Scanner in;

	public void run() {
		model = new MainMenuModel();
		control = new MainMenuControl(model);
		view = new MainMenuView(model,control);
		
		// Here plays the music!
		view.run();
		
		// Do something with the input!
		
	}

}
