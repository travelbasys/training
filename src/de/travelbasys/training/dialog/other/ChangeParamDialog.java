package de.travelbasys.training.dialog.other;

import de.travelbasys.training.dialog.Dialog;

/**
 * Diese Klasse ist für das ändern der Spracheinstellungen verantwortlich.
 * 
 * @author tba
 **/
public class ChangeParamDialog implements Dialog {

	private ChangeParamModel model;
	private ChangeParamView view;
	private ChangeParamControl control;

	public void run() {
		model = new ChangeParamModel();
		control = new ChangeParamControl(model, view);
		view = new ChangeParamView(model, control);

		// Here plays the music!
		view.run();

		// Do something with the input!

	}

}