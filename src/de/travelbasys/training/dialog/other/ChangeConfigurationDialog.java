package de.travelbasys.training.dialog.other;

import de.travelbasys.training.framework.Dialog;

/**
 * Diese Klasse ist für das ändern der Spracheinstellungen verantwortlich.
 * 
 * @author tba
 **/
public class ChangeConfigurationDialog implements Dialog {

	private ChangeConfigurationModel model;
	private ChangeConfigurationView view;
	@SuppressWarnings("unused")
	private ChangeConfigurationControl control;

	public ChangeConfigurationDialog() {
		model = new ChangeConfigurationModel();
		view = new ChangeConfigurationView(model);
		control = new ChangeConfigurationControl(model, view);
	}

	@Override
	public void run() {
		Dialog d = null;
		// Here plays the music!
		view.run();
		if (model.getEnd()) {
			return;
		}
		try {
			d = model.getDialog();
			d.run();
		} catch (NullPointerException e) {
		}
	}
}
