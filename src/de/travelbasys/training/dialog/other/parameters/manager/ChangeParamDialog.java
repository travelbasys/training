package de.travelbasys.training.dialog.other.parameters.manager;

import de.travelbasys.training.framework.Dialog;

/**
 * Diese Klasse ist für das ändern der Spracheinstellungen verantwortlich.
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
		view.run();
		if (model.getEnd()) {
			return;
		}
		try {
			Dialog d = model.getDialog();
			d.run();
		} catch (NullPointerException e) {
		}
	}
}
