package de.travelbasys.training.dialog.other;

import de.travelbasys.training.dialog.Dialog;

/**
 * Diese Klasse ist für das ändern der Spracheinstellungen verantwortlich und
 * diese in die Konfigurationsdatei zu speichen.
 * 
 * @author tba
 * 
 */

public class ChangeLangDialog implements Dialog {

	private ChangeLangModel model;
	private ChangeLangView view;
	private ChangeLangControl control;

	public void run() {
		model = new ChangeLangModel();
		control = new ChangeLangControl(model, view);
		view = new ChangeLangView(model, control);

		// Here plays the music!
		view.run();

		// Do something with the input!

	}

}