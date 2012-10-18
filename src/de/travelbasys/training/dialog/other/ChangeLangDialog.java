package de.travelbasys.training.dialog.other;

import de.travelbasys.training.dialog.Dialog;
import de.travelbasys.training.dialog.menu.MainMenuDialog;
import de.travelbasys.training.util.Config;

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
		MainMenuDialog d;
		model = new ChangeLangModel();
		control = new ChangeLangControl(model);
		view = new ChangeLangView(model, control);

		// Here plays the music!
		view.run();
		if(model.getEndFlag()){
			return;
		}
		Config.updateLanguage(model.getLocale());
		d = new MainMenuDialog();
		d.run();
		

		// Do something with the input!

	}

}