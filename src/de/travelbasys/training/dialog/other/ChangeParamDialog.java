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
	private Dialog d;

	public void run() {
		model = new ChangeParamModel();
		control = new ChangeParamControl(model);
		view = new ChangeParamView(model, control);

		// Here plays the music!
		view.run();
		if(model.getEndFlag()){
			return;
		}
		try {
			d = model.getDialog();
			d.run();
		} catch (NullPointerException e) {
		}

		// Do something with the input!

	}

}