package de.travelbasys.training.dialog.other.configuration.manager;

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
		// Here plays the music!
		view.run();
		if (model.getDialog() == null) {
			return;
		}
		Dialog d = model.getDialog();
		d.run();
	}
}
