package de.travelbasys.training.dialog.menu;

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

	public void run() {
		model = new MainMenuModel();
		control = new MainMenuControl(model, view);
		view = new MainMenuView(model, control);

		// Here plays the music!
		view.run();

		// Do something with the input!

	}

}
