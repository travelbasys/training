package de.travelbasys.training.dialog.menu;

/**
 * ist verantwortlich für den Dialog mit dem Benutzer, um alle Daten für ein
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
