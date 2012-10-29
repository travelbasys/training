package de.travelbasys.training.dialog.other;

import de.travelbasys.training.dialog.menu.MainMenuDialog;
import de.travelbasys.training.framework.Dialog;
import de.travelbasys.training.util.Config;

/**
 * Diese Klasse ist für das ändern der Spracheinstellungen verantwortlich.
 * 
 * @author tba
 **/
public class ChangeLangDialog implements Dialog {

	private ChangeLangModel model;
	private ChangeLangView view;
	@SuppressWarnings("unused")
	private ChangeLangControl control;

	public ChangeLangDialog() {
		model = new ChangeLangModel();
		view = new ChangeLangView(model);
		control = new ChangeLangControl(model, view);
	}

	@Override
	public void run() {
		MainMenuDialog d;

		// Here plays the music!
		view.run();
		if (model.getEnd()) {
			return;
		}
		Config.updateLanguage(model.getLocale());
		d = new MainMenuDialog();
		d.run();

	}
}
