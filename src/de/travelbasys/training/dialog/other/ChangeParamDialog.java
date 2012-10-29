package de.travelbasys.training.dialog.other;

import de.travelbasys.training.dialog.menu.MainMenuDialog;
import de.travelbasys.training.framework.Dialog;

/**
 * Diese Klasse ist f�r das �ndern der Spracheinstellungen verantwortlich.
 * 
 * @author tba
 **/
public class ChangeParamDialog implements Dialog {

	private ChangeParamModel model;
	private ChangeParamView view;
	@SuppressWarnings("unused")
	private ChangeParamControl control;

	public ChangeParamDialog() {
		model = new ChangeParamModel();
		view = new ChangeParamView(model);
		control = new ChangeParamControl(model, view);
	}

	@Override
	public void run() {
		// Here plays the music!
		view.run();
		if (model.getEnd()) {
			return;
		}
		try {
			Dialog d = model.getDialog();
			d.run();
		} catch (NullPointerException e) {
		}
		MainMenuDialog d2 = new MainMenuDialog();
		d2.run();
	}
}
